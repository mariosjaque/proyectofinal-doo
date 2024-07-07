package doo.sistemaBuses.interfazGrafica;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import doo.sistemaBuses.logicaNegocio.Bus;
import doo.sistemaBuses.logicaNegocio.SalonCama;
import doo.sistemaBuses.logicaNegocio.SemiCama;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Pasaje extends JPanel {
    private Bus bus;
    private int numeroAsiento;
    private String nombrePasajero;
    private String horarioFechaSalida;
    private double precio;

    public Pasaje(Bus bus, int numeroAsiento, String nombrePasajero, String horarioFechaSalida) {
        this.bus = bus;
        this.numeroAsiento = numeroAsiento;
        this.nombrePasajero = nombrePasajero;
        this.horarioFechaSalida = horarioFechaSalida;
        this.precio = 4000; // Precio del pasaje
    }

    public Bus getBus() {
        return bus;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public String getHorarioFechaSalida() {
        return horarioFechaSalida;
    }

    public double getPrecio() {
        return precio;
    }

    public static double calcularTotal(ArrayList<Pasaje> pasajes) {
        double total = 0;
        for (Pasaje pasaje : pasajes) {
            total += pasaje.getPrecio();
        }
        return total;
    }
    public static String generarNombreArchivo(ArrayList<Pasaje> numAsiento) {
        String tipoBus = "SemiCama"; // Ajusta según cómo obtienes el tipo de bus

        String nombreArchivo = "Pasaje_" + tipoBus + numAsiento + ".pdf";
        return nombreArchivo;
    }

    public static void generarPDF(ArrayList<Pasaje> pasajes) {
        Document document = new Document();
        try {
            String nombrePDF = generarNombreArchivo(pasajes);
            PdfWriter.getInstance(document, new FileOutputStream(nombrePDF));
            document.open();

            // Encabezado
            Font fontTitle = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
            Paragraph title = new Paragraph("Detalles del Pasaje", fontTitle);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20);
            document.add(title);

            // Tabla de detalles del pasaje
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            // Encabezados de la tabla
            Font headFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            PdfPCell hcell;

            hcell = new PdfPCell(new Phrase("Tipo de Bus", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Número de Asiento", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Nombre del Pasajero", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Fecha y Hora de Salida", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            // Contenido de la tabla
            Font contentFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
            for (Pasaje pasaje : pasajes) {
                PdfPCell cell;

                cell = new PdfPCell(new Phrase(pasaje.getBus().toString(), contentFont));
                cell.setPaddingLeft(5);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(pasaje.getNumeroAsiento()), contentFont));
                cell.setPaddingLeft(5);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(pasaje.nombrePasajero, contentFont));
                cell.setPaddingLeft(5);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(pasaje.getHorarioFechaSalida(), contentFont));
                cell.setPaddingLeft(5);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell);
            }

            document.add(table);
            JOptionPane.showMessageDialog(null, "PDF generado con éxito.");
        } catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + e.getMessage());
        } finally {
            document.close();
        }
    }
}
