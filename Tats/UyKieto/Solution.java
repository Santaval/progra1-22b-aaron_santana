package UyKieto;
import java.util.Scanner;





public class Solution {

    public static void main(String[] args){
        Scanner scanner = new Scanner (System.in); 
        int cantidadNombres = scanner.nextInt();
        String[] nombres = new String[cantidadNombres];
    
        for(int index = 0; index < cantidadNombres; index++){
            nombres[index] = scanner.next().toLowerCase();
        }

        
        nombres = ordenarAlf(nombres);
       nombres = voltear(nombres);

        for(int index = 0; index < cantidadNombres; index++){
            System.out.println(nombres[index] );
        }


        
       
      scanner.close();

    }
    
        public static String[] ordenar( String[] nombres){
       
        String[] nuevaLista =new String[nombres.length];
       
          for (int i=0; i < nombres.length; i++){
            String menor = concat(nombres).toUpperCase();
             for (int j=0; j< nombres.length; j++){
                
                 String nomActual = nombres[j]; 
                
                // System.out.println(nomActual);

                 if (menor.compareTo(nomActual) <= 0 && !compareList(nomActual,nuevaLista)){
                     menor = nomActual;

    
                 }
               
                }
                
                nuevaLista[i] = menor;
               
               
            }

            return nuevaLista;
        }




        public static String[] ordenarAlf( String[] nombres){
       
            String[] nuevaLista =new String[nombres.length];
           
              for (int i=0; i < nombres.length; i++){
                String menor = concat(nombres).toUpperCase();
                 for (int j=0; j< nombres.length; j++){
                    
                     String nomActual = nombres[j]; 
                    
                    // System.out.println(nomActual);
    
                     if (nomActual.compareTo(menor) >= 0 && !compareList(nomActual,nuevaLista)){
                         menor = nomActual;
    
        
                     }
                   
                    }
                    
                    nuevaLista[i] = menor;
                   
                   
                }
    
                return nuevaLista;
            }


        public static boolean compareList(String nomactual, String[] nuevaLista){
           boolean isRepeated = false;

           for (int counter = 0; counter < nuevaLista.length; counter++){
                if (nomactual.equals(nuevaLista[counter])) isRepeated = true;
           }

            return isRepeated;
        }


        public static String concat(String[] nombres) {
            String finalString = "";
            for (int counter = 0; counter < nombres.length; counter++){
                finalString += nombres[counter];
            }

            return finalString;
        } 
 

        public static String[] voltear(String[] nombres){
            String[] listaFinal = new String[nombres.length];
            int listaFinalIndex = 0;
            for(int i = nombres.length -1; i >= 0 ; i--){
                listaFinal[listaFinalIndex] = nombres[i];
                listaFinalIndex++;
            }

            return listaFinal;

        }
    

}




