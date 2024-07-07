package doo.sistemaBuses.interfazGrafica;
import javax.swing.JFrame;
import java.text.ParseException;



public class Ventana extends JFrame {
    private static Ventana ventana = new Ventana();
    Panel_fondo panel_fondo;
    private Ventana(){
        super();
        panel_fondo = Panel_fondo.singleton();
        panel_fondo.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(0,0,1000,1000);
        this.add(panel_fondo);
        this.setVisible(true);


    }
    public static Ventana singleton(){
        return ventana;
    }
}
