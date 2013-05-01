/*
 * BoardUpdated.cpp
 *
 *  Created on: 28/04/2013
 *      Author: amalia
 */

#include	"BoardUpdated.h"

BoardUpdated::BoardUpdated( int numberOfPlayers, Semaphore* initBoardUpdate, Semaphore* endBoardUpdate, Semaphore* readBoard ) {

	this->board = new Board(numberOfPlayers);

	this->memoryPlayerLoserOfGame = new SharedMem<int> ( Constants::MEMORY_PLAYER_LOSER_OF_GAME );
	this->memoryPlayerLoserOfRound = new SharedMem<int> ( Constants::MEMORY_PLAYER_LOSER_OF_ROUND );
	this->memoryBoard  = new SharedMemBoard ();

	this->initBoardUpdate = initBoardUpdate;
	this->endBoardUpdate = endBoardUpdate;
	this->readBoard = readBoard;

	this->initMemoryPlayerLoser( this->memoryPlayerLoserOfRound );
	this->initMemoryPlayerLoser( this->memoryPlayerLoserOfGame );
	this->initMemoryBoard();
}

BoardUpdated::~BoardUpdated() {

	this->endMemoryBoard();
	this->endMemoryPlayerLoser( this->memoryPlayerLoserOfRound );
	this->endMemoryPlayerLoser( this->memoryPlayerLoserOfGame );

	delete this->board;

	delete this->memoryBoard;
	delete this->memoryPlayerLoserOfGame;
	delete this->memoryPlayerLoserOfRound;
}

void BoardUpdated::run () {

	int losingPlayer;
int v[] = {1,2,3,1,2,3,2,3,2,3,2,3,3,3,2,1,1,3};
int i = 0;
	while(true)
	{
		this->initBoardUpdate->p(); //wait (ACTUALIZAR PUNTAJE);

//		cout << "Tablero actualizandose." << endl;

//		losingPlayer = this->memoryPlayerLoserOfRound->read();
		losingPlayer = v[i]; i++;

		//escribir el id del jugador que perdió en el logger;

		this->board->updateScore( losingPlayer );

		this->readBoard->p();
//		cout << "Escribiendo tabla en memoria." << endl;

		this->memoryBoard->write(this->board);
		cout << "Escribiendo tabla en memoria." << endl;

		this->memoryBoard->read()->lookAtScore();
		this->readBoard->v();

		//escribir el puntaje de todos los jugadores en el logger;

		if ( this->board->thereIsALoser() )
		{
			this->memoryPlayerLoserOfGame->write( losingPlayer );// escribir en memoria compartida el id del jugador que perdió

			// escribir en el logger el jugador que perdió

			cout << "--------------------------Board::run - Perdió: " << losingPlayer << endl;
			this->endBoardUpdate->v(); // signal(FIN ACTUALIZACION PUNTAJE)

			return;
		}

		this->endBoardUpdate->v(); // signal(FIN ACTUALIZACION PUNTAJE)
	}
}

void BoardUpdated::initMemoryPlayerLoser( SharedMem <int>* memory ) {

	if ( memory->get() == -1 ) {
		cerr << "Error al crear la memoria compartida para el BoardUpdate:initMemoryPlayerLoser. " << strerror(errno)<< endl;
		exit ( 1 );
	}

	if ( memory->attach() == -1 ) {
		cerr << "Error al adosar la memoria compartida para el BoardUpdate: initMemoryPlayerLoser. " << strerror(errno)<< endl;
		exit ( 1 );
	}
}

void BoardUpdated::initMemoryBoard() {

	if ( memoryBoard->create( Constants::MEMORY_BOARD, board->getNumberOfPlayers() ) == -1 ) {
		cerr << "Error al crear la memoria compartida para el BoardUpdate: initMemoryBoard. " << strerror(errno)<< endl;
		exit ( 1 );
	}
}

void BoardUpdated::endMemoryPlayerLoser( SharedMem <int>* memory ) {

	if ( memory->detach()  == -1  ) {
		cerr << "Error al liberar la memoria compartida para el BoardUpdated: endMemoryPlayerLoser. " << strerror(errno) << endl;
	}
}

void BoardUpdated::endMemoryBoard() {

	if ( memoryBoard->destroy() == -1 ) {

		cerr << "Error al liberar la memoria compartida para el BoardUpdated: endMemoryBoard. " << strerror(errno) << endl;
	}
}
