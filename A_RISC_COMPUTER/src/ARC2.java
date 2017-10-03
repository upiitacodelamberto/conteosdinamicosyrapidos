//registros + mem principal + alu
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class ARC2 extends Applet implements ActionListener, MouseListener, KeyListener, ItemListener{
    //registros
    private TextField [] registro;
    private Label [] etiqueta;
    private TextField irop,irrd,irop3,irrs1,iri,irrs2,irsimm13;
    private Label labir;
    //memoria principal
    private TextField[] localidad, contenido;
    private Integer memoria[];
    private Button read, write;
    //alu
    private TextField busa, busb, busc;
    private Button calcular;
    private Checkbox chkdec, chkhex;
    private CheckboxGroup grupo;
    private Choice op;
    private Image alu;

    public void init(){
        setLayout(null);
        //registros
        registro=new TextField[38];
        etiqueta=new Label[38];
        irop=new TextField(2);
        irrd=new TextField(2);
        irop3=new TextField(2);
        irrs1=new TextField(2);
        iri=new TextField(1);
        irrs2=new TextField(2);
        irsimm13=new TextField(4);
        labir=new  Label();
        
        for (int i=0;i<38;i++){
            registro[i]=new TextField(8);
            registro[i].setSize(80,20);
            etiqueta[i]=new Label();
            etiqueta[i].setSize(40,20);

        }
        
        int x=300;
        int y=10;
        registro[0].setLocation(x+0,y+0);
        registro[1].setLocation(x+120,y+0);
        registro[2].setLocation(x+240,y+0);
        registro[3].setLocation(x+360,y+0);

        etiqueta[0].setText("%r0=");
        etiqueta[0].setLocation(x-35,y+0);
        etiqueta[1].setText("%r1=");
        etiqueta[1].setLocation(x+85,y+0);
        etiqueta[2].setText("%r2=");
        etiqueta[2].setLocation(x+205,y+0);
        etiqueta[3].setText("%r3=");
        etiqueta[3].setLocation(x+325,y+0);

        registro[4].setLocation(x+0,y+30);
        registro[5].setLocation(x+120,y+30);
        registro[6].setLocation(x+240,y+30);
        registro[7].setLocation(x+360,y+30);

        etiqueta[4].setText("%r4=");
        etiqueta[4].setLocation(x-35,y+30);
        etiqueta[5].setText("%r5=");
        etiqueta[5].setLocation(x+85,y+30);
        etiqueta[6].setText("%r6=");
        etiqueta[6].setLocation(x+205,y+30);
        etiqueta[7].setText("%r7=");
        etiqueta[7].setLocation(x+325,y+30);

        registro[8].setLocation(x+0,y+60);
        registro[9].setLocation(x+120,y+60);
        registro[10].setLocation(x+240,y+60);
        registro[11].setLocation(x+360,y+60);

        etiqueta[8].setText("%r8=");
        etiqueta[8].setLocation(x-40,y+60);
        etiqueta[9].setText("%r9=");
        etiqueta[9].setLocation(x+80,y+60);
        etiqueta[10].setText("%r10=");
        etiqueta[10].setLocation(x+200,y+60);
        etiqueta[11].setText("%r11=");
        etiqueta[11].setLocation(x+320,y+60);

        registro[12].setLocation(x+0,y+90);
        registro[13].setLocation(x+120,y+90);
        registro[14].setLocation(x+240,y+90);
        registro[15].setLocation(x+360,y+90);

        etiqueta[12].setText("%r12=");
        etiqueta[12].setLocation(x-40,y+90);
        etiqueta[13].setText("%r13=");
        etiqueta[13].setLocation(x+80,y+90);
        etiqueta[14].setText("%r14=");
        etiqueta[14].setLocation(x+200,y+90);
        etiqueta[15].setText("%r15=");
        etiqueta[15].setLocation(x+320,y+90);

        registro[16].setLocation(x+0,y+120);
        registro[17].setLocation(x+120,y+120);
        registro[18].setLocation(x+240,y+120);
        registro[19].setLocation(x+360,y+120);

        etiqueta[16].setText("%r16=");
        etiqueta[16].setLocation(x-40,y+120);
        etiqueta[17].setText("%r17=");
        etiqueta[17].setLocation(x+80,y+120);
        etiqueta[18].setText("%r18=");
        etiqueta[18].setLocation(x+200,y+120);
        etiqueta[19].setText("%r19=");
        etiqueta[19].setLocation(x+320,y+120);

        registro[20].setLocation(x+0,y+150);
        registro[21].setLocation(x+120,y+150);
        registro[22].setLocation(x+240,y+150);
        registro[23].setLocation(x+360,y+150);

        etiqueta[20].setText("%r20=");
        etiqueta[20].setLocation(x-40,y+150);
        etiqueta[21].setText("%r21=");
        etiqueta[21].setLocation(x+80,y+150);
        etiqueta[22].setText("%r22=");
        etiqueta[22].setLocation(x+200,y+150);
        etiqueta[23].setText("%r23=");
        etiqueta[23].setLocation(x+320,y+150);

        registro[24].setLocation(x+0,y+180);
        registro[25].setLocation(x+120,y+180);
        registro[26].setLocation(x+240,y+180);
        registro[27].setLocation(x+360,y+180);

        etiqueta[24].setText("%r24=");
        etiqueta[24].setLocation(x-40,y+180);
        etiqueta[25].setText("%r25=");
        etiqueta[25].setLocation(x+80,y+180);
        etiqueta[26].setText("%r26=");
        etiqueta[26].setLocation(x+200,y+180);
        etiqueta[27].setText("%r27=");
        etiqueta[27].setLocation(x+320,y+180);

        registro[28].setLocation(x+0,y+210);
        registro[29].setLocation(x+120,y+210);
        registro[30].setLocation(x+240,y+210);
        registro[31].setLocation(x+360,y+210);

        etiqueta[28].setText("%r28=");
        etiqueta[28].setLocation(x-40,y+210);
        etiqueta[29].setText("%r29=");
        etiqueta[29].setLocation(x+80,y+210);
        etiqueta[30].setText("%r30=");
        etiqueta[30].setLocation(x+200,y+210);
        etiqueta[31].setText("%r31=");
        etiqueta[31].setLocation(x+320,y+210);

        registro[32].setLocation(x+0,y+270);  //%pc
        registro[33].setLocation(x+120,y+240);
        registro[34].setLocation(x+240,y+240);
        registro[35].setLocation(x+360,y+240);

        etiqueta[32].setText("%tm0=");
        etiqueta[32].setLocation(x-40,y+240);
        etiqueta[33].setText("%tm1=");
        etiqueta[33].setLocation(x+80,y+240);
        etiqueta[34].setText("%tm2=");
        etiqueta[34].setLocation(x+200,y+240);
        etiqueta[35].setText("%tm3=");
        etiqueta[35].setLocation(x+320,y+240);

        registro[36].setLocation(x+0,y+240);
        registro[37].setLocation(x+240,y+270);

        etiqueta[36].setText("%pc=");
        etiqueta[36].setLocation(x-40,y+270);
        etiqueta[37].setText("%ir=");
        etiqueta[37].setLocation(x+200,y+270);

        irop.setSize(20,20);
        irop.setLocation(x+200,y+320);
        add(irop);
        irrd.setSize(25,20);
        irrd.setLocation(x+235,y+320);
        add(irrd);
        irop3.setSize(25,20);
        irop3.setLocation(x+270,y+320);
        add(irop3);
        irrs1.setSize(25,20);
        irrs1.setLocation(x+305,y+320);
        add(irrs1);
        iri.setSize(20,20);
        iri.setLocation(x+340,y+320);
        add(iri);
        irrs2.setSize(25,20);
        irrs2.setLocation(x+370,y+320);
        add(irrs2);
        irsimm13.setSize(50,20);
        irsimm13.setLocation(x+405,y+320);
        add(irsimm13);

        labir.setLocation(x+200,y+300);
        labir.setSize(260,20);
        labir.setText("op        rd       op3     rs1       i        rs2      simm13");
        add(labir);
        
        for (int i=0;i<38;i++){
            registro[i].setText("00000000");
            add(registro[i]);
            add(etiqueta[i]);
        }

        //memoria principal
        localidad = new TextField[10];
        contenido = new TextField[10];
        memoria = new Integer[4096];

        setLayout(null);

        for (int i = 0; i < 10; i++) {   //textfields de mem principal
            localidad[i] = new TextField(8);
            localidad[i].setSize(80, 20);
            contenido[i] = new TextField(8);
            contenido[i].setSize(80, 20);
        }

        for (int i = 0; i < 10; i++) {   //textfields de mem principal
            localidad[i].setLocation(15, 400+(i * 25));
            contenido[i].setLocation(105, 400+(i * 25));
            add(localidad[i]);
            add(contenido[i]);
        }


        for (int i = 0; i < 4096; i++) {  //inicializacion memoria
            memoria[i] = 0;
        }

        for (int i = 0; i < 10; i++) {  //despliegue de memoria principal
            localidad[i].setText(Integer.toString(i * 4));
            contenido[i].setText(Integer.toString(memoria[i * 4]));
        }

        read = new Button("R");   //boton lectura memoria principal
        read.setSize(80, 20);
        read.setLocation(15, 650);
        add(read);
        read.addActionListener(this);

        write = new Button("W");   //boton escritura memoria principal
        write.setSize(80, 20);
        write.setLocation(105, 650);
        add(write);
        write.addActionListener(this);

        //alu
         busa = new TextField(10);
        busa.setSize(80, 20);
        busa.setLocation(100+360, 30+400);
        add(busa);
        busa.addKeyListener(this);
        busa.setText("0");

        busb = new TextField(10);
        busb.setSize(80, 20);
        busb.setLocation(200+360, 30+400);
        add(busb);
        busb.addKeyListener(this);
        busb.setText("0");

        busc = new TextField(10);
        busc.setSize(80, 20);
        busc.setLocation(150+360, 180+400);
        add(busc);
        busc.setText("0");

        calcular = new Button("Calcular");
        calcular.setSize(70, 30);
        calcular.setLocation(20+360, 100+400);
        add(calcular);
        calcular.addActionListener(this);

        grupo = new CheckboxGroup();
        chkdec = new Checkbox("Dec", true, grupo);
        chkdec.setSize(50, 20);
        chkdec.setLocation(10+360, 10+400);
        add(chkdec);
        chkdec.addMouseListener(this);

        chkhex = new Checkbox("Hex", false, grupo);
        chkhex.setSize(50, 20);
        chkhex.setLocation(10+360, 40+400);
        add(chkhex);
        chkhex.addMouseListener(this);

        op = new Choice();
        op.setLocation(300+360, 100+400);
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

    public void actionPerformed(ActionEvent e) {
        //alu
        operacion a;

        //memoria
        if (e.getSource() == read) { //lec a partir de loc especificada
            int auxloc = Integer.valueOf(localidad[0].getText());
            for (int i = 0; i < 10; i++) {
                localidad[i].setText(Integer.toString((i*4) + auxloc));
                contenido[i].setText(Integer.toString(memoria[(i*4) + auxloc]));
            }

        } else if (e.getSource() == write) {

            for (int i = 0; i < 10; i++){ //lee todos textfiels y guarda en memoria
                memoria[Integer.valueOf(localidad[i].getText())]= Integer.valueOf(contenido[i].getText());

            }
        //alu

        } else if (e.getSource() == calcular) {
            a=new operacion();
        }

    }


     public void paint(Graphics g) {  //dibujo alu
        System.out.println("dibuja");
        g.drawImage(alu, 100+360, 70+400, this);
    }

    public void mouseClicked(MouseEvent e) {
        //alu
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
        //alu
        operacion b;
        b=new operacion();
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
        if (e.getSource() == busa) {  //alu
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

    class operacion{ //alu
        int a,b,c,aux,aux1;
        operacion(){
            if (chkdec.getState()) {  //decimal
                a = Integer.parseInt(busa.getText());
                b = Integer.parseInt(busb.getText());
            } else {    //hexadecimal
                a = Integer.valueOf(busa.getText(), 16);
                b = Integer.valueOf(busb.getText(), 16);
            }

            //operacion alu
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



            //impresion de resultados alu
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
