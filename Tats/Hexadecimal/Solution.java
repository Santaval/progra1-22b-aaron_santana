import java.util.Scanner;


public class Solution {
    
public static void main (String[]args)
{
    Conversion conversion = new Conversion();
    Scanner scanner = new Scanner (System.in); 


    System.out.println("1: Hexadecimal a Decimal");
    System.out.println("2: Decimal a Hexadecimal");
    System.out.println("3: Hexadecimal a Binario");
    System.out.println("4: Binario a Hexadecimal");
    int opt = scanner.nextInt();

    System.out.println("Digite el valor a convertir");

    String value = scanner.next();

    System.out.println("Su valor es");
    switch (opt) {
        case 1: System.out.println(conversion.hex2Dec(value)); break;
        case 2: System.out.println(conversion.dec2Hex(value)); break;
        case 3: System.out.println(conversion.hex2Bin(value)); break;
        case 4: System.out.println(conversion.bin2Hex(value)); break;
    }

    

scanner.close();

}}




