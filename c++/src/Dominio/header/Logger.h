/*
 * Logger.h
 *
 *  Created on: Mar 29, 2013
 *      Author: santiago
 */

#ifndef LOGGER_H_
#define LOGGER_H_

#include "Player.h"
#include "Decorator.h"
#include "../../Soporte/header/LockFile.h"
#include "Board.h"
#include <time.h>





class LoggerPlayer : public Decorator {
private:
	Player  *player ;
	LockFile* lf;


public:
	LoggerPlayer ( Player &player);
	~LoggerPlayer () ;
	void operation ();
};


class LoggerBoard : public Decorator {
private:
	Board& board ;

public:
	LoggerBoard (const Board& board);
	~LoggerBoard () ;
	void operation ();
};


#endif /* LOGGER_H_ */
