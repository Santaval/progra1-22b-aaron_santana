import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Game board object
 * Keeps the Cells in a matrix and all the figures found there.
 */
public class GameBoard {
  // atributes
  // set gameBoard := null
  /**
   * game board cells matrix.
   */
  private Cell[][] gameBoard = null;
  // set boardFigures := null
  /**
   * figures found in the game board.
   */
  private ArrayList<Figure> boardFigures = null;

  // constructor GameBoard (rowCount, colCount) do
  /**
   * Game board constructor Generate a new Game Board that is a matrix of
   * Cells with the params row
   * and col count.

   * @param rowCount amount of rows
   * @param colCount amount of colunms

   */
  public GameBoard(final int rowCount, final int colCount) {
    // if (rowCount >= 3 AND colCount >= 3) do
    final int minGameBoardRange = 3;
    if (rowCount >= minGameBoardRange && colCount >= minGameBoardRange) {
      // gameBoard := new Cell[rowCount][colCount]
      this.gameBoard = new Cell[rowCount][colCount];
      this.boardFigures = new ArrayList<>(0);
    } else {
      // throw ERR
      throw new IndexOutOfBoundsException("invalid input");
    } // end
  } // end

  /**
   * Check how many figures are in the game board.

   * @return biard giures size
   */
  public int getTotalFigures() {
    return this.boardFigures.size();
  }

  // procedure read() do
  /**
   * Read game board from stdin In a for cicle reads the next token
   *from the stdin and generates a new Cells object, then keeps that
    Cell in the atribure gameBoard at the position row and col
   * index.

   * @param input Scanner instance
   */
  public void read(final Scanner input) {
    // for rowIndex to gameBoard(row) do
    for (int rowIndex = 0; rowIndex < this.gameBoard.length; rowIndex++) {
      // for colIndex to gameBoard(col) do
      for (int colIndex = 0; colIndex < this.gameBoard[rowIndex].length;
           colIndex++) {
        String cellString = "\0";
        // input cellString
        if (input.hasNext()) {
          cellString = input.next();
        } else {
          throw new NoSuchElementException("invalid input");
        }
        // gameBoard[rowIndex][colIndex] = new Cell(cellString,
        // rowIndex, colIndex)
        this.gameBoard[rowIndex][colIndex] = new Cell(cellString,
             rowIndex, colIndex);
      } // end
    } // end
  } // end


  /**
   * Valdiates game board Cehck te game board and calls validate
   * function from each Cell.

   * @return boolean
   */
  public boolean validate() {
    // for 0 to gameBoard(row) do
    for (int rowIndex = 0; rowIndex < this.gameBoard.length; rowIndex++) {
      // for 0 to gameBoard(col) do
      for (int colIndex = 0; colIndex < this.gameBoard[rowIndex].length;
           colIndex++) {
        // if(NOT gameBoard[rowIndex][colIndex].validate()) do
        if (!this.gameBoard[rowIndex][colIndex].validate()) {
          // return false
          throw new InputMismatchException("invalid input");
        } // end
      } // end
    } // end
    // return true
    return true;
  } // end

  // procedure searchBoardFigures() do
  /**
   * Search Board FIgures Check the game board matrix searching fugures
   *  and if find one append it to the boardFigures atribute list.
   */
  public void searchFigures() {
    final int minCellsAmountInFigure = 3;
    // for rowIndex to gameBoard(row) do
    for (int rowIndex = 0; rowIndex < this.gameBoard.length; rowIndex++) {
      // for colIndex to gameBoard(col) do
      for (int colIndex = 0; colIndex < this.gameBoard[rowIndex].length;
            colIndex++) {

        // if gameBoard[rowIndex][colIndex].verticalFigure == null do
        if (this.gameBoard[rowIndex][colIndex].getVerticalFigure() == null) {
          // figures add searchVerticalFigure(rowIndex, colIndex)
          Figure verticalFigure = this.searchVerticalFigure(rowIndex, colIndex);
          if (verticalFigure.items() >= minCellsAmountInFigure) {
            this.boardFigures.add(verticalFigure);
          }
        } // end

        // if gameBoard[rowIndex][colIndex].horizontalFigure == null do
        if (this.gameBoard[rowIndex][colIndex].getHorizontalFigure() == null) {
          // figures add searchHorizontalFigure(rowIndex, colIndex) only
          // if has 3 or more
          // elements
          Figure horizontalFigure = this.searchHorizontalFigure(rowIndex,
              colIndex);
          if (horizontalFigure.items() >= minCellsAmountInFigure) {
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
  /**
   * Search vertical figures in the game board.

   * @param rowIndex row start search
   * @param colIndex col start search
   * @return Figure found
   */
  private Figure searchVerticalFigure(final int rowIndex,
      final int colIndex) {
    // set currentFigure = new Figure("V")
    Figure currentFigure = new Figure('V', this.gameBoard[rowIndex][colIndex]
        .getColor());
    // if neighboor cell equals to current do
    if (Cell.exists(gameBoard, rowIndex + 1, colIndex + 0)
          && this.gameBoard[rowIndex][colIndex]
        .compareEquals(this.gameBoard[rowIndex + 1][colIndex + 0])) {
      // currentFigure := recursiveVerticalSearch(curentFigure,rowIndex + 1,
      // colIndex + 0)
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
  public Figure recursiveVerticalSearch(final Figure currentFigure,
        final int rowIndex, final int colIndex) {
    // curentFigure add currentCell
    currentFigure.addCell(this.gameBoard[rowIndex][colIndex]);
    // current cell reference figure
    this.gameBoard[rowIndex][colIndex].setVerticalfigure(currentFigure);
    // if rowIndex >= gameBoard(row) OR NOT neighboor cell equals to current do
    if (rowIndex + 1 >= this.gameBoard.length
        || !this.gameBoard[rowIndex][colIndex]
        .compareEquals(this.gameBoard[rowIndex + 1][colIndex + 0])) {
      // return curentFigure
      return currentFigure;
    } // end
    // return recursiveVerticalSearch(curentFigure,rowIndex + 1, colIndex + 0)
    return this.recursiveVerticalSearch(currentFigure,
        rowIndex + 1, colIndex + 0);
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
  private Figure searchHorizontalFigure(final int rowIndex,
        final int colIndex) {
    // set currentFigure = new Figure("H")
    Figure currentFigure = new Figure('H', this.gameBoard[rowIndex][colIndex]
        .getColor());
    // if neighboor cell equals to current do
    if (Cell.exists(gameBoard, rowIndex + 0, colIndex + 1)
        && this.gameBoard[rowIndex][colIndex]
        .compareEquals(this.gameBoard[rowIndex + 0][colIndex + 1])) {
      // currentFigure := recursiveHorizontalSearch(curentFigure,
      //rowIndex + 0, colIndex + 1)
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
  private Figure recursiveHorizontalSearch(final Figure currentFigure,
      final int rowIndex, final int colIndex) {
    // curentFigure add currentCell
    currentFigure.addCell(this.gameBoard[rowIndex][colIndex]);
    // current cell reference figure
    this.gameBoard[rowIndex][colIndex].sethorizontalfigure(currentFigure);
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
    return this.recursiveHorizontalSearch(currentFigure,
         rowIndex + 0, colIndex + 1);
  } // end


  // procedure searchLFigure(rowIndex, colIndex) do
  /**
   * Search L figures figures in the game board.

   * @param rowIndex row start search
   * @param colIndex col start search
   */
  private void searchlFigure(final int rowIndex, final int colIndex) {
    this.l1(rowIndex, colIndex);
    this.l2(rowIndex, colIndex);
    this.l3(rowIndex, colIndex);
    this.l4(rowIndex, colIndex);
    //if gameBoard[rowIndex][colIndex] have horizontalFigure and
    //verticalFigure and Lfigure ==
    // null do

  } //end

  // procedure searchTFigure(rowIndex, colIndex) do
  /**
    * Search T figures figures in the game board.

   * @param rowIndex row start search
   * @param colIndex col start search
   */
  private void searchtFigure(final int rowIndex,
      final int colIndex) {
    this.t1(rowIndex, colIndex);
    this.t2(rowIndex, colIndex);
    this.t3(rowIndex, colIndex);
    this.t4(rowIndex, colIndex);

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
          deleteFigure.getCell(index).delete(this.gameBoard);
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
      for (int rowIndex = this.gameBoard.length - 1;  rowIndex >= 0;
          rowIndex--) {
        for (int colIndex = this.gameBoard[rowIndex].length - 1;
            colIndex >= 0; colIndex--) {
          if (this.gameBoard[rowIndex][colIndex].isEmpty()
              && Cell.exists(gameBoard,
              rowIndex - 1,  colIndex) && !this.gameBoard[rowIndex - 1]
                  [colIndex].isEmpty()) {
            this.gameBoard[rowIndex][colIndex]
                .changeCells(this.gameBoard[rowIndex - 1][colIndex]);
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
      for (int colIndex = 0; colIndex < this.gameBoard
          [rowIndex].length; colIndex++) {
        final Cell currentCell = this.gameBoard[rowIndex][colIndex];
        if (colIndex != 0) {
          System.out.printf(" %s%s", currentCell.getType(),
              currentCell.getColor());
        } else {
          System.out.printf("%s%s", currentCell.getType(),
              currentCell.getColor());
        }
      }
      System.out.print("\n");
    }
  } //end

  /**
   * Delete the found figures an their references.
   */
  public void clearFigures() {
    this.boardFigures.clear();
    for (int rowIndex = 0; rowIndex < this.gameBoard.length; rowIndex++) {
      for (int colIndex = 0; colIndex < this.gameBoard[rowIndex]
          .length; colIndex++) {
        this.gameBoard[rowIndex][colIndex].setVerticalfigure(null);
        this.gameBoard[rowIndex][colIndex].sethorizontalfigure(null);
        this.gameBoard[rowIndex][colIndex].setlfigure(null);
        this.gameBoard[rowIndex][colIndex].settfigure(null);
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

  /**
   * Search l1.

   * @param rowIndex row
   * @param colIndex col
   */
  private void l1(final int rowIndex, final int colIndex) {




    final int minCellsAmountInFigure = 5;
    final Cell currentCell = this.gameBoard[rowIndex][colIndex];
    Figure lfigure = new Figure('L', currentCell.getColor());
    lfigure.addCell(currentCell);

    if (rowIndex + 2 < this.gameBoard.length
        && colIndex + 2 < this.gameBoard[rowIndex].length) {
      if (this.gameBoard[rowIndex + 1][colIndex]
              .compareEquals(currentCell)) {
        lfigure.addCell(this.gameBoard[rowIndex + 1][colIndex]);
      }
      if (this.gameBoard[rowIndex + 2][colIndex]
              .compareEquals(currentCell)) {
        lfigure.addCell(this.gameBoard[rowIndex + 2][colIndex]);
      }
      if (this.gameBoard[rowIndex + 2][colIndex + 1]
              .compareEquals(currentCell)) {
        lfigure.addCell(this.gameBoard[rowIndex + 2][colIndex + 1]);
      }
      if (this.gameBoard[rowIndex + 2][colIndex + 2]
              .compareEquals(currentCell)) {
        lfigure.addCell(this.gameBoard[rowIndex + 2][colIndex + 2]);
      }
    }

    if (lfigure.items() == minCellsAmountInFigure) {
      this.boardFigures.add(lfigure);
    }

  }



  /**
   * Search l1.

   * @param rowIndex row
   * @param colIndex col
   */
  private void l2(final int rowIndex, final int colIndex) {
    final int minCellsAmountInFigure = 5;
    final Cell currentCell = this.gameBoard[rowIndex][colIndex];
    Figure lfigure = new Figure('L', currentCell.getColor());
    lfigure.addCell(currentCell);

    if (rowIndex + 2 < this.gameBoard.length
        && colIndex - 2 >= 0) {
      if (this.gameBoard[rowIndex + 1][colIndex]
              .compareEquals(currentCell)) {
        lfigure.addCell(this.gameBoard[rowIndex + 1][colIndex]);
      }
      if (this.gameBoard[rowIndex + 2][colIndex]
              .compareEquals(currentCell)) {
        lfigure.addCell(this.gameBoard[rowIndex + 2][colIndex]);
      }
      if (this.gameBoard[rowIndex + 2 ][colIndex - 1]
              .compareEquals(currentCell)) {
        lfigure.addCell(this.gameBoard[rowIndex + 2][colIndex - 1]);
      }
      if (this.gameBoard[rowIndex + 2][colIndex - 2]
              .compareEquals(currentCell)) {
        lfigure.addCell(this.gameBoard[rowIndex + 2][colIndex - 2]);
      }
    }

    if (lfigure.items() == minCellsAmountInFigure) {
      this.boardFigures.add(lfigure);
    }

  }

  /**
   * l3 search.

   * @param rowIndex row
   * @param colIndex col
   */
  private void l3(final int rowIndex, final int colIndex) {
    final int minCellsAmountInFigure = 5;
    final Cell currentCell = this.gameBoard[rowIndex][colIndex];
    Figure lfigure = new Figure('L', currentCell.getColor());
    lfigure.addCell(currentCell);

    if (rowIndex + 2 < this.gameBoard.length
        && colIndex + 2 < this.gameBoard[rowIndex].length) {
      if (this.gameBoard[rowIndex + 1][colIndex]
              .compareEquals(currentCell)) {
        lfigure.addCell(this.gameBoard[rowIndex + 1][colIndex]);
      }
      if (this.gameBoard[rowIndex + 2][colIndex]
              .compareEquals(currentCell)) {
        lfigure.addCell(this.gameBoard[rowIndex + 2][colIndex]);
      }
      if (this.gameBoard[rowIndex][colIndex + 1]
              .compareEquals(currentCell)) {
        lfigure.addCell(this.gameBoard[rowIndex][colIndex + 1]);
      }
      if (this.gameBoard[rowIndex][colIndex + 2]
              .compareEquals(currentCell)) {
        lfigure.addCell(this.gameBoard[rowIndex][colIndex + 2]);
      }
    }

    if (lfigure.items() == minCellsAmountInFigure) {
      this.boardFigures.add(lfigure);
    }

  }

  /**
   * l4 search.

   * @param rowIndex row
   * @param colIndex col
   */
  private void l4(final int rowIndex, final int colIndex) {
    final int minCellsAmountInFigure = 5;
    final Cell currentCell = this.gameBoard[rowIndex][colIndex];
    Figure lfigure = new Figure('L', currentCell.getColor());
    lfigure.addCell(currentCell);

    if (rowIndex + 2 < this.gameBoard.length
        && colIndex + 2 < this.gameBoard[rowIndex].length) {
      if (this.gameBoard[rowIndex][colIndex + 1]
              .compareEquals(currentCell)) {
        lfigure.addCell(this.gameBoard[rowIndex ][colIndex + 1]);
      }
      if (this.gameBoard[rowIndex][colIndex + 2]
              .compareEquals(currentCell)) {
        lfigure.addCell(this.gameBoard[rowIndex][colIndex + 2]);
      }
      if (this.gameBoard[rowIndex + 1][colIndex + 2]
              .compareEquals(currentCell)) {
        lfigure.addCell(this.gameBoard[rowIndex + 1][colIndex + 2]);
      }
      if (this.gameBoard[rowIndex + 2][colIndex + 2]
              .compareEquals(currentCell)) {
        lfigure.addCell(this.gameBoard[rowIndex + 2][colIndex + 2]);
      }
    }

    if (lfigure.items() == minCellsAmountInFigure) {
      this.boardFigures.add(lfigure);
    }

  }

  /**
   * Search t1.

   * @param rowIndex row
   * @param colIndex col
   */
  private void t1(final int rowIndex, final int colIndex) {
    final int minCellsAmountInFigure = 5;
    final Cell currentCell = this.gameBoard[rowIndex][colIndex];
    Figure tfigure = new Figure('T', currentCell.getColor());
    tfigure.addCell(currentCell);
    if ((rowIndex + 2 < this.gameBoard.length)
        && (colIndex + 2 < this.gameBoard[rowIndex].length)) {
      if (this.gameBoard[rowIndex ][colIndex + 1]
              .compareEquals(currentCell)) {
        tfigure.addCell(this.gameBoard[rowIndex ][colIndex + 1]);
      }
      if (this.gameBoard[rowIndex][colIndex + 2]
              .compareEquals(currentCell)) {
        tfigure.addCell(this.gameBoard[rowIndex][colIndex + 2]);
      }
      if (this.gameBoard[rowIndex + 1][colIndex + 1]
              .compareEquals(currentCell)) {
        tfigure.addCell(this.gameBoard[rowIndex + 1][colIndex + 1]);
      }
      if (this.gameBoard[rowIndex + 2][colIndex + 1]
              .compareEquals(currentCell)) {
        tfigure.addCell(this.gameBoard[rowIndex + 2][colIndex + 1]);
      }
    }

    if (tfigure.items() == minCellsAmountInFigure) {
      this.boardFigures.add(tfigure);
    }

  }


  /**
   * Search t1.

   * @param rowIndex row
   * @param colIndex col
   */
  private void t2(final int rowIndex, final int colIndex) {

    final int minCellsAmountInFigure = 5;
    final Cell currentCell = this.gameBoard[rowIndex][colIndex];
    Figure tfigure = new Figure('T', currentCell.getColor());
    tfigure.addCell(currentCell);

    if ((rowIndex + 2 < this.gameBoard.length)
        && (colIndex + 1 < this.gameBoard[rowIndex]
            .length && colIndex - 1 >= 0)) {

      if (this.gameBoard[rowIndex + 1][colIndex]
              .compareEquals(currentCell)) {
        tfigure.addCell(this.gameBoard[rowIndex + 1][colIndex]);
      }
      if (this.gameBoard[rowIndex + 2][colIndex]
              .compareEquals(currentCell)) {
        tfigure.addCell(this.gameBoard[rowIndex + 2][colIndex]);
      }
      if (this.gameBoard[rowIndex + 2][colIndex - 1]
              .compareEquals(currentCell)) {
        tfigure.addCell(this.gameBoard[rowIndex + 2][colIndex - 1]);
      }
      if (this.gameBoard[rowIndex + 2][colIndex + 1]
              .compareEquals(currentCell)) {
        tfigure.addCell(this.gameBoard[rowIndex + 2][colIndex + 1]);
      }
    }

    if (tfigure.items() == minCellsAmountInFigure) {
      this.boardFigures.add(tfigure);
    }

  }

  /**
   * Search t1.

   * @param rowIndex row
   * @param colIndex col
   */
  private void t3(final int rowIndex, final int colIndex) {

    final int minCellsAmountInFigure = 5;
    final Cell currentCell = this.gameBoard[rowIndex][colIndex];
    Figure tfigure = new Figure('T', currentCell.getColor());
    tfigure.addCell(currentCell);

    if ((rowIndex + 2 < this.gameBoard.length)
        && (colIndex + 2 < this.gameBoard[rowIndex]
            .length)) {

      if (this.gameBoard[rowIndex + 1][colIndex]
              .compareEquals(currentCell)) {
        tfigure.addCell(this.gameBoard[rowIndex + 1][colIndex]);
      }
      if (this.gameBoard[rowIndex + 2][colIndex]
              .compareEquals(currentCell)) {
        tfigure.addCell(this.gameBoard[rowIndex + 2][colIndex]);
      }
      if (this.gameBoard[rowIndex + 1][colIndex + 1]
              .compareEquals(currentCell)) {
        tfigure.addCell(this.gameBoard[rowIndex + 1][colIndex + 1]);
      }
      if (this.gameBoard[rowIndex + 1][colIndex + 2]
              .compareEquals(currentCell)) {
        tfigure.addCell(this.gameBoard[rowIndex + 1][colIndex + 2]);
      }
    }

    if (tfigure.items() == minCellsAmountInFigure) {
      this.boardFigures.add(tfigure);
    }

  }


  /**
   * Search t1.

   * @param rowIndex row
   * @param colIndex col
   */
  private void t4(final int rowIndex, final int colIndex) {

    final int minCellsAmountInFigure = 5;
    final Cell currentCell = this.gameBoard[rowIndex][colIndex];
    Figure tfigure = new Figure('T', currentCell.getColor());
    tfigure.addCell(currentCell);

    if ((rowIndex + 2 < this.gameBoard.length)
        && (colIndex - 2 >= 0)) {

      if (this.gameBoard[rowIndex + 1][colIndex]
              .compareEquals(currentCell)) {
        tfigure.addCell(this.gameBoard[rowIndex + 1][colIndex]);
      }
      if (this.gameBoard[rowIndex + 2][colIndex]
              .compareEquals(currentCell)) {
        tfigure.addCell(this.gameBoard[rowIndex + 2][colIndex]);
      }
      if (this.gameBoard[rowIndex + 1][colIndex - 1]
              .compareEquals(currentCell)) {
        tfigure.addCell(this.gameBoard[rowIndex + 1][colIndex - 1]);
      }
      if (this.gameBoard[rowIndex + 1][colIndex - 2]
              .compareEquals(currentCell)) {
        tfigure.addCell(this.gameBoard[rowIndex + 1][colIndex - 2]);
      }
    }

    if (tfigure.items() == minCellsAmountInFigure) {
      this.boardFigures.add(tfigure);
    }

  }
}
