package doo.sistemaBuses.interfazGrafica;

import doo.sistemaBuses.logicaNegocio.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * Panel que muestra los buses de un terminal
 */
public class Panel_Buses extends JPanel {
    /** Variable para la terminal que almacena buses */
    private terminalBus terminal;
    /** Bus seleccionado por el usuario */
    private Bus bus_seleccionado;
    /** Lista de recorridos en interfaz */
    private JComboBox<recorridos> recorridoComboBox;
    /** Lista de modelos en interfaz */
    private JComboBox<modelosBus> modeloBusComboBox;
    /** Panel de botones de buses */
    private JPanel busButtonsPanel;
    /** */
    private modelosBus modeloSeleccionado;
    private recorridos recorridoSeleccionado;
    /** Un elemento que permite convertir el instant a un string con determinado formato */
    private static DateTimeFormatter formatoFechaHora = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss").withZone(ZoneId.systemDefault());


    /**
     * Constructor del panel
     * @author Santiago Diaz
     * @author Mario Salgado
     * @param fondo recibe el fondo/holder (donde se almacena el terminal de buses)
     */
    public Panel_Buses(Panel_fondo fondo) {
        this.setLayout(null);
        this.setBounds(0, 0, 1000, 1000);

        terminal = fondo.getTerminalBus();
        ImageIcon imagen_fondo = new ImageIcon(getClass().getResource("/fondo.jpg"));
        JLabel Fondo = new JLabel();
        Fondo.setIcon(new ImageIcon(imagen_fondo.getImage().getScaledInstance(1000, 1000, Image.SCALE_SMOOTH)));
        Fondo.setBounds(0, 0, 1000, 1000);


        SimpleDateFormat simple = new SimpleDateFormat("dd/MM/yyyy");
        String fecha = simple.format(fondo.getfecha());
        JLabel Titulo = new JLabel("Pasajes del dia " + fecha);
        Titulo.setFont(new Font("Serif", Font.BOLD, 20));
        this.add(Titulo);
        Titulo.setBounds(300, 0, 400, 20);

        JLabel modeloBusLabel = new JLabel("Modelo de Bus:");
        modeloBusLabel.setForeground(Color.white);
        this.add(modeloBusLabel);
        modeloBusLabel.setBounds(50, 50, 150, 30);

        modeloBusComboBox = new JComboBox<>();
        for(int i=0;i<modelosBus.values().length;i++){
            modeloBusComboBox.addItem(modelosBus.values()[i]);
        }
        this.add(modeloBusComboBox);
        modeloBusComboBox.setBounds(210, 50, 200, 30);
        modeloBusComboBox.addActionListener(new ActionListener() {

            @SuppressWarnings("unchecked")
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<modelosBus> comboBox = (JComboBox<modelosBus>) e.getSource();
                modeloSeleccionado = (modelosBus) comboBox.getSelectedItem() ;
            }
        });

        JButton actualizarButton = new JButton("Filtrar Buses");
        actualizarButton.setBounds(450, 150, 200, 30);
        this.add(actualizarButton);

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizarBuses();
            }
        });

        JLabel recorridoLabel = new JLabel("Recorrido:");
        recorridoLabel.setForeground(Color.white);
        this.add(recorridoLabel);
        recorridoLabel.setBounds(50, 150, 150, 30);

        recorridoComboBox = new JComboBox<>();
        for(int i=0;i<recorridos.values().length;i++){
            recorridoComboBox.addItem(recorridos.values()[i]);
        }
        this.add(recorridoComboBox);
        recorridoComboBox.setBounds(200, 150, 200, 30);
        recorridoComboBox.addActionListener(new ActionListener() {

            @SuppressWarnings("unchecked")
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<recorridos> comboBox = (JComboBox<recorridos>) e.getSource();
                recorridoSeleccionado = (recorridos) comboBox.getSelectedItem() ;
            }
        });

        JButton siguiente = new JButton("Siguiente");
        JButton retroceder = new JButton("Anterior");
        this.add(siguiente);
        this.add(retroceder);
        siguiente.setBounds(150,750,150,50);
        retroceder.setBounds(0,750,150,50);

        ActionListener Avanzar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(bus_seleccionado==null){
                    JOptionPane.showMessageDialog(null, "No se puede avanzar sin un bus seleccionado.");
                } else {
                    Panel_Asientos panelAsientos = new Panel_Asientos(fondo, bus_seleccionado);
                    fondo.avanzaPanel(panelAsientos, Panel_Buses.this);
                }
            }
        };
        busButtonsPanel = new JPanel();
        busButtonsPanel.setLayout(new BoxLayout(busButtonsPanel, BoxLayout.Y_AXIS));
        actualizarBuses();
        JScrollPane scrollPane = new JScrollPane(busButtonsPanel);
        scrollPane.setBounds(50, 200, 900, 500);
        this.add(scrollPane);

        ActionListener Retroceder = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fondo.retrocedePanel(Panel_Buses.this);
            }
        };

        siguiente.addActionListener(Avanzar);
        retroceder.addActionListener(Retroceder);
        this.add(Fondo);



    }

    /**
     * Función que permite actualizar la lista de buses.
     * @author Santiago Diaz
     */
    private void actualizarBuses() {
        busButtonsPanel.removeAll();
        busButtonsPanel.revalidate();
        busButtonsPanel.repaint();

        int numeroBuses = terminal.getNumeroBuses();
        for (int i = 0; i < numeroBuses; i++) {
            Bus bus = terminal.getBuses(i);
            if (((bus.getModeloBus() == modeloSeleccionado) && (bus.getRecorridoBus() == recorridoSeleccionado)) || (modeloSeleccionado == null) || (recorridoSeleccionado == null)) {
                JButton busButton = new JButton("Bus " + (i + 1) + ": " + bus.getModeloBus() + " - " + formatoFechaHora.format(bus.getHorarioBus()) + " - " + bus.getRecorridoBus().getRecorrido());
                busButton.setFont(new Font("Arial", Font.PLAIN, 16));
                busButton.setBackground(Color.LIGHT_GRAY);
                busButton.setFocusPainted(false);
                busButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bus_seleccionado = bus;
                        JOptionPane.showMessageDialog(null, "Bus seleccionado: " + bus.getModeloBus() + "\nHorario: " + formatoFechaHora.format(bus.getHorarioBus()) + "\nRecorrido: " + bus.getRecorridoBus().getRecorrido());
                    }
                });
                busButtonsPanel.add(busButton);
            }
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
