public class Cell {
  // atributes
  // set rowIndex := 0
  public int rowIndex = 0;
  // set colIndex := 0
  public int colIndex = 0;
  // set type := '\0'
  public char type = '\0';
  // set color := '\0'
  public char color = '\0';
  // set horizontalFigure := null
  public Figure horizontalFigure = null;
  // set verticalFigure := null
  public Figure verticalFigure = null;
  // set LFigure := null
  public Figure LFigure = null;
  // set TFigure := null
  public Figure TFigure = null;
  // set types := "RVHWB"
  private final String types = "RVHWB";
  // set COLORS := "123456"
  private final String COLORS = "123456";

  // constructor Cell(cellString, rowIndex, colIndex) do
  public Cell(String cellString, int rowIndex, int colIndex) {
    // rowIndex := rowIndex
    this.rowIndex = rowIndex;
    // colIndex := colIndex
    this.colIndex = colIndex;
    // type := cellString[0]
    this.type = cellString.charAt(0);
    // color := cellString[1]
    this.color = cellString.charAt(1);
  } // end
  // function validate () do

  public boolean validate() {
    // if types have type AND COLORS have color do
    if (types.contains(this.type + "") && COLORS.contains(this.color + "")) {
      // return true
      return true;
    } // end
    // return false
    return false;
  }

  // function compareEquals (otherCell) do
  public boolean compareEquals(Cell otherCell) {
    // if this Cell color equals to otherCell color do
    if (this.color == otherCell.color) {
      // return true
      return true;
    } // end
      // return false
    return false;
  }// end
   // function exists (gameBoard, rowIndex, colIndex) do

  public static boolean exists(Cell[][] gameBoard, int rowIndex, int colIndex) {
    // if row < gameBoard(row) AND col < gameBoard(col) do
    if (rowIndex < gameBoard.length && colIndex < gameBoard[rowIndex].length) {
      // return true
      return true;
    } // end
      // return false
    return false;
  }// end

  // function boolean hasFigure() do
  public boolean hasFigure() {
    // if (verticalFigure OR horizontalFigure) NOT null do
    if (this.verticalFigure != null && this.verticalFigure.items() >= 3) {
      // return true
      return true;
    } // end
    if (this.horizontalFigure != null && this.horizontalFigure.items() >= 3) {
      // return true
      return true;
    } // end
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

	public void delete(){
		this.type = '-';
		this.color = '-';
	}
	

}
