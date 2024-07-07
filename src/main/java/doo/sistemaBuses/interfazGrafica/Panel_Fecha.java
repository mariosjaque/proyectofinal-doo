package doo.sistemaBuses.interfazGrafica;

import doo.sistemaBuses.logicaNegocio.terminalBus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Panel_Fecha extends JPanel{
    private int verificador=1;

    public Panel_Fecha(Panel_fondo panel_fondo,Date Fecha_inicio){
        this.setLayout(null);
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        JTextField texto = new JTextField();
        JLabel print = new JLabel("Ingrese la fecha en la que desea que salga el bus, con el siguiente formato:(dia/mes/año) y presione enter,");
        JLabel print2 = new JLabel( "tambien debe elegir una fecha desde la que abrio el programa hasta pasada 2 semanas.");
        JLabel Bienvenidos = new JLabel();
        ImageIcon bienvenido = new ImageIcon(getClass().getResource("/bienvenido.png"));
        Bienvenidos.setIcon(new ImageIcon(bienvenido.getImage().getScaledInstance(400,200,Image.SCALE_SMOOTH)));
        ImageIcon fondo = new ImageIcon(getClass().getResource("/fondo.jpg"));
        JLabel Fondo = new JLabel();
        Fondo.setIcon(new ImageIcon(fondo.getImage().getScaledInstance(1000,1000,Image.SCALE_SMOOTH)));
        print.setFont(new Font("Serif",Font.BOLD,16));
        print2.setFont(new Font("Serif",Font.BOLD,16));




        print.setForeground(Color.white);
        //Fijar coordenadas
        this.setBounds(0,0,1000,1000);
        print.setBounds(30,250,800,50);
        print2.setBounds(30,270,800,50);
        texto.setBounds(400,400,200,50);
        Bienvenidos.setBounds(300,0,400,200);
        Fondo.setBounds(0,0,1000,1000);


        print.setForeground(Color.black);
        print2.setForeground(Color.black);

        this.add(texto);
        this.add(print);
        this.add(print2);
        this.add(Bienvenidos);
        this.add(Fondo);

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
