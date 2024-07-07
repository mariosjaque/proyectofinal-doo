package doo.sistemaBuses.interfazGrafica;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

public class Panel_Fecha extends JPanel{
    private int verificador=1;



    public Panel_Fecha(Panel_fondo panel_fondo,Date Fecha_inicio){

        this.setLayout(null);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        JTextField texto = new JTextField();
        JLabel print = new JLabel("Ingresa la fecha de salida de bus: (dia/mes/año)");




        this.add(texto);
        this.add(print);

        print.setForeground(Color.white);
        //Fijar coordenadas
        this.setBounds(0,0,1000,1000);
        print.setBounds(0,0,500,100);
        texto.setBounds(0,100,200,50);

        KeyAdapter Enter = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                int tecla_presionada = e.getKeyCode();
                if(tecla_presionada == KeyEvent.VK_ENTER){
                    try {

                        Date fecha;
                        fecha = formato.parse(texto.getText());
                        for(int i=0;i<=14;i++){
                            if(fecha.equals(Panel_Fecha.this.variarFecha(Fecha_inicio,i))){
                                panel_fondo.setfecha(fecha);
                                Panel_Buses panelBuses = new Panel_Buses(panel_fondo);
                                panel_fondo.avanzaPanel(panelBuses, Panel_Fecha.this);
                                verificador=0;
                                break;
                            }
                        }
                        if(verificador !=0){
                            JOptionPane.showMessageDialog(null,"Se ha seleccionado una fecha incorrecta");
                        }



                    } catch (ParseException ex) {
                        JOptionPane.showMessageDialog(null,"Se ha seleccionado una fecha incorrecta");
                    }


                }
            }
        };
        texto.addKeyListener(Enter);




    }
    public Date variarFecha(Date fecha, int valor){
        if (valor==0) return fecha;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fecha);
        calendar.add(Calendar.DAY_OF_YEAR, valor);
        return calendar.getTime();
    }
}
