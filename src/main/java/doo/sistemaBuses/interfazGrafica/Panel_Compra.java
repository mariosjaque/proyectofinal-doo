package doo.sistemaBuses.interfazGrafica;

import doo.sistemaBuses.logicaNegocio.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Panel_Compra extends JPanel {
    private JTextField textoTarjeta;
    private JTextField textoCVV;
    private JTextField textoNombre;
    private Panel_fondo fondo;
    public Panel_Compra(Panel_fondo fondo, Bus bus, ArrayList<Asiento> asientos){
        this.setLayout(null);
        this.setBounds(0,0,1000,1000);
        //paneles de indicacion
        JLabel printSeleccion = new JLabel("Selecciona tu tipo de tarjeta");
        this.add(printSeleccion);
        printSeleccion.setBounds(0, 0, 500, 100);
        printSeleccion.setForeground(Color.white);

        JButton debito = new JButton("Débito");
        this.add(debito);
        debito.setBounds(0,100,200,50);

        JButton credito = new JButton("Crédito");
        this.add(credito);
        credito.setBounds(200,100,200,50);

        JButton retroceder = new JButton("Anterior");
        this.add(retroceder);
        retroceder.setBounds(0,750,150,50);

        //action listener de debito y credito reducidas para mejor funcionamiento
        debito.addActionListener(new DebitoActionListener());
        credito.addActionListener(new CreditoActionListener());
        ActionListener Retroceder = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fondo.retrocedePanel(Panel_Compra.this);
            }
        };

        retroceder.addActionListener(Retroceder);
    }
    private void mostrarFormularioTarjeta(String tipo) {
        this.removeAll();
        this.repaint();

        JLabel printSeleccion = new JLabel("Selecciona tu tipo de tarjeta");
        this.add(printSeleccion);
        printSeleccion.setBounds(0, 0, 500, 100);
        printSeleccion.setForeground(Color.white);

        JButton debito = new JButton("Débito");
        this.add(debito);
        debito.setBounds(0, 100, 200, 50);
        debito.addActionListener(new DebitoActionListener());

        JButton credito = new JButton("Crédito");
        this.add(credito);
        credito.setBounds(200, 100, 200, 50);
        credito.addActionListener(new CreditoActionListener());

        JLabel numberTarjeta = new JLabel("Número de Tarjeta:");
        this.add(numberTarjeta);
        numberTarjeta.setBounds(0, 190, 200, 50);
        numberTarjeta.setForeground(Color.white);

        textoTarjeta = new JTextField();
        this.add(textoTarjeta);
        textoTarjeta.setBounds(0, 240, 200, 30);

        JLabel tarjetaCVV = new JLabel("CVV:");
        this.add(tarjetaCVV);
        tarjetaCVV.setBounds(0, 290, 200, 50);
        tarjetaCVV.setForeground(Color.white);

        textoCVV = new JTextField();
        this.add(textoCVV);
        textoCVV.setBounds(0, 340, 200, 30);

        JLabel nombreTitular = new JLabel("Nombre del Titular:");
        this.add(nombreTitular);
        nombreTitular.setBounds(0, 390, 200, 50);
        nombreTitular.setForeground(Color.white);

        textoNombre = new JTextField();
        this.add(textoNombre);
        textoNombre.setBounds(0, 440, 200, 30);

        JButton boton_enviar = new JButton("Submit");
        this.add(boton_enviar);
        boton_enviar.setBounds(0, 490, 200, 30);
        boton_enviar.addActionListener(new SubmitActionListener(tipo));

        JButton anterior = new JButton("Anterior");
        this.add(anterior);
        anterior.setBounds(0, 750, 150, 50);
        anterior.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarPantallaInicial();
            }
        });
    }


}
