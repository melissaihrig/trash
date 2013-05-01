/*
 * Tablero.h
 *
 *  Created on: Mar 29, 2013
 *      Author: santiago
 */

#ifndef BOARD_H_
#define BOARD_H_

#include	<iostream>
#include 	<vector>

#include 	"../../Constants.h"

using namespace std;

class Board {

private:

	friend class SharedMemBoard;

	static const string score;
	unsigned char* 		board;
	int 				numberOfPlayers;
	int 				loser;

	void initBoard();

public:
	Board ( int numberOfPlayers );
	virtual ~Board ();

	Board& operator= ( const Board& board );

	int updateScore ( int playerID );
	string getStringScore ( int playerID ) const;
	unsigned char getScore ( int playerID ) const;
	void lookAtScore () const;

	bool thereIsALoser () const;
	int getTheLoser () const;

	int getNumberOfPlayers () const;
};

#endif /* BOARD_H_ */
