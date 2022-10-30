import java.util.Scanner;


/**
 * Validates a treasure map and prints the path from a starting
 * point to the position where the trasure is
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
    int startRow = this.input.nextInt();
    int startCol = this.input.nextInt();


    int startCell = concatNums(startRow, startCol);

    int[][] map = generateMatrix(rowCount, colCount);



    int[] treasureWayCells = calculateTreasureWay(map, startCell);

    this.printTableSymbols(map, treasureWayCells);


    // TODO(you): Analyze the problem and be sure you understand each piece of
    // input and output. Solve the problem by creating an algorithm and test it.
    // Convert the algorithm to source code comments. Implement the algorithm's
    // instructions applying good programming practices and remove this comment.
  }




  public int concatNums(int num1, int num2){
    String finalNum = String.valueOf(num1) + String.valueOf(num2);
   // System.out.printf("Concat: %s", finalNum);
    return Integer.parseInt(finalNum);
  }


  public int[][] generateMatrix(int rowCount, int colCount){

    int[][] matrix = new int[rowCount][colCount];

    for (int rowIndex = 0; rowIndex < rowCount; rowIndex ++){
        for (int colIndex = 0; colIndex < colCount; colIndex ++){
            matrix[rowIndex][colIndex] = this.input.nextInt();
        }
    }

    return matrix;
  }


  public int[] calculateTreasureWay(int[][] map, int startCell){
    int totalCells = calculateSteps(map, startCell);
    int[] treasureMapWay = new int[totalCells -1];
    int[] currentCell = separateDigits(startCell);
    currentCell[0] -=1;
    currentCell[1] -= 1;
    int previousNumber = 0;
    boolean err = false;
    int cellsCounter = 0;


    while (!err){
        int[] nextCell = separateDigits(map[currentCell[0] ][currentCell[1] ] );
        nextCell[0] -= 1;
        nextCell[1] -= 1;


        if(nextCell[0] + nextCell[1] > (map.length + map[0].length)){
        
            System.out.println("err\n");
            err = true;
        } 

        else if (concatNums(nextCell[0], nextCell[1]) < 0){
        
            System.out.println("sea\n");
            err = true;
        }
        else if(checkValue(treasureMapWay, concatNums(currentCell[0], currentCell[1]))){
            System.out.println("loop\n");
            err = true;
        }

        else if(concatNums(currentCell[0], currentCell[1]) == concatNums(nextCell[0], nextCell[1])){
            
            treasureMapWay[cellsCounter] = concatNums(currentCell[0], currentCell[1]);
            System.out.println("treasure\n");
            cellsCounter ++;
            err = true;

        }

        else {
            treasureMapWay[cellsCounter] = concatNums(currentCell[0], currentCell[1] );
            previousNumber = concatNums(currentCell[0], currentCell[1]);
            currentCell[0] = nextCell[0];
            currentCell[1] = nextCell[1];
            
            cellsCounter ++;

        }
    }

    return treasureMapWay;

  }


  public int calculateSteps(int[][] map, int startCell){
    int[] currentCell = separateDigits(startCell);
    currentCell[0] -=1;
    currentCell[1] -=1;
    int previousNumber = 0;
    boolean err = false;
    int cellsCounter = 0;


    while (startCell != previousNumber && !err){


       

        int[] nextCell = separateDigits(map[currentCell[0] ][currentCell[1] ] );
        nextCell[0] -= 1;
        nextCell[1] -= 1;
       

        if(nextCell[0] + nextCell[1] > (map.length + map[0].length)){
           
            err = true;
        } 

        else if (concatNums(nextCell[0], nextCell[1]) < 0){
           
            err = true;
        }

        else if(previousNumber == concatNums(currentCell[0], currentCell[1])){
          
            cellsCounter ++;
            err = true;
        }

        else {
          
            cellsCounter ++;
            previousNumber = concatNums(currentCell[0], currentCell[1]);
            currentCell[0] = nextCell[0];
            currentCell[1] = nextCell[1];

        }
    }

    return cellsCounter;
  }



  public int[] separateDigits(int num){
    int[] digits = new int[2];
    String numString = ""+ num;

    for (int counter = 0; counter < 2; counter ++){
        digits[counter] = Integer.parseInt(numString.charAt(counter) + "");
    }

    return digits;
  }


  public boolean checkValue(int [] treasureMapWay, int currentValue){
    for (int index = 0; index < treasureMapWay.length; index++){
        if (treasureMapWay[index] == currentValue) return true;
    }

    return false;
  }



  public void printTableSymbols(int[][] map, int[] treasureMapWay){
    for (int rowIndex = 0; rowIndex < map.length; rowIndex ++){
        for (int colIndex = 0; colIndex < map[0].length; colIndex ++){
            int cell = concatNums(rowIndex, colIndex);
            int cellValue = map[rowIndex][colIndex];

            if (cellValue < 0) printSymbol("~");
            else if(cell == treasureMapWay[treasureMapWay.length - 1]) printSymbol("X");
            else if (checkValue(treasureMapWay, cell)) printSymbol(".");
            else if(cellValue == concatNums(rowIndex +1, colIndex + 1)) printSymbol("!");
            else printSymbol(" ");

            
        }

        System.out.print("\n");
    }
  }

  public void printSymbol(String symbol){
    System.out.print(symbol+ " ");
  }
 


}