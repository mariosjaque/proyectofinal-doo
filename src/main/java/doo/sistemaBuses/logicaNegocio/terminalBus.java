package doo.sistemaBuses.logicaNegocio;

import java.util.ArrayList;
import java.util.Date;

public class terminalBus{
    private ArrayList<Bus> Buses;
    public terminalBus(Date fechaInicial){
        itinerario Itinerario = itinerario.values();
        for (int i=0;i<itinerario.values().length;i++){
            itinerario horario = Itinerario[i];
            switch (horario.getBus()) {
                case 0:
                    Buses.add(new SemiCama(100000+i,horario.getHoraSalida()+fechaInicial));
                    break;
            }
        }
    }
}
