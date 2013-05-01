/*
 * Tablero.cpp
 *
 *  Created on: Mar 29, 2013
 *      Author: santiago
 */

#include	"../header/Board.h"

const string Board::score = "CHANCHO";

Board::Board ( int numberOfPlayers ) {

	this->numberOfPlayers = numberOfPlayers;
	this->loser = Constants::THERE_IS_NOT_LOSER;
	this->board = new char[numberOfPlayers];

	this->initBoard();
}

Board& Board::operator= ( const Board& board )
{
	this->numberOfPlayers = board.getNumberOfPlayers();
	this->loser = board.getTheLoser();
cout<<"COpia" << endl;
	for (int player = 0; player < numberOfPlayers; player++)
	{	this->board[player] = board.getScore( player + 1 );
		cout<<this->board[player] << " " <<  board.getScore( player + 1 ) << endl;
	}
	return *this;
}

Board::~Board() {
	delete [] this->board;
}

int Board::updateScore ( int playerID ) {

	if ( playerID > this->getNumberOfPlayers() )
		return -1;

	board[playerID - 1]++;

	if ( board[playerID - 1] >= (int) score.length() )
		loser = playerID;

	return 0;
}

string Board::getStringScore ( int playerID ) const {

	if ( playerID > this->getNumberOfPlayers() )
		return "---";

	return score.substr ( 0, board[ playerID - 1] );
}

int Board::getScore ( int playerID ) const {

	if ( playerID > this->getNumberOfPlayers() )
		return -1;

	return board[ playerID - 1];
}

bool Board::thereIsALoser() const {
	return loser != Constants::THERE_IS_NOT_LOSER;
}

int Board::getTheLoser() const {
	return loser;
}

void Board::lookAtScore() const {

	cout << "Jugador          Puntaje " << endl;

	for ( int playerID = 1; playerID <= this->getNumberOfPlayers(); playerID++ )
		cout << "   " <<playerID << "             " << this->getStringScore( playerID ) << endl;
}

int Board::getNumberOfPlayers() const {
	return this->numberOfPlayers;
}

void Board::initBoard() {

	for ( int player = 0; player < numberOfPlayers; player++ )
		this->board[player] = 0;
}
