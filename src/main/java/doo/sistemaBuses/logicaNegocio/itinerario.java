package doo.sistemaBuses.logicaNegocio;

/**
 * Enum que tiene el itinerario de buses con, en este caso, 7 salidas por dia, considerando hora y minuto de cada salida
 * Recorrido y modelo del bus estan representados con enteros
 */
public enum itinerario {
    salida1(8,0,0,1),
    salida2(9,15,1,0),
    salida3(10,00,0,0),
    salida4(11,20,0,1),
    salida5(12,00,2,1),
    salida6(13,00,3,1),
    salida7(14,15,3,0);
    private final int horaDia;
    private final int minutoDia;
    private final int recorridoAnden;
    private final int modeloBusAnden;

    itinerario(int horaDia, int minutoDia, int recorridoAnden, int modeloBusAnden) {
        this.horaDia = horaDia;
        this.minutoDia = minutoDia;
        this.recorridoAnden = recorridoAnden;
        this.modeloBusAnden = modeloBusAnden;
    }

    public int getHoras() {
        return horaDia;
    }

    public int getMinutos() {
        return minutoDia;
    }

    public int getRecorrido() {
        return recorridoAnden;
    }

    public int getModeloBus() {
        return modeloBusAnden;
    }
}
