package doo.proyectofinal;
import java.util.ArrayList;
import java.util.Date;

public class Bus {
    private Date horarioBus;
    private modelosBus modeloBus;
    private ArrayList<Asiento> Asientos;

    public Bus(int tipoBus, Date horaSalida){
        horarioBus = horaSalida;

    }

    public Date getHorarioBus() {
        return horarioBus;
    }
}
