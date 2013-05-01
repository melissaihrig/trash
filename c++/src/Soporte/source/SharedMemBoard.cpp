#include	"../header/SharedMemBoard.h"
#include <unistd.h>
SharedMemBoard::SharedMemBoard()
{
	this->shmIdBoard = 0;
	this->shmId = 0;
	this->ptrDatos = NULL;
}

SharedMemBoard::~SharedMemBoard() {}

void* SharedMemBoard::createSpaceToScore(const string name, const char letter, int& shmid, const size_t dataSize, const bool ronly) {

	key_t key = ftok ( name.c_str(), letter );

	if ( key == -1 )
		return NULL;

	shmid = shmget ( key, dataSize, 0644 | IPC_CREAT );

	if ( shmid == -1 )
		return NULL;

	void* ptrTemporal ;
//	if ( ronly == true )
//	{
//		ptrTemporal = shmat ( shmid, NULL, SHM_RDONLY );
//		cout<<"solo lectura" << endl;
//	}
//	else
//	{
		ptrTemporal = shmat ( shmid, NULL, 0 );
//	}

	if ( ptrTemporal == (void *) -1 )
		return NULL;

	cout<< "shmId " << shmid << " ptr " << ptrTemporal  << " " << name <<  " " << getpid() << endl;
	return  ptrTemporal;
}

int SharedMemBoard :: create ( const string name, const int numberOfPlayers, const bool ronly ) {

	cout << name << " " << numberOfPlayers << " " << ronly << endl;
	cout<< " board ";
	this->ptrDatos = (Board*)createSpaceToScore( name, 'A', this->shmIdBoard, sizeof(Board), ronly);

	if ( ptrDatos  == NULL ) {
		cerr << "Error en la creación de la memoria compartida en SharedMemBoard: ptrDatos" << endl;
		return -1;
	}
	cout<< " score ";
	/*crear memoria para el puntaje*/
	char* score = (char*)createSpaceToScore( name, 'Z', this->shmId, sizeof(char) * numberOfPlayers, ronly );

	if ( score == NULL ) {
		cerr << "Error en la creación de la memoria compartida en SharedMemBoard: score" << endl;
		return -1;
	}

	this->ptrDatos->board = score;
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
cout<< "1: " << rVal1 << " 2: " << rVal2 << endl;
	return ( rVal1 == -1 || rVal2 == -1 )? -1 : 0;

}

int SharedMemBoard :: destroy () {

	cout<< " score ";

	int rVal1 = this->destroy( (void*) this->ptrDatos->board, this->shmId  );
	cout<< " board ";

	int	rVal2 = this->destroy( (void*) this->ptrDatos, this->shmIdBoard );

	return ( rVal1 == -1 || rVal2 == -1 )? -1 : 0;
}

void SharedMemBoard :: write ( Board* dato ) {
	 *this->ptrDatos = *dato;
}

Board* SharedMemBoard :: read () {
	return this->ptrDatos;
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
