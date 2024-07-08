package doo.sistemaBuses.interfazGrafica;
import doo.sistemaBuses.logicaNegocio.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;

/**
 * Panel Fondo, holder y singleton.
 *
 * Este panel almacena todos los otros paneles del programa y administra información vital que es pasada entre ellos.
 * Solo puede existir una instancia, la cual es pasada entre los distintos paneles.
 * Almacena los terminales de buses creados durante toda la ejecución del programa
 * @author Luis Martinez
 * @author Mario Salgado
 */
public class Panel_fondo extends JPanel{
    private static Panel_fondo panel_fondo = new Panel_fondo();
    private Panel_Fecha panel_fecha;
    private ArrayList<JPanel> Paneles;
    private ArrayList<Date> terminales_fechas;
    private ArrayList<terminalBus> terminales_cont;
    private Date Fecha;

    /** Constructor de panel_fondo, invocado solamente en Ventana */
    private Panel_fondo() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date Fecha_inicio = new Date();
        String String_Fecha_inicio = formato.format(Fecha_inicio);
        try {
            Fecha_inicio = formato.parse(String_Fecha_inicio);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        this.setBounds(0,0,1000,1000);
        this.setLayout(null);

        Paneles = new ArrayList<>();
        terminales_fechas = new ArrayList<>();
        terminales_cont = new ArrayList<>();
        panel_fecha = new Panel_Fecha(this,Fecha_inicio);
        Paneles.add(panel_fecha);
        this.add(panel_fecha);
        panel_fecha.setVisible(true);

    }

    /**
     * Método que es invocado cualquiera de los otros paneles para hacerse invisible y dar lugar a otro panel.
     *
     * @param jp1 El panel que invoca este método y que desea desaoarecer
     * @param jp2 El panel que deberá mostrarse después
     */
    public void avanzaPanel(JPanel jp1, JPanel jp2){
        Paneles.add(jp1);
        this.add(jp1);
        jp1.setVisible(true);
        jp2.setVisible(false);
    }

    /**
     * Método que es invocado cualquiera de los otros paneles para retroceder al panel anterior.
     *
     * @param jp El panel que invoca este método y que desea desaoarecer
     */
    public void retrocedePanel(JPanel jp){
        Paneles.removeLast();
        jp.setVisible(false);
        Paneles.getLast().setVisible(true);
    }

    /**
     * Método para volver al panel fecha, primer panel de la interfaz
     *
     * @param jp El panel que invoca este método y que debe desaparecer
     */
    public void reset(JPanel jp) {
        Paneles = new ArrayList<>();
        Paneles.add(panel_fecha);
        panel_fecha.setVisible(true);
        jp.setVisible(false);
    }

    /**
     * Método que permite definir la fecha con la que se trabajará en los paneles posteriores a panel fecha.
     * Esto sirve para crear los terminales de Bus segun su estado en una fecha.
     * @param fecha La fecha en cuestion
     */
    public void setfecha(Date fecha){
        Fecha = fecha;
        if(!terminales_fechas.contains(fecha)){
            terminales_fechas.add(fecha);
            terminales_cont.add(new terminalBus(fecha));
        }
    }

    /**
     * Método para obtener fecha
     *
     * @return la fecha de trabajo
     */
    public Date getfecha(){
        return Fecha;
    }

    /**
     * Método para obtener el terminal de buses de la fecha de trabajo.
     *
     * @return El Terminal de buses en cuestion
     */
    public terminalBus getTerminalBus(){
        return terminales_cont.get(terminales_fechas.indexOf(Fecha));
    }

    /**
     * Método que retorna la referencia a este objeto de instancia única.
     *
     * @return La referencia a la unica instancia de Panel_fondo
     */
    public static Panel_fondo singleton(){
        return panel_fondo;
    }

}
