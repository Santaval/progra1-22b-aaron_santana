//ximport java.math.BigInteger;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Calculates the greatest common divisor of two integers recursively
 * and prints the number of function calls required to calculate them.
 */
public class Solution {
  /**
   * Parse formatted data from standard input.
   */
  private Scanner input = null;

  /**
   * Number of function calls requierd to calculate the gcd.
   */


  //atributes
  //set firstValue := null;
  BigInteger firstValue = null;  
  //set secondVaue := null;
  BigInteger secondValue = null;
  //set MCD = null;
  BigInteger MCD = null;
  //set MCDCounter := null;
  int MCDCounter = 0;

  BigInteger originalFirstValue = null;

  BigInteger originalSecondValue = null;


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
    // while exist next int do 
    while(this.input.hasNextBigInteger()){
        // readValues()
        this.readValues();
        // MCD := calculateMCD()
        this.MCD = this.calculateMCD(this.firstValue.abs(), this.secondValue.abs());
        // printResult()
        this.printResult();
        // resetAtributes()
        this.resetAtributes();
    }// end

  }
  //procedure readValues() do
  public void readValues(){
    
    //try do 
    try{    
        //firstValue := absolute(input nextInt)
        this.firstValue = this.input.nextBigInteger();
        //secondVaue := absolute(input secondVaue)
        this.secondValue = this.input.nextBigInteger();
        this.originalFirstValue = this.firstValue;
        this.originalSecondValue = this.secondValue;
    }//end 
    //catch(err) do
    catch (InputMismatchException err){
        //output invalid data
        System.out.println("Invalid data");
    } //end 
  }//end



  //procedure calculateMCD(lastMultiple) do 
  public BigInteger calculateMCD(BigInteger firstValue, BigInteger secondValue){
    //MCDCounter++
    this.MCDCounter++;

    //if secondValue == 0 return firstValue
   
    if (secondValue.equals(BigInteger.valueOf(0))) return firstValue;
    //else do
    else { 
        return this.calculateMCD(secondValue, firstValue.mod(secondValue));
    }//end

  }//end


  


    //procedure printResult()do 
    public void printResult(){
        DecimalFormat format = new DecimalFormat("###,###");
        //output firstValue secondValue":" MCD (MCDCounter)
        System.out.printf("%s %s: %s (%d)\n", format.format(this.originalFirstValue), format.format(this.originalSecondValue), format.format(this.MCD),  this.MCDCounter );
    
      }//end



        //procedure resetAtributes() do
  public void resetAtributes(){

    //firstValue := 0;
    this.firstValue = null;
    //secondVaue := 0;
    this.secondValue = null;
    //MCD = 0;
    this.MCD = null;
    //MCDCounter := 0;
    this.MCDCounter = 0;
  }//end

}



  


