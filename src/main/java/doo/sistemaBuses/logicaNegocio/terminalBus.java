package doo.sistemaBuses.logicaNegocio;
import java.util.ArrayList;
import java.util.Date;
import java.time.Instant;

import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;

public class terminalBus {
    private ArrayList<Bus> Buses;
    private Date fecha;

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

    public Bus getBuses(int i) {
        return Buses.get(i);
    }

    public int getNumeroBuses() {
        return Buses.size();
    }
}
