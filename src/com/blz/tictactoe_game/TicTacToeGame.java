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
		while (player1Position.contains(player1Pos) || player2Position.contains(player1Pos)) {
			System.out.println("Position is taken, Enter a correct Position");
			player1Pos = SC.nextInt();
		}
		placeOnBoard(ticTacToeBoard, player1Pos, "player1", symbolPlayer1);
		showBoard(ticTacToeBoard);
	}
	
	public void computerSelectPositon(char[][] ticTacToeBoard, char symbolPlayer2) {

		int player2Pos;
		player2Pos = random.nextInt(9)+1;
		while (player1Position.contains(player2Pos) || player2Position.contains(player2Pos)) {
			System.out.println("Position is taken, Enter a correct Position");
			player2Pos = random.nextInt(9)+1;
		}
		placeOnBoard(ticTacToeBoard, player2Pos, "player2", symbolPlayer2);
		showBoard(ticTacToeBoard);
	}
	
	public String tossCoin() {

		System.out.println("Choose Option\n1.Head 0 \n2.Tail 1\n");
		int options = SC.nextInt();
		int tossVal = 0;
		if (options == 1) {
			tossVal = 0;
		} else if (options == 2) {
			tossVal = 1;
		} else {
			System.out.println("Invalid Input");
		}
		int tossRandVal = random.nextInt(2);
		System.out.println("Toss value : " + tossRandVal);
		if (tossRandVal == tossVal) {
			System.out.println("Human Turn");
			return "Human";
		} else {
			System.out.println("Computer Turn");
			return "Computer";
		}
	}
	
	public void chooseXOUserComp(char[][] ticTacToeBoard) {
		String firstTurn = tossCoin();
		char symbolPlayer1 = 0;
		char symbolPlayer2 = 0;
		if (firstTurn.equals("Human")) {
			symbolPlayer1 = choose_XO();
			
			if (symbolPlayer1 == 'X') {
				symbolPlayer2 = 'O';
			} else if (symbolPlayer1 == 'O') {
				symbolPlayer2 = 'X';
			}
			selectingPositionsOfPlayer(ticTacToeBoard, symbolPlayer1, symbolPlayer2, "Human");
		} else {
			int compToss_XO = random.nextInt(2);
			if (compToss_XO == 1) {
				symbolPlayer2 = 'X';
				symbolPlayer1 = 'O';
			} else if (compToss_XO == 0) {
				symbolPlayer2 = 'O';
				symbolPlayer1 = 'X';
			}
			selectingPositionsOfPlayer(ticTacToeBoard, symbolPlayer1, symbolPlayer2, "Computer");
		}
	}
	
	public void selectingPositionsOfPlayer(char[][] ticTacToeBoard, char symbolPlayer1, char symbolPlayer2,
			String firstPlay) {
		if (firstPlay.equals("Human")) {
			while (true) {
				userSelectPositon(ticTacToeBoard, symbolPlayer1);
				computerSelectPositon(ticTacToeBoard, symbolPlayer2);
			}
		} else {
			while (true) {
				computerSelectPositon(ticTacToeBoard, symbolPlayer2);
				userSelectPositon(ticTacToeBoard, symbolPlayer1);
			}
		}
	}
	public static void main(String[] args) {
		TicTacToeGame ticTacToeGame = new TicTacToeGame();
		char[][] ticTacToeBoard = ticTacToeGame.createTicTacToeBoard();	
		ticTacToeGame.chooseXOUserComp(ticTacToeBoard);
	}
}
