package doo.sistemaBuses.interfazGrafica;
import doo.sistemaBuses.logicaNegocio.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel_fondo extends JPanel{
    private static Panel_fondo panel_fondo = new Panel_fondo();
    Panel_Fecha panel_fecha;
    ArrayList<JPanel> Paneles;
    Panel_pasajes panel_Pasajes;
    private Date Fecha;


    private Panel_fondo(){

        this.setBounds(0,0,1000,1000);
        this.setLayout(null);

        Paneles = new ArrayList<>();
        panel_fecha = new Panel_Fecha(this);
        Paneles.add(panel_fecha);
        panel_Pasajes = new Panel_pasajes();

        panel_fecha.setBackground(Color.blue);
        panel_Pasajes.setBackground(Color.yellow);


        this.add(panel_fecha);
        this.add(panel_Pasajes);

        panel_fecha.setVisible(true);
        panel_Pasajes.setVisible(false);


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
    }
    public Date getfecha(){
        return Fecha;
    }

    public Date variarFecha(Date fecha, int valor){
        if (valor==0) return fecha;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, valor);
        return calendar.getTime();
    }
    public static Panel_fondo singleton(){
        return panel_fondo;
    }

}
