package doo.sistemaBuses.logicaNegocio;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public abstract class Bus {
    private Date fechaSalida;
    private Instant horarioBus;
    private modelosBus modeloBus;
    private int patenteBus;
    private recorridos recorridoBus;
    private ArrayList<Asiento> Asientos;

    public Bus(int tipoBus, int patente, Instant horaSalida, recorridos recorrido) {
        fechaSalida = Date.from(horaSalida);
        horarioBus = horaSalida;
        patenteBus = patente;
        recorridoBus = recorrido;
        Asientos = new ArrayList<>();
        modeloBus = modelosBus.values()[tipoBus];
        for (int i = 0; i < modeloBus.getNumeroAsientos(); i++) {
            Asiento asiento = new Asiento(i + 1);
            Asientos.add(asiento);
        }
    }

    public Instant getHorarioBus() {
        return horarioBus;
    }

    public modelosBus getModeloBus() {
        return modeloBus;
    }

    public Asiento getAsiento(int i) {
        return Asientos.get(i);
    }

    public recorridos getRecorridoBus() {
        return recorridoBus;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }
}
