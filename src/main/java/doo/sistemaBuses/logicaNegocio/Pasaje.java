package doo.sistemaBuses.logicaNegocio;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import javax.swing.*;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Pasaje extends JPanel {
    private Bus bus;
    private int numeroAsiento;
    private String nombrePasajero;
    private Instant horarioFechaSalida;
    private double precio;
    private static DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").withZone(ZoneId.systemDefault());
    private static DateTimeFormatter formatoFechaHora2 = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss").withZone(ZoneId.systemDefault());


    public Pasaje(Bus bus, int numeroAsiento, String nombrePasajero, Instant horarioFechaSalida) {
        this.bus = bus;
        this.numeroAsiento = numeroAsiento;
        this.nombrePasajero = nombrePasajero;
        this.horarioFechaSalida = horarioFechaSalida;
        this.precio = bus.getRecorridoBus().getPrecio(); // Precio del pasaje
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
        return formatoFechaHora.format(horarioFechaSalida);
    }

    public double getPrecio() {
        return precio;
    }
    public String generarNombreArchivo() {
        return "Pasaje_" + formatoFechaHora2.format(Instant.now()) + "_" + this.getNumeroAsiento() + "_"+ bus.getRecorridoBus()+ "_"+ bus.getPatenteBus() + ".pdf";
    }
    public void generarPDF() {

        Document document = new Document();
        try {
            String nombrePDF = generarNombreArchivo();

            PdfWriter.getInstance(document, new FileOutputStream(nombrePDF));
            document.open();

            Font fontTitle = new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD);
            Paragraph title = new Paragraph("Detalles del Pasaje", fontTitle);
            title.setAlignment(Element.ALIGN_CENTER);
            title.setSpacingAfter(20);
            document.add(title);

            PdfPTable table = new PdfPTable(6);
            table.setWidthPercentage(100);
            table.setSpacingBefore(10f);
            table.setSpacingAfter(10f);

            Font headFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            PdfPCell hcell;

            hcell = new PdfPCell(new Phrase("Tipo de Bus", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Recorrido Bus", headFont));
            hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(hcell);

            hcell = new PdfPCell(new Phrase("Patente Bus", headFont));
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

            Font contentFont = new Font(Font.FontFamily.HELVETICA, 10, Font.NORMAL);
            PdfPCell cell;

                cell = new PdfPCell(new Phrase(String.valueOf(this.getBus().getModeloBus()), contentFont));
                cell.setPaddingLeft(5);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(bus.getRecorridoBus().getRecorrido()), contentFont));
                cell.setPaddingLeft(5);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(bus.getPatenteBus()), contentFont));
                cell.setPaddingLeft(5);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(String.valueOf(this.getNumeroAsiento()), contentFont));
                cell.setPaddingLeft(5);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(this.getNombrePasajero(), contentFont));
                cell.setPaddingLeft(5);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell);

                cell = new PdfPCell(new Phrase(this.getHorarioFechaSalida(), contentFont));
                cell.setPaddingLeft(5);
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                table.addCell(cell);

            document.add(table);
            JOptionPane.showMessageDialog(null, "PDF generado con éxito.");
        } catch (DocumentException | IOException e) {
            JOptionPane.showMessageDialog(null, "Error al generar el PDF: " + e.getMessage());
        } finally {
            document.close();
        }
    }


}