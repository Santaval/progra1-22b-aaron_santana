package Tests;
import java.lang.System;

//System.out.print("\033\143")

public class Interfaz{
    //atributes
    String OS = System.getProperty("os.name");

    //constructor
    public Interfaz(){

    }

   
    public void clearConsole(){
        try{
            if(this.OS.contains("Windows")) Runtime.getRuntime().exec("cls");
            else if (this.OS.contains("Mac")) System.out.print("\033\143");
        } 
        catch (Exception err){
            System.out.println("Can't determinate OS");
        }

    }

    

}