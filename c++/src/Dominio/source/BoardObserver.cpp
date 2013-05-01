/*
 * BoardObserver.cpp
 *
 *  Created on: 28/04/2013
 *      Author: amalia
 */

#include "BoardObserver.h"

BoardObserver::BoardObserver( Semaphore* readTable, const int numberOfPlayers ) {

	this->memoryBoard  = new SharedMemBoard();
	this->readTable = readTable;

	this->initMemoryBoard(numberOfPlayers);

	SignalHandler :: getInstance()->registrarHandler ( SIGINT, &sigint_handler );
}

void BoardObserver::run () {

//	cout << "-p       Para ver el puntaje de los jugadores." << endl;
//	cout << "==============================================" << endl;

	string opcion = "";
	getline(cin, opcion);
	while ( sigint_handler.getGracefulQuit() == 0 )
	{

		cout<<"Leido" << endl;

		if ( opcion.compare("-p") == 0 ) {

			this->readTable->p();
			cout << "Mostrar tabla " << endl;

			this->memoryBoard->read()->lookAtScore();
//			this->memoryBoard->read()->lookAtScore();
			this->readTable->v();
		} else {
			cout << "LA tabla no se va a mostrar " << endl;

		}

		opcion = "";
		getline(cin, opcion);
	}

//	this->endMemoryBoard();
//	delete this->memoryBoard;
//	SignalHandler :: destruir ();
//	exit (0);
}

BoardObserver::~BoardObserver()
{
	SignalHandler :: destruir ();
	cout <<"Llamando al destructor del observer " << endl;
	this->endMemoryBoard();
	delete this->memoryBoard;
//	exit (0);
}

void BoardObserver::initMemoryBoard( const int numberOfPlayers ) {

	if ( memoryBoard->create( Constants::MEMORY_BOARD, numberOfPlayers ) == -1 ) {
		cerr << "Error al crear la memoria compartida para el BoardObserver. " << strerror(errno)<< endl;
		exit ( 1 );
	}
}

void BoardObserver::endMemoryBoard() {

	if ( memoryBoard->destroy() == -1 ) 	{
		cerr << "Error al liberar la memoria compartida para el BoardObserver. " << strerror(errno) << endl;
	}
}
