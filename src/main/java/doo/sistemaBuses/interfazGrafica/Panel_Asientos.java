package doo.sistemaBuses.interfazGrafica;

import doo.sistemaBuses.logicaNegocio.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Panel_Asientos extends JPanel {

    public Panel_Asientos(Bus bus){
        this.setLayout(null);
        this.setBounds(0,0,1000,1000);

        int cantidadPisos = bus.getModeloBus().getNumeroPisos();
        int filasPorPiso = bus.getModeloBus().getFilasPorPiso();
        int asientosPorPiso = 4*filasPorPiso;

        for(int i=0;i<cantidadPisos;i++){
            for(int j=0;j<filasPorPiso;j++) {
                for (int k = j * 4; k < (j + 1) * 4; k++) {
                    Asiento asiento = bus.getAsientos().get(k);
                    JButton asientoBtn = asiento.asientoGrafico();
                    int finalK = k;
                    ActionListener oyente = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            bus.getAsientos().get(finalK).compraAsiento();
                            JOptionPane.showMessageDialog(null,"Waos!");
                        }
                    };
                    asientoBtn.addActionListener(oyente);
                    asientoBtn.setBounds(90+(30*j), 210+(50*i), 50, 50);
                    this.add(asientoBtn);
                }
            }
        }


    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRect(0,0,1000,1000);
    }
}
