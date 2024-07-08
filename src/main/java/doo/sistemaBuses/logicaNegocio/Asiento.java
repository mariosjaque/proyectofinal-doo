package doo.sistemaBuses.logicaNegocio;

/**
 * Tipo asiento.
 * @author Mario Salgado
 */
public class Asiento {
    private int numero;
    private boolean reservado;

    /**
     * Constructor, recibe el número del asientp
     *
     * @param num Entero que es número de este objeto Asiento
     */
    public Asiento(int num){
        numero = num;
        reservado = false;
    }

    /**
     * Getter del número
     *
     * @return Número de asiento
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Getter del estado del asiento
     *
     * @return El valor de estado del asiento
     */
    public boolean isReservado() {
        return reservado;
    }

    /**
     * Método que permite registrar internamente la reserva del asiento una vez este ha sido comprado.
     */
    public void compraAsiento(){
        if(!reservado) {
            reservado = true;
        }
    }
}
