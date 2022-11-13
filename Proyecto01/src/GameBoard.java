import java.util.Scanner;

public class GameBoard {
		//atributes
		// set gameBoard := null
		private Cell[][] gameBoard = null;
		// set boardStructures := null

	// constructor GameBoard (rowCount, colCount) do 
	public GameBoard(int rowCount, int colCount){
		// if (rowCount >= 3 AND colCount >= 3) do
		if (rowCount >= 3 && colCount >= 3){
			// gameBoard := new Cell[rowCount][colCount]
			this.gameBoard = new Cell[rowCount][colCount];
		}// end 
		// else do
		else { 
			// throw ERR
			throw new IndexOutOfBoundsException("invalid terrain");
		}// end
	}// end

	// procedure read() do
	public void read(Scanner input){
		// for rowIndex to gameBoard(row) do
		for (int rowIndex = 0; rowIndex < this.gameBoard.length; rowIndex ++){ 
			// for colIndex to gameBoard(col) do
			for (int colIndex = 0; colIndex < this.gameBoard[rowIndex].length; colIndex++){
				// input cellString
				final String cellString = input.next();
				// gameBoard[rowIndex][colIndex] = new Cell(cellString, rowIndex, colIndex)
				this.gameBoard[rowIndex][colIndex] = new Cell(cellString, rowIndex, colIndex);
			}// end
		}// end
	}// end

	// function validate() do
	public boolean validate(){
		// for 0 to gameBoard(row) do
		for (int rowIndex = 0; rowIndex < this.gameBoard.length; rowIndex ++){ 
			// for 0 to gameBoard(col) do
			for (int colIndex = 0; colIndex < this.gameBoard[rowIndex].length; colIndex++){ 
				// if(NOT gameBoard[rowIndex][colIndex].validate()) do
				if (!this.gameBoard[rowIndex][colIndex].validate()){
					// return false
					return false;
				}// end
			}// end
		}// end
		// return true
		return true;
	}// end

	// procedure print() do
	public void print(){ 
		// output gameBoard
		for (int rowIndex = 0; rowIndex < this.gameBoard.length; rowIndex ++){ 
			for (int colIndex = 0; colIndex < this.gameBoard[rowIndex].length; colIndex++){
				final Cell currentCell = this.gameBoard[rowIndex][colIndex];
				System.out.printf("%s%s ", currentCell.getType(), currentCell.getColor());
			}
			System.out.print("\n");
		} 
	}// end 
}