import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Solution for histogram problem.
 */
public class Solution {
  /**
   * Parse formatted data from standard input.
   */
  private Scanner input = null;

  /**
   * Start the execution of the solution.

   * @param args Command line arguments.
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

    //reaing valuesamount, range, int digits and decimal digits

    int valuesAmount = this.input.nextInt();
    int rangeAmount = this.input.nextInt();
    int intDegits = this.input.nextInt();
    int decimalDigits = this.input.nextInt();

    //reading and order values 
    double[] values = this.readValues(valuesAmount);
    Arrays.sort(values);
    this.printHistogram(values, rangeAmount, intDegits, decimalDigits);



  }



  //read the values, create and return a double array with them
  public double[] readValues(int valuesAmount){

    double[] values = new double[valuesAmount];

    for (int index = 0; index < valuesAmount; index++){
        
        if (this.input.hasNextDouble()) {
            values[index] = this.input.nextDouble();
        } else throw new InputMismatchException("Invalid or insufficient data");  
    }

    return values;

  }


  public void printHistogram(double[] values, int rangeAmount, int intDigits, int decimalDigts){
    int[] rangesValuesAmount = calculateValuesRangeAmount(values, rangeAmount);
    double rangeWidth = calculateRangeWidth(values, rangeAmount);
    double min = values[0];

    for (int index = 0; index < rangeAmount - 1; index++){
        System.out.printf("[%"+intDigits+"."+ decimalDigts +"f, %"+intDigits+"."+ decimalDigts +"f[ | ", min, (min+rangeWidth));

        for (int counter = 0; counter < rangesValuesAmount[index] ; counter++){
            System.out.print("*");
        }

        System.out.print("\n");
        min += rangeWidth;

    }



    System.out.printf("[%"+intDigits+"."+ decimalDigts +"f, %"+intDigits+"."+ decimalDigts +"f] | ", min, (min+rangeWidth));

        for (int counter = 0; counter <= rangesValuesAmount[rangeAmount -1]; counter++){
            System.out.print("*");
        }
  }



  private int[] calculateValuesRangeAmount(double[] values, int rangeAmount) {
    double min = values[0];
    double rangeWidth = calculateRangeWidth(values, rangeAmount);
    int[] rangesValuesAmount = new int[rangeAmount];

    for (int index = 0; index < values.length - 1; index++){
        int valuesRangeIndex = (int) Math.floor((values[index]- min) / rangeWidth);
        try {
          rangesValuesAmount[valuesRangeIndex ] ++;
        } catch (Exception err){
          rangesValuesAmount[valuesRangeIndex - 1] ++;
        }
    }

    return rangesValuesAmount;

    
}

private double calculateRangeWidth(double[] values, int rangeAmount) {
    double min = values[0];
    double max = values[values.length - 1];
    return (max-min) / rangeAmount;
}



  // Do not modify code above.
  // Design a pseudocode solution using arrays and sub-tasks.
  // Implement missing and at least 4 more subroutines here.
}