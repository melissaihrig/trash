//============================================================================
// Name        : z.cpp
// Author      : Amalia
// Version     :
// Copyright   : Your copyright notice
// Description : Hello World in C++, Ansi-style
//============================================================================

#include <iostream>
#include <unistd.h>
#include <stdlib.h>
#include <time.h>
#include <sys/wait.h>
#include <errno.h>
#include <stdio.h>
#include <string.h>

//#include "MemoriaCompartida.h"
#include "Semaphore.h"
#include "MemoriaCompartidaBoard.h"


using namespace std;

int main() {

	Semaphore semaforo( (char*) "./src/z.cpp", 0, 'z');

	pid_t proceso = fork();

	if (proceso == 0 )
	{
		cout<< "hijo: " << getpid() << endl;

		semaforo.p();
		MemoriaCompartidaBoard* memory = new MemoriaCompartidaBoard();

		if (memory->create("./src/z.cpp", 3) != 0 )
			cout << "error -1"<< endl;


		cout << "---- por leer el hijo --- "<< endl;
		memory->leer()->lookAtScore();
		cout << "---- dejó de leer ------- "<< endl;

		memory->destroy();
		delete memory;
		exit ( 0 );
	}
	else
	{
		cout<< "padre: " << getpid() << endl;
		MemoriaCompartidaBoard* memory = new MemoriaCompartidaBoard();


		if (memory->create("./src/z.cpp", 3) != 0  )
			cout << "error -1"<< strerror(errno) << endl;
		Board *board = new Board(3);

		board->updateScore(2);
		board->updateScore(2);
		board->updateScore(1);
		board->updateScore(1);
		board->updateScore(2);
		board->updateScore(3);
		board->updateScore(2);

		board->lookAtScore();
		cout << "***** por escribir *****"<< endl;

		memory->escribir(board);

		cout<< " ***** actualizados *****" << endl;

		semaforo.v();

		cout << "esperando al hijo"<< endl;
		int estado;
		wait ( (void*) &estado );

		cout << "terminó el hijo"<< endl;
//
		semaforo.destroy();
		memory->destroy();
		delete memory;
		delete board;
		cout << "terminó el padre"<< endl;
		exit ( 0 );

	}

	return 0;
}
