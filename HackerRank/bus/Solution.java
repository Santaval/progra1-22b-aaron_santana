package bus;
import java.util.InputMismatchException;
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
    try{
      // This try calls solution.close() automatically
    Solution solution = new Solution();
    solution.start();
    }catch (InputMismatchException err){
      System.out.println("invalid data");
    }
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

    long passageValue = 0;
    if(this.input.hasNextLong()){
      passageValue = this.input.nextLong();}
    else throw new InputMismatchException("Invalid data"); 

    if (this.validatePassage(passageValue)){
      System.out.printf("%5d\n",passageValue);
      this.printTableHeaders();

      while(this.input.hasNextLong()){
      long payment = this.input.nextLong();
      System.out.printf("%5d ", payment);
      this.printChange(passageValue, payment);
      this.printCoinsAmount(payment, passageValue);
      }
    }

    else{
      System.out.printf("%5d error",passageValue);
    }



  }





  //validations
 public boolean validatePassage(long passageValue){
    if (passageValue <= 0) return false;
    return true;
 }

public boolean validatePayment(long payment){
  if(payment <= 0) return false;
  return true;
}

public boolean validateChange(long payment,long passageValue){
  if (payment >= passageValue) return true;
  else return false;
}


//print

public void printTableHeaders(){
  System.out.println(" PAGO VUELT 500 100  50  25  10   5");
  System.out. println("----- ----- --- --- --- --- --- ---");
}

public void printChange(long passageValue, long payment){
  if(this.validatePayment(payment)){
    if(this.validateChange(payment, passageValue)){
      long change = this.calculateChange(payment, passageValue);
      System.out.printf("%5d ", change);
    } else {
        System.out.printf("%5s", "insuf");
    }
  } else{
    System.out.printf("%5s", "error");
    System.out.print("\n");
  }
}


public void printCoinsAmount(long payment, long passageValue){
  if(this.validatePayment(payment)){
    long change = this.calculateChange(payment, passageValue);
    long[] coinsAmount = this.calculateCoinsAmount(change);

    for(int counter = 0; counter < 6; counter++){
      long currentCoinAmount = coinsAmount[counter];
      if (currentCoinAmount > 0) System.out.printf("%3d ", currentCoinAmount);
      else{
        if (counter == 5) System.out.print("   ");
        else System.out.print("    ");
      }
    }

    System.out.print("\n");
  }
}

//calculate 
public long calculateChange(long payment, long passageValue){
  assert payment >= passageValue;
  return payment - passageValue;
}


public long[] calculateCoinsAmount(long change){
  assert change >= 0;
  long[] coinsAmount = new long[6];

  for(int counter = 0; counter < 6; counter++){
    switch(counter){
            case 0:  
            coinsAmount[counter] =   change / 500;
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

  return coinsAmount;
}


} 


