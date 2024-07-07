package doo.sistemaBuses.interfazGrafica;

import doo.sistemaBuses.logicaNegocio.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Panel_Compra extends JPanel {

    public Panel_Compra(Panel_fondo fondo, Bus bus, ArrayList<Asiento> asientos){
        this.setLayout(null);
        this.setBounds(0,0,1000,1000);
        //paneles de indicacion
        JLabel print_seleccion = new JLabel("Selecciona tu tipo de tarjeta");
        this.add(print_seleccion);
        print_seleccion.setBounds(0,0,500,100);
        print_seleccion.setForeground(Color.white);
        JButton debito = new JButton("Débito");
        this.add(debito);
        debito.setBounds(0,100,200,50);
        JButton credito = new JButton("Crédito");
        this.add(credito);
        credito.setBounds(200,100,200,50);
        JButton retroceder = new JButton("Anterior");
        this.add(retroceder);
        retroceder.setBounds(0,750,150,50);
        ActionListener Credito = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTextField texto_c = new JTextField("Ingrese número de tarjeta");
                texto_c.setBounds(0,100,200,50);
            }
        };
        ActionListener Debito = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JTextField texto_d = new JTextField();
                this.notify("Tarjeta de Debito seleccionada");
                texto_d.setBounds(0,100,200,50);
            }

            private void notify(String debitoSeleccionada) {
            }
        };
        ActionListener Retroceder = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fondo.retrocedePanel(Panel_Compra.this);
            }
        };
        debito.addActionListener(Debito);
        credito.addActionListener(Credito);
        retroceder.addActionListener(Retroceder);
    }



    //color de fondo
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.gray);
        g.fillRect(0,0,1000,1000);
    }
}
