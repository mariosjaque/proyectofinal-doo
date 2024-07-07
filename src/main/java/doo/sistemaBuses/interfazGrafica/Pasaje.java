package doo.sistemaBuses.interfazGrafica;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import doo.sistemaBuses.logicaNegocio.Bus;
import doo.sistemaBuses.logicaNegocio.SalonCama;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

public class Pasaje {
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

    public void generarPDF(String filePath) throws FileNotFoundException, DocumentException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();
        document.add(new Paragraph("Información del Pasaje"));
        document.add(new Paragraph("Bus: " + bus));
        document.add(new Paragraph("Número de Asiento: " + numeroAsiento));
        document.add(new Paragraph("Nombre del Pasajero: " + nombrePasajero));
        document.add(new Paragraph("Horario y Fecha de Salida: " + horarioFechaSalida));
        document.close();
    }

    public void setBus(SalonCama salonCama) {
    }

    public void asignar_fecha_bus(Date fechaInicio) {
    }
}