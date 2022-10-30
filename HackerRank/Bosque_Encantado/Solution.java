
import java.util.Scanner;

import javax.management.ValueExp;

/**
 * Simulates an enchated forest (an adaptation of game-of-live problem).
 */
public class Solution {
  /**
   * Parse formatted data from standard input.
   */
  private Scanner input = null;

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


    int rowCount = this.input.nextInt();
    int colCount = this.input.nextInt();
    int nightCount = this.input.nextInt();
    String[][] matrix= generateMatrix(rowCount, colCount);
    Forest forest = new Forest(rowCount, colCount,matrix);


    if (nightCount >= 0){
        System.out.println((0)+":");
        System.out.println(forest.toString());
        for (int counter =0; counter < nightCount; counter ++){
            forest.updateForest();
            System.out.println((counter+1)+":");
            System.out.println(forest.toString());
        }

    } else {
        System.out.println(0+":");
        System.out.println(forest.toString());

        for (int counter =0; counter > nightCount; counter --){
            forest.updateForest();
        }

        System.out.println(Math.abs(nightCount)+":");
        System.out.println(forest.toString());


    }
     
  


    // TODO(you): Analyze the problem and be sure you understand each piece of
    // input and output. Solve the problem by creating an algorithm and test it.
    // Convert the algorithm to source code comments. Implement the algorithm's
    // instructions applying good programming practices and remove this comment.
 
}



private String[][] generateMatrix(int row, int col){
    String[][] matrix = new String[row][col];
    String matrixString = this.input.next();

    while(this.input.hasNextLine()){
        matrixString += this.input.nextLine();
    }

    int charCount = 0;
    for (int rowIndex = 0; rowIndex < row; rowIndex ++){
        
        for (int colIndex = 0; colIndex < col; colIndex ++){
            matrix[rowIndex][colIndex] =""+ matrixString.charAt(charCount);
            charCount++;
        }
        
    }

    return matrix;

}

}

class Forest{

    public String[][]  forest;
    public int row;
    public int col;
    public Scanner input;


    public  Forest(int row, int col, String[][] matrix){
        this.row = row;
        this.col = col;
        this.forest = matrix;
        this.input = new Scanner(System.in);
       
    }


    private String updateCell(int currentRow, int currentCol){
        String currentCellValue = this.forest[currentRow][currentCol];
        String[] closeCells = this.closeCells(currentRow,currentCol);
       
        if(currentCellValue.equals("a")){
            if (this.searchValue("l", closeCells) == 4) return "l";
            if( searchValue("a", closeCells) == 4) return "-" ;
        }

        else if(currentCellValue.equals("l") && searchValue("l", closeCells) < 3) return "-";
        else if (currentCellValue.equals("-") && searchValue("a", closeCells) == 3) return "a";
        return currentCellValue;
    }


    private String[] closeCells(int currentRow, int currentCol){
        String[] closeCells = new String[8];

        for (int index = 0; index < 8; index ++){
            closeCells[index] = "\0";
        }



        if (checkValues(currentRow,currentCol)) closeCells[0] = forest[currentRow -1][currentCol];
        if (checkValues(currentRow,currentCol)) closeCells[1] = forest[currentRow +1][currentCol];
        if (checkValues(currentRow,currentCol)) closeCells[2] = forest[currentRow][currentCol - 1];
        if (checkValues(currentRow,currentCol)) closeCells[3] = forest[currentRow][currentCol + 1];
 

        return closeCells;
    }

    private boolean checkValues(int currenRow,int currentCol){
    
        if(currentCol -1 >= 0 && currentCol + 1 < this.col && currenRow -1 >= 0 && currenRow + 1 < this.row) return true;
        
        return false;
    }


    private int searchValue(String value, String[] list ){
        int foundValues = 0;

        for (int index = 0; index < list.length; index++){
       
            if (list[index].charAt(0) == value.charAt(0)) foundValues ++;

        }
        return foundValues;
    }


    public void updateForest(){
        String[][] newForest = new String[this.row][this.col];
        for (int rowIndex = 0; rowIndex < row; rowIndex ++){
        
            for (int colIndex = 0; colIndex < col; colIndex ++){
                newForest[rowIndex][colIndex] = this.updateCell(rowIndex, colIndex);
            }
            
        }

        this.forest = newForest;

    }


    public String toString(){

        String forestString = "";
        for (int rowIndex = 0; rowIndex < this.row; rowIndex ++){
            for (int colIndex = 0; colIndex < this.col; colIndex ++){
                forestString += this.forest[rowIndex][colIndex];
            }

            forestString += "\n";
        }
    
        return forestString;


    }

}


