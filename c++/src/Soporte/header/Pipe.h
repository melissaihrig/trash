/*
 * Pipe.h
 *
 *  Created on: Mar 31, 2013
 *      Author: santiago
 */

#ifndef PIPE_H_
#define PIPE_H_




template< class T> class Pipe {
private:
	int fd [2] ;
	void* buffer;
	int fdNum;

public:
	Pipe();
	virtual ~Pipe();

	void setFileDescriptor (int fd);
	T& writer ( const T& objetoGenerico) ;
	T& read () ;
};

#endif /* PIPE_H_ */
