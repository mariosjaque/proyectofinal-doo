package doo.sistemaBuses.interfazGrafica;
import javax.swing.JFrame;

public class Ventana extends JFrame {
    Panel_fondo panel_fondo;
    public Ventana(){
        super();
        panel_fondo = new Panel_fondo();
        panel_fondo.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(0,0,1000,1000);
        this.add(panel_fondo);
        this.setVisible(true);
    }
}
