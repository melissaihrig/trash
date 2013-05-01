/*
 * IProceso.h
 *
 *  Created on: Mar 29, 2013
 *      Author: santiago
 */

#ifndef IPROCESO_H_
#define IPROCESO_H_

class IProceso {
public:
	virtual void run () = 0;
	virtual ~IProceso () {};
};

#endif /* IPROCESO_H_ */
