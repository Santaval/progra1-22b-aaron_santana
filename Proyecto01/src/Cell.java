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
  public Figure lfigure = null;
  // set TFigure := null
  public Figure tfigure = null;
  // set types := "RVHWB"
  private final String types = "RVHWB";
  // set colors := "123456"
  private final String colors = "123456";

  // constructor Cell(cellString, rowIndex, colIndex) do
  /**
   * Cell constructor Generates a new Cell with type, color, row and col index.
   * 
   * @param cellString contains type and color
   * @param rowIndex row index
   * @param colIndex col index
   */
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
  /**
   * Validate Cell Type and color must be some of type and color constants.
   * 
   * @return boolean
   */
  public boolean validate() {
    // if types have type AND colors have color do
    if (types.contains(this.type + "") && colors.contains(this.color + "")) {
      // return true
      return true;
    } // end
    // return false
    return false;
  }

  /**
   * Compare Cells Compare if two Cells have the same color.
   * 
   * @param otherCell other cell to compare
   * @return boolean
   */
  public boolean compareEquals(Cell otherCell) {
    // if this Cell color equals to otherCell color do
    if (this.color == otherCell.color) {
      // return true
      return true;
    } // end
    // return false
    return false;
  } // end

  // function exists (gameBoard, rowIndex, colIndex) do
  /**
   * Cell out of ranfe Check if one Cells is in range of the matrix.
   * 
   * @param gameBoard game board matrix
   * @param rowIndex cell row index
   * @param colIndex cell col index
   * @return
   */
  public static boolean exists(Cell[][] gameBoard, int rowIndex, int colIndex) {
    // if row < gameBoard(row) AND col < gameBoard(col) do
    if (rowIndex < gameBoard.length && colIndex < gameBoard[rowIndex].length) {
      // return true
      return true;
    } // end
    // return false
    return false;
  } // end

  // procedure delete (gameBoard) do
  /**
   * Delete Cells Delete Cells from game board with the differents effect of each type.
   * 
   * @param gameBoard game board matrix
   */
  public void delete(Cell[][] gameBoard) {
    // switch (type) do
    switch (this.type) {
      // case 'R': setDefaultValues()
      case 'R':
        setDefaultValues();
        break;
      // case 'V': deleteCol(gameBoard)
      case 'V':
        deleteCol(gameBoard);
        break;
      // case 'H': deleteRow(gameBoard)
      case 'H':
        deleteRow(gameBoard);
        break;
      // case 'W': wrapped(gameBoard)
      case 'W':
        wrapped(gameBoard);
        break;
      // case 'B': colorBomb(gameBoard)
      case 'B':
        colorBomb(gameBoard);
        break;
      default:
        this.setDefaultValues();
    } // end
  } // end


  /**
   * Reset values
   * Change all the values of figures to null and type and color to - 
   * to simulate a deleted cell.
   */
  public void setDefaultValues() {
    // type = '-'
    this.type = '-';
    // color = '-'set horizontalFigure := null
    this.color = '-';
    // figures := null
    this.verticalFigure = null;
    this.horizontalFigure = null;
    this.tfigure = null;
    this.lfigure = null;
  } //end

  // procedure deleteCol()do
  /**
   * Delete col
   * Delete a complete col of game board matrix.
   * @param gameBoard game board matrix
   */
  public void deleteCol(Cell[][] gameBoard) {
    // setDefaultValues()
    this.setDefaultValues();
    // for rowIndex to gameBoard(row) do
    for (int rowIndex = 0; rowIndex < gameBoard.length; rowIndex++) {
      // gameBoard[rowIndex][col].delete()
      gameBoard[rowIndex][this.colIndex].delete(gameBoard);
    } // end
  } //end

  /**
   * Delete row
   * Delete a complete row of game board matrix.
   * @param gameBoard game board matrix
  */
  public void deleteRow(Cell[][] gameBoard) {
    // setDefaultValues()
    this.setDefaultValues();
    // for rowIndex to gameBoard(row) do
    for (int colIndex = 0; colIndex < gameBoard[this.rowIndex].length; colIndex++) {
      // gameBoard[rowIndex][col].delete()
      gameBoard[this.rowIndex][colIndex].delete(gameBoard);
    } // end
  } //end

  /**
   * Wrapped delete
   * Delete the 8 neighboor Cells of a Cell.
   * @param gameBoard game board matrix
  */
  public void wrapped(Cell[][] gameBoard) {
    // setDefaultValues()
    this.setDefaultValues();
    // for rowIndex = row 1 to row + 2 do
    for (int rowIndex = this.rowIndex - 1; rowIndex < this.rowIndex + 1; rowIndex++) {
      // for colIndex = col - 1 to row + 2 do
      for (int colIndex = this.colIndex - 1; colIndex < this.colIndex + 1; colIndex++) {
        if (colIndex >= 0 && rowIndex >= 0) {
          // gameBoard[rowIndex][colIndex].delete()
          gameBoard[rowIndex][colIndex].delete(gameBoard);
        }
      } // end
    } // end
  } //end

  /**
   * Color delete
   * Delete all the Cells of the same color.
   * @param gameBoard game board matrix
  */
  public void colorBomb(Cell[][] gameBoard) {
    // setDefaultValues()
    this.setDefaultValues();
    // for rowIndex to gameBoard(row) do
    for (int rowIndex = 0; rowIndex < gameBoard.length; rowIndex++) {
      // for colIndex to gameBoard(col) do
      for (int colIndex = 0; colIndex < gameBoard[this.rowIndex].length; colIndex++) {
        // if compareEquals(gameBoard[rowIndex][colIndex]) do
        if (this.compareEquals(gameBoard[rowIndex][colIndex])) {
          // gameBoard[rowIndex][colIndex].delete()
          gameBoard[rowIndex][colIndex].delete(gameBoard);
        } // end
      } // end
    } // end
  } //end


}
