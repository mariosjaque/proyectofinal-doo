package doo.sistemaBuses.logicaNegocio;

import java.time.Instant;

public class SalonCama extends Bus{
    /**
     * Constructor de subclase SalonCama. El tipo de bus es notificado al constructor de Bus.
     *
     * @param patente    Entero patente
     * @param horaSalida Instante hora de salida
     * @param recorrido  Valor del Enum recorridos que representa su recorrido
     */
    public SalonCama(int patente, Instant horaSalida, recorridos recorrido){
        super(0, patente, horaSalida, recorrido);
    }
}
