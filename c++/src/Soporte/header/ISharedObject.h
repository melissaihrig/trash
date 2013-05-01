/*
 * ISharedObject.h
 *
 *  Created on: Apr 6, 2013
 *      Author: santiago
 */

#ifndef ISHAREDOBJECT_H_
#define ISHAREDOBJECT_H_

namespace soporte {


	template < typename T >	class ISharedObject {
	public:
			virtual ~ISharedObject () {}
			virtual T write (   T object ) = 0;
			virtual T read () = 0;
			virtual int lock () = 0;
			virtual int unlock() = 0;
	};
};
#endif /* ISHAREDOBJECT_H_ */
