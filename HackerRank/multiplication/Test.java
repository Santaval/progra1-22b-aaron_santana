package multiplication;

import java.util.Scanner;

/**
 * Prints formatted multiplication tables in a given range.
 */
public class Test {
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
    Test solution = new Test();
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
    long[] tableValues = {2,4,10};
    System.out.println(this.calculateMaxWidth(tableValues));


  }

  public int calculateMaxWidth(long[] tableValues){
    int tableValuesAmount = tableValues.length - 1;
    long biggestValue = tableValues[tableValuesAmount] * tableValues[tableValuesAmount];
    String biggesValueToString = "" + biggestValue;

    return biggesValueToString.length();
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

  for (int counter = 0; counter <tableValues.length; counter++){
   System.out.println(tableValues[counter]);
   
  }
  return tableValues;
}


public int calculateRowsAmount(long startNumber,long endNumber,long increment){
  assert startNumber <= endNumber;
  int totalNumbers = 0; 
  while (startNumber <= endNumber){
     totalNumbers ++;
     startNumber += increment;
  }

  return totalNumbers;
}

}

