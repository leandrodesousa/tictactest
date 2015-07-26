package expedia.tictac.test;

import java.util.Scanner;

public class TicTacToeGame {

	static Scanner scanner = new Scanner(System.in);
	
	static int col;
	static int line;
	static String player = "x";
	
	static String[][] table = new String[3][3];
	
	/**
	 * 
	 * @param args
	 */
	public void main(String[] args){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				table[i][j] = new String("_");
			}
		}
		
		showTable();
		game();
	}
	
	/**
	 * game method (controller of the game)
	 */
	public String game(){
		boolean isGameAlive = true;
		String result = "Game over!";
		while(isGameAlive){
			System.out.println(player + " - Type the line number (1 to 3): ");
			line = scanner.nextInt();
			if(line > 0){
				line --;
			} else if(line == 0 || line > 3){
				System.out.println("Wrong number, game over!");
				return result;
			}
			
			System.out.println(player + " - Type the column number (1 to 3): ");
			col = scanner.nextInt();
			if(col > 0){
				col --;
			} else if(col == 0 || col > 3) {
				System.out.println("Wrong number, game over!");
				return result;
			}
			
			if(table[line][col] != null && !table[line][col].equals("_")){
				System.out.println("Type other numbers!");
			} else {
				table[line][col] = player;
				
				if(hasWinner(line, col)){
					isGameAlive = false;
					System.out.println("We have a winner! The player: " + player + " wins!!!");
					result = "We have a winner!";
					
					System.out.println(">>>" + table[line][col]);
				}

				if(player == "x"){
					player = "o";
				} else {
					player = "x";
				}
			}
			showTable();
		}
		
		return result;
	}
	
	/**
	 * Method to show tictac table
	 */
	public void showTable(){
		for(int i = 0; i < 3; i++){
			for(int j = 0; j < 3; j++){
				if(j == 2){
					System.out.print("_");
				} else {
					System.out.print(table[i][j] + "|");
				}
				
			}
			System.out.println();
		}
	}
	
	/**
	 * 
	 * Method that checks if there is a winner, checking lines and diagonals match
	 * 
	 * @param lNumber
	 * @param cNumber
	 * @return
	 */
	public boolean hasWinner(int lNumber, int cNumber){
		
		if(table[0][cNumber] == table[1][cNumber] && table[0][cNumber] == table[2][cNumber])
			return true;
		
		if(table[lNumber][0] == table[lNumber][1] && table[lNumber][0] == table[lNumber][2])
			return true;
		
		if(table[0][0] == table[1][1] && table[0][0] == table[2][2] && table[1][1] != "_" )
			return true;
		
		if(table[0][2] == table[1][1] && table[0][2] == table[2][0] && table[1][1] != "_" )
			return true;
		
		return false;
	}
}
