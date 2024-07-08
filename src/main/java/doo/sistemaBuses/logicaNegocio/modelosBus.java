package doo.sistemaBuses.logicaNegocio;

/**
 * Enum de modelos de Bus
 */
public enum modelosBus {
    /**
     * Modelo SalonCama
     */
    SalonCama(1,7),
    /**
     * Modelo SemiCama
     */
    SemiCama(2,10);

    private final int numeroPisos;
    private final int filasPorPiso;

    modelosBus(int numeroPisos, int filasPorPiso) {
        this.numeroPisos = numeroPisos;
        this.filasPorPiso = filasPorPiso;
    }

    /**
     * Getter de filas por piso segun bus
     *
     * @return Entero total de filas de asientos por piso del bus
     */
    public int getFilasPorPiso() {
        return filasPorPiso;
    }

    /**
     * Getter del numero de pisos por bus
     *
     * @return Entero que es el numero de pisos
     */
    public int getNumeroPisos() {
        return numeroPisos;
    }

    /**
     * Getter del numero de asientos de un determinado modelo de bus
     *
     * @return Entero que es el numero de asientos
     */
    public int getNumeroAsientos() {
        return 4*filasPorPiso*numeroPisos;
    }
}