package doo.sistemaBuses.logicaNegocio;

import javax.swing.*;
import java.awt.*;

public class Asiento {
    private int numero;
    private boolean reservado;
    ImageIcon grafico;

    public Asiento(int num){
        numero = num;
        reservado = false;
    }
    public int getNumero() {
        return numero;
    }

    public JButton asientoGrafico() {
        if(reservado!=true){
            grafico = new ImageIcon(getClass().getResource("/asiento_disponible.png"));
        } else {
            grafico = new ImageIcon(getClass().getResource("/asiento_comprado.png"));
        }
        grafico = new ImageIcon(grafico.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH));
        JButton jb = new JButton(grafico);
        jb.setText(String.valueOf(numero));
        jb.setHorizontalTextPosition(JButton.CENTER);
        jb.setVerticalTextPosition(JButton.CENTER);
        return jb;
    }

    public boolean isReservado() {
        return reservado;
    }

    public boolean compraAsiento(){
        if(reservado!=true) {
            reservado = true;
        }
        return reservado;
    }
}
