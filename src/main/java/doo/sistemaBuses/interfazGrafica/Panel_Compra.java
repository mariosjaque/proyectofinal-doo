package doo.sistemaBuses.interfazGrafica;

import doo.sistemaBuses.logicaNegocio.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Panel_Compra extends JPanel {

    public Panel_Compra(Panel_fondo fondo, Bus bus, ArrayList<Asiento> asientos){
        this.setLayout(null);
        this.setBounds(0,0,1000,1000);

        JButton retroceder = new JButton("Anterior");
        this.add(retroceder);
        retroceder.setBounds(0,800,100,100);

        ActionListener Retroceder = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fondo.retrocedePanel(Panel_Compra.this);
            }
        };

        retroceder.addActionListener(Retroceder);
    }
}
