package doo.sistemaBuses.logicaNegocio;

public enum itinerario {
    salida1(8,0,0,1),
    salida2(9,15,1,0),
    salida3(10,00,0,0),
    salida4(12,00,0,1);
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
