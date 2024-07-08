package doo.sistemaBuses.logicaNegocio;
import java.util.ArrayList;
import java.util.Date;
import java.time.Instant;

import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;

/**
 * Clase terminal de Buses
 * @author Santiago Diaz
 * @author Mario Salgado
 */
public class terminalBus {
    private ArrayList<Bus> Buses;
    private Date fecha;

    /**
     * Constructor del terminal de buses, genera los buses respectivos.
     *
     * @param fechaInicial the fecha inicial
     */
    public terminalBus(Date fechaInicial) {
        Buses = new ArrayList<>();
        fecha = fechaInicial;
        itinerario[] Itinerario = itinerario.values();
        for (int i = 0; i < itinerario.values().length; i++) {
            itinerario horario = Itinerario[i];
            Instant horaSalida = fecha.toInstant();
            horaSalida = horaSalida.plus(horario.getHoras(), HOURS);
            horaSalida = horaSalida.plus(horario.getMinutos(), MINUTES);
            if (horario.getModeloBus() == 0) {
                Buses.add(new SalonCama(100000 + i, horaSalida, recorridos.values()[horario.getRecorrido()]));
            } else if (horario.getModeloBus() == 1) {
                Buses.add(new SemiCama(200000 + i, horaSalida, recorridos.values()[horario.getRecorrido()]));
            }
        }
    }

    /**
     * Getter de un bus especifico.
     *
     * @param i Indice del bus.
     * @return El Objeto Bus solicitado
     */
    public Bus getBuses(int i) {
        return Buses.get(i);
    }

    /**
     * Getter de la cantidad actual de Buses
     *
     * @return Entero con los buses prontos a salir.
     */
    public int getNumeroBuses() {
        return Buses.size();
    }
}
