#ifndef SEMAFORO_H_
#define SEMAFORO_H_

#include <sys/ipc.h>
#include <sys/sem.h>
#include <sys/types.h>
#include <iostream>
#include <unistd.h>
#include <stdlib.h>
#include "string.h"
#include <sys/wait.h>
#include <stdio.h>
using namespace std;

class Semaphore {

private:
	int id;
	int valorInicial;

	int init();

public:
	Semaphore(const char* name, int initialValue,char character);
	virtual ~Semaphore();

	int p(int val = -1); // decrementa
	int v(int val = 1); // incrementa
	int c(); //Espera que el semaforo sea cero
	void destroy();
};

#endif /* SEMAFORO_H_ */
