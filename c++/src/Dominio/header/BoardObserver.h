/*
 * BoardObserver.h
 *
 *  Created on: 28/04/2013
 *      Author: amalia
 */

#ifndef BOARDOBSERVER_H_
#define BOARDOBSERVER_H_

#include	"IProceso.h"

#include	"../../Soporte/header/SharedMemBoard.h"
#include 	"../../Soporte/header/SIGINT_Handler.h"
#include	"../../Soporte/header/SignalHandler.h"
#include 	"../../Soporte/header/SharedMem.h"
#include	"../../Soporte/header/Semaphore.h"

#include 	<iostream>
#include 	<errno.h>
#include 	<stdio.h>
#include 	<stdlib.h>

using namespace std;
using namespace soporte;

class BoardObserver: public IProceso {
private:

	SharedMemBoard* 	memoryBoard;
	Semaphore* 			readTable;
	SIGINT_Handler 		sigint_handler;

	void initMemoryBoard( const int numberOfPlayers );
	void endMemoryBoard();
	void initMemoryPID();
	void endMemoryPID();

public:
	BoardObserver( Semaphore* readTable, const int numberOfPlayers );
	void run ();
	virtual ~BoardObserver();
};

#endif /* BOARDOBSERVER_H_ */
