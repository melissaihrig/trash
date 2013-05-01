#ifndef SHAREDMEMBOARD_H_
#define SHAREDMEMBOARD_H_

#include	<sys/types.h>
#include	<sys/ipc.h>
#include	<sys/shm.h>
#include 	<errno.h>
#include 	<stdio.h>
#include 	<string.h>

#include 	"Board.h"

using namespace std;

class SharedMemBoard {
private:
	int		shmIdBoard;
	int		shmIdScore;
	int 	shmIdLoserRound;
	int 	shmIdLoserGame;

	Board*	board;
	int*	loserRound;
	int*	loserGame;

	void* createSpaceToScore( const string name, int& shmid, const size_t dataSize );
	int destroySpaceToPlayers();

	int destroy( void *  ptr, int shmId );

	unsigned long int amountOfAttachedProcesses(  const int shmId  ) const ;

public:

	SharedMemBoard ();
	~SharedMemBoard ();

	int create ( const int numberOfPlayers = 0 );
	int destroy ();

	void updateBoard ( Board* dato );
	Board* getBoard ();

	int getTheLoserOfRound () const;
	void setTheLoserOfRound ( const int playerId );

	int getTheLoserOfGame () const;
	void setTheLoserOfGame ( const int playerId );

	unsigned long int amountOfAttachedProcesses() const ;
};


#endif /* SHAREDMEMBOARD_H_ */
