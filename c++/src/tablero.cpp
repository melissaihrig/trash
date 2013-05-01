//============================================================================
// Name        : tablero.cpp
// Author      : Amalia
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include "Soporte/header/SharedMem.h"
#include "Soporte/header/Semaphore.h"
#include "Soporte/source/SharedMem.cpp"
#include "Dominio/header/BoardUpdated.h"
#include "Dominio/header/BoardObserver.h"

#include <unistd.h>
#include <wait.h>
#include <stdlib.h>
#include <iostream>
#include <errno.h>
#include <stdio.h>
#include <string.h>

using namespace std;
using namespace soporte;

void crearJugador ( Semaphore* initRound, Semaphore* endRound, Semaphore* deleteBoard );
void crearTabla ( Semaphore* initTableUpdate, Semaphore* endTableUpdate, Semaphore* readBoard, Semaphore* deleteBoard );
void initMemory ( SharedMem <int>* memory );
void initMemoryPIDObserver ( SharedMem <pid_t>* memory );
void impresionTabla ( Semaphore* readBoard, Semaphore* deleteBoard );

int main() {

	Semaphore* initBoardUpdate = new Semaphore( Constants::SEMAPHORE, 0, 'a' );
	Semaphore* endBoardUpdate = new Semaphore ( Constants::SEMAPHORE, 0, 'z' );
	Semaphore* initRound = new Semaphore ( Constants::SEMAPHORE, 0, 'b' );
	Semaphore* endRound = new Semaphore ( Constants::SEMAPHORE, 0, 'y' );
	Semaphore* readBoard = new Semaphore ( Constants::SEMAPHORE, 1, 'c' );
	Semaphore* deleteBoard = new Semaphore ( Constants::SEMAPHORE, 3, 'c' );

	pid_t procesoVerTabla;

//	if ( fork() == 0 )
//		crearJugador( initRound, endRound, deleteBoard );

	if ( fork() == 0 )
		crearTabla( initBoardUpdate, endBoardUpdate, readBoard, deleteBoard );

	if ( (procesoVerTabla = fork()) == 0 )
		impresionTabla( readBoard, deleteBoard );

	cout<< "Handler proceso: " << getpid() << endl;

	SharedMem <int>* memoryPlayerLoserOfGame = new SharedMem<int> ( Constants::MEMORY_PLAYER_LOSER_OF_GAME );
	initMemory( memoryPlayerLoserOfGame );
	memoryPlayerLoserOfGame->write( Constants::THERE_IS_NOT_LOSER );

	int perdedor = Constants::THERE_IS_NOT_LOSER;

	while ( perdedor == Constants::THERE_IS_NOT_LOSER )
	{
//		initRound->v();
//		cout << "Inicia la ronda" << endl;
//		endRound->p();
//		cout << "Fin de la ronda" << endl;

		initBoardUpdate->v();
//		cout << "Inicio del actualizar tabla" << endl;
		endBoardUpdate->p();
//		cout << "Fin del actualizar tabla" << endl;

		perdedor = memoryPlayerLoserOfGame->read();
	}

	initRound->v(); //despierto todos los jugadires dormidos
	deleteBoard->p();

	if ( kill(procesoVerTabla, SIGINT) == 0)
		cout << "muerte exitosa" << endl;

	cout << "Esperando por hijos " << endl;
	while ( wait( NULL ) > 0 ) {}

	cout << "Liberando memoria handler" << endl;

	if ( memoryPlayerLoserOfGame->detach() == -1 ) {
		cerr << "Error al liberar la memoria compartida para el handler." << strerror(errno) << endl;
	}

	delete memoryPlayerLoserOfGame;

	//eliminar semáforos
	initBoardUpdate->destroy();
	endBoardUpdate->destroy();
	initRound->destroy();
	endRound->destroy();
	readBoard->destroy();


	delete initBoardUpdate;
	delete endBoardUpdate;
	delete initRound;
	delete endRound;
	delete readBoard;

	cout << "Terminó el programa" << endl; // prints

	exit ( 0 );
}

void crearJugador( Semaphore* initRound, Semaphore* endRound, Semaphore* deleteBoard ) {
	cout<< "Jugador proceso: " << getpid() << endl;

	SharedMem <int>* memoryPlayerLoserOfRound = new SharedMem<int> ( Constants::MEMORY_PLAYER_LOSER_OF_ROUND );
	initMemory(memoryPlayerLoserOfRound);
	SharedMem <int>* memoryPlayerLoserOfGame = new SharedMem<int> ( Constants::MEMORY_PLAYER_LOSER_OF_GAME );
	initMemory( memoryPlayerLoserOfGame );

	int v[] = {3, 2, 3, 1, 3, 1, 3, 2, 3, 2, 3, 2, 3, 1, 3};
	int posicion = 0;

	initRound->p();
	int perdedor = memoryPlayerLoserOfGame->read();

	while ( perdedor == Constants::THERE_IS_NOT_LOSER )
	{
		cout << "perdedor: "<< v[posicion] << endl;

		memoryPlayerLoserOfRound->write(v[posicion]);
//		sleep(1);
		posicion ++;

		endRound->v();
		initRound->p();
		perdedor = memoryPlayerLoserOfGame->read();
	}

	deleteBoard->p();

	cout << "Liberando memoria hijo" << endl;
	int retornoDeDesconexion1 = memoryPlayerLoserOfRound->detach();
	int retornoDeDesconexion2 = memoryPlayerLoserOfGame->detach();

	if ( retornoDeDesconexion1 == -1 || retornoDeDesconexion2 == -1 ) {
		cerr << "Error al liberar la memoria compartida para el hijo." << strerror(errno) << endl;
//		exit ( 1 );
	}

	delete memoryPlayerLoserOfGame;
	delete memoryPlayerLoserOfRound;
	delete initRound;
	delete endRound;
cout<< "                                hijo chau" << endl;
	exit ( 0 );
}

void crearTabla ( Semaphore* initBoardUpdate, Semaphore* endBoardUpdate, Semaphore* readBoard, Semaphore* deleteBoard ) {

	cout<< "Tabla proceso: " << getpid() << endl;

	BoardUpdated* board = new BoardUpdated(3, initBoardUpdate, endBoardUpdate, readBoard);
	board->run();
	cout<< "                                  tabla up esperando " << endl;

	deleteBoard->c();
	cout<< "                                  tabla up fin espera " << endl;

	cout << "Liberando memoria tabla" << endl;
	delete board;
	delete initBoardUpdate;
	delete endBoardUpdate;
	delete readBoard;
	cout<< "                                  tabla update chau" << endl;

	exit ( 0 );
}

void impresionTabla( Semaphore* readBoard, Semaphore* deleteBoard ) {

	BoardObserver* observerOfBoard = new BoardObserver(readBoard, 3);

	observerOfBoard->run();
	cout<< "                                  tabla observer fin run " << endl;

	delete observerOfBoard;
	cout<< "                                  tabla observer desb " << endl;

	deleteBoard->p();
	cout<< "                                  tabla observer del " << endl;

	delete readBoard;


	cout<< "                                  tabla observer chau" << endl;

	exit ( 0 );
}

void initMemory ( SharedMem <int>* memory )
{
	int identificadorDeMemoria, retornoDeConexion;

	identificadorDeMemoria = memory->get();

	if ( identificadorDeMemoria == -1 )
	{
		cerr << "Error al crear la memoria compartida para la tabla." << endl;
		cerr << strerror(errno)<< endl;
		exit ( 1 );
	}

	retornoDeConexion = memory->attach();

	if ( retornoDeConexion == -1 )
	{
		cerr << "Error al adosar la memoria compartida para la tabla." << endl;
		cerr << strerror(errno)<< endl;
		exit ( 1 );
	}
}

void initMemoryPIDObserver ( SharedMem <pid_t>* memory )
{
	int identificadorDeMemoria, retornoDeConexion;

	identificadorDeMemoria = memory->get();

	if ( identificadorDeMemoria == -1 )
	{
		cerr << "Error al crear la memoria compartida para la tabla." << endl;
		cerr << strerror(errno)<< endl;
		exit ( 1 );
	}

	retornoDeConexion = memory->attach( true );

	if ( retornoDeConexion == -1 )
	{
		cerr << "Error al adosar la memoria compartida para la tabla." << endl;
		cerr << strerror(errno)<< endl;
		exit ( 1 );
	}
}
