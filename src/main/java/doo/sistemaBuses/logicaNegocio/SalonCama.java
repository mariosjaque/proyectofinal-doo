package doo.sistemaBuses.logicaNegocio;

import java.time.Instant;

public class SalonCama extends Bus{
    public SalonCama(int patente, Instant horaSalida, String recorrido){
        super(0, patente, horaSalida, recorrido);
    }
}
