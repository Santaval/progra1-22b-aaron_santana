import java.util.Scanner;

public class Game {
  //atributes
  //input declaration
  private Scanner input = null;
  //set gameBoard = null
  private GameBoard gameBoard = null;
  // set gameBoardCount = 0
  private int gameBoardCount = 1;


  /**
   * Main function.
   * @param args parametros
   */
  public static void main(final String[] args) {
    Game game = new Game();
    game.runApp();
  }

  /**
  *Run the app
  *Run the start function and create an instance of stdin Scanner.
  * @throws IllegalArgumentException if board is invalid
  */
  public void runApp() {
    // Create object to read data from standard input
    this.input = new Scanner(System.in);
    // Run problem solution
    try {
      this.start();
    } catch (IndexOutOfBoundsException err) {
      System.out.println(this.gameBoardCount + ":");
      System.out.println(err.getMessage());
    }

    // Close the scanner of standard input
    this.input.close();
  }


<<<<<<< HEAD
    //procedure  do 
    public void start(){
	 	//while hasNextInt do
        while (this.input.hasNextInt()){ 
			//input rowCount,colCount
            final int rowCount = this.input.nextInt();
            final int colCount = this.input.nextInt();	
			//gameBoard := new GameBoard(rowCount, colCount)
            this.gameBoard = new GameBoard(rowCount, colCount);
            //read game board
            this.gameBoard.read(input);
	 		//if(gameBoard.validate()) do
            if (this.gameBoard.validate()){
                //gameBoard.searchFigures()
                gameBoard.searchFigures();
                //gameBoard.deleteFigure()
                gameBoard.deleteFigure();
                System.out.printf("\n%d:\n", this.gameBoardCount); 
                this.gameBoard.print();
			}//end
			//else do
            else { 
	 			//output invalid terrain
                System.out.printf("\n%d:\n%s", this.gameBoardCount, "invalid terrain"); 
	 		}//end
	 	}//end
    }//end
=======
  /**
   * Start app
   *Excute the main logic. Reads board size,
  generate neew Board while exist inputs
    and execute elmination and gravity function.
   */
  public void start() {
    // while hasNextInt do
    while (this.input.hasNextInt()) {
      // input rowCount,colCount
      final int rowCount = this.input.nextInt();
      final int colCount = this.input.nextInt();
      // gameBoard := new GameBoard(rowCount, colCount)
      this.gameBoard = new GameBoard(rowCount, colCount);
      // read game board
      this.gameBoard.read(input);
      // if(gameBoard.validate()) do
      if (this.gameBoard.validate()) {
        // gameBoard.searchFigures()
        gameBoard.searchFigures();
        Figure eliminate = gameBoard.selectFigureToDelete();
        eliminate.eliminate();
        System.out.printf("\n%d:\n", this.gameBoardCount);
        this.gameBoard.print();
      } else {
        // output invalid terrain
        System.out.printf("\n%d:\n%s", this.gameBoardCount, "invalid terrain");
      } // end
    } // end
  } // end
>>>>>>> 0d7bae5 (linting corrections)



}
