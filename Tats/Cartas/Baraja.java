package Cartas;

public class Baraja {
    public Carta[] baraja;
    public int n;
    public int cartasSeleccionadas;



    public Baraja(int n){
        this.n = definirValorN(n);
        this.baraja = generarBaraja(this.n);  
        this.cartasSeleccionadas = 0;

    }


    private Carta[] generarBaraja(int n){
        Carta[] baraja = new Carta[n];


        for (int counter = 0; counter < n; counter ++){
            Carta nuevaCarta = new Carta(counter);

            while(compararCartas(nuevaCarta, baraja)){
                nuevaCarta = new Carta(counter);
            }

            baraja[counter] = nuevaCarta;

        }
        return baraja;
    }


    private boolean compararCartas(Carta nuevaCarta, Carta[] baraja){

       boolean esIgual = false;

       for (int index = 0; index < baraja.length; index++){

            if( baraja[index] != null && nuevaCarta.toString().equals(baraja[index].toString()) ){
                esIgual = true;
                index = baraja.length;
            }

       }


       return esIgual;
    
    }

    private int definirValorN(int n){

        if(n > 52 ) n = 52;
        if (n < 9) n = 12;
        else if (n%4 != 0) n += 4 - (n%4);

        return n;

    }

    public void barajar(){

        for (int index = 0; index < this.n; index++){
            int valorRandom1 = (int) ((Math.random())* n);
            int valorRandom2 = (int) ((Math.random())* n);

            Carta intercambiar1  = this.baraja[valorRandom1];
            Carta intercambiar2  = this.baraja[valorRandom2];

            this.baraja[valorRandom1] = intercambiar2;
            this.baraja[valorRandom2] = intercambiar1;
        }

    }


    public Carta sacar() {
        
        assert this.cartasSeleccionadas < this.n;
            
         Carta cartaSeleccionada = baraja[cartasSeleccionadas];
       
        this.cartasSeleccionadas ++;   
        return cartaSeleccionada;
        
    }
}

