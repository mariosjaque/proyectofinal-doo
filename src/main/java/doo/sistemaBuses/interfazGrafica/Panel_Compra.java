package doo.sistemaBuses.interfazGrafica;

import doo.sistemaBuses.logicaNegocio.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Panel_Compra extends JPanel {
    private JTextField textoTarjeta;
    private ArrayList<Asiento> asientos;
    private Bus bus;
    private JTextField textoCVV, textoEfectivo, textoNombrePass;
    private JTextField textoMonto;
    private JTextField textoNombre;
    private Panel_fondo fondo;
    private JLabel listaAsientosTXT;
    private String tipo;
    private double precio;
    private JLabel totalTXT;
    private double totalCompra = 0;
    private JTextField textoCodigoCajero;
    private double totalPagar;

    public Panel_Compra(Panel_fondo fondo, Bus bus, ArrayList<Asiento> asientos) {
        this.fondo = fondo;
        this.bus = bus;
        this.asientos = asientos;
        //calcular precio a pagar
        totalPagar = asientos.size() * 4000;

        this.setLayout(null);
        this.setBounds(0, 0, 1000, 1000);

        JLabel printSeleccion = new JLabel("Selecciona tu tipo de tarjeta");
        printSeleccion.setForeground(Color.white);
        printSeleccion.setFont(new Font("Arial", Font.BOLD, 16));
        this.add(printSeleccion);
        printSeleccion.setBounds(20, 20, 300, 30);

        JButton debito = new JButton("Débito");
        this.add(debito);
        debito.setBounds(20, 60, 150, 50);
        debito.addActionListener(new DebitoActionListener());

        JButton credito = new JButton("Crédito");
        this.add(credito);
        credito.setBounds(180, 60, 150, 50);
        credito.addActionListener(new CreditoActionListener());

        JButton efectivo = new JButton("Efectivo");
        this.add(efectivo);
        efectivo.setBounds(340, 60, 150, 50);
        efectivo.addActionListener(new EfectivoActionListener());

        JButton retroceder = new JButton("Anterior");
        this.add(retroceder);
        retroceder.setBounds(20, 750, 150, 50);
        retroceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fondo.retrocedePanel(Panel_Compra.this);
            }
        });
        JButton validarPago = new JButton("Validar Pago");
        this.add(validarPago);
        validarPago.setBounds(20, 370, 200, 50);
        validarPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ("Efectivo".equals(tipo)) {
                    String codigoEfectivo = textoEfectivo.getText();
                    if ("212378".equals(codigoEfectivo)) {
                        procesarPago();
                    } else {
                        JOptionPane.showMessageDialog(Panel_Compra.this, "Código de cajero inválido.");
                    }
                } else {
                    String cardNumberStr = textoTarjeta.getText();
                    String cvvStr = textoCVV.getText();
                    String cardholderName = textoNombre.getText();

                    try {
                        long cardNumber = Long.parseLong(cardNumberStr);
                        int cvv = Integer.parseInt(cvvStr);

                        ValidadorPago validador = new ValidadorPago(tipo, cardNumber, cvv, cardholderName);
                        if (validador.validar()) {
                            procesarPago();
                        } else {
                            throw new Exception("Datos inválidos");
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(Panel_Compra.this, "Número de tarjeta o CVV inválidos: " + ex.getMessage());
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(Panel_Compra.this, "Error al validar pago: " + ex.getMessage());
                    }
                }
            }
        });
        JLabel asientosSeleccionados = new JLabel("Asientos seleccionados:");
        this.add(asientosSeleccionados);
        asientosSeleccionados.setBounds(650, 10, 200, 30);
        asientosSeleccionados.setForeground(Color.white);

        JTextArea areaAsientos = new JTextArea();
        areaAsientos.setEditable(false);
        for (Asiento asiento : asientos) {
            areaAsientos.append("Asiento: " + asiento.getNumero() + "\n");
        }
        JScrollPane scrollPane = new JScrollPane(areaAsientos);
        scrollPane.setBounds(650, 50, 300, 200);
        this.add(scrollPane);
    }
    public void getPrecio(double precio) {
        this.precio = precio * asientos.size();
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

        JButton efectivo = new JButton("Efectivo");
        this.add(efectivo);
        efectivo.setBounds(400, 100, 200, 50);
        efectivo.addActionListener(new EfectivoActionListener());

        JButton retroceder = new JButton("Anterior");
        this.add(retroceder);
        retroceder.setBounds(0, 750, 150, 50);
        retroceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fondo.retrocedePanel(Panel_Compra.this);
            }
        });

        JLabel numberTarjeta = new JLabel("Ingresa número de tarjeta");
        this.add(numberTarjeta);
        numberTarjeta.setBounds(0, 190, 200, 50);
        numberTarjeta.setForeground(Color.white);

        textoTarjeta = new JTextField();
        this.add(textoTarjeta);
        textoTarjeta.setBounds(0, 240, 200, 30);

        JLabel tarjetaCVV = new JLabel("Ingresa CVV");
        this.add(tarjetaCVV);
        tarjetaCVV.setBounds(0, 280, 200, 50);
        tarjetaCVV.setForeground(Color.white);

        textoCVV = new JTextField();
        this.add(textoCVV);
        textoCVV.setBounds(0, 330, 200, 30);

        JLabel nombreTarjeta = new JLabel("Nombre del titular de la tarjeta");
        this.add(nombreTarjeta);
        nombreTarjeta.setBounds(0, 370, 300, 50);
        nombreTarjeta.setForeground(Color.white);

        textoNombre = new JTextField();
        this.add(textoNombre);
        textoNombre.setBounds(0, 420, 200, 30);

        JButton validarPago = new JButton("Validar Pago");
        this.add(validarPago);
        validarPago.setBounds(0, 470, 200, 50);
        validarPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cardNumberStr = textoTarjeta.getText();
                String cvvStr = textoCVV.getText();
                String cardholderName = textoNombre.getText();

                try {
                    long cardNumber = Long.parseLong(cardNumberStr);
                    int cvv = Integer.parseInt(cvvStr);

                    ValidadorPago validador = new ValidadorPago(tipo, cardNumber, cvv, cardholderName);
                    if (validador.validar()) {
                        JOptionPane.showMessageDialog(Panel_Compra.this, "Pago validado correctamente");
                        ArrayList<Pasaje> pasajes = new ArrayList<>();
                        for (Asiento asiento : asientos) {
                            asiento.compraAsiento();
                            Pasaje pasaje = new Pasaje(bus, asiento.getNumero(), cardholderName, "Fecha y Hora de Salida");
                            pasajes.add(pasaje);
                        }
                        Panel_pasajes panelPasaje = new Panel_pasajes(pasajes, fondo);
                        fondo.avanzaPanel(panelPasaje, Panel_Compra.this);
                    } else {
                        throw new Exception("Datos inválidos");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Panel_Compra.this, "Número de tarjeta o CVV inválidos: " + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(Panel_Compra.this, "Error al validar pago: " + ex.getMessage());
                }
            }
        });
    }
    private class EfectivoActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            tipo = "Efectivo";
            mostrarFormularioEfectivo();
        }
    }
    private void mostrarFormularioEfectivo() {
        this.removeAll();
        this.repaint();

        JLabel printSeleccion = new JLabel("Pago en Efectivo");
        this.add(printSeleccion);
        printSeleccion.setBounds(0, 0, 500, 100);
        printSeleccion.setForeground(Color.white);

        JButton retroceder = new JButton("Anterior");
        this.add(retroceder);
        retroceder.setBounds(0, 750, 150, 50);
        retroceder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fondo.retrocedePanel(Panel_Compra.this);
            }
        });

        JLabel codigoCajero = new JLabel("Ingresa código de cajero");
        this.add(codigoCajero);
        codigoCajero.setBounds(0, 190, 200, 50);
        codigoCajero.setForeground(Color.white);

        textoEfectivo = new JTextField();
        this.add(textoEfectivo);
        textoEfectivo.setBounds(0, 240, 200, 30);

        JLabel nombrePasajero = new JLabel("Nombre del pasajero");
        this.add(nombrePasajero);
        nombrePasajero.setBounds(0, 280, 200, 50);
        nombrePasajero.setForeground(Color.white);

        textoNombrePass = new JTextField();
        this.add(textoNombrePass);
        textoNombrePass.setBounds(0, 330, 200, 30);

        JLabel montoIngresado = new JLabel("Monto ingresado");
        this.add(montoIngresado);
        montoIngresado.setBounds(0, 370, 300, 50);
        montoIngresado.setForeground(Color.white);

        textoMonto = new JTextField();
        this.add(textoMonto);
        textoMonto.setBounds(0, 420, 200, 30);

        JButton validarPago = new JButton("Validar Pago");
        this.add(validarPago);
        validarPago.setBounds(0, 380, 200, 50);
        validarPago.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String codigoCajero = textoEfectivo.getText();
                String montoIngresadoStr = textoMonto.getText();

                try {
                    double montoIngresado = Double.parseDouble(montoIngresadoStr);

                    if ("212378".equals(codigoCajero)) {
                        double vuelto = montoIngresado - (4000* asientos.size());
                        if (vuelto >= 0) {
                            JOptionPane.showMessageDialog(Panel_Compra.this, "Pago validado correctamente. Su vuelto es: " + vuelto);
                            ArrayList<Pasaje> pasajes = new ArrayList<>();
                            ArrayList<Asiento> asientosSeleccionados = new ArrayList<>();
                            for (Asiento asiento : asientos) {
                                Pasaje pasaje = new Pasaje(bus, asiento.getNumero(), textoNombre.getText(), "Fecha y Hora de Salida");
                                pasajes.add(pasaje);
                                asiento.compraAsiento();
                                Asiento asiento_numero = new Asiento(asiento.getNumero());
                                asientosSeleccionados.add(asiento_numero);
                            }
                            Panel_pasajes panelPasaje = new Panel_pasajes(pasajes, fondo);
                            fondo.avanzaPanel(panelPasaje, Panel_Compra.this);

                        } else {
                            JOptionPane.showMessageDialog(Panel_Compra.this, "Monto ingresado insuficiente.");
                        }
                    } else {
                        JOptionPane.showMessageDialog(Panel_Compra.this, "Código de cajero inválido.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Panel_Compra.this, "Monto ingresado inválido: " + ex.getMessage());
                }
            }
        });
    }

    private void mostrarPantallaInicial() {
        this.removeAll();
        this.repaint();
        //new Panel_Compra(fondo);
    }
    private void procesarPago() {
        JOptionPane.showMessageDialog(Panel_Compra.this, "Pago validado correctamente");
        ArrayList<Pasaje> pasajes = new ArrayList<>();
        for (Asiento asiento : asientos) {
            pasajes.add(new Pasaje(bus, asiento.getNumero(), textoNombre.getText(), "Fecha y Hora de Salida"));
        }
        Panel_pasajes panelPasaje = new Panel_pasajes(pasajes, fondo);
        fondo.avanzaPanel(panelPasaje, Panel_Compra.this);

    }
    private void actualizarAsientosPendientes() {
        StringBuilder listaAsientos = new StringBuilder("<html>Asientos seleccionados:<br>");
        for (Asiento asiento : asientos) {
            listaAsientos.append("Asiento ").append(asiento.getNumero()).append("<br>");
        }
        listaAsientos.append("</html>");
        listaAsientosTXT.setText(listaAsientos.toString());
    }

    public void cambiarAPanelPasaje(ArrayList<Pasaje> pasajes) {
        Panel_pasajes panelPasaje = new Panel_pasajes(pasajes, fondo);
        panelPasaje.setBackground(Color.WHITE);  // Ajusta el color de fondo según necesites
        fondo.avanzaPanel(panelPasaje, Panel_Compra.this);
    }



    //color de fondo
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.gray);
        g.fillRect(0,0,1000,1000);
    }
    private class DebitoActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mostrarFormularioTarjeta("Débito");
        }
    }

    private class CreditoActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            mostrarFormularioTarjeta("Crédito");
        }
    }

    // Clase ValidadorPago ya se encuentra casi en la etapa final
    public class ValidadorPago {
        private String cardType;
        private long cardNumber;
        private int cvv;
        private String cardholderName;

        public ValidadorPago(String cardType, long cardNumber, int cvv, String cardholderName) {
            this.cardType = cardType;
            this.cardNumber = cardNumber;
            this.cvv = cvv;
            this.cardholderName = cardholderName;
        }

        public boolean validar() {
            String cardNumberStr = Long.toString(cardNumber);
            if (cardNumberStr.length() != 16) {
                return false;
            }

            String cvvStr = Integer.toString(cvv);
            if (cvvStr.length() != 3 && cvvStr.length() != 4) {
                return false;
            }

            if (cardholderName.isEmpty()) {
                return false;
            }

            return true;
        }
    }

}
