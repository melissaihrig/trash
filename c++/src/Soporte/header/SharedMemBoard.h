#ifndef SHAREDMEMBOARD_H_
#define SHAREDMEMBOARD_H_

#include	<sys/types.h>
#include	<sys/ipc.h>
#include	<sys/shm.h>
#include 	<errno.h>
#include 	<stdio.h>
#include 	<string.h>
#include	"../../Dominio/header/Board.h"

using namespace std;

class SharedMemBoard {
private:
	int		shmIdBoard;
	int		shmId;

	Board*	ptrDatos;

	void* createSpaceToScore( const string name, const char letter, int& shmid, const size_t dataSize, const bool ronly );
	int destroySpaceToPlayers();

	int destroy( void *  ptr, int shmId );

	unsigned long int amountOfAttachedProcesses(  const int shmId  ) const ;

public:

	SharedMemBoard ();
	~SharedMemBoard ();
	int create ( const string name, const int numberOfPlayers = 0, const bool ronly = false);
	int destroy ();
	void write ( Board* dato );
	Board* read ();
	unsigned long int amountOfAttachedProcesses() const ;
};

#endif /* SHAREDMEMBOARD_H_ */
