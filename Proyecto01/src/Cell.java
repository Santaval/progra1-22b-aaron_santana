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

	// function priorityFigure() do  returns Figure object
	public Figure priorityFigure() {
		// if verticalFigure exist and verticalFigure(Cells) >= 5 do 
		if(this.verticalFigure != null && this.verticalFigure.figure.size() >= 5){
				// return verticalFigure
				return this.verticalFigure;
		}// end
			//else if horizontalalFigure exist and horizontalalFigure(Cells) >= 5 do 
		if (this.horizontalFigure != null && this.horizontalFigure.items()  >= 5){
			//return horizontalalFigure
			return this.horizontalFigure;
		}// end
		// else if LFigure extist do 
		if (this.LFigure != null && verticalFigure.items() >= 5){
			//return LFigure
			return this.LFigure;
		}// end
		// else if Tfigure exist do 
		if (this.TFigure != null && TFigure.items() >= 6){
			//return Tfigure
			return this.TFigure;
		}// end
		// else if verticalFigure exist do
		if (this.verticalFigure != null){ 
		 	//return verticalFigure
			return this.verticalFigure;
		}// end
		// else if horizontalalFigure exist do
		if (this.horizontalFigure != null){ 
			//return horizontalalFigure
			return this.horizontalFigure;
		}// end
		// else do 
		else {
			// return null
			return null;
		}	// end
	}// end


	public void eliminate(){
		this.type = '-';
		this.color = '-';
	}
	

}
