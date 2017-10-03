/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
//  YA TIENE LAS 16 OPERACIONES, VERIFICADA
/**
 *
 * @author MIGUEL
 */
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class ALU3 extends Applet implements ActionListener, MouseListener, KeyListener, ItemListener {

    private TextField busa, busb, busc;
    private Button calcular;
    private Checkbox chkdec, chkhex;
    private CheckboxGroup grupo;
    private Choice op;
    private Image alu;

    public void init() {
        this.setLayout(null);

        busa = new TextField(10);
        busa.setSize(80, 20);
        busa.setLocation(100, 30);
        add(busa);
        busa.addKeyListener(this);
        busa.setText("0");

        busb = new TextField(10);
        busb.setSize(80, 20);
        busb.setLocation(200, 30);
        add(busb);
        busb.addKeyListener(this);
        busb.setText("0");

        busc = new TextField(10);
        busc.setSize(80, 20);
        busc.setLocation(150, 180);
        add(busc);
        busc.setText("0");

        calcular = new Button("Calcular");
        calcular.setSize(70, 30);
        calcular.setLocation(20, 100);
        add(calcular);
        calcular.addActionListener(this);

        grupo = new CheckboxGroup();
        chkdec = new Checkbox("Dec", true, grupo);
        chkdec.setSize(50, 20);
        chkdec.setLocation(10, 10);
        add(chkdec);
        chkdec.addMouseListener(this);

        chkhex = new Checkbox("Hex", false, grupo);
        chkhex.setSize(50, 20);
        chkhex.setLocation(10, 40);
        add(chkhex);
        chkhex.addMouseListener(this);

        op = new Choice();
        op.setLocation(300, 100);
        op.addItem("andcc (A,B)");
        op.addItem("orcc (A,B)");
        op.addItem("norcc (A,B)");
        op.addItem("addcc (A,B) ");
        op.addItem("srl (A,B) ");
        op.addItem("and (A,B) ");
        op.addItem("or (A,B) ");
        op.addItem("nor (A,B) ");
        op.addItem("add (A,B) ");
        op.addItem("lshift2 (A) ");
        op.addItem("lshift10 (A) ");
        op.addItem("simm13 (A) ");
        op.addItem("sext13 (A) ");
        op.addItem("inc (A) ");
        op.addItem("incpc (A) ");
        op.addItem("rshift5 (A) ");
        add(op);
        op.addItemListener(this);

        alu = getImage(getDocumentBase(), "alu.gif");
   }

    public void paint(Graphics g) {
        System.out.println("dibuja");
        g.drawImage(alu, 100, 70, this);
    }

    public void actionPerformed(ActionEvent e) {
        operacion a;
        if (e.getSource() == calcular) {
            a=new operacion();
            busa.setBackground(Color.red);
        }
    }

    public void mouseClicked(MouseEvent e) {
        int a, b, c;
        if (e.getSource() == chkdec) {
            a = Integer.valueOf(busa.getText(), 16);
            b = Integer.valueOf(busb.getText(), 16);
            c = Integer.valueOf(busc.getText(), 16);
            busa.setText(Integer.toString(a));
            busb.setText(Integer.toString(b));
            busc.setText(Integer.toString(c));
        } else if (e.getSource() == chkhex) {
            a = Integer.parseInt(busa.getText());
            b = Integer.parseInt(busb.getText());
            c = Integer.parseInt(busc.getText());
            busa.setText(Integer.toHexString(a));
            busb.setText(Integer.toHexString(b));
            busc.setText(Integer.toHexString(c));
        }
    }

    public void mouseEntered(MouseEvent e) {
    }

    public void mouseExited(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

    public void itemStateChanged(ItemEvent e) {
        operacion b;
        b=new operacion();
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
        if (e.getSource() == busa) {
            if (chkdec.getState()) {  //decimal
                if ((e.getKeyChar() < '0' || e.getKeyChar() > '9') && e.getKeyChar() != 8) { //8=backspace
                    e.setKeyChar('\0');
                }
            } else {   //hexadecimal
                if ((e.getKeyChar() < 48 || (e.getKeyChar() > 57 && e.getKeyChar() < 65) || (e.getKeyChar() > 70 && e.getKeyChar() < 97) || e.getKeyChar() > 102) && e.getKeyChar() != 8) {
                    e.setKeyChar('\0');
                }
            }
        } else if (e.getSource() == busb) {
            if (chkdec.getState()) {  //decimal
                if ((e.getKeyChar() < '0' || e.getKeyChar() > '9') && e.getKeyChar() != 8) { //8=backspace
                    e.setKeyChar('\0');
                }
            } else {   //hexadecimal
                if ((e.getKeyChar() < 48 || (e.getKeyChar() > 57 && e.getKeyChar() < 65) || (e.getKeyChar() > 70 && e.getKeyChar() < 97) || e.getKeyChar() > 102) && e.getKeyChar() != 8) {
                    e.setKeyChar('\0');
                }
            }
        }
    }

    class operacion{
        int a,b,c,aux,aux1;
        operacion(){
            if (chkdec.getState()) {  //decimal
                a = Integer.parseInt(busa.getText());
                b = Integer.parseInt(busb.getText());
            } else {    //hexadecimal
                a = Integer.valueOf(busa.getText(), 16);
                b = Integer.valueOf(busb.getText(), 16);
            }

            //operacion
            aux = op.getSelectedIndex();
            if (aux == 0) {  //andcc
                c = a & b;
            } else if (aux == 1) { //orcc
                c = a | b;
            } else if (aux == 2) {  //norcc
                c = ~(a | b);
            } else if (aux == 3) {  //addcc
                c = a + b;
            } else if (aux == 4) {  //srl
                c = a >> b;
            } else if (aux == 5) {  //and
                c = a & b;
            } else if (aux == 6) {  //or
                c = a | b;
            } else if (aux == 7) {  //nor
                c = ~(a + b);
            } else if (aux == 8) {  //add
                c = a + b;
            } else if (aux == 9) {  //lshift2
                c = a << 2;
            } else if (aux == 10) {  //lshift10
                c = a << 10;
            } else if (aux == 11) {  //simm13
                c = a & 0x00001FFF;
            } else if (aux == 12) {  //sext13
                c = a & 0x00001FFF;
                aux1= c & 0x00001000;
                if (aux1==0x00001000) { //si es negativo llena con 1s a la izq
                    c=c|0x1111E000;
                }
            } else if (aux == 13) {  //inc
                c = a + 1;
            } else if (aux == 14) {  //incpc
                c = a + 4;
            } else if (aux == 15) {  //rshift5
                c = a >> 5;
            }
            


            //impresion de resultados
            if (chkdec.getState()) {  //decimal
                busa.setText(Integer.toString(a));
                busb.setText(Integer.toString(b));
                busc.setText(Integer.toString(c));
            } else {    //hexadecimal
                busa.setText(Integer.toHexString(a));
                busb.setText(Integer.toHexString(b));
                busc.setText(Integer.toHexString(c));
            }

        }
    }

}
