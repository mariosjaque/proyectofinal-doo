package doo.sistemaBuses.logicaNegocio;

public enum recorridos {
    ConcepcionSantiago("Concepcion-Santiago"),
    ConcepcionLosAngeles("Concepcion-Los Angeles");

    private final String recorrido;
    recorridos(String recorrido) {
        this.recorrido = recorrido;
    }

    public String getRecorrido() {
        return recorrido;
    }
}
