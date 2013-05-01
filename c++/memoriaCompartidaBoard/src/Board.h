/*
 * Tablero.h
 *
 *  Created on: Mar 29, 2013
 *      Author: santiago
 */

#ifndef BOARD_H_
#define BOARD_H_

#include <iostream>
#include <vector>

#include "Constants.h"

using namespace std;

class Board {
public:
	static const string score;
	char* board;
	int numberOfPlayers;
	int loser;

	void initBoard();

public:
	Board(int numberOfPlayers);
	Board& operator=( const Board& board );
	int updateScore ( int playerID );
	string getStringScore ( int playerID ) const;
	int getScore ( int playerID ) const;
	bool thereIsALoser() const;
	int getTheLoser() const;
	int getNumberOfPlayers() const;
	int getPositionLastLetter(int posicion) const;
	virtual ~Board();
	void lookAtScore() const;
	void copiar(Board* boardOriginal);

	friend class MemoriaCompartidaBoard;
};

#endif /* BOARD_H_ */
