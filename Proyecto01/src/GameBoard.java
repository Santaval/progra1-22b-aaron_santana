import java.util.ArrayList;
import java.util.Scanner;

/**
 * Game board object
 * Keeps the Cells in a matrix and all the figures found there.
 */
public class GameBoard {
  // atributes
  // set gameBoard := null
  private Cell[][] gameBoard = null;
  // set boardFigures := null
  private ArrayList<Figure> boardFigures = null;

  // constructor GameBoard (rowCount, colCount) do
  /**
   * Game board constructor Generate a new Game Board that is a matrix of Cells with the params row
   * and col count.

   * @param rowCount amount of rows
   * @param colCount amount of colunms
   * 
   * @throws IndexOutOfBOundException if row or col count are minor than 3
   */
  public GameBoard(int rowCount, int colCount) {
    // if (rowCount >= 3 AND colCount >= 3) do
    if (rowCount >= 3 && colCount >= 3) {
      // gameBoard := new Cell[rowCount][colCount]
      this.gameBoard = new Cell[rowCount][colCount];
      this.boardFigures = new ArrayList<>(0);
    } else {
      // throw ERR
      throw new IndexOutOfBoundsException("invalid terrain");
    } // end
  } // end

  public int getTotalFigures() {
    return this.boardFigures.size();
  }

  // procedure read() do
  /**
   * Read game board from stdin In a for cicle reads the next token from the stdin and generates a
   * new Cells object, then keeps that Cell in the atribure gameBoard at the position row and col
   * index.

   * @param input Scanner instance
   */
  public void read(Scanner input) {
    // for rowIndex to gameBoard(row) do
    for (int rowIndex = 0; rowIndex < this.gameBoard.length; rowIndex++) {
      // for colIndex to gameBoard(col) do
      for (int colIndex = 0; colIndex < this.gameBoard[rowIndex].length; colIndex++) {
        // input cellString
        final String cellString = input.next();
        // gameBoard[rowIndex][colIndex] = new Cell(cellString, rowIndex, colIndex)
        this.gameBoard[rowIndex][colIndex] = new Cell(cellString, rowIndex, colIndex);
      } // end
    } // end
  } // end


  /**
   * Valdiates game board Cehck te game board and calls validate function from each Cell.

   * @return boolean
   */
  public boolean validate() {
    // for 0 to gameBoard(row) do
    for (int rowIndex = 0; rowIndex < this.gameBoard.length; rowIndex++) {
      // for 0 to gameBoard(col) do
      for (int colIndex = 0; colIndex < this.gameBoard[rowIndex].length; colIndex++) {
        // if(NOT gameBoard[rowIndex][colIndex].validate()) do
        if (!this.gameBoard[rowIndex][colIndex].validate()) {
          // return false
          return false;
        } // end
      } // end
    } // end
    // return true
    return true;
  } // end

  // procedure searchBoardFigures() do
  /**
   * Search Board FIgures Check the game board matrix searching fugures and if find one append it to
   * the boardFigures atribute list.
   */
  public void searchFigures() {
    // for rowIndex to gameBoard(row) do
    for (int rowIndex = 0; rowIndex < this.gameBoard.length; rowIndex++) {
      // for colIndex to gameBoard(col) do
      for (int colIndex = 0; colIndex < this.gameBoard[rowIndex].length; colIndex++) {

        // if gameBoard[rowIndex][colIndex].verticalFigure == null do
        if (this.gameBoard[rowIndex][colIndex].verticalFigure == null) {
          // figures add searchVerticalFigure(rowIndex, colIndex)
          Figure verticalFigure = this.searchVerticalFigure(rowIndex, colIndex);
          if (verticalFigure.items() >= 3) {
            this.boardFigures.add(verticalFigure);
          }
        } // end

        // if gameBoard[rowIndex][colIndex].horizontalFigure == null do
        if (this.gameBoard[rowIndex][colIndex].horizontalFigure == null) {
          // figures add searchHorizontalFigure(rowIndex, colIndex) only if has 3 or more
          // elements
          Figure horizontalFigure = this.searchHorizontalFigure(rowIndex, colIndex);
          if (horizontalFigure.items() >= 3) {
            this.boardFigures.add(horizontalFigure);
          }
        } // end
        
        // searchLFigure()
        this.searchlFigure(rowIndex, colIndex);
        this.searchtFigure(rowIndex, colIndex);

      } // end
    } // end
  } // end

  
  // procedure searchVerticalFigure(rowIndex, colIndex) do
  private Figure searchVerticalFigure(int rowIndex, int colIndex) {
    // set currentFigure = new Figure("V")
    Figure currentFigure = new Figure('V', this.gameBoard[rowIndex][colIndex]
        .color);
    // if neighboor cell equals to current do
    if (Cell.exists(gameBoard, rowIndex + 1, colIndex + 0) && this.gameBoard[rowIndex][colIndex]
        .compareEquals(this.gameBoard[rowIndex + 1][colIndex + 0])) {
      // currentFigure := recursiveVerticalSearch(curentFigure,rowIndex + 1, colIndex + 0)
      return this.recursiveVerticalSearch(currentFigure, rowIndex, colIndex);
    } // end

    return currentFigure;

  } // end

  // function recursiveVerticalSearch(curentFigure, rowIndex, colIndex) do
  /**
   * Search veritcal figure
   * Check the matrix and compare the right cell of the current and if is equals
   * call the function again and add the current cell to figure instance.

   * @param currentFigure figure to append cells
   * @param rowIndex current cell row
   * @param colIndex current cell col
   * @return Figure with cells appends
   */
  public Figure recursiveVerticalSearch(Figure currentFigure, int rowIndex, int colIndex) {
    // curentFigure add currentCell
    currentFigure.figure.add(this.gameBoard[rowIndex][colIndex]);
    // current cell reference figure
    this.gameBoard[rowIndex][colIndex].verticalFigure = currentFigure;
    // if rowIndex >= gameBoard(row) OR NOT neighboor cell equals to current do
    if (rowIndex + 1 >= this.gameBoard.length || !this.gameBoard[rowIndex][colIndex]
        .compareEquals(this.gameBoard[rowIndex + 1][colIndex + 0])) {
      // return curentFigure
      return currentFigure;
    } // end
    // return recursiveVerticalSearch(curentFigure,rowIndex + 1, colIndex + 0)
    return this.recursiveVerticalSearch(currentFigure, rowIndex + 1, colIndex + 0);
  } //end


  // procedure searchHorizontalFigure(rowIndex, colIndex) do
  /**
   * Search H figure
   * Create new H type Figure and check the game board matrix calling
   * the recursive horizontal search.

   * @param rowIndex cell row 
   * @param colIndex cell col
   * @return Figure with cell appends
   */
  private Figure searchHorizontalFigure(int rowIndex, int colIndex) {
    // set currentFigure = new Figure("H")
    Figure currentFigure = new Figure('H', this.gameBoard[rowIndex][colIndex]
        .color);
    // if neighboor cell equals to current do
    if (Cell.exists(gameBoard, rowIndex + 0, colIndex + 1) && this.gameBoard[rowIndex][colIndex]
        .compareEquals(this.gameBoard[rowIndex + 0][colIndex + 1])) {
      // currentFigure := recursiveHorizontalSearch(curentFigure,rowIndex + 0, colIndex + 1)
      return this.recursiveHorizontalSearch(currentFigure, rowIndex, colIndex);
    } // end

    return currentFigure;

  } // end

  //function recursiveHorizontalSearch(curentFigure, rowIndex, colIndex) do
  /**
   * Search horizontal figure
   * Check the matrix and compare the cell down of the current and if is equals
   * call the function again and add the current cell to figure instance.

   * @param currentFigure figure to append cells
   * @param rowIndex current cell row
   * @param colIndex current cell col
   * @return Figure with cells appends
   */
  private Figure recursiveHorizontalSearch(Figure currentFigure, int rowIndex, int colIndex) {
    // curentFigure add currentCell
    currentFigure.figure.add(this.gameBoard[rowIndex][colIndex]);
    // current cell reference figure
    this.gameBoard[rowIndex][colIndex].horizontalFigure = currentFigure;
    // if rowIndex >= gameBoard(col) OR NOT neighboor cell equals to current do
    if (colIndex + 1 >= this.gameBoard[rowIndex].length) {
      // return curentFigure
      return currentFigure;
    } // end

    if (!this.gameBoard[rowIndex][colIndex]
        .compareEquals(this.gameBoard[rowIndex + 0][colIndex + 1])) {
      return currentFigure;
    }
    // return recursiveHorizontalSearch(curentFigure,rowIndex + 0, colIndex + 1)
    return this.recursiveHorizontalSearch(currentFigure, rowIndex + 0, colIndex + 1);
  } // end


  // procedure searchLFigure(rowIndex, colIndex) do
  private void searchlFigure(int rowIndex, int colIndex) {
    // if gameBoard[rowIndex][colIndex] have horizontalFigure and verticalFigure and Lfigure ==
    // null do
    Cell curentCell = this.gameBoard[rowIndex][colIndex];
    if (curentCell.horizontalFigure != null
        && curentCell.horizontalFigure.isLastOrFirstCell(curentCell)) {
      if (curentCell.verticalFigure != null
          && curentCell.verticalFigure.isLastOrFirstCell(curentCell)) {
        if (curentCell.verticalFigure.items() >= 3 && curentCell.horizontalFigure.items() >= 3) {
          if (curentCell.lfigure == null) {
            // lfigure := new Figure('L')
            // lfigure.figure.add(horizontalFigure and verticalFigure cells)
            Figure lfigure =
                Figure.combine(curentCell.horizontalFigure, curentCell.verticalFigure, 'L');
            this.boardFigures.add(lfigure);


          }
        }
      }
    } // end


  } //end

  // procedure searchLFigure(rowIndex, colIndex) do
  private void searchtFigure(int rowIndex, int colIndex) {
    // if gameBoard[rowIndex][colIndex] have horizontalFigure and verticalFigure and Lfigure ==
    // null do
    Cell curentCell = this.gameBoard[rowIndex][colIndex];
    if (curentCell.horizontalFigure != null && curentCell.verticalFigure != null) {
      if ((!curentCell.verticalFigure.isLastOrFirstCell(curentCell)
          && curentCell.horizontalFigure.isLastOrFirstCell(curentCell))
          || (curentCell.verticalFigure.isLastOrFirstCell(curentCell)
              && !curentCell.horizontalFigure.isLastOrFirstCell(curentCell))) {
        if (curentCell.verticalFigure.items() >= 3 && curentCell.horizontalFigure.items() >= 3) {
          if (curentCell.tfigure == null) {
            // lfigure := new Figure('T')
            // lfigure.figure.add(horizontalFigure and verticalFigure cells)
            Figure tfigure =
                Figure.combine(curentCell.verticalFigure, curentCell.horizontalFigure, 'T');
            this.boardFigures.add(tfigure);
          }
        }
      }
    } // end
  } // end



  /**
   * Delte figure
   * Calls priority figure function to get the most priority figure
   * and in cicle eliminate each Cell in the cicle with the
   * Cell method delete.
   */
  public void deleteFigure() {
    if (this.haveFigures()) {
      // set deleteFigure = Figure.priorityFigure(boardFigures);
      Figure deleteFigure = Figure.priorityFigure(this.boardFigures);
      // for index to deleteFigure.items() do
      if (deleteFigure != null) {
        for (int index = 0; index < deleteFigure.items(); index++) {
          // figure[index].delete(gameBoard)
          deleteFigure.figure.get(index).delete(this.gameBoard);
        } // end
        // deleteFigure[0].determinateType(deleteFigure)
        deleteFigure.generateSpecialCell();
      }
    }
  } //end

  /**
   * Search for a empty cell and change it values with the Cell upside.
   */
  public void gravity() {
    int itemsChanged = 0;

    do {
      itemsChanged = 0;
      for (int rowIndex = this.gameBoard.length - 1;  rowIndex >= 0; rowIndex--) {
        for (int colIndex = this.gameBoard[rowIndex].length - 1;  colIndex >= 0; colIndex--) {
          if (this.gameBoard[rowIndex][colIndex].isEmpty() && Cell.exists(gameBoard,
              rowIndex - 1,  colIndex) && !this.gameBoard[rowIndex - 1][colIndex].isEmpty()) {
            this.gameBoard[rowIndex][colIndex].changeCells(this.gameBoard[rowIndex - 1]
                [colIndex]);
            itemsChanged++;
          }
        }
      }
    }  while (itemsChanged > 0); 
  }


  // procedure print() do
  /**
   * Print game board
   * Check the game board and print each cell type and color.
   */
  public void print() {
    for (int rowIndex = 0; rowIndex < this.gameBoard.length; rowIndex++) {
      for (int colIndex = 0; colIndex < this.gameBoard[rowIndex].length; colIndex++) {
        final Cell currentCell = this.gameBoard[rowIndex][colIndex];
        
          System.out.printf("%s%s ", currentCell.type, currentCell.color);
      }
      System.out.print("\n");
    }  
  } //end

  public void clearFigures() {
    this.boardFigures.clear();
    for (int rowIndex = 0; rowIndex < this.gameBoard.length; rowIndex++) {
      for (int colIndex = 0; colIndex < this.gameBoard[rowIndex].length; colIndex++) {
        this.gameBoard[rowIndex][colIndex].verticalFigure = null;
        this.gameBoard[rowIndex][colIndex].horizontalFigure = null;
        this.gameBoard[rowIndex][colIndex].lfigure = null;
        this.gameBoard[rowIndex][colIndex].tfigure = null;
      }
    }
  }

  /**
   * Check if the board have some figure.
   * @return boolean
   */
  public boolean haveFigures() {
    if (this.boardFigures.size() > 0) {
      return true;
    }
    return false;
  }

}
