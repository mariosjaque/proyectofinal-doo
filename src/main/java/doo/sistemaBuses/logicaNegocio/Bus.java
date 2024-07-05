package doo.sistemaBuses.logicaNegocio;
import doo.sistemaBuses.logicaNegocio.Asiento;
import doo.sistemaBuses.logicaNegocio.modelosBus;

import java.util.ArrayList;
import java.util.Date;

public abstract class Bus {
    private Date horarioBus;
    private modelosBus modeloBus;
    private int patenteBus;
    private Date dia;
    private ArrayList<Asiento> Asientos;

    public Bus(int tipoBus, int patente, Date horaSalida){
        horarioBus = horaSalida;
        patenteBus = patente;
        Asientos = new ArrayList<>();
        modeloBus = modelosBus.values()[tipoBus];
        for(int i=0;i<modeloBus.getNumeroAsientos();i++){
            Asiento asiento = new Asiento(i+1);
            Asientos.add(asiento);
        }
    }

    public Date getHorarioBus() {
        return horarioBus;
    }

    public modelosBus getModeloBus() {
        return modeloBus;
    }

    public ArrayList<Asiento> getAsientos(){
        return Asientos;
    }

    public void setdia(Date fecha){
        dia = fecha;
    }

}
