package bus;
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

  /**
   * Run the solution. This method is called from main().
   */
  public void run() {

    //reading passage value

      long payment = this.input.nextLong();
   
      this.calculateCoinsAmount(payment);


  }




public void calculateCoinsAmount(long change){
  assert change >= 0;
  long[] coinsAmount = new long[6];

  for(int counter = 0; counter < 6; counter++){
    switch(counter){
            case 0:  
            coinsAmount[counter] =  change / 500;
            change = change % 500;
             break;

            case 1: 
                coinsAmount[counter] =  change / 100;
                change = change % 100;
            break;

            case 2: 
            coinsAmount[counter] =  change / 50;
            change = change % 50;
            break;

            case 3: 
            coinsAmount[counter] =  change / 25;
            change = change % 25;
            break;

            case 4: 
            coinsAmount[counter] =  change / 10;
            change = change % 10;
            break;

            case 5: 
            coinsAmount[counter] =  change / 5;
            change = change % 5;
            break;
    }
  }

  System.out.println(coinsAmount[0]);
  System.out.println(coinsAmount[1]);
  System.out.println(coinsAmount[2]);
  System.out.println(coinsAmount[3]);
  System.out.println(coinsAmount[4]);
  System.out.println(coinsAmount[5]);
}


} 


