package doo.proyectofinal;
import javax.swing.JFrame;

public class Ventana extends JFrame {
    public Ventana(){
        super();
        this.setLayout(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(0,0,1000,1000);
        Panel_Fecha panel = new Panel_Fecha();
        this.add(panel);
        this.setVisible(true);
    }
}
