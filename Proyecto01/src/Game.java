import java.util.Scanner;
public class Game {
    //atributes
    //input declaration
    private Scanner input = null;
    // set gameBoard = null
    private GameBoard gameBoard = null;
	// set gameBoardCount = 0
    private int gameBoardCount = 1;


    public static void main(final String[] args){
        Game game = new Game();
        game.runApp();
    }

    public void runApp(){
        // Create object to read data from standard input
        this.input = new Scanner(System.in);
        // Run problem solution
       try {
        this.start();
       }
       catch (IndexOutOfBoundsException err){
            System.out.println(this.gameBoardCount + ":");
            System.out.println(err.getMessage());
       }
        // Close the scanner of standard input
        this.input.close();
    }

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
                System.out.printf("%d:\n", this.gameBoardCount); 
                this.gameBoard.print();
			}//end
			//else do
            else { 
	 			//output invalid terrain
                System.out.printf("%d:\n%s", this.gameBoardCount, "invalid terrain"); 
	 		}//end
	 	}//end
    }//end
    


}