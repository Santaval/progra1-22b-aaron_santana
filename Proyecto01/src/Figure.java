import java.util.ArrayList;

/**
 * Figure object
 * Must be tYpe Horizontal, Vertical L or t , keeps the Cells that are in one
 * of this type of Figure.
 */
public class Figure {
  // atributes
  // set figure = Cell[]
  public ArrayList<Cell> figure = new ArrayList<>(0);
  // set type := '\0'
  public char type = '\0';

  // constructor Figure(type) do
  public Figure(char type) {
    // type := type
    this.type = type;
  } //end

  // function items() do
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
  public static Figure combine(Figure first, Figure second, char type) {
    Figure newFigure = new Figure(type);
    for (int index = 0; index < first.figure.size(); index++) {
      if (type == 'L') {
        first.figure.get(index).lfigure = newFigure;
      } else {
        first.figure.get(index).tfigure = newFigure;
      }
      newFigure.figure.add(first.figure.get(index));
    }

    for (int index = 0; index < second.figure.size(); index++) {
      if (type == 'L') {
        second.figure.get(index).lfigure = newFigure;
      } else {
        second.figure.get(index).tfigure = newFigure;
      }
      newFigure.figure.add(second.figure.get(index));
    }

    return newFigure;
  }

  // function isLastOrFirstCell(cell) do
  /**
   * Last or first Cell
   * Verify if one Cell is the first or last in a Fifure.

   * @param cell Cell to check
   * @return boolean
   */
  public boolean isLastOrFirstCell(Cell cell) {
    // if cell equals figure[0] or figure[last] do );
    if (cell == this.figure.get(0) || cell == this.figure.get(this.figure.size() - 1)) {
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
  public static Figure priorityFigure(ArrayList<Figure> boardFigures) {
    // for index to boardFigures.items() do
    for (int index = 0; index < boardFigures.size(); index++) {
      // if (boardFigures[index].type == 'V' OR boardFigures[index].type == 'V') AND size >= 5 do
      if ((boardFigures.get(index).type == 'V' || boardFigures.get(index).type == 'H')
          && boardFigures.get(index).items() >= 5) {
        // return boardFigures[index]
        return boardFigures.get(index);
      } // end
    } // end
    // for index to boardFigures.items() do
    for (int index = 0; index < boardFigures.size(); index++) {
      // if boardFigures[index].type == 'L' OR boardFigures[index].type == 'T' do
      if ((boardFigures.get(index).type == 'L' || boardFigures.get(index).type == 'T')
          && boardFigures.get(index).items() >= 6) {
        // return boardFigures[index]
        return boardFigures.get(index);
      } // end
    } // end
    // for index to boardFigures.items() do
    for (int index = 0; index < boardFigures.size(); index++) {
      // if (boardFigures[index].type == 'H' OR boardFigures[index].type == 'V') AND size == 4 do
      if ((boardFigures.get(index).type == 'V' || boardFigures.get(index).type == 'H')
          && boardFigures.size() == 4) {
        // return boardFigures[index]
        return boardFigures.get(index);
      } // end
    } // end
    // for index to boardFigures.items() do
    for (int index = 0; index < boardFigures.size(); index++) {
      // if (boardFigures[index].type == 'V' OR boardFigures[index].type == 'H') AND size == 3 do
      if ((boardFigures.get(index).type == 'V' || boardFigures.get(index).type == 'H')
          && boardFigures.size() == 3) {
        // return boardFigures[index]
        return boardFigures.get(index);
      } // end
    } // end
    // return null
    return null;
  } // end

}
