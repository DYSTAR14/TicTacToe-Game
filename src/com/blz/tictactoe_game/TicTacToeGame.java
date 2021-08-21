package com.blz.tictactoe_game;

import java.util.Scanner;

public class TicTacToeGame {
	static final Scanner SC = new Scanner(System.in);
	
	public char[][] createTicTacToeBoard() {
		char[][] ticTacToeBoard = { { '1', '|', '2', '|', '3' }, 
				{ '-', '+', '-', '+', '-' },
				{ '4', '|', '5', '|', '6' }, 
				{ '-', '+', '-', '+', '-' }, 
				{ '7', '|', '8', '|', '9' } };
		return ticTacToeBoard;
	}

	public char choose_XO() {
		System.out.println("Choose between X or O");
		char letter = SC.next().charAt(0);
		if (letter == 'x' || letter == 'X') {
			letter = 'X';
			return letter;
		} else if (letter == 'o' || letter == 'O') {
			letter = 'O';
			return letter;
		} else {
			System.out.println("Invalid Input");
			return 0;
		}
	}
	
	public void chooseXOUserComp(char[][] ticTacToeBoard) {
		char symbolPlayer = 0;
		char symbolComputer;
		symbolPlayer = choose_XO();

		if (symbolPlayer == 'X') {
			symbolComputer = 'O';
		} else if (symbolPlayer == 'O') {
			symbolComputer = 'X';
		}
	}
	
	public void showBoard(char[][] ticTacToeBoard) {
		System.out.println("Tic Tac Toe Game Board");
		for (char[] row : ticTacToeBoard) {
			for (char col : row) {
				System.out.print(col + " ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		char[][] ticTacToeBoard = ticTacToeGame.createTicTacToeBoard();	
		ticTacToeGame.chooseXOUserComp(ticTacToeBoard);
		ticTacToeGame.showBoard(ticTacToeBoard);
	}
}
