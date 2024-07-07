package doo.sistemaBuses.logicaNegocio;

public enum itinerario {
    salidas1(8,0,"Concepcion-Santiago",1,null,0,null,0),
    salidas2(9,15,"Concepcion-Santiago",1,null,0,null,0);
    private final int horaDia;
    private final int minutoDia;
    private final String recorridoAnden1;
    private final int modeloBusAnden1;
    private final String recorridoAnden2;
    private final int modeloBusAnden2;
    private final String recorridoAnden3;
    private final int modeloBusAnden3;

    itinerario(int horaDia, int minutoDia, String recorridoAnden1, int modeloBusAnden1, String recorridoAnden2, int modeloBusAnden2, String recorridoAnden3, int modeloBusAnden3) {
        this.horaDia = horaDia;
        this.minutoDia = minutoDia;
        this.recorridoAnden1 = recorridoAnden1;
        this.modeloBusAnden1 = modeloBusAnden1;
        this.recorridoAnden2 = recorridoAnden2;
        this.modeloBusAnden2 = modeloBusAnden2;
        this.recorridoAnden3 = recorridoAnden3;
        this.modeloBusAnden3 = modeloBusAnden3;
    }

    public int getHoras() {
        return horaDia;
    }

    public int getMinutos() {
        return minutoDia;
    }

    public String getRecorrido(int rec) {
        String salida = null;
        switch (rec) {
            case 0:
                salida = recorridoAnden1;
                break;
            case 1:
                salida = recorridoAnden2;
                break;
            case 2:
                salida = recorridoAnden3;
                break;
        }
        return salida;
    }
    public int getModeloBus(int rec) {
        int salida = 0;
        switch (rec) {
            case 0:
                salida = modeloBusAnden1;
                break;
            case 1:
                salida = modeloBusAnden2;
                break;
            case 2:
                salida = modeloBusAnden3;
                break;
        }
        return salida;
    }
}
