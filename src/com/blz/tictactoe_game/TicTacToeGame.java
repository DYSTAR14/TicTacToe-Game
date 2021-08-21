package com.blz.tictactoe_game;

public class TicTacToeGame {
	public char[][] createTicTacToeBoard() {
		char[][] ticTacToeBoard = { { '1', '|', '2', '|', '3' }, 
				{ '-', '+', '-', '+', '-' },
				{ '4', '|', '5', '|', '6' }, 
				{ '-', '+', '-', '+', '-' }, 
				{ '7', '|', '8', '|', '9' } };
		return ticTacToeBoard;
	}

	public static void main(String[] args) {
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		char[][] ticTacToeBoard = ticTacToeGame.createTicTacToeBoard();
		
	}
}
