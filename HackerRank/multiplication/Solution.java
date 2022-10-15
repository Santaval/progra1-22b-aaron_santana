package multiplication;

import java.util.Scanner;

/**
 * Prints formatted multiplication tables in a given range.
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

  
  public void run() {
    long[] orderNums = this.orderNums();
    long startNumber = orderNums[0];
    long endNumber = orderNums[1];
    long increment = this.input.nextLong();

    if(this.validateIncrement(increment)){
        long[] tableValues = this.calculateTableValues(startNumber, endNumber, increment);
        this.prinTableHeaders(tableValues);
        this.printTableRows(tableValues);

    }


  }


  //Trabaja bajo el supuesto de que en la entrada estandar existan dos valores de tipo long
  public long[] orderNums(){
    assert this.input.hasNextLong(); //must have exist a long in standart input
    long firtsNumber = this.input.nextLong();

    assert this.input.hasNextLong(); //must have exist a long in standart input
    long secondNumber = this.input.nextLong();

    long[] orderNums =new long[2];
    
    if (firtsNumber < secondNumber) {
        orderNums[0] = firtsNumber;
        orderNums[1] = secondNumber;
    }
    else if (firtsNumber > secondNumber){
        orderNums[0] = secondNumber;
        orderNums[1] = firtsNumber;
    }

    else {
        orderNums[0] = firtsNumber;
        orderNums[1] = secondNumber;
    }

    return orderNums;

  }        

  public boolean validateIncrement (long increment){
    if (increment <= 0){ 
    System.out.println("invalid increment");
    return false;
    }
    return true;
  }

 //trabaja bajo el supuesto que startNumber es menor o igual que final number, si no es asi lanza un error 
 public long[] calculateTableValues(long startNumber,long endNumber,long increment){
    assert startNumber <= endNumber;
    int totalNumbers = calculateRowsAmount(startNumber, endNumber, increment);
    long[] tableValues =new long[totalNumbers];
 
    for (int counter = 0; counter < tableValues.length; counter++){
       tableValues[counter] = startNumber;
       startNumber += increment;
    }
 
    return tableValues;
 }

 // supuesto star < end
 public int calculateRowsAmount(long startNumber,long endNumber,long increment){
    assert startNumber <= endNumber;
    int totalNumbers = 0; 
    while (startNumber <= endNumber){
       totalNumbers ++;
       startNumber += increment;
    }

    return totalNumbers;
 }

 public void prinTableHeaders(long[] tableValues){
    int spaceWhidth = this.calculateMaxWidth(tableValues);

    System.out.printf("%"+spaceWhidth +"s", "x");
    System.out.print(" |");
  
    for (int counter = 0; counter < tableValues.length; counter++){
        System.out.printf(" %"+spaceWhidth+"d", tableValues[counter]);
    }
    System.out.print("\n");
    this.printGuion(spaceWhidth);
    System.out.print("  ");
    for (int counter = 0; counter<tableValues.length; counter++){
      System.out.print(" ");
        printGuion(spaceWhidth);
    }
 }

public int calculateMaxWidth(long[] tableValues){

  int biggestLenght = 0;

  for (int firstValueCounter = 0; firstValueCounter<tableValues.length; firstValueCounter++){
    for (int secondValuecounter = 0; secondValuecounter<tableValues.length; secondValuecounter++){
        long currentNumber = tableValues[firstValueCounter] * tableValues[secondValuecounter];
        String currentNumberToString = "" + currentNumber;
        if(currentNumberToString.length() >= biggestLenght){
          biggestLenght = currentNumberToString.length() ;
        }
    }
  }


    return biggestLenght;

} 

public void printGuion(int spaceWhidth){
    for (int counter = 0; counter < spaceWhidth; counter++){
        System.out.print("-");
    }
}

public void printTableRows(long[] tableValues){
 
  int spaceWhidth = calculateMaxWidth(tableValues);
  for(int counter = 0; counter < tableValues.length; counter++){
      long currentValue = tableValues[counter];
      this.printTableRowsHeader(currentValue, spaceWhidth);
      this.printRowContent(tableValues, currentValue);
  } 
}

public void printTableRowsHeader(long currentValue,int spaceWidth){
  
   System.out.printf("\n%"+ spaceWidth +"d", currentValue);
   System.out.print(" |");
}


public void printRowContent(long[] tableValues, long currentValue){
  int spaceWhidth = calculateMaxWidth(tableValues);
  for(int counter = 0; counter < tableValues.length; counter++){
      long currentMultiplication = currentValue * tableValues[counter];
      System.out.printf(" %"+ spaceWhidth +"d", currentMultiplication);
} 
}

}






