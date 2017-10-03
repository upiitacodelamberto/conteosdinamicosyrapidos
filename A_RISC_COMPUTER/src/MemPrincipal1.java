/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MIGUEL
 */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class MemPrincipal1 extends Applet implements ActionListener {

    private TextField[] localidad, contenido;
    private Integer memoria[];
    private Button read, write;

    public void init() {
        localidad = new TextField[10];
        contenido = new TextField[10];
        memoria = new Integer[4096];

        setLayout(null);

        for (int i = 0; i < 10; i++) {
            localidad[i] = new TextField(8);
            localidad[i].setSize(80, 20);
            contenido[i] = new TextField(8);
            contenido[i].setSize(80, 20);
        }

        for (int i = 0; i < 10; i++) {
            localidad[i].setLocation(0, i * 25);
            contenido[i].setLocation(90, i * 25);
            add(localidad[i]);
            add(contenido[i]);
        }


        for (int i = 0; i < 4096; i++) {  //inicializacion memoria
            memoria[i] = 0;
        }

        for (int i = 0; i < 10; i++) {  //despliegue de memoria en textfield
            localidad[i].setText(Integer.toString(i * 1));
            contenido[i].setText(Integer.toString(memoria[i * 1]));
        }

        read = new Button("R");
        read.setSize(100, 50);
        read.setLocation(250, 40);
        add(read);
        read.addActionListener(this);

        write = new Button("W");
        write.setSize(100, 50);
        write.setLocation(250, 100);
        add(write);
        write.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == read) { //lec a partir de loc especificada
            int auxloc = Integer.valueOf(localidad[0].getText());
            for (int i = 0; i < 10; i++) {
                localidad[i].setText(Integer.toString((i*1) + auxloc));
                contenido[i].setText(Integer.toString(memoria[(i*1) + auxloc]));
            }

        } else if (e.getSource() == write) {

            for (int i = 0; i < 10; i++){ //lee todos textfiels y guarda en memoria
                memoria[Integer.valueOf(localidad[i].getText())]= Integer.valueOf(contenido[i].getText());
                
            }

        }
    }
}
