#include "../header/Semaphore.h"

Semaphore::Semaphore(char* nombre, int valorInicial, char letra) {

	this->valorInicial = valorInicial;

	key_t clave = ftok(nombre, letra);
	this->id = semget(clave, 1, 0666 | IPC_CREAT);
	if (id == 0) {
		cout << "error crear el semaforo" << endl;
	}
	this->init();
}

Semaphore::Semaphore(string nombre, int valorInicial, char letra)
{
	this->valorInicial = valorInicial;

	key_t clave = ftok(nombre.c_str(), letra);
	this->id = semget(clave, 1, 0666 | IPC_CREAT);
	if (id == 0) {
		cout << "error crear el semaforo" << endl;
	}
	this->init();
}

Semaphore::~Semaphore() {
}

int Semaphore::init() {

	union semnum {
		int val;
		struct semid_ds* buf;
		ushort* array;
	};

	semnum init;
	init.val = this->valorInicial;
	int resultado = semctl(this->id, 0, SETVAL, init);
	if (resultado != 0) {
		cout << "Error al iniciar semaforo" << endl;
	}
	return resultado;
}

int Semaphore::p() {
	struct sembuf operacion;

	operacion.sem_num = 0; // numero de semaforo
	operacion.sem_op = -1; // restar 1 al semaforo
	operacion.sem_flg = SEM_UNDO;
	int resultado = semop(this->id, &operacion, 1);
	//if (resultado == -1) {
	//cout << "problemas para aplicar p en semaforo" << endl;
	//perror("P");
	//}
	return resultado;
}

int Semaphore::v() {

	struct sembuf operacion;

	operacion.sem_num = 0; // numero de semaforo
	operacion.sem_op = 1; // sumar 1 al semaforo
	operacion.sem_flg = SEM_UNDO;

	int resultado = semop(this->id, &operacion, 1);
	//if (resultado == -1) {
	//cout << "problemas para aplicar v en semaforo" << endl;
	//perror("V");
	//}
	return resultado;
}

int Semaphore::c() {

	struct sembuf operacion;

	operacion.sem_num = 0; // numero de semaforo
	operacion.sem_op = 0; // sumar 1 al semaforo
	operacion.sem_flg = SEM_UNDO;

	int resultado = semop(this->id, &operacion, 1);
	//if (resultado == -1) {
	//cout << "problemas para aplicar c en semaforo" << endl;
	//}
	return resultado;
}

void Semaphore::destroy() {
	semctl(this->id, 0, IPC_RMID);
}
