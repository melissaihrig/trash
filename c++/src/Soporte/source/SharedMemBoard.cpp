#include	"../header/SharedMemBoard.h"
#include 	<unistd.h>

SharedMemBoard::SharedMemBoard()
{
	this->shmIdBoard = 0;
	this->shmIdScore = 0;
	this->shmIdLoserGame = 0;
	this->shmIdLoserRound = 0;
	this->board = NULL;
	this->loserGame = NULL;
	this->loserRound = NULL;
}

SharedMemBoard::~SharedMemBoard() {}

void* SharedMemBoard :: createSpaceToScore ( const string name, int& shmid, const size_t dataSize ) {

	key_t key = ftok ( name.c_str(), 'A' );

	if ( key == -1 )
		return NULL;

	shmid = shmget ( key, dataSize, 0666 | IPC_CREAT );

	if ( shmid == -1 )
		return NULL;

	void* ptrTemporal = shmat ( shmid, NULL, 0 );

	if ( ptrTemporal == (void *) -1 )
		return NULL;

	cout<< "--------------> key: " << key << " shmId " << shmid << " ptr " << ptrTemporal  << " " << name <<  " " << getpid() << " data: " << dataSize << endl;
	return  ptrTemporal;
}

int SharedMemBoard :: create ( const int numberOfPlayers ) {

	cout<< " score ";
	unsigned char* score = ( unsigned char* ) createSpaceToScore ( Constants::MEMORY_SCORE, this->shmIdScore, sizeof( unsigned char ) * numberOfPlayers );

	if ( score == NULL ) {
		cerr << "Error en la creación de la memoria compartida en SharedMemBoard: score" << endl;
		return -1;
	}

	cout<< " board ";
	this->board = ( Board* ) createSpaceToScore ( Constants::MEMORY_BOARD, this->shmIdBoard, sizeof( Board ) );


	if ( board  == NULL ) {
		cerr << "Error en la creación de la memoria compartida en SharedMemBoard: ptrDatos" << endl;
		return -1;
	}

	this->board->board = score;

	this->loserGame = ( int* ) createSpaceToScore ( Constants::MEMORY_PLAYER_LOSER_OF_GAME, this->shmIdLoserGame, sizeof( int ) );

	if ( loserGame  == NULL ) {
		cerr << "Error en la creación de la memoria compartida en SharedMemBoard: loserGame" << endl;
		return -1;
	}

	this->loserRound = ( int* ) createSpaceToScore ( Constants::MEMORY_PLAYER_LOSER_OF_ROUND, this->shmIdLoserRound, sizeof( int ) );

	if ( loserRound  == NULL ) {
		cerr << "Error en la creación de la memoria compartida en SharedMemBoard: loserRound" << endl;
		return -1;
	}

	return 0;
}

int SharedMemBoard :: destroy( void*  ptr, int shmId ) {

	cout<< "shmId " << shmId <<  " ptr " << ptr  <<  " " << getpid() << endl;

	int rVal1 = shmdt ( ptr ),
			rVal2 = 0 ;

	if ( rVal1 != 0 )
		cerr << "Error en MemoriaCompartidaBoard " << strerror(errno) << endl;

	if ( this->amountOfAttachedProcesses( shmId ) == 0 ) {

		rVal2 = shmctl ( shmId, IPC_RMID, NULL );

		if ( rVal2 != 0 )
			cerr << "Error en MemoriaCompartidaBoard " <<  strerror(errno) << endl;
	}
cout<< "1: " << rVal1 << " 2: " << rVal2 <<" " << getpid()<< endl;
	return ( rVal1 == -1 || rVal2 == -1 )? -1 : 0;

}

int SharedMemBoard :: destroy () {

	cout<< " score ";

	int rVal1 = this->destroy( (void*) this->board->board, this->shmIdScore  );
	cout<< " board ";

	int	rVal2 = this->destroy( (void*) this->board, this->shmIdBoard );

	int	rVal3 = this->destroy( (void*) this->loserGame, this->shmIdLoserGame );

	int	rVal4 = this->destroy( (void*) this->loserRound, this->shmIdLoserRound );

	return ( rVal1 == -1 || rVal2 == -1 || rVal3 == -1 || rVal4 == -1 )? -1 : 0;
}

void SharedMemBoard :: updateBoard ( Board* dato ) {
	 *this->board = *dato;
}

Board* SharedMemBoard :: getBoard () {
	return this->board;
}

int SharedMemBoard :: getTheLoserOfRound () const {
	return *this->loserRound;
}

void SharedMemBoard :: setTheLoserOfRound ( const int playerId ) {
	 *this->loserRound = playerId;
}

int SharedMemBoard :: getTheLoserOfGame () const {
	return *this->loserGame;
}

void SharedMemBoard :: setTheLoserOfGame ( const int playerId ) {
	 *this->loserGame = playerId;
}


unsigned long int  SharedMemBoard :: amountOfAttachedProcesses( const int shmId ) const {
	shmid_ds estado;
	shmctl ( shmId, IPC_STAT, &estado );
	return estado.shm_nattch;
}

unsigned long int  SharedMemBoard :: amountOfAttachedProcesses() const {
	shmid_ds estado;
	shmctl ( shmIdBoard, IPC_STAT, &estado );
	return estado.shm_nattch;
}
