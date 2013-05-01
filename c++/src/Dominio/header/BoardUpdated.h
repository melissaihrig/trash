/*
 * BoardUpdated.h
 *
 *  Created on: 28/04/2013
 *      Author: amalia
 */

#ifndef BOARDUPDATED_H_
#define BOARDUPDATED_H_

#include	"IProceso.h"

#include	"../../Soporte/header/SharedMem.h"
#include	"../../Soporte/header/LockFile.h"
#include	"../../Soporte/header/Semaphore.h"
#include	"../../Soporte/header/SharedMemBoard.h"

#include	<errno.h>
#include	<stdio.h>
#include	<string.h>

using namespace std;
using namespace soporte;

class BoardUpdated: public IProceso {
private:

	Board* 				board;

	SharedMem <int>*	memoryPlayerLoserOfRound;
	SharedMem <int>*	memoryPlayerLoserOfGame;
	SharedMemBoard* 	memoryBoard;

	Semaphore* 			initBoardUpdate;
	Semaphore* 			endBoardUpdate;
	Semaphore* 			readBoard;

	void initMemoryPlayerLoser( SharedMem <int>* memory );
	void initMemoryBoard();

	void endMemoryPlayerLoser( SharedMem <int>* memory );
	void endMemoryBoard();

public:
	BoardUpdated( int numberOfPlayers, Semaphore* initBoardUpdate, Semaphore* endBoardUpdate, Semaphore* readBoard );
	void run ();
	virtual ~BoardUpdated();
};

#endif /* BOARDUPDATED_H_ */
