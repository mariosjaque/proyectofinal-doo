package doo.sistemaBuses.logicaNegocio;

import java.time.Instant;

public class SemiCama extends Bus{
    /**
     * Constructor de subclase SemiCama. El tipo de bus es notificado al constructor de Bus.
     *
     * @param patente    Entero patente
     * @param horaSalida Instante hora de salida
     * @param recorrido  Valor del Enum recorridos que representa su recorrido
     */
    public SemiCama(int patente, Instant horaSalida, recorridos recorrido){
        super(1, patente, horaSalida, recorrido);
    }

}
