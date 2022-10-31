//package Ejemplos.Buscaminas;
import java.util.Scanner;

/**
 * TODO(you): Purpose of your solution
 */
public class Solution {
  /**
   * Parse formatted data from standard input.
   */
  private Scanner input = null;

      //atributes
    // set validBoard := true
  private boolean validBoard = true;
    // set gameBoard := null
  private char[][] gameBoard = null;
    // set boardCount := 0
  private int boardCount = 0;

  /**
   * Start the execution of the solution.

   * @param args Command line arguments
   */
  public static void main(final String[] args) {
    // This try calls solution.close() automatically
    Solution solution = new Solution();
    solution.start();
  }

  /**
   * Start the solution.
   */
  public void start() {
    // Create object to read data from standard input
    this.input = new Scanner(System.in);
    // Run problem solution
    this.run();
    // Close the scanner of standard input
    this.input.close();
  }

  /**
   * Run the solution. This method is called from main().
   */
  public void run() {

    // while hasNextInt AND validBoard do 
    while (this.input.hasNextInt() && this.validBoard) {}
    //set rowCount := input nextInt
    final int rowCount = this.input.nextInt();
    // set colCount := input nextInt
    final int colCount = this.input.nextInt();
    // if isValidBoard (rowCount, colCount) do 
    if (this.isValidBoard(rowCount,colCount)){
    //this.printGameBoard()
    this.printGameBoard();
    }//end

    //else do 
    else {
    //output "invalid terrain"
    System.out.printf("%d:\n%s", this.boardCount, "invalid terrain");
    }// end
  }// end


    // returns boolean
    // function isValidBoard (rowCount, colCount) do 
    public boolean isValidBoard(int rowCount, int colCount){

        //set isValidBoard := true
        boolean isValidBoard = true;
        

        //if (rowCount < 0 OR colCount < 0) do
        if (rowCount <0 || colCount < 0 ) isValidBoard = false; //isValidBoard := false
    
        //  if isValidBoard do 
        if (isValidBoard) {
            //this.generateGameBoard(rowCount,colCount)
            this.generateGameBoard(rowCount, colCount);

            // for rowIndex to rowCount do 
            for (int rowIndex =0; rowCount < rowCount; rowIndex++){
                //for colIndex to colCount do 
                for (int colIndex =0; colCount < colCount; colIndex++){
                    // currentValue := this.gameBoard[rowIndex][colIndex]
                    char currentValue = this.gameBoard[rowIndex][colIndex];
                    // if currentValue != '.' OR currentValue != '*' do 
                    if (currentValue != '.' || currentValue != '*') isValidBoard = false;  //isValidBoard := false
                       
                }//end
            } // end
        }// end

        //this.isValidBoard:= isValidBoard
        this.validBoard = isValidBoard;
        //return isValidBoard
        return isValidBoard;
    }// end


    // procedure generateGameBoard (rowCount,colCount) do 
    public void generateGameBoard(int rowCount, int colCount){
        //this.gameBoard = char[rowCount][colCount]
        this.gameBoard = new char[rowCount][colCount]; 
        //for rowIndex to rowCount do 
        for (int rowIndex =0; rowCount < rowCount; rowIndex++){        
        //set currentValues := input nextLine
        String currentValues = this.input.nextLine();
        
            //for colIndex to colCount do 
            for (int colIndex = 0; colCount < colCount; colIndex++){
                //this.gameBoard[rowIndex][colIndex] = currentValues.chartAt(colIndex)
                this.gameBoard[rowIndex][colIndex] = currentValues.charAt(colIndex);
            }//end
        }//end
        
    }// end

    // procedure printGameBoard() do 
    public void printGameBoard(){
        //set rowCount := this.gameBoard.length
        final int rowCount = this.gameBoard.length;
        //set colCount := this.gameBoard[0].length
        final int colCount = this.gameBoard[0].length;

        // set minesAmount := this.generateMinesAmount()
        final int[][] minesAmount = this.generateMinesAmount();

        //for rowIndex to rowCount do 
        for (int rowIndex =0; rowCount < rowCount; rowIndex++){ 
            //for colIndex to colCount do 
            for (int colIndex =0; colCount < colCount; colIndex++){
                //set currentValue := minesAmount[rowIndex][colIndex] 
                int currentValue = minesAmount[rowIndex][colIndex];

                // if currentValue = -1 d //output "*"
                if (currentValue == -1) System.out.print("*");
        
                // else if currentValue = 0 do  //output "-"
                else if (currentValue == 0) System.out.print("-");
               
                //else output currentValue
                else System.out.print(currentValue);
            }//end

            //output "\n"
            System.out.print("\n");
        }//end
    }// end


    //returns int matrix
    // function generateMinesAmount () do 
    public int[][] generateMinesAmount(){

        //set rowCount := this.gameBoard.length
        final int rowCount = this.gameBoard.length;
        //set colCount := this.gameBoard[0].length
        final int colCount = this.gameBoard[0].length;
        //set minesAmount = int[rowCount][colCount]
        int [][] minesAmount = new int[rowCount][colCount];

        //for rowIndex to rowCount do 
        for (int rowIndex =0; rowCount < rowCount; rowIndex++){ 
            //for colIndex to colCount do 
            for (int colIndex =0; colCount < colCount; colIndex++){ 

            //if this.gameBoard[rowIndex][colIndex] = '*' minesAmount [rowIndex][colIndex] := -1
            if (this.gameBoard[rowIndex][colIndex] == '*') minesAmount[rowIndex][colIndex] = -1;

            //else minesAmount [rowIndex][colIndex] := this.checkCell(rowIndex,colIndex)
            else minesAmount[rowIndex][colIndex] = this.checkCell(rowIndex, colIndex);
    

            }//end
        }//end

        //return minesAmount
        return minesAmount;

    }// end


    //returns int
    // function checkCell(rowIndex,colIndex) do 
    public int checkCell(int rowIndex, int colIndex){
        //set minesCounter = 0
        int minesCounter = 0;

        //if(checkRange(rowIndex, colIndex) AND this.gameBoard[rowIndex][colIndex +1] = '*') minesCounter ++
        if(checkRange(rowIndex, colIndex) && this.gameBoard[rowIndex][colIndex +1 ] == '*') minesCounter ++;
        //if(checkRange(rowIndex, colIndex) AND this.gameBoard[rowIndex][colIndex-1] = '*') minesCounter ++
        if(checkRange(rowIndex, colIndex) && this.gameBoard[rowIndex][colIndex +-1 ] == '*') minesCounter ++;
        //if(checkRange(rowIndex, colIndex) AND this.gameBoard[rowIndex+1][colIndex] = '*') minesCounter ++
        if(checkRange(rowIndex, colIndex) && this.gameBoard[rowIndex + 1 ][colIndex] == '*') minesCounter ++;
        //if(checkRange(rowIndex, colIndex) AND this.gameBoard[rowIndex-1][colIndex] = '*') minesCounter ++
        if(checkRange(rowIndex, colIndex) && this.gameBoard[rowIndex - 1 ][colIndex] == '*') minesCounter ++;
        //if(checkRange(rowIndex, colIndex) AND this.gameBoard[rowIndex+1][colIndex -1] = '*') minesCounter ++
        if(checkRange(rowIndex, colIndex) && this.gameBoard[rowIndex + 1 ][colIndex -1 ] == '*') minesCounter ++;
        //if(checkRange(rowIndex, colIndex) AND this.gameBoard[rowIndex+1][colIndex + 1]= '*') minesCounter ++
        if(checkRange(rowIndex, colIndex) && this.gameBoard[rowIndex + 1][colIndex +1 ] == '*') minesCounter ++;
        //if(checkRange(rowIndex, colIndex) AND this.gameBoard[rowIndex-1][colIndex+1] = '*') minesCounter ++
        if(checkRange(rowIndex, colIndex) && this.gameBoard[rowIndex - 1 ][colIndex + 1 ] == '*') minesCounter ++;
        //if(checkRange(rowIndex, colIndex) AND this.gameBoard[rowIndex-1][colIndex-1] = '*') minesCounter ++
        if(checkRange(rowIndex, colIndex) && this.gameBoard[rowIndex - 1 ][colIndex -1 ] == '*') minesCounter ++;

        //return minesCounter
        return minesCounter;
    }// end

    // //returns boolean
    // function checkRange(rowIndex,colIndex) do 
    public boolean checkRange(int rowIndex, int colIndex){
        //if rowIndex -1 < 0 OR rowIndex >= this.gameBoard.length return false
        if (rowIndex - 1 < 0 || rowIndex >= this.gameBoard.length) return false;
 
        //if colIndex -1 < 0 OR colIndex >= this.gameBoard.length return false
        if (colIndex - 1 < 0 || colIndex >= this.gameBoard[0].length) return false;

        //return true
        return true;
    }// end

}
