package doo.sistemaBuses.interfazGrafica;
import doo.sistemaBuses.logicaNegocio.*;
import java.util.Date;
import java.util.ArrayList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel_fondo extends JPanel{
    Panel_Asientos panel_asientos;
    Panel_Buses panel_buses;
    Panel_Fecha panel_fecha;
    ArrayList<JPanel> Paneles;
    Panel_pasajes panel_Pasajes;
    private int posicion = 0;


    public Panel_fondo(){

        this.setBounds(0,0,1000,1000);
        this.setLayout(null);

        Paneles = new ArrayList<>();
        panel_buses = new Panel_Buses(this);
        Paneles.add(panel_buses);
        panel_fecha = new Panel_Fecha(this);
        panel_Pasajes = new Panel_pasajes();

        panel_buses.setBackground(Color.magenta);
        panel_fecha.setBackground(Color.blue);


        this.add(panel_buses);
        this.add(panel_fecha);
        this.add(panel_Pasajes);

        panel_fecha.setVisible(true);
        panel_Pasajes.setVisible(false);
        panel_buses.setVisible(false);

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

    public void salir_panel_fecha(){

        posicion=+1;
        panel_fecha.setVisible(false);
        panel_buses.setVisible(true);
    }
}
