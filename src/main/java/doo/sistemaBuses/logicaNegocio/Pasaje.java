package doo.sistemaBuses.logicaNegocio;

import doo.sistemaBuses.logicaNegocio.Asiento;
import doo.sistemaBuses.logicaNegocio.Bus;

import java.util.Date;

public class Pasaje {
    private Asiento asiento;
    private Bus bus;

    public Pasaje(){
    }

    public void asignar_fecha_bus(Date fecha){
        bus.setdia(fecha);
    }
    public void setBus(Bus BUS){bus = BUS;}

}
