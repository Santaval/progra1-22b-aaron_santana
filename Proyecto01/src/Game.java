import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Game class
 * Main logic of Match3 engine. Call all the necesaries
 * functions to work
*/
public class Game {
  // atributes
  // input declaration
  /**
   * Instance of Scanner to read values from stdin.
   */
  private Scanner input = null;
  // set gameBoard = null
  /**
   * Instance of the class GameBoard.
   */
  private GameBoard gameBoard = null;
  // set gameBoardCount = 0
  /**
   *Number of boards processed.
   */
  private int gameBoardCount = 1;

  /**
   * Constructor.
   */
  public Game() {

  }

  /**
   * Main function.

   * @param args parametros
   */
  public static void main(final String[] args) {
    Game game = new Game();
    game.runApp();
  }

  /**
   * Run the app Run the start function and create an instance of stdin Scanner.

   * @throws IllegalArgumentException if board is invalid
   */
  public void runApp() {
    // Create object to read data from standard input
    this.input = new Scanner(System.in);
    // Run problem solution

    try {
      this.start();
    } catch (IndexOutOfBoundsException err) {
      this.printSpace();
      System.out.println(err.getMessage());
    } catch (InputMismatchException err) {
      this.printSpace();
      System.out.println(err.getMessage());
    } catch (NoSuchElementException err) {
      this.printSpace();
      System.out.println(err.getMessage());
    }

    // Close the scanner of standard input
    this.input.close();
  }


  /**
  * Start app
  *Excute the main logic. Reads board size,
  generate neew Board while exist inputs.
  and execute elmination and gravity function.
  */
  public void start() {
    // while hasNextInt do
    while (this.input.hasNext()) {
      // input rowCount,colCount
      int rowCount = 0;
      if (input.hasNextInt()) {
        rowCount = this.input.nextInt();
      } else {
        throw new InputMismatchException("invalid input");
      }
      int colCount = 0;
      if (input.hasNextInt()) {
        colCount = this.input.nextInt();
      } else {
        throw new InputMismatchException("invalid input");
      }
      // gameBoard := new GameBoard(rowCount, colCount)
      this.gameBoard = new GameBoard(rowCount, colCount);
      // read game board
      this.gameBoard.read(input);
      // if(gameBoard.validate()) do
      if (this.gameBoard.validate()) {

        do {
          this.gameBoard.gravity();
          this.gameBoard.clearFigures();
          // gameBoard.searchFigures()
          gameBoard.searchFigures();
          // gameBoard.deleteFigure()
          gameBoard.deleteFigure();
          // System.out.printf("\n");
          // this.gameBoard.print();
          // System.out.print("\n");
          // gameBoard.print();
          // System.out.print("\n");
          // System.out.println("----------------");
        } while (gameBoard.haveFigures());
        if (this.gameBoardCount != 1) {
          System.out.print("\n");
        }
        System.out.printf("%d:\n", this.gameBoardCount);
        this.gameBoard.print();
      } else {
        // output invalid terrain
        System.out.printf("\n%s", "invalid input");
      } // end
      this.gameBoardCount++;
    } // end
  } //end

  /**
   * Formating print.
   */
  private void printSpace() {
    if (this.gameBoardCount != 1) {
      System.out.print("\n");
    }
  }


}
