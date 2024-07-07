package doo.sistemaBuses.logicaNegocio;

public class Asiento {
    private int numero;
    private boolean reservado;

    public Asiento(int num){
        numero = num;
        reservado = false;
    }
    public int getNumero() {
        return numero;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void compraAsiento(){
        if(!reservado) {
            reservado = true;
        }
    }
}
