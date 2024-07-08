package doo.sistemaBuses.interfazGrafica;

import doo.sistemaBuses.logicaNegocio.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Panel que muestra los asientos de un bus.
 */
public class Panel_Asientos extends JPanel {
    /**
     * Lista de asientos que están seleccionados por el usuario.
     */
    private ArrayList<Asiento> asientosPendientes;
    /**
     * Label que muestra la lista de asientos
     */
    private JLabel listaAsientosTXT;

    /**
     * Constructor que recibe el panel de fondo (holder) y un bus para mostrar sus asientos
     * @author Mario Salgado
     * @author Luis Martinez
     * @param fondo fondo/holder
     * @param bus   el bus
     */
    public Panel_Asientos(Panel_fondo fondo, Bus bus){
        this.setLayout(null);
        this.setBounds(0,0,1000,1000);
        ImageIcon imagen_fondo = new ImageIcon(getClass().getResource("/fondo.jpg"));
        JLabel Fondo = new JLabel();
        Fondo.setIcon(new ImageIcon(imagen_fondo.getImage().getScaledInstance(1000,1000,Image.SCALE_SMOOTH)));
        Fondo.setBounds(0,0,1000,1000);


        JButton siguiente = new JButton("Siguiente");
        JButton retroceder = new JButton("Anterior");
        listaAsientosTXT = new JLabel();
        listaAsientosTXT.setForeground(Color.white);
        this.add(siguiente);
        this.add(retroceder);
        this.add(listaAsientosTXT);
        listaAsientosTXT.setBounds(100,700,800,50);
        siguiente.setBounds(150,750,150,50);
        retroceder.setBounds(0,750,150,50);
        ActionListener Avanzar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(asientosPendientes.isEmpty()){
                    JOptionPane.showMessageDialog(null, "No se puede avanzar sin un asiento seleccionado.");
                } else {
                    Panel_Compra panelCompra = new Panel_Compra(fondo, bus, asientosPendientes);
                    fondo.avanzaPanel(panelCompra, Panel_Asientos.this);
                }
            }
        };

        ActionListener Retroceder = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fondo.retrocedePanel(Panel_Asientos.this);
            }
        };

        siguiente.addActionListener(Avanzar);
        retroceder.addActionListener(Retroceder);

        int cantidadPisos = bus.getModeloBus().getNumeroPisos();
        int filasPorPiso = bus.getModeloBus().getFilasPorPiso();
        asientosPendientes = new ArrayList<>();
        actualizarAsientosPendientes();

        for(int i=0;i<cantidadPisos;i++){
            for(int j=1;j<=filasPorPiso;j++) {
                int x = 0;
                for (int k=((4*j)-4)+(4*filasPorPiso*i); k<(4*j)+(4*filasPorPiso*i); k++) {
                    Asiento asiento = bus.getAsiento(k);
                    JButton asientoBtn = asientoGrafico(asiento);
                    ActionListener oyente = new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(!asiento.isReservado()) {
                                if(asientosPendientes.contains(asiento)){
                                    asientosPendientes.remove(asiento);
                                    JOptionPane.showMessageDialog(null, "Asiento ya no se encuentra seleccionado.");
                                } else {
                                    asientosPendientes.add(asiento);
                                    JOptionPane.showMessageDialog(null, "Asiento seleccionado con éxito.");
                                }
                                actualizarAsientosPendientes();
                            } else {
                                JOptionPane.showMessageDialog(null, "Asiento ya se encuentra reservado.");
                            }
                        }
                    };
                    asientoBtn.addActionListener(oyente);
                    asientoBtn.setBounds(100+(50*x)+(7*50*i), 100+(50*j), 50, 50);
                    if(x==1){x+=2;}else{x+=1;}
                    this.add(asientoBtn);
                }
            }
        }
        this.add(Fondo);


    }

    /**
     * Método que genera un botón, representación gráfica de Asiento.
     * @author Mario Salgado
     * @param a the a
     * @return the j button
     */
    public JButton asientoGrafico(Asiento a) {
        ImageIcon grafico;
        if(!a.isReservado()){
            grafico = new ImageIcon(getClass().getResource("/asiento_disponible.png"));
        } else {
            grafico = new ImageIcon(getClass().getResource("/asiento_comprado.png"));
        }
        grafico = new ImageIcon(grafico.getImage().getScaledInstance(50,50,Image.SCALE_SMOOTH));
        JButton jb = new JButton(grafico);
        jb.setText(String.valueOf(a.getNumero()));
        jb.setHorizontalTextPosition(JButton.CENTER);
        jb.setVerticalTextPosition(JButton.CENTER);
        return jb;
    }

    /**
     * Este método permite actualizar la lista de asientos que se encuentran seleccionados.
     * @author Mario Salgado
     */
    public void actualizarAsientosPendientes(){
        StringBuilder listaAsientos = new StringBuilder("Asientos seleccionados: ");
        int numAsientosR = asientosPendientes.size();
        for(int i=0;i<numAsientosR;i++){
            listaAsientos.append(asientosPendientes.get(i).getNumero());
            if(numAsientosR > 1 && i!=numAsientosR-1){
                listaAsientos.append(", ");
            }
        }
        listaAsientosTXT.setText(listaAsientos.toString());
        repaint();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
    }
}
