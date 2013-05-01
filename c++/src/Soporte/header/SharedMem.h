/*
 * SharedMem.h
 *
 *  Created on: Mar 31, 2013
 *      Author: santiago
 */

#ifndef SHAREDMEM_H_
#define SHAREDMEM_H_

#include <string>
#include <sys/types.h>
#include <sys/ipc.h>
#include <sys/shm.h>
#include <stdio.h>

namespace soporte {

template < typename T >
class SharedMem {
private:
	key_t key;
	size_t size;
	int segment_id;
	T* ptr;

public:
	SharedMem( const std::string& str);
	SharedMem( const char*  str);

	virtual ~SharedMem();
	inline int getSegmentID() { return this->segment_id; }
	T write (   T object );
	T read () ;


	unsigned long int amountOfAttachedProcesses() const ;

	/* Especifica el modo de creacion del segmento de memoria
	 * Param:
	 * IPC_CREAT : crea un nuevo segmento,  : public soporte::ISharedObject si ya existe un segmento con dicha clave retorna ese segmento
	 * IPC_CREAT | IPC_EXCL : crea un segmento unico, si ya existe un segmento con la clave retorna error
	 *
	 * Retorno:
	 * Indentificador de segmento
	 * */
	int get (bool exclusive = false);


	/* Desacoplar la memoria
	 * Retorno:
	 * 0 en caso de exito
	 * -1 si hubo error
	 * */
	int detach() ;

	/* Especifica el modo en que será acoplado el segmento de memoria.
	 * Si se especifica SHM_RDONLY como flag entonces el segmento de memoria será de solo lectura.
	 * En caso de no especificar será lectura y escritura.
	 *
	 * Retorno:
	 * Dirección en la que se acoplo la memoria
	 * */
	int attach (bool ronly = false);

};


}

#include "../source/SharedMem.cpp"


#endif /* SHAREDMEM_H_ */
