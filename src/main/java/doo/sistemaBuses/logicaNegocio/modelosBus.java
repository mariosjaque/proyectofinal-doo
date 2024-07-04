package doo.sistemaBuses.logicaNegocio;

public enum modelosBus {
    SalonCama(1,7),
    SemiCama(2,10);

    private final int numeroPisos;
    private final int filasPorPiso;

    modelosBus(int numeroPisos, int filasPorPiso) {
        this.numeroPisos = numeroPisos;
        this.filasPorPiso = filasPorPiso;
    }

    public int getFilasPorPiso() {
        return filasPorPiso;
    }

    public int getNumeroPisos() {
        return numeroPisos;
    }

    public int getNumeroAsientos() {
        return 4*filasPorPiso*numeroPisos;
    }
}