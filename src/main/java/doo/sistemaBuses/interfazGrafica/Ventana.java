package doo.sistemaBuses.interfazGrafica;
import javax.swing.JFrame;
import java.text.ParseException;


/**
 * Clase Ventana, donde se crea la ventana que muestra la interfaz.
 * @author Luis Martinez
 */
public class Ventana extends JFrame {
    private static Ventana ventana = new Ventana();
    /**
     * Variable para almacenar unica instancia de panel fondo
     */
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

    /**
     * Ventana debe tener única instancia pues no es posible tener más de una ventana abierta por proceso/instancia del programa.
     * Por esto se usa patrón Singleton.
     * @return Referencia a la ventana de instancia única
     */
    public static Ventana singleton(){
        return ventana;
    }
}
