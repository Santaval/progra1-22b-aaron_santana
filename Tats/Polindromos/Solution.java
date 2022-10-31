//package Ejemplos.Buscaminas;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * TODO(you): Purpose of your solution
 */
public class Solution {
  /**
   * Parse formatted data from standard input.
   */
  private Scanner input = null;

      //atributes
    // set validBoard := true
  private boolean validBoard = true;
    // set gameBoard := null
  private char[][] gameBoard = null;
    // set boardCount := 0
  private int boardCount = 0;

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
  
   try {
    this.run();
   } catch (InputMismatchException err){
    System.out.println(err.getMessage());
   }

    

    // Close the scanner of standard input
    this.input.close();
  }

  /**
   * Run the solution. This method is called from main().
   */
  public void run() {
    
    System.out.println(recursivo("ackka"));

    }


    public boolean recursivo(String palabra){
        
    
       if ((palabra.length() == 0) || (palabra.length() == 1 )){
           return true;
        }

        //amorroma

        if  ((palabra.charAt(0)) == (palabra.charAt(palabra.length()-1))){
            if((palabra.charAt(palabra.length()-1))<=(palabra.charAt(palabra.length()-2))){

                if ((palabra.charAt(0))<= (palabra.charAt(1))){
    
                return  recursivo(palabra.substring(1, palabra.length()-1)); 
                   
                }
            }
      }
      return false; 
    }
}