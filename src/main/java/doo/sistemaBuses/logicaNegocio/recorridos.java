package doo.sistemaBuses.logicaNegocio;

public enum recorridos {
    ConcepcionSantiago("Concepcion-Santiago",4000),
    ConcepcionLosAngeles("Concepcion-Los Angeles",2000);

    private final String recorrido;
    private final int precio;

    recorridos(String recorrido, int precio) {
        this.recorrido = recorrido;
        this.precio = precio;
    }

    public String getRecorrido() {
        return recorrido;
    }
    public int getPrecio(){return precio;}
}
