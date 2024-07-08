package doo.sistemaBuses.logicaNegocio;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

/**
 * Clase abstracta Bus
 * @author Mario Salgado
 * @author Santiago Diaz
 */
public abstract class Bus {
    /**
     * Variables de fecha, horario, modelo, patente, recorrido y Lista de Asientos.
     */
    private Date fechaSalida;
    private Instant horarioBus;
    private modelosBus modeloBus;
    private int patenteBus;
    private recorridos recorridoBus;
    private ArrayList<Asiento> Asientos;

    /**
     * COnstructor. Recibe al momento de ser creado los elementos del bus
     *
     * @param tipoBus    Valor entero que representa el tipo de bus
     * @param patente    Entero que es patente
     * @param horaSalida Instante hora de salida
     * @param recorrido  Valor Enum recorrido
     */
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

    /**
     * Getter del horario de bus
     * @return El instante de horario del bus
     */
    public Instant getHorarioBus() {
        return horarioBus;
    }

    /**
     * Getter del enum modelo bus correspondiente.
     *
     * @return Valor enum modelosBus
     */
    public modelosBus getModeloBus() {
        return modeloBus;
    }

    /**
     * Getter de un asiento especifico.
     *
     * @param i el numero del asiento a obtener
     * @return el asiento
     */
    public Asiento getAsiento(int i) {
        return Asientos.get(i);
    }

    /**
     * Getter del valor de enum que corresponde al recorrido del Bus
     *
     * @return Valor enum recorrido bus
     */
    public recorridos getRecorridoBus() {
        return recorridoBus;
    }

    /**
     * Getter de la fecha de Salida del Bus.
     *
     * @return Elemento date que es fecha salida
     */
    public Date getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Getter de la patente del bus
     *
     * @return Entero que es patente de bus
     */
    public int getPatenteBus() { return patenteBus; }
}
