import java.util.Scanner;

public class TicTacToe{
	
	// Name-constants to represent the various states of the game
	public enum GameState {
		PLAYING, DRAW, CROSS_WON, NOUGHT_WON
	}
	
	// Name-constants to represent the seeds and cell contents
	public enum Seed {
		EMPTY, CROSS, NOUGHT
	}
	
	// The game board and the game status
	public static final int ROWS = 3, COLS = 3; 
	public static Seed[][] board = new Seed[ROWS][COLS];
	
	public static GameState currentState;
	public static Seed currentPlayer;
	public static int currntRow, currentCol;

	public static Scanner in = new Scanner(System.in);
	
	// Initialize the game-board contents and the current states
	public static void initGame() {
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
			    board[row][col] = Seed.EMPTY;
			}
		}
		currentState = GameState.PLAYING;
		currentPlayer = Seed.CROSS;
	}
	
	// Player move
	public static void playerMove(Seed theSeed) {
		
		// for input validation
		boolean validInput = false;
		do {
			if (theSeed == Seed.CROSS)
		    		System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
			else
				System.out.print("Player 'O', enter your move (row[1-3] column[1-3]): ");
		
		 int row = in.nextInt() - 1;
		 int col = in.nextInt() - 1;
		 if (row >= 0 && row < ROWS && col >= 0 && col < COLS && board[row][col] == Seed.EMPTY) {
			currntRow = row;
			currentCol = col;
			board[currntRow][currentCol] = theSeed;
			validInput = true;
		 } 
		 else 
		 	System.out.println("This move at (" + (row + 1) + "," + (col + 1) + ") is not valid. Try again...");
		 	
		} while (!validInput);
	}
	
	//update board
	public static void updateGame(Seed theSeed, int currentRow, int currentCol) {
		if (hasWon(theSeed, currentRow, currentCol))
		 	currentState = (theSeed == Seed.CROSS) ? GameState.CROSS_WON : GameState.NOUGHT_WON;
		else if (isDraw()) currentState = GameState.DRAW;
	}

	// Return true if it is a draw (no more empty cell)
	public static boolean isDraw() {
		for (int row = 0; row < ROWS; ++row) {
			for (int col = 0; col < COLS; ++col) {
				if (board[row][col] == Seed.EMPTY) return false;
			}
		}
		return true;
	}
	
	// Return true if the player with "theSeed" has won
	public static boolean hasWon(Seed theSeed, int currentRow, int currentCol) {
		return (board[currentRow][0] == theSeed && board[currentRow][1] == theSeed && board[currentRow][2] == theSeed ||
			board[0][currentCol] == theSeed && board[1][currentCol] == theSeed && board[2][currentCol] == theSeed ||
			currentRow == currentCol && board[0][0] == theSeed && board[1][1] == theSeed && board[2][2] == theSeed ||
			currentRow + currentCol == 2 && board[0][2] == theSeed && board[1][1] == theSeed && board[2][0] == theSeed );
	}
	
	public static void printBoard() {
		for (int row = 0; row < ROWS; ++row) {
			 for (int col = 0; col < COLS; ++col) {
			 	printCell(board[row][col]);
			    	if (col != COLS - 1) System.out.print("|");  
			 }
			 System.out.println();
			 if (row != ROWS - 1) System.out.println("-----------");
		}
		System.out.println();
	}
	
	public static void printCell(Seed content) {
		switch (content) {
			 case EMPTY:  System.out.print("   "); break;
			 case NOUGHT: System.out.print(" O "); break;
			 case CROSS:  System.out.print(" X "); break;
		}
	}
	
	public static void again(){
		// Prompt the user whether to play again
		System.out.print("Play again (y/n)? ");
		char ans = in.next().charAt(0);
		if (ans != 'y' && ans != 'Y') {
		      System.out.println("Bye!");
		      System.exit(0);  // terminate the program
		   }
	}
	
	public static void game(){
		// Initialize the game-board and current status
		initGame();
		// Play the game once
		do {
			 // update currentRow and currentCol
			 playerMove(currentPlayer);
			 // update currentState
			 updateGame(currentPlayer, currntRow, currentCol);
			 printBoard();
			 
			 // Print message if game-over
			 if (currentState == GameState.CROSS_WON)
			 	System.out.println("'X' won!");
			 
			 else if (currentState == GameState.NOUGHT_WON)
			 	System.out.println("'O' won!");
			 
			 else if (currentState == GameState.DRAW)
			 	System.out.println("It's a Draw!");
			 
			 // Switch player
			 currentPlayer = (currentPlayer == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS;

		} while (currentState == GameState.PLAYING);
	}

	public static void main(String[] args) {
		do{
			game();
			again();
		}while(true);
		
	}
}
