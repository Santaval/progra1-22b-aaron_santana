import java.util.InputMismatchException;

/**
 * Cell object
 * Represent a cell with type, color and position in the game board.
 */
public class Cell {
  // atributes
  // set rowIndex := 0
  /**
   *Row position in the game board.
   */
  private int rowIndex = 0;
  // set colIndex := 0
  /**
   *Col position in the game board.
   */
  private int colIndex = 0;
  // set type := '\0'
  /**
   * Cell type.
   */
  private char type = '\0';
  // set color := '\0'
  /**
   * Cell color.
   */
  private char color = '\0';
  // set horizontalFigure := null
  /**
   * Reference to horizontal Figure found in this Cell.
   */
  private Figure horizontalFigure = null;
  // set verticalFigure := null
  /**
  * Reference to vertical Figure found in this Cell.
  */
  private Figure verticalFigure = null;
  // set LFigure := null
  /**
  * Reference to L Figure found in this Cell.
  */
  private Figure lfigure = null;
  // set TFigure := null
  /**
  * Reference to T Figure found in this Cell.
  */
  private Figure tfigure = null;
  // set types := "RVHWB"
  /**
   * Valid Cell types.
   */
  private final String types = "RVHWB-";

  // set colors := "123456"
  /**
  * Valid Cell colors.
  */
  private final String colors = "123456-";

  // constructor Cell(cellString, rowIndex, colIndex) do
  /**
   * Cell constructor Generates a new Cell with type, color, row and col index.

   * @param cellString contains type and color
   * @param rowPosition row index
   * @param colPosition col index
   */
  public Cell(final String cellString, final int rowPosition,
      final int colPosition) {
    if (cellString.length() == 2) {
      // rowIndex := rowIndex
    this.rowIndex = rowPosition;
    // colIndex := colIndex
    this.colIndex = colPosition;
    // type := cellString[0]
    this.type = cellString.charAt(0);
    // color := cellString[1]
    this.color = cellString.charAt(1);
    } else {
      throw new InputMismatchException("invalid input");
    }
  } // end


  // SET METHODS
  /**
   * set L figure atribute.

   * @param newFigure figure to insert
   */
  public void setlfigure(final Figure newFigure) {
    this.lfigure = newFigure;
  }

  /**
   * set T figure atribute.

   * @param newFigure figure to insert
  */
  public void settfigure(final Figure newFigure) {
    this.tfigure = newFigure;
  }

  /**
   * set vertical figure atribute.

   * @param newFigure figure to insert
   */
  public void setVerticalfigure(final Figure newFigure) {
    this.verticalFigure = newFigure;
  }

  /**
   * set horizontal figure atribute.

   * @param newFigure figure to insert
   */
  public void sethorizontalfigure(final Figure newFigure) {
    this.horizontalFigure = newFigure;
  }

  //GET METHODS
  /**
   * returns vertical figure.

   * @return vertical figure
   */
  public Figure getVerticalFigure() {
    return this.verticalFigure;
  }

  /**
   * returns horizontal figure.

   * @return horizontal figure
   */
  public Figure getHorizontalFigure() {
    return this.horizontalFigure;
  }

  /**
   * returns L figure.

   * @return L figure
   */
  public Figure getlFigure() {
    return this.lfigure;
  }

  /**
   * returns T figure.

   * @return T figure
   */
  public Figure gettFigure() {
    return this.tfigure;
  }

  /**
   * returns cell color.

   * @return cell color
   */
  public char getColor() {
    return this.color;
  }

  /**
   * returns cell type.

   * @return cell  type
   */
  public char getType() {
    return this.type;
  }

  // function validate () do
  /**
   * Validate Cell Type and color must be some of type and color constants.

   * @return boolean
   */
  public boolean validate() {
    // if types have type AND colors have color do
    if (types.contains(this.type + "") && colors.contains(this.color + "")) {
      if ((this.type != '-' && this.color != '-')
          || (this.type == '-' && this.color == '-')) {
        return true;
      }
        if ((this.type == '-' && this.color != '-')
          || (this.type != '-' && this.color == '-')) {
            return true;
        }
      // return true
      return false;
    } // end
    // return false
    return false;
  }

  /**
   * Compare Cells Compare if two Cells have the same color.

   * @param otherCell other cell to compare
   * @return boolean
   */
  public boolean compareEquals(final Cell otherCell) {
    // if this Cell color equals to otherCell color do
    if (this.color != '-' && this.color == otherCell.color) {
      // return true
      return true;
    } // end
    // return false
    return false;
  } // end

  // function exists (gameBoard, rowIndex, colIndex) do
  /**
   * Cell out of ranfe Check if one Cells is in range of the matrix.

   * @param gameBoard game board matrix
   * @param rowIndex cell row index
   * @param colIndex cell col index
   * @return boolean
   */
  public static boolean exists(final Cell[][] gameBoard, final int rowIndex,
      final int colIndex) {
    // if row < gameBoard(row) AND col < gameBoard(col) do
    if ((rowIndex < gameBoard.length && rowIndex >= 0) && (colIndex
         < gameBoard[rowIndex].length && colIndex >= 0)) {
      // return true
      return true;
    } // end
    // return false
    return false;
  } // end

  // procedure delete (gameBoard) do
  /**
   * Delete Cells Delete Cells from game board with the differents
   *  effect of each type.

   * @param gameBoard game board matrix
   */
  public void delete(final Cell[][] gameBoard) {
    // switch (type) do
    switch (this.type) {
      // case 'R': setDefaultValues()
      case 'R':
        this.setDefaultValues();
        break;
      // case 'V': deleteCol(gameBoard)
      case 'V':
        this.deleteCol(gameBoard);
        break;
      // case 'H': deleteRow(gameBoard)
      case 'H':
        this.deleteRow(gameBoard);
        break;
      // case 'W': wrapped(gameBoard)
      case 'W':
        this.wrapped(gameBoard);
        break;
      // case 'B': colorBomb(gameBoard)
      case 'B':
        this.colorBomb(gameBoard);
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
  public void deleteCol(final Cell[][] gameBoard) {
    // setDefaultValues()
    this.setDefaultValues();
    // for rowIndex to gameBoard(row) do
    for (int rowPosition = 0; rowPosition < gameBoard.length; rowPosition++) {
      // gameBoard[rowIndex][col].delete()
      gameBoard[rowPosition][this.colIndex].delete(gameBoard);
    } // end
  } //end

  /**
   * Delete row
   * Delete a complete row of game board matrix.

   * @param gameBoard game board matrix
  */
  public void deleteRow(final Cell[][] gameBoard) {
    // setDefaultValues()
    this.setDefaultValues();
    // for rowIndex to gameBoard(row) do
    for (int colPosition = 0; colPosition < gameBoard[this.rowIndex].length;
        colPosition++) {
      // gameBoard[rowIndex][col].delete()
      gameBoard[this.rowIndex][colPosition].delete(gameBoard);
    } // end
  } //end

  /**
   * Wrapped delete
   * Delete the 8 neighboor Cells of a Cell.

   * @param gameBoard game board matrix
  */
  public void wrapped(final Cell[][] gameBoard) {
    // setDefaultValues()
    this.setDefaultValues();
    // for rowIndex = row 1 to row + 2 do
    for (int rowPosition = this.rowIndex - 1; rowPosition
        < this.rowIndex + 2; rowPosition++) {
      // for colIndex = col - 1 to row + 2 do
      for (int colPosition = this.colIndex - 1; colPosition
          < this.colIndex + 2; colPosition++) {
        //System.out.printf("\nrow: %d col: %d\n", rowPosition, colPosition);
        if ((rowPosition < gameBoard.length && rowPosition >= 0)
            && (colPosition < gameBoard[rowIndex].length) && colPosition >= 0) {
          // gameBoard[rowPosition][colPosition].delete()
          gameBoard[rowPosition][colPosition].delete(gameBoard);
        }
      } // end
    } // end
  } //end

  /**
   * Color delete
   * Delete all the Cells of the same color.

   * @param gameBoard game board matrix
  */
  public void colorBomb(final Cell[][] gameBoard) {
    char bombColor = this.color;
    //setDefaultValues()
    this.setDefaultValues();
    //for rowIndex to gameBoard(row) do
    for (int rowPosition = 0; rowPosition < gameBoard.length; rowPosition++) {
      //for colPosition to gameBoard(col) do
      for (int colPosition = 0; colPosition < gameBoard[rowPosition].length;
           colPosition++) {
        //if compareEquals(gameBoard[rowPosition][colPosition]) do
        if (gameBoard[rowPosition][colPosition].color == bombColor) {
          //gameBoard[rowPosition][colPosition].delete()
          gameBoard[rowPosition][colPosition].delete(gameBoard);
        } //end
      } //end
    } //end

  } // end

  //procedure determinateType(deletedFigure) do
  /**
   * Determinate type
   * Verify is after eliminates a Figure in the first Cell
   * of it generate a new Cells with an special type.

   * @param deletedFigure deleted figure
   */
  public void determinateType(final Figure deletedFigure) {
    //switch(deletedFigure.type) do
    switch (deletedFigure.getType()) {
      //case colors'V': setTypeHorizontalOrVerticalFigures('V', deletedFigure)
      case 'V': this.setTypeHorizontalOrVerticalFigures('V', deletedFigure);
        break;
      //case 'H': setTypeHorizontalOrVerticalFigures('H', deletedFigure)
      case 'H': this.setTypeHorizontalOrVerticalFigures('H', deletedFigure);
        break;
      //case 'L':
      case 'L':
        //type = 'W'
        this.type = 'W';
        //color = deletedFigure.getColor()
        this.color = deletedFigure.getColor();
        break;
      //case 'T':
      case 'T':
        //type = 'W'
        this.type = 'W';
        //color = deletedFigure.getColor()
        this.color = deletedFigure.getColor();
        break;
      default:
        this.color = '-';
        this.type = '-';
    } //end
  } // end

  // procedure setTypeHorizontalOrVerticalFigures (type, deletedFigure) do
  /**
   * When a vertical or horizontal have been deleted check if it generate
   * an special cell type.

   * @param deletedType vertical or horizontal figure
   * @param deletedFigure figure deleted
  */
  private void setTypeHorizontalOrVerticalFigures(final char deletedType,
      final Figure deletedFigure) {
    final int normalFigureCells = 3;
    final int wrappedFigureCells = 4;
    final int bombFigureCells = 5;
    //if deletedFigure.items() <= 3 do
    if (deletedFigure.items() <= normalFigureCells) {
      //type = '-'
      this.color = '-';
      //color = '-'
      this.type = '-';
    } else if (deletedFigure.items() == wrappedFigureCells) {
      //type = type
      this.type = deletedType;
      //color = deletedFigure.getColor()
      this.color = deletedFigure.getColor();
    } else if (deletedFigure.items() >= bombFigureCells) {
      //type = 'B'
      this.type = 'B';
      //color = deletedFigure.getColor()
      this.color = deletedFigure.getColor();
    } //end
  } //end


  /**
   * Check if one Cell appear first tham other in the game board.

   * @param otherCell other Cell to compare
   * @return boolean
   */
  public boolean isFirst(final Cell otherCell) {
    if (this.rowIndex < otherCell.rowIndex)  {
      return true;
    } else if (this.rowIndex == otherCell.rowIndex
          && this.colIndex < otherCell.colIndex) {
          return true;
        }
    return false;
  }

  /**
   * Exchange the type and value of two cells.

   * @param otherCell other cell to change
   */
  public void changeCells(final Cell otherCell) {
    final char auxiliarColor = this.color;
    final char auxiliarType = this.type;

    this.color = otherCell.color;
    otherCell.color = auxiliarColor;

    this.type = otherCell.type;
    otherCell.type = auxiliarType;

  }

  /**
   * Verify if the cell have no type and color.

   * @return boolean
   */
  public boolean isEmpty() {
    if (this.color == '-' && this.type == '-') {
      return true;
    }

    return false;
  }

}
