//package Laberinto_encantado;
import java.util.Scanner;

/**
 * Marks the solution path within a maze with breadcrumbs
 */
public class Solution{

  //atributes
  //set labyrinthBoard := null
  char[][] labyrinthBoard = null;
  //set wayFound := false
  boolean wayFound = false;
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
    final Solution solution = new Solution();
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
  //input rowCount,colCount
  final int rowCount = this.input.nextInt();
  final int colCount = this.input.nextInt();
  //readLabyrinthBoard(row,col);
  this.readLabyrinthBoard(rowCount, colCount);
  //set startCell := findStartCell() returns int array
  int[] startCell = findStartCell();
  //findLabyrinthWay(startCell[0], startCell[1]) recursive procedure
  this.findLabyrinthWay(startCell[0], startCell[1]);
  //printLabyrinthBoard()
  this.printLabyrinthBoard();
 

  }


  //procedure readLabyrinthBoard(rowCount,colCount) do 
  public void readLabyrinthBoard(int rowCount, int colCount) {
    //labyrinthBoard = char[rowCount][ColCount]
    this.labyrinthBoard = new char[rowCount][colCount];
    this.input.nextLine();
    //this.input.nextLine();
    //for rowIndex to row(labyrinthBoard) do
    for (int rowIndex = 0; rowIndex < this.labyrinthBoard.length; rowIndex++){ 
      //for colIndex to col(labyrinthBoard) do
      String currentValues = this.input.nextLine();
      for (int colIndex = 0; colIndex < this.labyrinthBoard[rowIndex].length; colIndex++){ 
        //labyrinthBoard[rowIndex][colIndex] = input nextChar
        //System.out.println(currentValues);
        this.labyrinthBoard[rowIndex][colIndex] = currentValues.charAt(colIndex); 
      }//end
    }//end
  }//end 

//function findStartCell() do //returns int array
  public int[] findStartCell() {
    //set startCell := int[2]
    int[] startCell = new int[2];
    //for rowIndex to row(labyrinthBoard) do 
    for (int rowIndex = 0; rowIndex < this.labyrinthBoard.length; rowIndex++){ 
      //for colIndex to col(labyrinthBoard) do 
      for (int colIndex = 0; colIndex < this.labyrinthBoard[rowIndex].length; colIndex++){ 
        //if (labyrinthBoard[rowIndex][colIndex] == 'A') do 
        if (this.labyrinthBoard[rowIndex][colIndex] == 'A'){
          //startCell[0] ""= rowIndex
          startCell[0] = rowIndex;
          //startCell[1] := colIndex
          startCell[1] = colIndex;
          //return startCell
          return startCell;
        }//end
      }//end
    }//end
    //return startCell
    return startCell;
  }//end


  //procedure findLabyrinthWay(rowIndex, colIndex) do
  public void findLabyrinthWay(int rowIndex, int colIndex){ 
    //labyrinthBoard[rowIndex][colIndex] := '.'
    this.labyrinthBoard[rowIndex][colIndex] = this.labyrinthBoard[rowIndex][colIndex] == 'A' ? 'A': '.';
    //if checkCell(rowIndex - 1, colIndex + 0) AND NOT wayFound do
    if (this.checkCell(rowIndex - 1, colIndex + 0) && !this.wayFound){ 
      //set nextCellValue = labyrinthBoard[rowIndex - 1][colIndex + 0]
      char nextCellValue = this.labyrinthBoard[rowIndex - 1][colIndex + 0];
      //if nextCellValue == 'B' do
      if(nextCellValue == 'B'){ 
        //wayFound :true
        this.wayFound = true;
      }//end
      //else if nextCellValue == ' ' do
      else if (nextCellValue == ' '){ 
      //recursive(rowIndex -1, colIndex)
      this.findLabyrinthWay(rowIndex - 1, colIndex + 0);
      }//end
    }//end

        //if checkCell(rowIndex + 1, colIndex + 0) AND NOT wayFound do
    if (this.checkCell(rowIndex + 1, colIndex + 0) && !this.wayFound){ 
      //set nextCellValue = labyrinthBoard[rowIndex + 1][colIndex + 0]
      char nextCellValue = this.labyrinthBoard[rowIndex + 1][colIndex + 0];
      //if nextCellValue == 'B' do
      if(nextCellValue == 'B'){ 
        //wayFound :true
        this.wayFound = true;
      }//end
      //else if nextCellValue == ' ' do
      else if (nextCellValue == ' '){ 
      //recursive(rowIndex+-1, colIndex)
      this.findLabyrinthWay(rowIndex + 1, colIndex + 0);
      }//end
    }//end


        //if checkCell(rowIndex - 0, colIndex - 1) AND NOT wayFound do
    if (this.checkCell(rowIndex - 0, colIndex - 1) && !this.wayFound){ 
      //set nextCellValue = labyrinthBoard[rowIndex - 0][colIndex - 1]
      char nextCellValue = this.labyrinthBoard[rowIndex - 0][colIndex - 1];
      //if nextCellValue == 'B' do
      if(nextCellValue == 'B'){ 
        //wayFound :true
        this.wayFound = true;
      }//end
      //else if nextCellValue == ' ' do
      else if (nextCellValue == ' '){ 
      //recursive(rowIndex -0, colIndex)- 1    
      this.findLabyrinthWay(rowIndex - 0, colIndex - 1);
      }//end
    }//end

        //if checkCell(rowIndex - 0, colIndex + 1) AND NOT wayFound do
    if (this.checkCell(rowIndex - 0, colIndex + 1) && !this.wayFound){ 
      //set nextCellValue = labyrinthBoard[rowIndex - 0][colIndex + 1]
      char nextCellValue = this.labyrinthBoard[rowIndex - 0][colIndex + 1];
      //if nextCellValue == 'B' do
      if(nextCellValue == 'B'){ 
        //wayFound :true
        this.wayFound = true;
      }//end
      //else if nextCellValue == ' ' do
      else if (nextCellValue == ' '){ 
      //recursive(rowIndex -0, colIndex)+ 1    
      this.findLabyrinthWay(rowIndex - 0, colIndex + 1);
      }//end
    }//end
    //else do
    if (!this.wayFound){
      //labyrinthBoard[rowIndex][colIndex] := "-"
      this.labyrinthBoard[rowIndex][colIndex] = '-';

    }//do

  }// end


  //function checkCell(rowCount, colCount) do  //returns boolean
  public boolean checkCell(int rowCount, int colCount){
    //if(rowCount >= 0 AND colCount < colCount(labyrinthBoard))do
    if ((rowCount >= 0 && rowCount < this.labyrinthBoard.length) && (colCount >= 0 && colCount < this.labyrinthBoard[rowCount].length)){
      //if(labyrinthBoard[rowCount][colCount] != '.' AND labyrinthBoard[rowCount][colCount] != '-') do 
      if(this.labyrinthBoard[rowCount][colCount] != '.' && this.labyrinthBoard[rowCount][colCount] != '-'){
        //return true
        return true;
      }//end
    }//end       
    //return false
    return false;

  }// end

  //procedure printLabyrinthBoard() do
  public void printLabyrinthBoard(){ 
    if(this.wayFound){
          //for rowIndex to row(labyrinthBoard) do 
    for (int rowIndex = 0; rowIndex < this.labyrinthBoard.length; rowIndex ++){
      //for colIndex to col(labyrinthBoard) do
      for (int colIndex = 0; colIndex < this.labyrinthBoard[rowIndex].length; colIndex ++){ 
        //if (labyrinthBoard[rowIndex][colIndex] == '-') do
        if (this.labyrinthBoard[rowIndex][colIndex] == '-'){ 
          //output " "
          System.out.print(" ");
        }//end
        //else do
        else { 
          //output labyrinthBoard[rowIndex][colIndex]
          System.out.print(this.labyrinthBoard[rowIndex][colIndex]);
        }//end
      }//end
      System.out.printf("\n");
    }//end
    }
    else {
      System.out.println("No solution path");
    }
  }//end

}
