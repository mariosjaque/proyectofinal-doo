package doo.sistemaBuses.interfazGrafica;

import doo.sistemaBuses.logicaNegocio.Bus;
import doo.sistemaBuses.logicaNegocio.Pasaje;
import doo.sistemaBuses.interfazGrafica.Panel_Compra;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;

public class Panel_pasajes extends JPanel {
    private Pasaje pasaje;

    public Panel_pasajes(Pasaje pasaje) {
        this.pasaje = pasaje;
        this.setLayout(null);
        this.setBounds(0, 0, 1000, 1000);

        JLabel infoLabel = new JLabel("Información del Pasaje");
        this.add(infoLabel);
        infoLabel.setBounds(0, 0, 500, 100);
        infoLabel.setForeground(Color.white);

        JLabel busLabel = new JLabel("Bus: " + pasaje.bus_seleccionado());
        this.add(busLabel);
        busLabel.setBounds(0, 100, 500, 50);
        busLabel.setForeground(Color.white);

        JLabel asientoLabel = new JLabel("Número de Asiento: " + pasaje.getNumeroAsiento());
        this.add(asientoLabel);
        asientoLabel.setBounds(0, 150, 500, 50);
        asientoLabel.setForeground(Color.white);

        JLabel pasajeroLabel = new JLabel("Nombre del Pasajero: " + pasaje.getNombrePasajero());
        this.add(pasajeroLabel);
        pasajeroLabel.setBounds(0, 200, 500, 50);
        pasajeroLabel.setForeground(Color.white);

        JLabel horarioLabel = new JLabel("Horario y Fecha de Salida: " + pasaje.getHorarioFechaSalida());
        this.add(horarioLabel);
        horarioLabel.setBounds(0, 250, 500, 50);
        horarioLabel.setForeground(Color.white);

        JButton downloadButton = new JButton("Descargar PDF");
        this.add(downloadButton);
        downloadButton.setBounds(0, 300, 200, 50);
        downloadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    pasaje.generarPDF("pasaje.pdf");
                    JOptionPane.showMessageDialog(Panel_Pasaje.this, "PDF generado exitosamente");
                } catch (FileNotFoundException | DocumentException ex) {
                    JOptionPane.showMessageDialog(Panel_Pasaje.this, "Error al generar PDF: " + ex.getMessage());
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.gray);
        g.fillRect(0, 0, 1000, 1000);
    }
}