//package Hexadecimal;

public class Conversion {

    String hexValues;

    public Conversion(){
        this.hexValues = "0123456789ABCDEF";
    }

    public  int hex2Dec (String value){
        value = value.toUpperCase();
        int decimal = 0;
        for (int i=0; i<value.length(); i++){
            char caracter = value.charAt(i);
            int digito = this.hexValues.indexOf(caracter);
            decimal = 16 * decimal + digito;
        }

        return decimal;
    }


    
    public  String dec2Hex (String valorObtenido){
        int valor = Integer.parseInt(valorObtenido);
        char valorFinal = this.hexValues.charAt(valor );

        return valorFinal + "";
    }



    public String hex2Bin(String valor){
        int numHex = Integer.parseInt(valor, 16);
        String binary = Integer.toBinaryString(numHex);
        return binary;

    }

    public String bin2Hex(String bin){
        //1111
        int binary = Integer.parseInt(bin, 2); 
        String hex = "" + this.hexValues.charAt(binary); 
        return hex;

    }


}
