package Cartas;

public class Mano {
    int[] mano;

 
    public Mano (Baraja baraja){

        this.mano = this.asignarValor(baraja);
    }



    public int[] asignarValor(Baraja baraja){
        int[] mano = new int[5];

        for(int counter = 0; counter < 5; counter++){

            Carta cartaSeleccionada = baraja.sacar();
            mano[counter] = cartaSeleccionada.obtenerValor();

        }
        return mano;

    }


    public int getValor(){

        int valorTotal = 0;

       for(int counter = 0; counter < 5; counter++){
            valorTotal += mano[counter];

        }
        return valorTotal;
    }


    public boolean gana (Mano segundaMano){
        boolean gana = false; 

        if (this.getValor() >= segundaMano.getValor()) gana = true;

        return gana;

    }

}
