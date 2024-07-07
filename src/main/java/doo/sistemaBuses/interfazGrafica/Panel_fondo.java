package doo.sistemaBuses.interfazGrafica;
import doo.sistemaBuses.logicaNegocio.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;

public class Panel_fondo extends JPanel{
    private static Panel_fondo panel_fondo = new Panel_fondo();
    private Panel_Fecha panel_fecha;
    private ArrayList<JPanel> Paneles;
    private ArrayList<Date> terminales_fechas;
    private ArrayList<terminalBus> terminales_cont;
    private Panel_pasajes panel_Pasajes;
    private Date Fecha;


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

        panel_fecha.setBackground(Color.blue);
        //panel_Pasajes.setBackground(Color.yellow);


        this.add(panel_fecha);
        //this.add(panel_Pasajes);

        panel_fecha.setVisible(true);
        //panel_Pasajes.setVisible(false);

    }

    public void avanzaPanel(JPanel jp1, JPanel jp2){
        Paneles.add(jp1);
        this.add(jp1);
        jp1.setVisible(true);
        jp2.setVisible(false);
    }

    public void retrocedePanel(JPanel jp){
        Paneles.removeLast();
        jp.setVisible(false);
        Paneles.getLast().setVisible(true);
    }

    public void setfecha(Date fecha){
        Fecha = fecha;
        if(!terminales_fechas.contains(fecha)){
            terminales_fechas.add(fecha);
            terminales_cont.add(new terminalBus(fecha));
        }
    }
    public Date getfecha(){
        return Fecha;
    }

    public terminalBus getTerminalBus(){
        return terminales_cont.get(terminales_fechas.indexOf(Fecha));
    }

    public static Panel_fondo singleton(){
        return panel_fondo;
    }

}
