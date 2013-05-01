/*
 * SharedMem.cpp
 *
 *  Created on: Mar 31, 2013
 *      Author: santiago
 */

#ifndef SHAREDMEM_C_
#define SHAREDMEM_C_

#include "../header/SharedMem.h"
#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>
#include <iostream>

using namespace soporte;
using namespace std;


template < typename T >
SharedMem<T>::SharedMem(  const std::string& str )
{
	this->key = ftok( str.c_str() , 'R');
	this->size = sizeof (T);
	this->segment_id = 0;
	ptr = NULL;
}

template < typename T >
SharedMem<T>::SharedMem(   const char* str ) {
	this->key = ftok( str , 'R');
	this->size = sizeof (T);
	this->segment_id = 0;
	ptr = NULL;
}

template < typename T >
SharedMem<T>::~SharedMem() {}

template < typename T >
int SharedMem<T>::get (bool exclusive ) {
	if (exclusive)
		segment_id = shmget(key, size, 0666 | IPC_CREAT | IPC_EXCL);
	else
		segment_id = shmget(key, size, 0666 | IPC_CREAT );
	return segment_id;
}

template < typename T >
int SharedMem<T>::attach (bool ronly ) {
	if (ronly)
		ptr = (T*) shmat (segment_id, NULL , SHM_RDONLY);
	else
		ptr = (T*) shmat (segment_id, NULL , 0);
	return (ptr == NULL) ? -1 : 0;
}

template < typename T >
int SharedMem<T>::detach() {
	int rVal1 = shmdt (ptr);
	int rVal2 = 0;

	//Check if this was the last process attached
	if ( amountOfAttachedProcesses()  == 0 ) {
		rVal2 = shmctl ( segment_id , IPC_RMID ,NULL );
	}
	return ( rVal1 == -1 || rVal2 == -1 )? -1 : 0;
}

template < typename T >
unsigned long int SharedMem<T>::amountOfAttachedProcesses() const{
	shmid_ds state;
	shmctl ( this->segment_id,IPC_STAT,&state );
	return state.shm_nattch;
}


template < typename T >
T SharedMem<T>::write (  T object ) {
	*(this->ptr) = object;
	return *ptr;
}

template < typename T >
T SharedMem<T>::read () {
	return *ptr;
}


#endif /* SHAREDMEM_C_ */
