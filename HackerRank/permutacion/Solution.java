
//package permutacion;
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

  /**
   * Run the solution. This method is called from main().
   */
  public void run() {
    // Numbers are separed by :, items by |, and students by \n
    this.input.useDelimiter("[\\|\\:\\n]+");

    //Number of words to be evaluated
    int wordsAmount = this.input.nextInt();

    String[] originalHomework  = this.extractWords(wordsAmount);
    

    while (this.input.hasNextInt()){
      int studentNum = this.input.nextInt();
      String[] currentHomework = new String[wordsAmount];
      currentHomework = this.extractWords(wordsAmount);
      int totalRepeatedWords = this.matchWords(originalHomework,currentHomework);
      this.printResults(wordsAmount, totalRepeatedWords, studentNum);
    }

  }




/** 
 * @param wordsAmount
 * @return String[]
 */
public  String[] extractWords(int wordsAmount){
 
  String[] words =new String [wordsAmount];

  for (int counter = 0; counter < wordsAmount; counter ++){
    String currentWord = this.input.next().trim().toLowerCase();
    words[counter] = currentWord;
  }

  return words;
}



/** 
 * Extracts the text from the standard input and saves it in a list.
 * None of the values must be an empty string.
 * @param originalHomework array of strings 
 * @param currentHomework array of strings 
 * @return int
 */
public int matchWords(String[] originalHomework, String[] currentHomework){

  int totalRepeatedWords = 0;
  originalHomework = deleteDuplicateValues(originalHomework);

  for (int originalCounter = 0; originalCounter < originalHomework.length; originalCounter++){
    //System.out.println(originalHomework[originalCounter]);
    for (int currentCounter = 0; currentCounter < currentHomework.length; currentCounter++){
      
      if (currentHomework[currentCounter].equals(originalHomework[originalCounter])){
           totalRepeatedWords +=1;
      }
    }

  }
  return totalRepeatedWords;
}




/** 
 * prints the results according to the described format 
 * @param wordsAmount
 * @param totalRepeatedWords
 * @param studentNum
 */
public void printResults(int wordsAmount, int totalRepeatedWords, int studentNum){

  int plagiarism = calculatePlagiarism(wordsAmount, totalRepeatedWords);

  System.out.print(studentNum + ": ");

  if(plagiarism == 0) System.out.print("original\n");

  else if (plagiarism >= 100) System.out.print("plagiarism\n");

  else System.out.print(plagiarism+ "%\n");
  
}



/** 
 * calculates the plage percentage 
 * @param wordsAmount
 * @param totalRepeatedWords
 * @return int
 */
public int calculatePlagiarism(double wordsAmount, double totalRepeatedWords){
  int average = (int )Math.round(totalRepeatedWords/wordsAmount * 100.00);
  return  average;
}




/** elimina los valores duplicados en la lista de strings y  reemplaza uno de ellos por un string vacio ("\0")
 * @param list
 * @return String[]
 */
public String[] deleteDuplicateValues(String[] list){

  String[] listCopy = list;

  for(int listIndex = 0; listIndex<list.length; listIndex++){
    int itemsCount = 0;

    for (int copyListIndex = 0; copyListIndex < listCopy.length; copyListIndex++){
          if(list[listIndex].equals(listCopy[copyListIndex])){
            itemsCount++;
          }

         
    }

    if(itemsCount > 1) listCopy[listIndex] = "\0";

  }

  return listCopy;

}


} 








