/*
 * Pipe.cpp
 *
 *  Created on: Mar 31, 2013
 *      Author: santiago
 */

#include "../header/Pipe.h"
#include <stdio.h>
#include <stdlib.h>
#include <errno.h>
#include <sys/types.h>
#include <unistd.h>


inline   int _write(int fd, void * ptr, int numbytes) {
	return write (fd,ptr,numbytes);
}

inline  int _read(int fd, void * ptr, int numbytes) {
	return read(fd,ptr,numbytes);
}

template< class T> Pipe<T>::Pipe() {
	buffer = (char *) malloc(sizeof (T));
	pipe (fd);
	fdNum = -1;
}

template< class T> Pipe<T>::~Pipe() {
	free(buffer);
	close (fd[fdNum]);
}

template< class T> void Pipe< T>::setFileDescriptor( int fd) {
	this->fdNum = fd ;
}

template <class T> T& Pipe< T>::writer ( const T& objetoGenerico)  {
    buffer = memcpy(buffer,&objetoGenerico,sizeof(T));
	_write(fd[fdNum],buffer, sizeof(T));
}

template <class T> T& Pipe< T>::read ()  {
	_read(fd[fdNum], buffer, sizeof(T));
	return ((T&) *buffer);
}
