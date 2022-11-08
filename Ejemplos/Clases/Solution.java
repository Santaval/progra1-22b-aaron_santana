//package Ejemplos.Clases;

//package bus;
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

    Persona persona1 = new Persona("Aaron", "Santana Valdelomar", 18, true);
    Persona persona2 = new Persona("Cynthia", "Valdelomar Brizuela", 42, true);
    Persona persona3 = new Persona("Anabelle", "Brizuela Guadamuz", 75, true);


    persona1.agregarMadre(persona2);
    persona2.agregarMadre(persona3);


    System.out.println(persona3.novia);

  }

    






} 


