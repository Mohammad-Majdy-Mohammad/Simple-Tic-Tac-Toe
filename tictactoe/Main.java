package tictactoe;

import java.util.Scanner;

public class Main {
	
	
	static char[][] grid = new char[3][3];
	
	
	private static void printTheGame() {
		
		System.out.println("---------");
		for (int i = 0; i < grid.length; ++i) {
	
			System.out.print("| ");
			for (int j = 0; j < grid[i].length; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println("|");
		}
		System.out.println("---------");		
	}
	
	
	
	
	
	private static char checkAWinner() {
		
		int xWins = 0;
		int oWins = 0;
		
		int column = 0;
		int row = 0;
		for (int i = 0; i < grid.length; i++) { // checking rows and columns at the same time
			
			if (grid[i][0] == 'X' && grid[i][1] == 'X' && grid[i][2] == 'X') {
				++xWins;
			} else if (grid[i][0] == 'O' && grid[i][1] == 'O' && grid[i][2] == 'O') {
				++oWins;
			}
			
			if (grid[0][i] == 'X' && grid[1][i] == 'X' && grid[2][i] == 'X') {
				++xWins;
			} else if (grid[0][i] == 'O' && grid[1][i] == 'O' && grid[2][i] == 'O') {
				++oWins;
			}
			
		}
		
		
		if (grid[0][0] == 'X' && grid[1][1] == 'X' && grid[2][2] == 'X') {
			++xWins;
		} else if (grid[0][0] == 'O' && grid[1][1] == 'O' && grid[2][2] == 'O') {
			++oWins;
		}
		
		
		if (grid[0][2] == 'X' && grid[1][1] == 'X' && grid[2][0] == 'X') {
			++xWins;
		} else if (grid[0][2] == 'O' && grid[1][1] == 'O' && grid[2][0] == 'O') {
			++oWins;
		}
		
		
		if (xWins == 1 && oWins == 0) {
			return 'X';
		} else if (oWins == 1 && xWins == 0) {
			return 'O';
		} 			
		
		return 'D';
		
	}
	
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
			
		printTheGame();
	
		int count = 0;
		boolean isDone = false;
		while (!isDone && count < 9) {
		
			System.out.print("Enter the coordinates: ");
			String x = scan.next();
			String y = scan.next();
			
			System.out.println();
			
			if (!x.matches("[0-9]")) {
				
				System.out.println("You should enter numbers!");
			
			} else if(Integer.parseInt(x) < 1 || Integer.parseInt(x) > 3 || Integer.parseInt(y) < 1 || Integer.parseInt(y) > 3) {
				
				System.out.println("Coordinates should be from 1 to 3!");
				
			} else {
				
				if (Character.toString(grid[Integer.parseInt(x) - 1][Integer.parseInt(y) - 1]).matches("[^XO]")) {
				
					grid[Integer.parseInt(x) - 1][Integer.parseInt(y) - 1] = (count + 2) % 2 == 0 ? 'X' : 'O';
					++count;
					printTheGame();
					
					char status = checkAWinner();
					
					if (status == 'D' && count == 9) {
						
						System.out.println("Draw");
						isDone = true;
						
					} else if (status == 'X') {
						
						System.out.println("X wins");
						isDone = true;
						
					} else if (status == 'O') {
						
						System.out.println("O wins");
						isDone = true;
						
					}
				
				} else {
					
					System.out.println("This cell is occupied! Choose another one!");
				
				}
				
			}
		
		}
	}
	
}
