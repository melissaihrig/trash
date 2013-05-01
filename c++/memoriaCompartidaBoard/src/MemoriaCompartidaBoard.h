#ifndef MEMORIACOMPARTIDA_H_
#define MEMORIACOMPARTIDA_H_

#include	<sys/types.h>
#include	<sys/ipc.h>
#include	<sys/shm.h>
#include 	<errno.h>
#include 	<stdio.h>
#include 	<string.h>
#include	"Board.h"

using namespace std;

class MemoriaCompartidaBoard {
private:
	int		shmIdBoard;
	int		shmId;

	Board*	ptrDatos;

	int cantidadProcesosAdosados ( int shmId );
	char* createSpaceToScore( const string name, const char letter, const int numberOfPlayers );
	Board* createBoard(const string name, const char letter, const size_t sizeOfData);

	int destroySpaceToPlayers();
	int destroy( void *  ptr, int shmId );

public:

	MemoriaCompartidaBoard ();
	~MemoriaCompartidaBoard ();
	int create ( const string name, const int numberOfPlayers = 0);
	void destroy ();
	void escribir ( Board* dato );
	Board* leer ();

};

#endif /* MEMORIACOMPARTIDA_H_ */
