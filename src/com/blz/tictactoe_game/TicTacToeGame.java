package com.blz.tictactoe_game;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class TicTacToeGame {
	static final Scanner SC = new Scanner(System.in);
	static List<Integer> player1Position = new ArrayList<>();
	static List<Integer> player2Position = new ArrayList<>();
	Random random = new Random();
	
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
		char symbolComputer = 0;
		symbolPlayer = choose_XO();

		if (symbolPlayer == 'X') {
			symbolComputer = 'O';
		} else if (symbolPlayer == 'O') {
			symbolComputer = 'X';
		}
		userSelectPositon(ticTacToeBoard,symbolPlayer);
		computerSelectPositon(ticTacToeBoard,symbolComputer);
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
	
	public void placeOnBoard(char[][] ticTacToeBoard, int pos, String user, char symbol) {

		if (user.equals("player1")) {
			TicTacToeGame.player1Position.add(pos);
		} else if (user.equals("player2")) {
			TicTacToeGame.player2Position.add(pos);
		}

		switch (pos) {
		case 1:
			ticTacToeBoard[0][0] = symbol;
			break;
		case 2:
			ticTacToeBoard[0][2] = symbol;
			break;
		case 3:
			ticTacToeBoard[0][4] = symbol;
			break;
		case 4:
			ticTacToeBoard[2][0] = symbol;
			break;
		case 5:
			ticTacToeBoard[2][2] = symbol;
			break;
		case 6:
			ticTacToeBoard[2][4] = symbol;
			break;
		case 7:
			ticTacToeBoard[4][0] = symbol;
			break;
		case 8:
			ticTacToeBoard[4][2] = symbol;
			break;
		case 9:
			ticTacToeBoard[4][4] = symbol;
			break;
		default:
			break;
		}
	}
	
	public void userSelectPositon(char[][] ticTacToeBoard, char symbolPlayer1) {
		System.out.println("Enter your Place (1 to 9):");
		int player1Pos = SC.nextInt();
		placeOnBoard(ticTacToeBoard, player1Pos, "player1", symbolPlayer1);
		showBoard(ticTacToeBoard);
	}
	
	public void computerSelectPositon(char[][] ticTacToeBoard, char symbolPlayer2) {

		int player2Pos;
		player2Pos = random.nextInt(9)+1;
		placeOnBoard(ticTacToeBoard, player2Pos, "player2", symbolPlayer2);
		showBoard(ticTacToeBoard);
	}
	
	public static void main(String[] args) {
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		char[][] ticTacToeBoard = ticTacToeGame.createTicTacToeBoard();	
		ticTacToeGame.chooseXOUserComp(ticTacToeBoard);
	}
}
