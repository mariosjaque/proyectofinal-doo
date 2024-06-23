package doo.sistemaBuses.logicaNegocio;

import javax.swing.*;
import java.awt.*;

public class Asiento {
    private int numero;
    private boolean vendido;
    ImageIcon grafico;

    public Asiento(int num){
        numero = num;
        vendido = false;
    }
    public int getNumero() {
        return numero;
    }

    public JButton asientoGrafico() {
        if(vendido!=true){
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

    public boolean compraAsiento(){
        if(vendido!=true) {
            vendido = true;
        }
        return vendido;
    }
}
