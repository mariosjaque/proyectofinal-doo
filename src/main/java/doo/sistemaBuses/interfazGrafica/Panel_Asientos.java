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
            for(int j=1;j<=filasPorPiso;j++) {
                int x = 0;
                for (int k=(4*j)-4; k<4*j; k++) {
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
                    asientoBtn.setBounds(90+(50*x), 210+(50*j), 50, 50);
                    if(x==1){x+=3;}else{x+=1;}
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
