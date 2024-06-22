package doo.proyectofinal;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Panel_fondo extends JPanel{
    Panel_Asientos panel_asientos;
    Panel_Buses panel_buses;
    Panel_Fecha panel_fecha;
    Panel_Compra panel_Compra;
    Panel_pasajes panel_Pasajes;
    private int posicion = 0;


    public Panel_fondo(){

        this.setBounds(0,0,1000,1000);
        this.setLayout(null);

        panel_asientos = new Panel_Asientos();
        panel_buses = new Panel_Buses();
        panel_fecha = new Panel_Fecha(this);
        panel_Compra = new Panel_Compra();
        panel_Pasajes = new Panel_pasajes();

        panel_asientos.setBackground(Color.BLACK);
        panel_buses.setBackground(Color.magenta);
        panel_fecha.setBackground(Color.blue);
        panel_Compra.setBackground(Color.cyan);

        this.add(panel_asientos);
        this.add(panel_buses);
        this.add(panel_Compra);
        this.add(panel_fecha);
        this.add(panel_Pasajes);

        panel_fecha.setVisible(true);
        panel_asientos.setVisible(false);
        panel_Compra.setVisible(false);
        panel_Pasajes.setVisible(false);
        panel_buses.setVisible(false);

        JButton siguiente = new JButton();
        JButton retroceder = new JButton();
        siguiente.setBounds(0,0,100,100);
        this.add(siguiente);

        ActionListener Avanzar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(posicion<3){
                    if(posicion == 1){
                        posicion +=1;
                        panel_buses.setVisible(false);
                        panel_asientos.setVisible(true);
                    }
                    else if(posicion == 2){
                        posicion +=1;
                        panel_asientos.setVisible(false);
                        panel_Compra.setVisible(true);
                    }
                }
            }
        };

        siguiente.addActionListener(Avanzar);



    }
    public void salir_panel_fecha(){

        posicion=+1;
        panel_fecha.setVisible(false);
        panel_buses.setVisible(true);
    }
}
