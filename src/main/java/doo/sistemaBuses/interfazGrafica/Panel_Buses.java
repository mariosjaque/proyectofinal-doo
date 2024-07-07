package doo.sistemaBuses.interfazGrafica;

import doo.sistemaBuses.logicaNegocio.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Panel_Buses extends JPanel {

    private Bus bus_seleccionado;

    public Panel_Buses(Panel_fondo fondo) throws ParseException {
        this.setLayout(null);
        this.setBounds(0,0,1000,1000);

        // Test
        Date currentDate = new Date();
        bus_seleccionado = new SalonCama(1, currentDate);

        SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = simple.format(fondo.getfecha());
        JLabel Titulo = new JLabel("Pasajes del dia "+fecha);
        Titulo.setFont(new Font("Serif",Font.BOLD,20));
        this.add(Titulo);
        Titulo.setBounds(300,0,400,20);

        JButton siguiente = new JButton("Siguiente");
        JButton retroceder = new JButton("Anterior");
        this.add(siguiente);
        this.add(retroceder);
        siguiente.setBounds(150,750,150,50);
        retroceder.setBounds(0,750,150,50);



        ActionListener Avanzar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(bus_seleccionado==null){
                    JOptionPane.showMessageDialog(null, "No se puede avanzar sin un bus seleccionado.");
                } else {
                    Panel_Asientos panelAsientos = new Panel_Asientos(fondo, bus_seleccionado);
                    panelAsientos.setBackground(Color.BLACK);
                    fondo.avanzaPanel(panelAsientos, Panel_Buses.this);
                }
            }
        };

        ActionListener Retroceder = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fondo.retrocedePanel(Panel_Buses.this);
            }
        };

        siguiente.addActionListener(Avanzar);
        retroceder.addActionListener(Retroceder);

    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.magenta);
        g.fillRect(0,0,1000,1000);
    }

}
