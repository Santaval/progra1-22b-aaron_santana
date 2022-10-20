package Tats;
class Carta {
    public String valor = "7";
    public String palo; 
    public int valorCarta; 
    public static final String VALORS []= {"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
    public static final String PALOS [] = {"trebol", "corazones", "diamente", "espada"};

    public Carta(int counter){
        this.valor = generarValor();
        this.palo = PALOS[counter % 4];
    }


    private String generarValor(){
        int valorRandom = (int) ((Math.random())*13.0);
        return VALORS[valorRandom];
    }



    public String toString(){

        return this.valor + " de " + this.palo;
    
    }

    public int obtenerValor(){

        int valor = -1;

        for (int counter = 0; counter < 9; counter ++){
            if (VALORS[counter].charAt(0) == this.valor.charAt(0) ){
                    valor = counter + 2;
                    counter = 9;
            }

        }


        if(valor == -1) {
            if (this.valor.charAt(0) == 'A') valor = 11;
            else valor = 10;
        }
        
     return valor;
    }

}











