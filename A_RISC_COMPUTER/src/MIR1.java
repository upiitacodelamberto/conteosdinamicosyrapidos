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

public class MIR1 extends Applet {
   
    private TextField a, amux, b, bmux,c,cmux,rd,wr,alu,cond,jumpaddr;
    
    public void init() {
        this.setLayout(null);

        a = new TextField(10);
        a.setSize(30, 20);
        a.setLocation(100, 100);
        add(a);

        amux = new TextField(1);
        amux.setSize(15, 20);
        amux.setLocation(135, 100);
        add(amux);

        b = new TextField(10);
        b.setSize(30, 20);
        b.setLocation(155, 100);
        add(b);

        bmux = new TextField(1);
        bmux.setSize(15, 20);
        bmux.setLocation(190, 100);
        add(bmux);
        
        c = new TextField(10);
        c.setSize(30, 20);
        c.setLocation(210, 100);
        add(c);

        cmux = new TextField(1);
        cmux.setSize(15, 20);
        cmux.setLocation(245, 100);
        add(cmux);

        rd = new TextField(10);
        rd.setSize(15, 20);
        rd.setLocation(265, 100);
        add(rd);

        wr = new TextField(10);
        wr.setSize(15, 20);
        wr.setLocation(285, 100);
        add(wr);

        alu = new TextField(10);
        alu.setSize(30, 20);
        alu.setLocation(305, 100);
        add(alu);

        cond = new TextField(10);
        cond.setSize(15, 20);
        cond.setLocation(340, 100);
        add(cond);

        jumpaddr = new TextField(4);
        jumpaddr.setSize(40, 20);
        jumpaddr.setLocation(360, 100);
        add(jumpaddr);
               


    }
        
    
}
