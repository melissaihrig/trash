#include	"MemoriaCompartidaBoard.h"


MemoriaCompartidaBoard :: MemoriaCompartidaBoard () {
	this->shmIdBoard = 0;
	this->shmId = 0;
	this->ptrDatos = NULL;
}

MemoriaCompartidaBoard :: ~MemoriaCompartidaBoard () {
}

Board* MemoriaCompartidaBoard :: createBoard(const string name, const char letter, const size_t sizeOfData) {

	key_t clave = ftok ( name.c_str(), letter );

	if ( clave == -1 )
		return NULL;

	// creacion de la memoria compartida
	this->shmIdBoard = shmget ( clave, sizeOfData, 0644|IPC_CREAT );

	if ( this->shmIdBoard == -1 )
		return NULL;

	// attach del bloque de memoria al espacio de direcciones del proceso
	void* ptrTemporal = shmat ( this->shmIdBoard, NULL, 0 );

	if ( ptrTemporal == (void *) -1 )
		return NULL;

	cout << "shmind board " << shmIdBoard << " ptr " << ptrTemporal << endl;
	return (Board*)ptrTemporal;
}

char* MemoriaCompartidaBoard :: createSpaceToScore(const string name, const char letter, const int numberOfPlayers) {

	key_t clave = ftok ( name.c_str(), letter );

	if ( clave == -1 )
		return NULL;

	// creacion de la memoria compartida
	this->shmId = shmget ( clave, sizeof(char) *  numberOfPlayers, 0644|IPC_CREAT );

	if ( this->shmId == -1 )
		return NULL;

	// attach del bloque de memoria al espacio de direcciones del proceso
	void* ptrTemporal = shmat ( this->shmId, NULL, 0 );

	if ( ptrTemporal == (void *) -1 )
		return NULL;
	cout << "shmind " << shmId << " ptr " << ptrTemporal << endl;
	return (char *) ptrTemporal;
}

int MemoriaCompartidaBoard :: create ( const string name, const int numberOfPlayers ) {

	this->ptrDatos =  this->createBoard( name, 'a', sizeof(Board));

	/*crear memoria para el puntaje*/
	char* score = createSpaceToScore( name, 'b', numberOfPlayers );
//if distinto de null

	this->ptrDatos->board = score;

	cout<<"constructor ok!" << endl;
	return 0;
}

int MemoriaCompartidaBoard :: destroy( void*  ptr, int shmId ) {

	int val1 = shmdt ( ptr ),
			val2,
			procAdosados = this->cantidadProcesosAdosados (shmId);

	if ( val1 != 0 ) {
		cerr << "Error en MemoriaCompartidaBoard " << strerror(errno) << endl;
	}

	if ( procAdosados == 0 ) {

		val2 = shmctl ( shmId, IPC_RMID, NULL );

		if ( val2 != 0 ) {
			cerr << "Error en MemoriaCompartidaBoard " <<  strerror(errno) << endl;
		}
	}
	cout << "shmind " << shmId << " ptr " << ptr << endl;
	return val1 || val2;
}

void MemoriaCompartidaBoard :: destroy () {

	cout << "ptos- ";
	this->destroy( (void*) this->ptrDatos->board, this->shmId );
	cout << "board ";
	this->destroy( (void*) this->ptrDatos, this->shmIdBoard );
}

void MemoriaCompartidaBoard :: escribir ( Board* dato ) {
	 *this->ptrDatos = *dato;
}

Board* MemoriaCompartidaBoard :: leer () {
	return this->ptrDatos;
}

int MemoriaCompartidaBoard :: cantidadProcesosAdosados (int shmId) {
	shmid_ds estado;
	shmctl ( shmId, IPC_STAT, &estado );
	return estado.shm_nattch;
}
