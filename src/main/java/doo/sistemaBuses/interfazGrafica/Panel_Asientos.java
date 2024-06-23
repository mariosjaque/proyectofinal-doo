package doo.sistemaBuses.interfazGrafica;

import doo.sistemaBuses.logicaNegocio.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class Panel_Asientos extends JPanel {
    private ArrayList<Asiento> asientosPendientes;

    public Panel_Asientos(Bus bus){
        this.setLayout(null);
        this.setBounds(0,0,1000,1000);

        int cantidadPisos = bus.getModeloBus().getNumeroPisos();
        int filasPorPiso = bus.getModeloBus().getFilasPorPiso();
        asientosPendientes = new ArrayList<>();

        for(int i=0;i<cantidadPisos;i++){
            for(int j=1;j<=filasPorPiso;j++) {
                int x = 0;
                for (int k=((4*j)-4)+(4*filasPorPiso*i); k<(4*j)+(4*filasPorPiso*i); k++) {
                    Asiento asiento = bus.getAsientos().get(k);
                    JButton asientoBtn = asiento.asientoGrafico();
                    int finalK = k;
                    ActionListener oyente = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(asiento.isReservado()!=true) {
                                if(asientosPendientes.contains(asiento)){
                                    asientosPendientes.remove(asiento);
                                    JOptionPane.showMessageDialog(null, "Asiento ya no se encuentra seleccionado.");
                                } else {
                                    asientosPendientes.add(asiento);
                                    JOptionPane.showMessageDialog(null, "Asiento seleccionado con éxito.");
                                }

                            } else {
                                JOptionPane.showMessageDialog(null, "Asiento ya se encuentra reservado.");
                            }
                        }
                    };
                    asientoBtn.addActionListener(oyente);
                    asientoBtn.setBounds(100+(50*x)+(7*50*i), 170+(50*j), 50, 50);
                    if(x==1){x+=2;}else{x+=1;}
                    this.add(asientoBtn);
                }
            }
        }


    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black);
        g.fillRect(0,0,1000,1000);
    }
}
