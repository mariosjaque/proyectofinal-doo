package doo.sistemaBuses.interfazGrafica;

import doo.sistemaBuses.logicaNegocio.Pasaje;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Panel_pasajes extends JPanel {
    private ArrayList<Pasaje> pasajes;
    Panel_fondo fondo;

    public Panel_pasajes(ArrayList<Pasaje> pasajes, Panel_fondo panelFondo) {
        this.pasajes = pasajes;
        this.setLayout(null);
        ImageIcon imagen_fondo = new ImageIcon(getClass().getResource("/fondo.jpg"));
        JLabel Fondo = new JLabel();
        Fondo.setIcon(new ImageIcon(imagen_fondo.getImage().getScaledInstance(1000,1000,Image.SCALE_SMOOTH)));
        this.add(Fondo);
        this.setBounds(0, 0, 1000, 1000);
        this.setBackground(new Color(30, 30, 30));
        fondo = panelFondo;

        JLabel label = new JLabel("Detalles de los Pasajes Comprados");
        label.setBounds(50, 20, 700, 30);
        label.setForeground(Color.white);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        this.add(label);

        JTextArea areaDetalles = new JTextArea();
        areaDetalles.setEditable(false);
        areaDetalles.setBackground(new Color(50, 50, 50));
        areaDetalles.setForeground(Color.white);
        areaDetalles.setFont(new Font("Arial", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(areaDetalles);
        scrollPane.setBounds(50, 60, 900, 400);
        this.add(scrollPane);


        for (Pasaje pasaje : pasajes) {
            areaDetalles.append("Bus: " + pasaje.getBus().getModeloBus() + "\n");
            areaDetalles.append("Patente: " + pasaje.getBus().getPatenteBus() + "\n");
            areaDetalles.append("Recorrido: " + pasaje.getBus().getRecorridoBus().getRecorrido() + "\n");
            areaDetalles.append("Número de Asiento: " + pasaje.getNumeroAsiento() + "\n");
            areaDetalles.append("Nombre del Pasajero: " + pasaje.getNombrePasajero() + "\n");
            areaDetalles.append("Fecha y Hora de Salida: " + pasaje.getHorarioFechaSalida() + "\n");
            areaDetalles.append("Precio: $" + pasaje.getPrecio() + "\n\n");
        }
        JButton confirmarCompra = new JButton("Exportar Pasajes");
        this.add(confirmarCompra);
        confirmarCompra.setBounds(0, 470, 200, 50);
        confirmarCompra.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    for (Pasaje pasaje2 : pasajes) {
                        pasaje2.generarPDF();
                    }
                    mostrarBotonVolverAlInicio();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + ex.getMessage());
                }
            }
        });
        //demasiados botones ahora cada uno se va a identificar como "sufijo"+"Btn"


        JButton retroceder = new JButton("Anterior");
        retroceder.setBounds(50, 550, 150, 50);
        this.add(retroceder);
        retroceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fondo.retrocedePanel(Panel_pasajes.this);
            }
        });


    }

    private void mostrarBotonVolverAlInicio() {
        JButton volverAlInicio = new JButton("Inicio");
        volverAlInicio.setBounds(200, 550, 150, 50);
        this.add(volverAlInicio);
        volverAlInicio.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fondo.reset(Panel_pasajes.this);
            }
        });

    }

}

