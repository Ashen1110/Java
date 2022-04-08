# Tic-Tac-Toe

## 功能：
* class name: TicTacToe
* 兩個玩家對戰，先者為 X；後者為 O
* 結束一局後可以選擇是否要再來一局

## 執行方法：
* 在本目錄下執行 makefile

## 函式
* public enum GameState
	  - new class name
	  - enumerated constants for gamestate: playing, X win, O win, draw
* public enum Seed
	  - new class name
	  - enumerated constants for the seeds and cell constants
* public static void initGame()
	  - Initialize the game-board contents and the current states
* public static void playerMove(Seed theSeed)
	  - player who is the seed can move
	  - check whether the player move is legal or not
	  - update game board contents
* public static void updateGame(Seed theSeed, int currentRow, int currentCol)
	  - update the current game state after seed player move
* public static boolean isDraw()
	  - check if it is draw
* public static boolean hasWon(Seed theSeed, int currentRow, int currentCol)
	  - Return true if the player with "theSeed" has won after moving
* public static void printBoard() 
	  - print the whole board 
* public static void printCell(Seed content)
	  - print a cell with specify conent
* public static void again()
	  - ask players whether want to play again or not after the end of this round
* public static void game()
	  - the process of this game (the uniom of all functions above)

