import java.util.ArrayList;
import java.util.Scanner;

public class GameBoard {
		//atributes
		// set gameBoard := null
		private Cell[][] gameBoard = null;
		// set boardFigures := null
		private ArrayList <Figure> boardFigures = null;

	// constructor GameBoard (rowCount, colCount) do 
	public GameBoard(int rowCount, int colCount){
		// if (rowCount >= 3 AND colCount >= 3) do
		if (rowCount >= 3 && colCount >= 3){
			// gameBoard := new Cell[rowCount][colCount]
			this.gameBoard = new Cell[rowCount][colCount];
			this.boardFigures = new ArrayList<>(0);
		}// end 
		// else do
		else { 
			// throw ERR
			throw new IndexOutOfBoundsException("invalid terrain");
		}// end
	}// end

	public int getRows(){
		return this.gameBoard.length;
	}

	public int getCols(){
		return this.gameBoard[0].length;
	}

	public Cell[][] getGameBoard(){
		return this.gameBoard;
	}

	

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


	// procedure searchBoardFigures() do
	public void searchFigures(){
		//for rowIndex to gameBoard(row) do
		for (int rowIndex = 0; rowIndex < this.gameBoard.length; rowIndex++){
			//for colIndex to gameBoard(col) do
			for (int colIndex = 0; colIndex < this.gameBoard[rowIndex].length; colIndex++){


							//if gameBoard[rowIndex][colIndex].verticalFigure == null do
							if (this.gameBoard[rowIndex][colIndex].verticalFigure == null){
								// figures add searchVerticalFigure(rowIndex, colIndex)
								Figure verticalFigure = this.searchVerticalFigure(rowIndex, colIndex);
								if (verticalFigure.items() >= 3){
									this.boardFigures.add(verticalFigure);
								}
							}//end

				//if gameBoard[rowIndex][colIndex].horizontalFigure == null do
				if  (this.gameBoard[rowIndex][colIndex].horizontalFigure == null){
					//figures add searchHorizontalFigure(rowIndex, colIndex) only if has 3 or more elements
					Figure horizontalFigure = this.searchHorizontalFigure(rowIndex, colIndex);
					if (horizontalFigure.items() >= 3){
						this.boardFigures.add(horizontalFigure);
					}
				}//end
				
				//searchLFigure()
				this.searchLFigure(rowIndex, colIndex);
				this.searchTFigure(rowIndex, colIndex);

			}//end
		}//end
	}//end

		// procedure searchVerticalFigure(rowIndex, colIndex) do
		private Figure searchVerticalFigure(int rowIndex, int colIndex){ 
			// set currentFigure = new Figure("V")
			Figure currentFigure = new Figure('V');
			// if  neighboor cell equals to current do
			if (Cell.exists(gameBoard, rowIndex + 1, colIndex + 0) && this.gameBoard[rowIndex][colIndex]
					.compareEquals(this.gameBoard[rowIndex + 1] [colIndex + 0])){
				//currentFigure := recursiveVerticalSearch(curentFigure,rowIndex + 1, colIndex + 0)
				return this.recursiveVerticalSearch(currentFigure, rowIndex, colIndex);
			}// end 
	
			return currentFigure;
	
		}// end
		
			// function recursiveVerticalSearch(curentFigure, rowIndex, colIndex) do
			public Figure recursiveVerticalSearch(Figure currentFigure, int rowIndex, int colIndex){
				// curentFigure add currentCell
				currentFigure.figure.add(this.gameBoard[rowIndex][colIndex]);
				//current cell reference figure
				this.gameBoard[rowIndex][colIndex].verticalFigure = currentFigure;
				// if  rowIndex >= gameBoard(row) OR NOT neighboor cell equals to current  do
				if (rowIndex + 1 >= this.gameBoard.length || !this.gameBoard[rowIndex][colIndex]
					.compareEquals(this.gameBoard[rowIndex + 1] [colIndex + 0])){
					// 	return curentFigure
					return currentFigure;
				}// end
				// return recursiveVerticalSearch(curentFigure,rowIndex + 1, colIndex + 0)
				return this.recursiveVerticalSearch(currentFigure, rowIndex + 1, colIndex + 0);	
			}// end


	// procedure searchHorizontalFigure(rowIndex, colIndex) do
	private Figure searchHorizontalFigure(int rowIndex, int colIndex){ 
		// set currentFigure = new Figure("H")
		Figure currentFigure = new Figure('H');
		// if  neighboor cell equals to current do
		if (Cell.exists(gameBoard, rowIndex + 0, colIndex + 1) && this.gameBoard[rowIndex][colIndex]
				.compareEquals(this.gameBoard[rowIndex + 0] [colIndex + 1])){
			// 	currentFigure := recursiveHorizontalSearch(curentFigure,rowIndex + 0, colIndex + 1)
			return this.recursiveHorizontalSearch(currentFigure, rowIndex , colIndex);
		}// end 
	
		return currentFigure;

	}// end

	// function recursiveHorizontalSearch(curentFigure, rowIndex, colIndex) do
	private Figure recursiveHorizontalSearch(Figure currentFigure, int rowIndex, int colIndex){
		// curentFigure add currentCell
		currentFigure.figure.add(this.gameBoard[rowIndex][colIndex]);
		//current cell reference figure
		this.gameBoard[rowIndex][colIndex].horizontalFigure = currentFigure;
		// if  rowIndex >= gameBoard(col) OR NOT neighboor cell equals to current  do
		if (colIndex + 1 >= this.gameBoard[rowIndex].length){
			// 	return curentFigure
			return currentFigure;
		}// end
		
		if( !this.gameBoard[rowIndex][colIndex].compareEquals(this.gameBoard[rowIndex + 0] [colIndex + 1])){
			return currentFigure;
		}
		// return recursiveHorizontalSearch(curentFigure,rowIndex + 0, colIndex + 1)
		return this.recursiveHorizontalSearch(currentFigure, rowIndex + 0, colIndex + 1);	
	}// end


	

		// procedure searchLFigure(rowIndex, colIndex) do
		private void searchLFigure(int rowIndex, int colIndex){ 
			// if gameBoard[rowIndex][colIndex] have horizontalFigure and verticalFigure and Lfigure == null do
			Cell curentCell = this.gameBoard[rowIndex][colIndex];
			if (curentCell.horizontalFigure != null && curentCell.horizontalFigure.isLastOrFirstCell(curentCell)){
				if (curentCell.verticalFigure != null && curentCell.verticalFigure.isLastOrFirstCell(curentCell)){
					if (curentCell.verticalFigure.items() >= 3 && curentCell.horizontalFigure.items() >= 3){
						if	(curentCell.LFigure == null){
							//LFigure := new Figure('L')
							// LFigure.figure.add(horizontalFigure and verticalFigure cells)
							Figure LFigure = Figure.combine(curentCell.horizontalFigure, curentCell.verticalFigure, 'L');
							this.boardFigures.add(LFigure);

			
						}
					}
				}
			} // end
				
			
		}// end

		// procedure searchLFigure(rowIndex, colIndex) do
		private void searchTFigure(int rowIndex, int colIndex){ 
			// if gameBoard[rowIndex][colIndex] have horizontalFigure and verticalFigure and Lfigure == null do
			Cell curentCell = this.gameBoard[rowIndex][colIndex];
			if (curentCell.horizontalFigure != null && curentCell.verticalFigure != null){
				if ((!curentCell.verticalFigure.isLastOrFirstCell(curentCell) && curentCell.horizontalFigure.isLastOrFirstCell(curentCell)) || (curentCell.verticalFigure.isLastOrFirstCell(curentCell) && !curentCell.horizontalFigure.isLastOrFirstCell(curentCell)) ){
					if (curentCell.verticalFigure.items() >= 3 && curentCell.horizontalFigure.items() >= 3){
						if	(curentCell.TFigure == null){
							//LFigure := new Figure('T')
							// LFigure.figure.add(horizontalFigure and verticalFigure cells)
							Figure TFigure = Figure.combine(curentCell.horizontalFigure, curentCell.verticalFigure, 'T');
							this.boardFigures.add(TFigure);
						}	
					}
				}
			} // end
		}// end


		//procedure deleteFigure() do 
		public void deleteFigure() {
			//set deleteFigure = Figure.priorityFigure(boardFigures);
			Figure deleteFigure = Figure.priorityFigure(this.boardFigures);
			//for index to deleteFigure.items() do 
			for (int index = 0; index < deleteFigure.items(); index ++){
				//figure[index].delete(gameBoard)
				deleteFigure.figure.get(index).delete(this.gameBoard);
			}//end
			//deleteFigure[0].determinateType(deleteFigure)
			//deleteFigure.figure.get(0).determinateType(deleteFigure);
		}//end

	// procedure print() do
	public void print(){ 
		for (int rowIndex = 0; rowIndex < this.gameBoard.length; rowIndex ++){ 
			for (int colIndex = 0; colIndex < this.gameBoard[rowIndex].length; colIndex++){
				final Cell currentCell = this.gameBoard[rowIndex][colIndex];
				try{
				
					System.out.printf("%s%s ", currentCell.type, currentCell.color);
				} catch (Exception err){
					System.out.printf("-- ");
				}
			}
			System.out.print("\n");
		}
	}// end
	
	
	// public void printFigureTypes(){
	// 	for (int index = 0; index < boardFigures.size(); index++){
	// 		System.out.println(this.boardFigures.get(index).type);
	// 	}
	// }

}




