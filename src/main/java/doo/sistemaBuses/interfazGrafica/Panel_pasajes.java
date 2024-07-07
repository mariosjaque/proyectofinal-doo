package doo.sistemaBuses.interfazGrafica;

import doo.sistemaBuses.logicaNegocio.Bus;
import doo.sistemaBuses.interfazGrafica.Pasaje;

import doo.sistemaBuses.interfazGrafica.Panel_Compra;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Panel_pasajes extends JPanel {
    private ArrayList<Pasaje> pasajes;

    public Panel_pasajes(ArrayList<Pasaje> pasajes) {
        this.pasajes = pasajes;
        this.setLayout(null);
        this.setBounds(0, 0, 1000, 1000);

        JButton descargarPDF = new JButton("Descargar PDF");
        descargarPDF.setBounds(400, 750, 200, 50);
        this.add(descargarPDF);
        descargarPDF.addActionListener(e -> Pasaje.generarPDF(pasajes));

        JLabel detalles = new JLabel("Detalles de los Pasajes:");
        detalles.setForeground(Color.white);
        detalles.setFont(new Font("Arial", Font.BOLD, 16));
        detalles.setBounds(20, 20, 300, 30);
        this.add(detalles);

        StringBuilder info = new StringBuilder("<html>");
        for (Pasaje pasaje : pasajes) {
            info.append("Bus: ").append(pasaje.getBus().getModeloBus().SalonCama)
                    .append(", Asiento: ").append(pasaje.getNumeroAsiento())
                    .append(", Pasajero: ").append(pasaje.getNombrePasajero())
                    .append(", Fecha y Hora de Salida: ").append(pasaje.getHorarioFechaSalida())
                    .append("<br>");
        }
        info.append("</html>");

        JLabel pasajeInfo = new JLabel(info.toString());
        pasajeInfo.setForeground(Color.white);
        pasajeInfo.setBounds(20, 60, 960, 600);
        this.add(pasajeInfo);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.gray);
        g.fillRect(0, 0, 1000, 1000);
    }
}
