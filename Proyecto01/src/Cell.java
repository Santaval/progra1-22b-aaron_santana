public class Cell {
  //atributes 
	// set rowIndex := 0
	public int rowIndex = 0;
  // set colIndex := 0
	public int colIndex  = 0;
  // set type := '\0'
	public char type = '\0';
  // set color := '\0'
	public char color = '\0';
	// set horizontalFigure := null
	public Figure horizontalFigure = null;
  //   set verticalFigure := null
	public Figure verticalFigure = null;
	//set LFigure := null
	public Figure LFigure = null;
	//set TFigure := null
	public Figure TFigure = null;
  // set TYPES := "RVHWB"
	private final String TYPES = "RVHWB";
  // set COLORS := "123456"
	private final String COLORS = "123456";

  // constructor Cell(cellString, rowIndex, colIndex) do
	public Cell (String cellString, int rowIndex, int colIndex){ 
  // rowIndex := rowIndex
	this.rowIndex = rowIndex;
  // colIndex := colIndex
	this.colIndex = colIndex;
  // type := cellString[0]
	this.type = cellString.charAt(0);
  // color := cellString[1]
	this.color = cellString.charAt(1);
  }// end
  // function validate () do
	public boolean validate(){
		// if TYPES have type AND COLORS have color do 
		if (TYPES.contains(this.type + "") && COLORS.contains(this.color + "")){
			// return true
			return true;
		}// end
		// return false
		return false;
  }
	// function compareEquals (otherCell) do 
	public boolean compareEquals(Cell otherCell){
		// if this Cell color equals to otherCell color do
		if (this.color == otherCell.color){ 
			//return true
			return true;
		}// end
		//return false
		return false;
	}// end
	// function exists (gameBoard, rowIndex, colIndex) do
	public static boolean exists (Cell[][] gameBoard, int rowIndex, int colIndex){
		// if row < gameBoard(row) AND col < gameBoard(col) do
		if (rowIndex < gameBoard.length && colIndex < gameBoard[rowIndex].length){
			// return true
			return true;
		}// end
		// return false
		return false;
	}// end

	// function boolean hasFigure() do 
	public boolean hasFigure(){
		// if (verticalFigure OR horizontalFigure) NOT null do 
		if (this.verticalFigure != null && this.verticalFigure.items() >= 3){
			// return true
			return true;
		}// end
		if (this.horizontalFigure != null && this.horizontalFigure.items() >= 3){
			// return true
			return true;
		}// end
		// return false
		return false;
	}// end

	// 	procedure delete (gameBoard) do 
	public void delete (Cell[][] gameBoard){
		// switch (type) do
		switch(this.type){
			//case 'R': setDefaultValues()
			case 'R': setDefaultValues(); break;
			//case 'V': deleteCol(gameBoard)
			case 'V': deleteCol(gameBoard); break;
			//case 'H': deleteRow(gameBoard)
			case 'H': deleteRow(gameBoard); break;
			//case 'W': wrapped(gameBoard)
			case 'W': wrapped(gameBoard); break;
			//case 'B': colorBomb(gameBoard)
			case 'B': colorBomb(gameBoard); break;
		}// end
	}// end

	// procedure setDefaultValues () do
	public void setDefaultValues(){ 
		//type = '-'
		this.type = '-';
		//color = '-'set horizontalFigure := null
		this.color = '-';
		//figures := null
		this.verticalFigure = null;
		this.horizontalFigure = null;
		this.TFigure = null;
		this.LFigure = null;
	}// end

	// procedure deleteCol()do
	public void deleteCol(Cell[][] gameBoard){
		//setDefaultValues()
		this.setDefaultValues();
		//for rowIndex to gameBoard(row) do
		for (int rowIndex = 0; rowIndex < gameBoard.length; rowIndex++){
			//gameBoard[rowIndex][col].delete()
			gameBoard[rowIndex][this.colIndex].delete(gameBoard);
		}//end
	}// end

	// procedure deleteCol()do
	public void deleteRow(Cell[][] gameBoard){
		//setDefaultValues()
		this.setDefaultValues();
		//for rowIndex to gameBoard(row) do
		for (int colIndex = 0; colIndex < gameBoard[this.rowIndex].length; colIndex++){
			//gameBoard[rowIndex][col].delete()
			gameBoard[this.rowIndex][colIndex].delete(gameBoard);
		}//end
	}// end

	//procedure wrapped(gameBoard) do 
	public void wrapped(Cell[][] gameBoard){
		//setDefaultValues()
		this.setDefaultValues();
		//for rowIndex = row 1 to row + 2 do 
		for (int rowIndex = this.rowIndex - 1; rowIndex < this.rowIndex + 1; rowIndex ++){
			//for colIndex = col - 1 to row + 2 do 
			for (int colIndex = this.colIndex - 1; colIndex < this.colIndex + 1; colIndex++){
				if(colIndex >= 0 && rowIndex >= 0){
					//gameBoard[rowIndex][colIndex].delete()
					gameBoard[rowIndex][colIndex].delete(gameBoard);
				}
			}//end
		}//end
	}// end

	// procedure colorBomb(gameBoard) do
	public void colorBomb(Cell[][] gameBoard){
		//setDefaultValues()
		this.setDefaultValues();
		//for rowIndex to gameBoard(row) do 
		for (int rowIndex = 0; rowIndex < gameBoard.length; rowIndex++){
			//for colIndex to gameBoard(col) do
			for (int colIndex = 0; colIndex < gameBoard[this.rowIndex].length; colIndex ++){ 
				//if compareEquals(gameBoard[rowIndex][colIndex]) do
				if (this.compareEquals(gameBoard[rowIndex][colIndex])){
					//gameBoard[rowIndex][colIndex].delete()
					gameBoard[rowIndex][colIndex].delete(gameBoard);
				}//end
			}//end
		}//end
	}// end

	// procedure determinateType(eliminateFigure) do 
	// 	switch(eliminateFigure.type) do 
	// 			case 'V': setTypeHorizontalOrVerticalFigures('V', eliminateFigure)
	// 			case 'H': setTypeHorizontalOrVerticalFigures('H', eliminateFigure)
	// 			case 'L': 
	// 					type = 'W'
	// 					color = eliminateFigure.getColor()
	// 			case 'T': 
	// 					type = 'W'
	// 					color = eliminateFigure.getColor()
						
	// 	end
	// end

	// procedure setTypeHorizontalOrVerticalFigures (type, eliminateFigure) do
	// 	if eliminateFigure.items() <= 3 do
	// 			type = '-'
	// 			color = '-'
	// 	end

	// 	else if eliminateFigure.items() == 4 do
	// 			type = type
	// 			color = eliminateFigure.getColor()
	// 	end

	// 	else if eliminateFigure.items() >= 5 do
	// 			type = 'B'
	// 			color = eliminateFigure.getColor()
	// 	end
	// end


}
