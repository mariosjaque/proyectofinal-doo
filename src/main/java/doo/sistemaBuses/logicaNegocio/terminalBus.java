package doo.sistemaBuses.logicaNegocio;

import java.util.ArrayList;
import java.util.Date;
import java.time.Instant;

import static java.time.temporal.ChronoUnit.HOURS;
import static java.time.temporal.ChronoUnit.MINUTES;

public class terminalBus{
    private ArrayList<Bus> Buses;
    private Date fecha;
    public terminalBus(Date fechaInicial){
        Buses = new ArrayList<>();
        fecha = fechaInicial;
        itinerario[] Itinerario = itinerario.values();
        for (int i = 0; i<itinerario.values().length; i++){
            itinerario horario = Itinerario[i];
            Instant horaSalida = fecha.toInstant();
            horaSalida = horaSalida.plus(horario.getHoras(), HOURS);
            horaSalida = horaSalida.plus(horario.getMinutos(), MINUTES);
            for(int j=0;j<3;j++){
                switch (horario.getModeloBus(j)) {
                    case 1:
                        Buses.add(new SemiCama(100000+i,horaSalida,horario.getRecorrido(j)));
                        break;
                    case 2:
                        Buses.add(new SalonCama(200000+i,horaSalida,horario.getRecorrido(j)));
                        break;
                }
            }
        }
    }

    public Bus getBuses(int i){
        return Buses.get(i);
    }
}
