package Tats;
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

 try{

  solution.start();
 } catch (InputMismatchException err){
    System.out.println("Numero invalido, juego finalizado");
 
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
  int ganadasJugador = 0;
  int ganadasComputadora = 0;


  System.out.println("Digite el numero de cartas que desea generar");


  while (this.input.hasNextInt() || (ganadasJugador + ganadasComputadora) == 0){
    
  int n = this.input.nextInt();
    Baraja baraja = new Baraja(n);

    Mano jugador = new Mano(baraja);
    Mano computadora = new Mano(baraja);
  
    if (jugador.gana(computadora)) ganadasJugador++;
    else ganadasComputadora++;
    
    System.out.println("Siquiere seguir jugando digite el numero de cartas de la baraja si no digite X");


    }



  System.out.println("Jugador: " + ganadasJugador);
  System.out.println("Computadora: " + ganadasComputadora);



  }







}




