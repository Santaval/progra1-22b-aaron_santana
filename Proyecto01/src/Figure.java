
import java.util.ArrayList;

/**
 * Figure object
 * Must be tYpe Horizontal, Vertical L or t , keeps the Cells that are in one
 * of this type of Figure.
 */
public class Figure {
  // atributes
  // set figure = Cell[]
  /**
   * Array to keep all cells of this figure.
   */
  private ArrayList<Cell> figure = new ArrayList<>(0);
  // set type := '\0'
  /**
   * Type of the Figure, must be V, H, L or T.
   */
  private char type = '\0';
  // set color := '\0'
  /**
   * Type of the Figure, must be 1, 2, 3, 4, 5 or 6.
   */
  private char color = '\0';

  // constructor Figure(type) do
  /**
   * Figure constructor
   * CReate new Figure.

   * @param inType figure type
   * @param inColor figure color
   */
  public Figure(final char inType, final char inColor) {
    // type and color = params
    this.type = inType;
    this.color = inColor;

  } //end


  //GET METHODS
  /**
   * returns figure color.

   * @return figure color
   */
  public char getColor() {
    return this.color;
  }

  /**
   * returns figure type.

   * @return figure  type
   */
  public char getType() {
    return this.type;
  }


  // function items() do
  /**
   * Check how many cells are in the array figure.

   * @return amount of cells in the figure
   */
  public int items() {
    // return figure(col)
    return figure.size();
  } // nd


  /**
   * Combine figures
   * Combine Cells of horizontal and vertical figures to create
    a new T or L figure.

   * @param first first figure to combine
   * @param second second figure to combine
   * @param type type of figure generated
   * @return new Figure T or L
   */
  public static Figure combine(final Figure first,
      final Figure second, final char type) {
    Figure newFigure = new Figure(type, first.color);
    for (int index = 0; index < first.figure.size(); index++) {
      if (type == 'L') {
        first.figure.get(index).setlfigure(newFigure);
      } else {
        first.figure.get(index).settfigure(newFigure);
      }
      newFigure.figure.add(first.figure.get(index));
    }

    for (int index = 0; index < second.figure.size(); index++) {
      if (type == 'L') {
        second.figure.get(index).setlfigure(newFigure);
      } else {
        second.figure.get(index).settfigure(newFigure);
      }
      newFigure.figure.add(second.figure.get(index));
    }

    return newFigure;
  }

  /**
   * Appends new Cell in the figure.

   * @param newCell figure to append
   */
  public void addCell(final Cell newCell) {
    this.figure.add(newCell);
  }

  /**
   * Return a cell in a specific index.

   * @param index index
   * @return cell
   */
  public Cell getCell(final int index) {
    return this.figure.get(index);
  }


  // function isLastOrFirstCell(cell) do
  /**
   * Last or first Cell
   * Verify if one Cell is the first or last in a Fifure.

   * @param cell Cell to check
   * @return boolean
   */
  public boolean isLastOrFirstCell(final Cell cell) {
    // if cell equals figure[0] or figure[last] do );
    if (cell == this.figure.get(0) || cell
         == this.figure.get(this.figure.size() - 1)) {
      // return true
      return true;
    } // end

    // return false
    return false;
  } //end

  // function priorityFigure(boardFigures) do
  /**
   * Return the first Figure found  with the priority:
   * 1) Vertical or horizontal more than 4 Cells
   * 2) T or L
   * 3) Vertical or horizontal with 4 Cells
   * 4) Vertical or horizontal.

   * @param boardFigures all the figures found in the board
   * @return most priority Figure
   */
  public static Figure priorityFigure(final ArrayList<Figure> boardFigures) {
    // for index to boardFigures.items() do
    final int five = 5; //most priority cells amount H or V
    final int six = 6; //min amount of cells in T or L figure
    final int four = 4; // H or V figure wrapped amount of cells
    final int three = 3; // H or V figure normal amount of cells
    for (int index = 0; index < boardFigures.size(); index++) {
      // if (boardFigures[index].type == 'V' OR
      //  boardFigures[index].type == 'V') AND size >= 5 do
      if ((boardFigures.get(index).type == 'V'
           || boardFigures.get(index).type == 'H')
          && boardFigures.get(index).items() >= five) {
        // return boardFigures[index]
        return boardFigures.get(index);
      } // end
    } // end
    // for index to boardFigures.items() do
    for (int index = 0; index < boardFigures.size(); index++) {
      // if boardFigures[index].type == 'L' OR
      // boardFigures[index].type == 'T' do
      if ((boardFigures.get(index).type == 'L'
            || boardFigures.get(index).type == 'T')
          && boardFigures.get(index).items() >= six) {
        // return boardFigures[index]
        return boardFigures.get(index);
      } // end
    } // end
    // for index to boardFigures.items() do
    for (int index = 0; index < boardFigures.size(); index++) {
      // if (boardFigures[index].type == 'H' OR
      //boardFigures[index].type == 'V') AND size == 4 do
      if ((boardFigures.get(index).type == 'V'
            || boardFigures.get(index).type == 'H')
          && boardFigures.get(index).items() == four) {
        // return boardFigures[index]
        return boardFigures.get(index);
      } // end
    } // end
    // for index to boardFigures.items() do
    for (int index = 0; index < boardFigures.size(); index++) {
      // if (boardFigures[index].type == 'V' OR
      //boardFigures[index].type == 'H') AND size == 3 do
      if ((boardFigures.get(index).type == 'V'
            || boardFigures.get(index).type == 'H')
          && boardFigures.get(index).items() == three) {
        // return boardFigures[index]
        return boardFigures.get(index);
      } // end
    } // end
    // return null
    return null;
  } // end

  /**
   * Check the first cell of the Figure that appears in the game board.

   * @return Cell
   */
  public Cell generateSpecialCell() {
    Cell minor = this.figure.get(0);
    for (int index = 0; index < this.figure.size(); index++) {
      if (this.figure.get(index).isFirst(minor)) {
        minor = this.figure.get(index);
      }
      minor.determinateType(this);
    }
    return minor;
  }

}
