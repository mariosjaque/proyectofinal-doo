package doo.sistemaBuses.interfazGrafica;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import doo.sistemaBuses.logicaNegocio.Bus;
import doo.sistemaBuses.logicaNegocio.SalonCama;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import doo.sistemaBuses.logicaNegocio.modelosBus;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pasaje extends ArrayList<Pasaje> {
    private ArrayList<Pasaje> pasajes;
    private JLabel detallesPasajesTXT;
    private Bus bus;
    private int numeroAsiento;
    private String nombrePasajero;
    private String horarioFechaSalida;

    public Pasaje(Bus bus, int numeroAsiento, String nombrePasajero, String horarioFechaSalida) {
        this.bus = bus;
        this.numeroAsiento = numeroAsiento;
        this.nombrePasajero = nombrePasajero;
        this.horarioFechaSalida = horarioFechaSalida;
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

    @Override
    public List<Pasaje> reversed() {
        return super.reversed();
    }

    //public void generarPDF(String filePath) throws FileNotFoundException, DocumentException {
      //  Document document = new Document();
        //PdfWriter.getInstance(document, new FileOutputStream(filePath));
        //document.open();
        //document.add(new Paragraph("Información del Pasaje"));
        //document.add(new Paragraph("Bus: " + bus));
        //document.add(new Paragraph("Número de Asiento: " + numeroAsiento));
        //document.add(new Paragraph("Nombre del Pasajero: " + nombrePasajero));
        //document.add(new Paragraph("Horario y Fecha de Salida: " + horarioFechaSalida));
        //document.close();
    //}
    public static void generarPDF(ArrayList<Pasaje> pasajes) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("Pasajes.pdf"));
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
                ////////modificar aqui luego ------------> ***************************************
                cell = new PdfPCell(new Phrase(String.valueOf(pasaje.bus), contentFont));
                cell.setPaddingLeft(5);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(pasaje.numeroAsiento), contentFont));
                cell.setPaddingLeft(5);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(pasaje.nombrePasajero, contentFont));
                cell.setPaddingLeft(5);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(pasaje.horarioFechaSalida, contentFont));
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