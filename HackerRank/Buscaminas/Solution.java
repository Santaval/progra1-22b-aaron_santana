//package Ejemplos.Buscaminas;
import java.util.InputMismatchException;
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
  
   try {
    this.run();
   } catch (InputMismatchException err){
    System.out.println(err.getMessage());
   }

    

    // Close the scanner of standard input
    this.input.close();
  }

  /**
   * Run the solution. This method is called from main().
   */
  public void run() {
    // while  validBoard do 
    while (this.validBoard) {
        
        if((this.input.hasNextLine() || this.input.hasNextInt())){
            
            int rowCount =  0 ; 
            int colCount =  0 ; 
            if(this.input.hasNextInt()) {
                //set rowCount := input nextInt
                rowCount = this.input.nextInt();
                // set colCount := input nextInt
                colCount = this.input.nextInt();
            } else throw new InputMismatchException ("invalid terrain");
          
        
            
            // if rowCount == 0 && colCount ==0 validBoard = false
            if (rowCount == 0 && rowCount == 0) this.validBoard = false;
            
            // else if isValidBoard (rowCount, colCount) do
            
            else if (this.validBoard){
                this.isValidBoard(rowCount, colCount);
                //this.printGameBoard()
                if (this.validBoard){
                    this.printGameBoard();
                } 
                else  System.out.printf("invalid terrain");

            }//end


            //else do 
            else {
                
                //output "invalid terrain"
                System.out.printf("invalid terrain");
            }// end
            
        
            if ( !this.input.hasNextInt() && this.input.hasNextLine()) {
            //discard lines
            //this.input.nextLine();
            
            }
        }

        else {
             //output "invalid terrain"
             System.out.printf("invalid terrain");
             this.validBoard = false;
        }
    }// end
   
  }

    
    /** Validate if the board is valid. The rowCount and colCount must be more than 0 and the game board could not have symbols that not be '.' or '*'
     * @param rowCount
     * @param colCount
     */
    // modify validBoard atribute boolean
    // function isValidBoard (rowCount, colCount) do 
    public void isValidBoard(int rowCount, int colCount){


        //if (rowCount < 0 OR colCount < 0) do
       
        if (rowCount <=0 || colCount <= 0 ) this.validBoard = false; //isValidBoard := false
       
        //  if isValidBoard do 
        if (this.validBoard) {
            //this.generateGameBoard(rowCount,colCount)
             this.generateGameBoard(rowCount, colCount);

            // for rowIndex to rowCount do 
            for (int rowIndex =0; rowIndex < rowCount; rowIndex++){
                //for colIndex to colCount do 
                for (int colIndex =0; colIndex < colCount; colIndex++){
                    // currentValue := this.gameBoard[rowIndex][colIndex]
                    char currentValue = this.gameBoard[rowIndex][colIndex];
                    // if currentValue != '.' OR currentValue != '*' do 
                    if (currentValue != '.' && currentValue != '*') this.validBoard = false;  //isValidBoard := false
                       
                }//end
            } // end
        }// end

     
    }// end


    
    /** Reads the values from the stdin and generate a char matrix whith them 
     * @param rowCount
     * @param colCount
     */
    // procedure generateGameBoard (rowCount,colCount) do 
    public void generateGameBoard(int rowCount, int colCount){
         //discard emptySpace  
        this.input.nextLine();
        //this.gameBoard = char[rowCount][colCount]
        this.gameBoard = new char[rowCount][colCount]; 
        //for rowIndex to rowCount do 
        for (int rowIndex = 0; rowIndex < rowCount; rowIndex++){        
        //set currentValues := input nextLine
      
        String currentValues =  this.input.nextLine(); 
       
            //for colIndex to colCount do 
            for (int colIndex = 0; colIndex < colCount; colIndex++){
                //this.gameBoard[rowIndex][colIndex] = currentValues.chartAt(colIndex)
                //System.out.printf("caracter:" + currentValues.charAt(colIndex)+ "\n");
               
                try {
                    
                    if(currentValues.length() < colCount) this.validBoard = false;
                    this.gameBoard[rowIndex][colIndex] = currentValues.charAt(colIndex);

                } catch (Exception err){
                    this.validBoard = false;
                }
               
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

        System.out.printf("%d:\n", this.boardCount+1);
        
        //for rowIndex to rowCount do 
        for (int rowIndex =0; rowIndex < rowCount; rowIndex++){ 
            //for colIndex to colCount do 
            for (int colIndex =0; colIndex < colCount; colIndex++){
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
        boardCount++;
        System.out.print("\n");
    }// end


    
    /** Generate a int mirror matrix from gameBoard matrix whith the numbers of mines arround each cell
     * @return int[][]
     */
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
        for (int rowIndex =0; rowIndex < rowCount; rowIndex++){ 
            //for colIndex to colCount do 
            for (int colIndex =0; colIndex< colCount; colIndex++){ 

            //if this.gameBoard[rowIndex][colIndex] = '*' minesAmount [rowIndex][colIndex] := -1
            if (this.gameBoard[rowIndex][colIndex] == '*') minesAmount[rowIndex][colIndex] = -1;

            //else minesAmount [rowIndex][colIndex] := this.checkCell(rowIndex,colIndex)
            else minesAmount[rowIndex][colIndex] = this.checkCell(rowIndex, colIndex);
           

            }//end
        }//end

           

        //return minesAmount
        return minesAmount;

    }// end


    
    /** Evaluate one cell of gameBoard and returns int that represents how much mines are arround that cell
     * @param rowIndex
     * @param colIndex
     * @return int
     */
    //returns int
    // function checkCell(rowIndex,colIndex) do 
    public int checkCell(int rowIndex, int colIndex){
        //set minesCounter = 0
        int minesCounter = 0;

        //if(checkRange(rowIndex, colIndex) AND this.gameBoard[rowIndex][colIndex +1] = '*') minesCounter ++
        if(checkRange(rowIndex, colIndex, 1) && this.gameBoard[rowIndex][colIndex +1 ] == '*') minesCounter ++;
        //if(checkRange(rowIndex, colIndex) AND this.gameBoard[rowIndex][colIndex-1] = '*') minesCounter ++
        if(checkRange(rowIndex, colIndex, 2) && this.gameBoard[rowIndex][colIndex -1 ] == '*') minesCounter ++;
        //if(checkRange(rowIndex, colIndex) AND this.gameBoard[rowIndex+1][colIndex] = '*') minesCounter ++
        if(checkRange(rowIndex, colIndex, 3)&& this.gameBoard[rowIndex + 1 ][colIndex] == '*') minesCounter ++;
        //if(checkRange(rowIndex, colIndex) AND this.gameBoard[rowIndex-1][colIndex] = '*') minesCounter ++
        if(checkRange(rowIndex, colIndex, 4)&& this.gameBoard[rowIndex - 1 ][colIndex] == '*') minesCounter ++;
        //if(checkRange(rowIndex, colIndex) AND this.gameBoard[rowIndex+1][colIndex -1] = '*') minesCounter ++
        if(checkRange(rowIndex, colIndex, 5) && this.gameBoard[rowIndex + 1 ][colIndex -1 ] == '*') minesCounter ++;
        //if(checkRange(rowIndex, colIndex) AND this.gameBoard[rowIndex+1][colIndex + 1]= '*') minesCounter ++
        if(checkRange(rowIndex, colIndex, 6) && this.gameBoard[rowIndex + 1][colIndex + 1 ] == '*') minesCounter ++;
        //if(checkRange(rowIndex, colIndex) AND this.gameBoard[rowIndex-1][colIndex+1] = '*') minesCounter ++
        if(checkRange(rowIndex, colIndex, 7) && this.gameBoard[rowIndex - 1 ][colIndex + 1 ] == '*') minesCounter ++;
        //if(checkRange(rowIndex, colIndex) AND this.gameBoard[rowIndex-1][colIndex-1] = '*') minesCounter ++
        if(checkRange(rowIndex, colIndex, 8) && this.gameBoard[rowIndex - 1 ][colIndex -1 ] == '*') minesCounter ++;

        //return minesCounter
        return minesCounter;
    }// end

    
    /**Evaluate if the range of the colIndex or rowIndex are in range of th e matrix (more than 0 and minus than matrix,lenght -1)  and return a boolean 
     * @param rowIndex
     * @param colIndex
     * @param config
     * @return boolean
     */
    // //returns boolean
    // function checkRange(rowIndex,colIndex) do 
    public boolean checkRange(int rowIndex, int colIndex, int config){
        //if rowIndex -1 < 0 OR rowIndex >= this.gameBoard.length return false
        if (config == 1 && colIndex + 1 >= this.gameBoard[0].length ) return false;
        else if (config == 2 && colIndex -1 < 0) return false;
        else if (config == 3 && rowIndex + 1 >= this.gameBoard.length ) return false;
        else if (config == 4 && rowIndex -1  < 0) return false;
        else if (config == 5 && (rowIndex + 1 >= this.gameBoard.length || colIndex - 1 < 0)) return false;
        else if (config == 6 && (colIndex +1 >= this.gameBoard[0].length  || rowIndex +1 >= this.gameBoard.length )) return false;
        else if (config == 7 && (colIndex + 1 >= this.gameBoard[0].length || rowIndex - 1 < 0)) return false;
        else if (config == 8 && (colIndex -1 < 0 || rowIndex -1 < 0)) return false;


        //return true
        return true;
    }// end



}
