package doo.sistemaBuses.logicaNegocio;
import doo.sistemaBuses.logicaNegocio.Asiento;
import doo.sistemaBuses.logicaNegocio.modelosBus;

import java.util.ArrayList;
import java.util.Date;

public class Bus {
    private Date horarioBus;
    private modelosBus modeloBus;
    private int patenteBus;
    private ArrayList<Asiento> Asientos;

    public Bus(int tipoBus, int patente, Date horaSalida){
        horarioBus = horaSalida;
        patenteBus = patente;
        modeloBus = modelosBus.values()[tipoBus];
        Asientos = new ArrayList<>();
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
}
