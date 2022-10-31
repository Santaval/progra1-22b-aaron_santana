import java.util.Scanner;

/**
 * Finds factorials of numbers given in command line arguments or stdin.
 */
public class Factorial {
  /**
   * Parse formatted data from standard input.
   */
  private Scanner input = null;

  /**
   * Number 
   */
  private int number = -1;

  /**
   * Start the execution of the solution.

   * @param args Command line arguments
   */
  public static void main(final String[] args) {
    try {
      Factorial factorial = new Factorial();
      factorial.start(args);
    } catch (final Exception error) {
      System.err.printf("error: %s%n", error.getMessage());
    }
  }

  /**
   * Start the solution.
   */
  public void start(/*Solution this, */final String[] args) throws Exception {
    // Create object to read data from standard input
    this.input = new Scanner(System.in);
    this.analyzeArguments(args);
    // Run problem solution
    this.run();
    // Close the scanner of standard input
    this.input.close();
  }

  /**
   * Pending.

   * @param args Pending.
   * @throws Exception Pending.
   */
  public void analyzeArguments(/*Solution this, */final String[] args)
      throws Exception {
    if (args.length == 1) {
      this.number = Integer.parseInt(args[0]);
      if (this.number < 0) {
        throw new Exception("number must be positive");
      }
    } else {
      throw new Exception("usage: java Factorial <number>");
    }
  }

  /**
   * Run the solution. This method is called from main().
   */
  public void run() {  // procedure main()
    System.out.println(Factorial.iterativeFactorial(this.number));
    System.out.println(Factorial.recursiveFactorial(this.number));
  } // end procedure


  public static long iterativeFactorial(final long number) {
    long result = 1;
    for (long current = 1; current <= number; ++current) {
      result = result * current;
    }
    return result;
  }

  public static long recursiveFactorial(final long number) {
    if (number == 0) {
      return 1;
    } else {
      return number * recursiveFactorial(number - 1);
    }
  }


  public static long tailFactorial(final long number, final long result){
    if (number== 0) return result;
    return tailFactorial(number,1);
  }
}
