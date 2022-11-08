//package Ejemplos.Clases;
        public class Persona {

        //atributos
        public String nombre;
        public String apellidos;
        public int edad;
        public boolean novia;
        public Persona madre;
    
    
        public Persona(String nombre, String apellidos, int edad, boolean novia){
    
            this.nombre = nombre;
            this.apellidos = apellidos;
            this.edad = edad;
            this.novia = novia;
        
    
        }

        
        public void agregarMadre(Persona madre){

            this.madre = madre;

        }


        public String nombreCompleto(){

            return this.nombre + " "+ this.apellidos;

        }




    
    } 
    

