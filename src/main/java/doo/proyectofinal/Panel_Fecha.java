package doo.proyectofinal;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Panel_Fecha extends JPanel{

    public Panel_Fecha(Panel_fondo panel_fondo){

        this.setLayout(null);

        JTextField texto = new JTextField();
        JLabel print = new JLabel();
        SimpleDateFormat formato = new SimpleDateFormat("yyyy/MM/dd");
        Calendar calendario = Calendar.getInstance();

        this.add(texto);
        this.add(print);

        //Fijar coordenadas
        this.setBounds(0,0,1000,1000);
        texto.setBounds(0,0,200,50);

        KeyAdapter Enter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int tecla_presionada = e.getKeyCode();
                if(tecla_presionada == KeyEvent.VK_ENTER){
                    try {
                        Date fecha = new Date();
                        fecha = formato.parse(texto.getText());
                        panel_fondo.salir_panel_fecha();

                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(null,"Se ha seleccionado una fecha incorrecta");
                    }


                }
            }
        };
        texto.addKeyListener(Enter);

    }
}
