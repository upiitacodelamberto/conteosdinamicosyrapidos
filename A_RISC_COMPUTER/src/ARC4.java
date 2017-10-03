//registros + mem principal + alu + mir + memcontrol
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class ARC4 extends Applet implements ActionListener, MouseListener, KeyListener, ItemListener {
    //registros

    private TextField[] registro;
    private Label[] etiqueta;
    private TextField irop, irrd, irop3, irrs1, iri, irrs2, irsimm13;
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
    private Image aluimg;
    //mir y memoria control
    private Button calc;
    private TextField a, amux, b, bmux, c, cmux, rd, wr, alu, cond, jumpaddr, loc;
    private int[][] cs = new int[2048][11];  //memoria de control

    public void init() {
        setLayout(null);
        //registros
        registro = new TextField[38];
        etiqueta = new Label[38];
        irop = new TextField(2);
        irrd = new TextField(2);
        irop3 = new TextField(2);
        irrs1 = new TextField(2);
        iri = new TextField(1);
        irrs2 = new TextField(2);
        irsimm13 = new TextField(4);
        labir = new Label();

        for (int i = 0; i < 38; i++) {
            registro[i] = new TextField(8);
            registro[i].setSize(80, 20);
            etiqueta[i] = new Label();
            etiqueta[i].setSize(40, 20);

        }

        int x = 300;
        int y = 10;
        registro[0].setLocation(x + 0, y + 0);
        registro[1].setLocation(x + 120, y + 0);
        registro[2].setLocation(x + 240, y + 0);
        registro[3].setLocation(x + 360, y + 0);

        etiqueta[0].setText("%r0=");
        etiqueta[0].setLocation(x - 35, y + 0);
        etiqueta[1].setText("%r1=");
        etiqueta[1].setLocation(x + 85, y + 0);
        etiqueta[2].setText("%r2=");
        etiqueta[2].setLocation(x + 205, y + 0);
        etiqueta[3].setText("%r3=");
        etiqueta[3].setLocation(x + 325, y + 0);

        registro[4].setLocation(x + 0, y + 30);
        registro[5].setLocation(x + 120, y + 30);
        registro[6].setLocation(x + 240, y + 30);
        registro[7].setLocation(x + 360, y + 30);

        etiqueta[4].setText("%r4=");
        etiqueta[4].setLocation(x - 35, y + 30);
        etiqueta[5].setText("%r5=");
        etiqueta[5].setLocation(x + 85, y + 30);
        etiqueta[6].setText("%r6=");
        etiqueta[6].setLocation(x + 205, y + 30);
        etiqueta[7].setText("%r7=");
        etiqueta[7].setLocation(x + 325, y + 30);

        registro[8].setLocation(x + 0, y + 60);
        registro[9].setLocation(x + 120, y + 60);
        registro[10].setLocation(x + 240, y + 60);
        registro[11].setLocation(x + 360, y + 60);

        etiqueta[8].setText("%r8=");
        etiqueta[8].setLocation(x - 40, y + 60);
        etiqueta[9].setText("%r9=");
        etiqueta[9].setLocation(x + 80, y + 60);
        etiqueta[10].setText("%r10=");
        etiqueta[10].setLocation(x + 200, y + 60);
        etiqueta[11].setText("%r11=");
        etiqueta[11].setLocation(x + 320, y + 60);

        registro[12].setLocation(x + 0, y + 90);
        registro[13].setLocation(x + 120, y + 90);
        registro[14].setLocation(x + 240, y + 90);
        registro[15].setLocation(x + 360, y + 90);

        etiqueta[12].setText("%r12=");
        etiqueta[12].setLocation(x - 40, y + 90);
        etiqueta[13].setText("%r13=");
        etiqueta[13].setLocation(x + 80, y + 90);
        etiqueta[14].setText("%r14=");
        etiqueta[14].setLocation(x + 200, y + 90);
        etiqueta[15].setText("%r15=");
        etiqueta[15].setLocation(x + 320, y + 90);

        registro[16].setLocation(x + 0, y + 120);
        registro[17].setLocation(x + 120, y + 120);
        registro[18].setLocation(x + 240, y + 120);
        registro[19].setLocation(x + 360, y + 120);

        etiqueta[16].setText("%r16=");
        etiqueta[16].setLocation(x - 40, y + 120);
        etiqueta[17].setText("%r17=");
        etiqueta[17].setLocation(x + 80, y + 120);
        etiqueta[18].setText("%r18=");
        etiqueta[18].setLocation(x + 200, y + 120);
        etiqueta[19].setText("%r19=");
        etiqueta[19].setLocation(x + 320, y + 120);

        registro[20].setLocation(x + 0, y + 150);
        registro[21].setLocation(x + 120, y + 150);
        registro[22].setLocation(x + 240, y + 150);
        registro[23].setLocation(x + 360, y + 150);

        etiqueta[20].setText("%r20=");
        etiqueta[20].setLocation(x - 40, y + 150);
        etiqueta[21].setText("%r21=");
        etiqueta[21].setLocation(x + 80, y + 150);
        etiqueta[22].setText("%r22=");
        etiqueta[22].setLocation(x + 200, y + 150);
        etiqueta[23].setText("%r23=");
        etiqueta[23].setLocation(x + 320, y + 150);

        registro[24].setLocation(x + 0, y + 180);
        registro[25].setLocation(x + 120, y + 180);
        registro[26].setLocation(x + 240, y + 180);
        registro[27].setLocation(x + 360, y + 180);

        etiqueta[24].setText("%r24=");
        etiqueta[24].setLocation(x - 40, y + 180);
        etiqueta[25].setText("%r25=");
        etiqueta[25].setLocation(x + 80, y + 180);
        etiqueta[26].setText("%r26=");
        etiqueta[26].setLocation(x + 200, y + 180);
        etiqueta[27].setText("%r27=");
        etiqueta[27].setLocation(x + 320, y + 180);

        registro[28].setLocation(x + 0, y + 210);
        registro[29].setLocation(x + 120, y + 210);
        registro[30].setLocation(x + 240, y + 210);
        registro[31].setLocation(x + 360, y + 210);

        etiqueta[28].setText("%r28=");
        etiqueta[28].setLocation(x - 40, y + 210);
        etiqueta[29].setText("%r29=");
        etiqueta[29].setLocation(x + 80, y + 210);
        etiqueta[30].setText("%r30=");
        etiqueta[30].setLocation(x + 200, y + 210);
        etiqueta[31].setText("%r31=");
        etiqueta[31].setLocation(x + 320, y + 210);

        registro[32].setLocation(x + 0, y + 270);  //%pc
        registro[33].setLocation(x + 120, y + 240);
        registro[34].setLocation(x + 240, y + 240);
        registro[35].setLocation(x + 360, y + 240);

        etiqueta[32].setText("%tm0=");
        etiqueta[32].setLocation(x - 40, y + 240);
        etiqueta[33].setText("%tm1=");
        etiqueta[33].setLocation(x + 80, y + 240);
        etiqueta[34].setText("%tm2=");
        etiqueta[34].setLocation(x + 200, y + 240);
        etiqueta[35].setText("%tm3=");
        etiqueta[35].setLocation(x + 320, y + 240);

        registro[36].setLocation(x + 0, y + 240);
        registro[37].setLocation(x + 240, y + 270);

        etiqueta[36].setText("%pc=");
        etiqueta[36].setLocation(x - 40, y + 270);
        etiqueta[37].setText("%ir=");
        etiqueta[37].setLocation(x + 200, y + 270);

        irop.setSize(20, 20);
        irop.setLocation(x + 200, y + 320);
        add(irop);
        irrd.setSize(25, 20);
        irrd.setLocation(x + 235, y + 320);
        add(irrd);
        irop3.setSize(25, 20);
        irop3.setLocation(x + 270, y + 320);
        add(irop3);
        irrs1.setSize(25, 20);
        irrs1.setLocation(x + 305, y + 320);
        add(irrs1);
        iri.setSize(20, 20);
        iri.setLocation(x + 340, y + 320);
        add(iri);
        irrs2.setSize(25, 20);
        irrs2.setLocation(x + 370, y + 320);
        add(irrs2);
        irsimm13.setSize(50, 20);
        irsimm13.setLocation(x + 405, y + 320);
        add(irsimm13);

        labir.setLocation(x + 200, y + 300);
        labir.setSize(260, 20);
        labir.setText("op        rd       op3     rs1       i        rs2      simm13");
        add(labir);

        for (int i = 0; i < 38; i++) {
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
            localidad[i].setLocation(15, 400 + (i * 25));
            contenido[i].setLocation(105, 400 + (i * 25));
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
        busa.setLocation(100 + 360, 30 + 400);
        add(busa);
        busa.addKeyListener(this);
        busa.setText("0");

        busb = new TextField(10);
        busb.setSize(80, 20);
        busb.setLocation(200 + 360, 30 + 400);
        add(busb);
        busb.addKeyListener(this);
        busb.setText("0");

        busc = new TextField(10);
        busc.setSize(80, 20);
        busc.setLocation(150 + 360, 180 + 400);
        add(busc);
        busc.setText("0");

        calcular = new Button("Calcular");
        calcular.setSize(70, 30);
        calcular.setLocation(20 + 360, 100 + 400);
        add(calcular);
        calcular.addActionListener(this);

        grupo = new CheckboxGroup();
        chkdec = new Checkbox("Dec", true, grupo);
        chkdec.setSize(50, 20);
        chkdec.setLocation(10 + 360, 10 + 400);
        add(chkdec);
        chkdec.addMouseListener(this);

        chkhex = new Checkbox("Hex", false, grupo);
        chkhex.setSize(50, 20);
        chkhex.setLocation(10 + 360, 40 + 400);
        add(chkhex);
        chkhex.addMouseListener(this);

        op = new Choice();
        op.setLocation(300 + 360, 100 + 400);
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

        aluimg = getImage(getDocumentBase(), "alu.gif");

        //mir y mem control
        //loc 0 lee inst de mem
        cs[0][0] = 32;
        cs[0][1] = 0;
        cs[0][2] = 32;
        cs[0][3] = 0;
        cs[0][4] = 37;
        cs[0][5] = 0;
        cs[0][6] = 1;
        cs[0][7] = 0;
        cs[0][8] = 5;
        cs[0][9] = 0;
        cs[0][10] = 0;
        //loc 1 decode
        cs[1][0] = 0;
        cs[1][1] = 0;
        cs[1][2] = 0;
        cs[1][3] = 0;
        cs[1][4] = 0;
        cs[1][5] = 0;
        cs[1][6] = 0;
        cs[1][7] = 0;
        cs[1][8] = 5;
        cs[1][9] = 7;
        cs[1][10] = 0;
        //addcc
        cs[1600][0] = 0;
        cs[1600][1] = 0;
        cs[1600][2] = 0;
        cs[1600][3] = 0;
        cs[1600][4] = 0;
        cs[1600][5] = 0;
        cs[1600][6] = 0;
        cs[1600][7] = 0;
        cs[1600][8] = 5;
        cs[1600][9] = 5;
        cs[1600][10] = 1602;
        cs[1601][0] = 0;
        cs[1601][1] = 1;
        cs[1601][2] = 0;
        cs[1601][3] = 1;
        cs[1601][4] = 0;
        cs[1601][5] = 1;
        cs[1601][6] = 0;
        cs[1601][7] = 0;
        cs[1601][8] = 3;
        cs[1601][9] = 6;
        cs[1601][10] = 2047;
        cs[1602][0] = 37;
        cs[1602][1] = 0;
        cs[1602][2] = 0;
        cs[1602][3] = 0;
        cs[1602][4] = 33;
        cs[1602][5] = 0;
        cs[1602][6] = 0;
        cs[1602][7] = 0;
        cs[1602][8] = 12;
        cs[1602][9] = 0;
        cs[1602][10] = 0;
        cs[1603][0] = 0;
        cs[1603][1] = 1;
        cs[1603][2] = 33;
        cs[1603][3] = 0;
        cs[1603][4] = 0;
        cs[1603][5] = 1;
        cs[1603][6] = 0;
        cs[1603][7] = 0;
        cs[1603][8] = 3;
        cs[1603][9] = 6;
        cs[1603][10] = 2047;
        //andcc
        cs[1604][0] = 0;
        cs[1604][1] = 0;
        cs[1604][2] = 0;
        cs[1604][3] = 0;
        cs[1604][4] = 0;
        cs[1604][5] = 0;
        cs[1604][6] = 0;
        cs[1604][7] = 0;
        cs[1604][8] = 5;
        cs[1604][9] = 5;
        cs[1604][10] = 1606;
        cs[1605][0] = 0;
        cs[1605][1] = 1;
        cs[1605][2] = 0;
        cs[1605][3] = 1;
        cs[1605][4] = 0;
        cs[1605][5] = 1;
        cs[1605][6] = 0;
        cs[1605][7] = 0;
        cs[1605][8] = 0;
        cs[1605][9] = 6;
        cs[1605][10] = 2047;
        cs[1606][0] = 37;
        cs[1606][1] = 0;
        cs[1606][2] = 0;
        cs[1606][3] = 0;
        cs[1606][4] = 33;
        cs[1606][5] = 0;
        cs[1606][6] = 0;
        cs[1606][7] = 0;
        cs[1606][8] = 11;
        cs[1606][9] = 0;
        cs[1606][10] = 0;
        cs[1607][0] = 0;
        cs[1607][1] = 1;
        cs[1607][2] = 33;
        cs[1607][3] = 0;
        cs[1607][4] = 0;
        cs[1607][5] = 1;
        cs[1607][6] = 0;
        cs[1607][7] = 0;
        cs[1607][8] = 0;
        cs[1607][9] = 6;
        cs[1607][10] = 2047;
        //or
        cs[1608][0] = 0;
        cs[1608][1] = 0;
        cs[1608][2] = 0;
        cs[1608][3] = 0;
        cs[1608][4] = 0;
        cs[1608][5] = 0;
        cs[1608][6] = 0;
        cs[1608][7] = 0;
        cs[1608][8] = 5;
        cs[1608][9] = 5;
        cs[1608][10] = 1610;
        cs[1609][0] = 0;
        cs[1609][1] = 1;
        cs[1609][2] = 0;
        cs[1609][3] = 1;
        cs[1609][4] = 0;
        cs[1609][5] = 1;
        cs[1609][6] = 0;
        cs[1609][7] = 0;
        cs[1609][8] = 1;
        cs[1609][9] = 6;
        cs[1609][10] = 2047;
        cs[1610][0] = 37;
        cs[1610][1] = 0;
        cs[1610][2] = 0;
        cs[1610][3] = 0;
        cs[1610][4] = 33;
        cs[1610][5] = 0;
        cs[1610][6] = 0;
        cs[1610][7] = 0;
        cs[1610][8] = 11;
        cs[1610][9] = 0;
        cs[1610][10] = 0;
        cs[1611][0] = 0;
        cs[1611][1] = 1;
        cs[1611][2] = 33;
        cs[1611][3] = 0;
        cs[1611][4] = 0;
        cs[1611][5] = 1;
        cs[1611][6] = 0;
        cs[1611][7] = 0;
        cs[1611][8] = 1;
        cs[1611][9] = 6;
        cs[1611][10] = 2047;
        //nor
        cs[1624][0] = 0;
        cs[1624][1] = 0;
        cs[1624][2] = 0;
        cs[1624][3] = 0;
        cs[1624][4] = 0;
        cs[1624][5] = 0;
        cs[1624][6] = 0;
        cs[1624][7] = 0;
        cs[1624][8] = 5;
        cs[1624][9] = 5;
        cs[1624][10] = 1626;
        cs[1625][0] = 0;
        cs[1625][1] = 1;
        cs[1625][2] = 0;
        cs[1625][3] = 1;
        cs[1625][4] = 0;
        cs[1625][5] = 1;
        cs[1625][6] = 0;
        cs[1625][7] = 0;
        cs[1625][8] = 2;
        cs[1625][9] = 6;
        cs[1625][10] = 2047;
        cs[1626][0] = 37;
        cs[1626][1] = 0;
        cs[1626][2] = 0;
        cs[1626][3] = 0;
        cs[1626][4] = 33;
        cs[1626][5] = 0;
        cs[1626][6] = 0;
        cs[1626][7] = 0;
        cs[1626][8] = 11;
        cs[1626][9] = 0;
        cs[1626][10] = 0;
        cs[1627][0] = 0;
        cs[1627][1] = 1;
        cs[1627][2] = 33;
        cs[1627][3] = 0;
        cs[1627][4] = 0;
        cs[1627][5] = 1;
        cs[1627][6] = 0;
        cs[1627][7] = 0;
        cs[1627][8] = 2;
        cs[1627][9] = 6;
        cs[1627][10] = 2047;
        //srl
        cs[1688][0] = 0;
        cs[1688][1] = 0;
        cs[1688][2] = 0;
        cs[1688][3] = 0;
        cs[1688][4] = 0;
        cs[1688][5] = 0;
        cs[1688][6] = 0;
        cs[1688][7] = 0;
        cs[1688][8] = 5;
        cs[1688][9] = 5;
        cs[1688][10] = 1690;
        cs[1689][0] = 0;
        cs[1689][1] = 1;
        cs[1689][2] = 0;
        cs[1689][3] = 1;
        cs[1689][4] = 0;
        cs[1689][5] = 1;
        cs[1689][6] = 0;
        cs[1689][7] = 0;
        cs[1680][8] = 4;
        cs[1689][9] = 6;
        cs[1689][10] = 2047;
        cs[1690][0] = 37;
        cs[1690][1] = 0;
        cs[1690][2] = 0;
        cs[1690][3] = 0;
        cs[1690][4] = 33;
        cs[1690][5] = 0;
        cs[1690][6] = 0;
        cs[1690][7] = 0;
        cs[1690][8] = 11;
        cs[1690][9] = 0;
        cs[1690][10] = 0;
        cs[1691][0] = 0;
        cs[1691][1] = 1;
        cs[1691][2] = 33;
        cs[1691][3] = 0;
        cs[1691][4] = 0;
        cs[1691][5] = 1;
        cs[1691][6] = 0;
        cs[1691][7] = 0;
        cs[1691][8] = 4;
        cs[1691][9] = 6;
        cs[1691][10] = 2047;

        //ld
        cs[1792][0] = 0;
        cs[1792][1] = 1;
        cs[1792][2] = 0;
        cs[1792][3] = 1;
        cs[1792][4] = 33;
        cs[1792][5] = 0;
        cs[1792][6] = 0;
        cs[1792][7] = 0;
        cs[1792][8] = 8;
        cs[1792][9] = 5;
        cs[1792][10] = 1794;
        cs[1793][0] = 33;
        cs[1793][1] = 0;
        cs[1793][2] = 33;
        cs[1793][3] = 0;
        cs[1793][4] = 0;
        cs[1793][5] = 1;
        cs[1793][6] = 1;
        cs[1793][7] = 0;
        cs[1793][8] = 5;
        cs[1793][9] = 6;
        cs[1793][10] = 2047;
        cs[1794][0] = 37;
        cs[1794][1] = 0;
        cs[1794][2] = 0;
        cs[1794][3] = 0;
        cs[1794][4] = 33;
        cs[1794][5] = 0;
        cs[1794][6] = 0;
        cs[1794][7] = 0;
        cs[1794][8] = 12;
        cs[1794][9] = 0;
        cs[1794][10] = 0;
        cs[1795][0] = 0;
        cs[1795][1] = 1;
        cs[1795][2] = 33;
        cs[1795][3] = 0;
        cs[1795][4] = 33;
        cs[1795][5] = 0;
        cs[1795][6] = 0;
        cs[1795][7] = 0;
        cs[1795][8] = 8;
        cs[1795][9] = 6;
        cs[1795][10] = 1793;

        //st
        cs[1808][0] = 0;
        cs[1808][1] = 1;
        cs[1808][2] = 0;
        cs[1808][3] = 1;
        cs[1808][4] = 33;
        cs[1808][5] = 0;
        cs[1808][6] = 0;
        cs[1808][7] = 0;
        cs[1808][8] = 8;
        cs[1808][9] = 5;
        cs[1808][10] = 1810;
        cs[1809][0] = 37;
        cs[1809][1] = 0;
        cs[1809][2] = 0;
        cs[1809][3] = 0;
        cs[1809][4] = 37;
        cs[1809][5] = 1;
        cs[1809][6] = 0;
        cs[1809][7] = 0;
        cs[1809][8] = 15;
        cs[1809][9] = 6;
        cs[1809][10] = 40;
        cs[40][0] = 37;
        cs[40][1] = 0;
        cs[40][2] = 0;
        cs[40][3] = 0;
        cs[40][4] = 37;
        cs[40][5] = 0;
        cs[40][6] = 0;
        cs[40][7] = 0;
        cs[40][8] = 15;
        cs[40][9] = 0;
        cs[40][10] = 0;
        cs[41][0] = 37;
        cs[41][1] = 0;
        cs[41][2] = 0;
        cs[41][3] = 0;
        cs[41][4] = 37;
        cs[41][5] = 0;
        cs[41][6] = 0;
        cs[41][7] = 0;
        cs[41][8] = 15;
        cs[41][9] = 0;
        cs[41][10] = 0;
        cs[42][0] = 37;
        cs[42][1] = 0;
        cs[42][2] = 0;
        cs[42][3] = 0;
        cs[42][4] = 37;
        cs[42][5] = 0;
        cs[42][6] = 0;
        cs[42][7] = 0;
        cs[42][8] = 15;
        cs[42][9] = 0;
        cs[42][10] = 0;
        cs[43][0] = 37;
        cs[43][1] = 0;
        cs[43][2] = 0;
        cs[43][3] = 0;
        cs[43][4] = 37;
        cs[43][5] = 0;
        cs[43][6] = 0;
        cs[43][7] = 0;
        cs[43][8] = 15;
        cs[43][9] = 0;
        cs[43][10] = 0;
        cs[444][0] = 33;
        cs[44][1] = 1;
        cs[44][2] = 0;
        cs[44][3] = 1;
        cs[44][4] = 0;
        cs[44][5] = 0;
        cs[44][6] = 0;
        cs[44][7] = 1;
        cs[44][8] = 5;
        cs[44][9] = 6;
        cs[44][10] = 2047;
        cs[1810][0] = 37;
        cs[1810][1] = 0;
        cs[1810][2] = 0;
        cs[1810][3] = 0;
        cs[1810][4] = 33;
        cs[1810][5] = 0;
        cs[1810][6] = 0;
        cs[1810][7] = 0;
        cs[1810][8] = 12;
        cs[1810][9] = 0;
        cs[1810][10] = 0;
        cs[1811][0] = 0;
        cs[1811][1] = 1;
        cs[1811][2] = 33;
        cs[1811][3] = 0;
        cs[1811][4] = 33;
        cs[1811][5] = 0;
        cs[1811][6] = 0;
        cs[1811][7] = 0;
        cs[1811][8] = 8;
        cs[1811][9] = 6;
        cs[1811][10] = 1809;
        //inc pc
        cs[2047][0] = 0;
        cs[2047][1] = 1;
        cs[2047][2] = 33;
        cs[2047][3] = 0;
        cs[2047][4] = 33;
        cs[2047][5] = 0;
        cs[2047][6] = 0;
        cs[2047][7] = 0;
        cs[2047][8] = 8;
        cs[2047][9] = 6;
        cs[2047][10] = 1793;

        a = new TextField(10);
        a.setSize(30, 20);
        a.setLocation(100 + 800, 100 + 480);
        add(a);

        amux = new TextField(1);
        amux.setSize(15, 20);
        amux.setLocation(135 + 800, 100 + 480);
        add(amux);

        b = new TextField(10);
        b.setSize(30, 20);
        b.setLocation(155 + 800, 100 + 480);
        add(b);

        bmux = new TextField(1);
        bmux.setSize(15, 20);
        bmux.setLocation(190 + 800, 100 + 480);
        add(bmux);

        c = new TextField(10);
        c.setSize(30, 20);
        c.setLocation(210 + 800, 100 + 480);
        add(c);

        cmux = new TextField(1);
        cmux.setSize(15, 20);
        cmux.setLocation(245 + 800, 100 + 480);
        add(cmux);

        rd = new TextField(10);
        rd.setSize(15, 20);
        rd.setLocation(265 + 800, 100 + 480);
        add(rd);

        wr = new TextField(10);
        wr.setSize(15, 20);
        wr.setLocation(285 + 800, 100 + 480);
        add(wr);

        alu = new TextField(10);
        alu.setSize(30, 20);
        alu.setLocation(305 + 800, 100 + 480);
        add(alu);

        cond = new TextField(10);
        cond.setSize(15, 20);
        cond.setLocation(340 + 800, 100 + 480);
        add(cond);

        jumpaddr = new TextField(4);
        jumpaddr.setSize(40, 20);
        jumpaddr.setLocation(360 + 800, 100 + 480);
        add(jumpaddr);

        loc = new TextField(4);
        loc.setSize(40, 20);
        loc.setLocation(250 + 800, 60 + 480);
        add(loc);
        loc.setText("0");

        calc = new Button("Ejecuta microinstruccion");
        calc.setSize(150, 40);
        calc.setLocation(300 + 800, 60 + 580);
        add(calc);
        calc.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        //alu
        operacion a1;
        //mir y mem control
        int dirmc;


        //memoria
        if (e.getSource() == read) { //lec a partir de loc especificada
            int auxloc = Integer.valueOf(localidad[0].getText());
            for (int i = 0; i < 10; i++) {
                localidad[i].setText(Integer.toString((i * 4) + auxloc));
                contenido[i].setText(Integer.toString(memoria[(i * 4) + auxloc]));
            }

        } else if (e.getSource() == write) {

            for (int i = 0; i < 10; i++) { //lee todos textfiels y guarda en memoria
                memoria[Integer.valueOf(localidad[i].getText())] = Integer.valueOf(contenido[i].getText());

            }
            //alu

        } else if (e.getSource() == calcular) {
            a1 = new operacion();
        } else if (e.getSource() == calc) {
            dirmc = Integer.parseInt(loc.getText());
            a.setText(Integer.toString(cs[dirmc][0]));
            amux.setText(Integer.toString(cs[dirmc][1]));
            b.setText(Integer.toString(cs[dirmc][2]));
            bmux.setText(Integer.toString(cs[dirmc][3]));
            c.setText(Integer.toString(cs[dirmc][4]));
            cmux.setText(Integer.toString(cs[dirmc][5]));
            rd.setText(Integer.toString(cs[dirmc][6]));
            wr.setText(Integer.toString(cs[dirmc][7]));
            alu.setText(Integer.toString(cs[dirmc][8]));
            cond.setText(Integer.toString(cs[dirmc][9]));
            jumpaddr.setText(Integer.toString(cs[dirmc][10]));
            //1.-clase opir
            opir opir1;
            opir1 = new opir();
            //2.-clase opbusa
            opbusa opbusa1;
            opbusa1 = new opbusa();
            //3.-clase operacion
            operacion operacion1;
            operacion1 = new operacion();
            //4.-clase obbusc
            opbusc opbusc1;
            opbusc1 = new opbusc();
            //5.-clase optarea
            optarea optarea1;
            optarea1 = new optarea();
            //6.-clase opcondicion
        }

    }

    public void paint(Graphics g) {  //dibujo aluimg
        System.out.println("dibuja");
        g.drawImage(aluimg, 100 + 360, 70 + 400, this);
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
        b = new operacion();
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

    class operacion { //alu

        int a, b, c, aux, aux1;

        operacion() {
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
                aux1 = c & 0x00001000;
                if (aux1 == 0x00001000) { //si es negativo llena con 1s a la izq
                    c = c | 0x1111E000;
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

    class opir {

        long aux2;

        opir() {
            //campo op
            aux2 = Long.parseLong(registro[37].getText());
            aux2 = aux2 & 0xc0000000;
            aux2 = aux2 >> 30;
            irop.setText(Long.toString(aux2));
            //campo rd
            aux2 = Long.parseLong(registro[37].getText());
            aux2 = aux2 & 0x3e000000;
            aux2 = aux2 >> 25;
            irrd.setText(Long.toString(aux2));
            //campo op3
            aux2 = Long.parseLong(registro[37].getText());
            aux2 = aux2 & 0x01f80000;
            aux2 = aux2 >> 19;
            irop3.setText(Long.toString(aux2));
            //campo rs1
            aux2 = Long.parseLong(registro[37].getText());
            aux2 = aux2 & 0x0007c000;
            aux2 = aux2 >> 14;
            irrs1.setText(Long.toString(aux2));
            //campo i
            aux2 = Long.parseLong(registro[37].getText());
            aux2 = aux2 & 0x00002000;
            aux2 = aux2 >> 13;
            iri.setText(Long.toString(aux2));
            //campo rs2
            aux2 = Long.parseLong(registro[37].getText());
            aux2 = aux2 & 0x0000001f;
            irrs2.setText(Long.toString(aux2));
        }
    }

    class opbusa {

        opbusa() {
            //verifica amux y coloca valor en busa
            if (amux.getText() == "0") {
                //a de MIR
                busa.setText(registro[Integer.parseInt(a.getText())].getText());
            } else {
                //a de rs1 de %ir
                busa.setText(registro[Integer.parseInt(irrs1.getText())].getText());
            }

        }
    }

    class opbusb {

        opbusb() {
            //verifica bmux y coloca valor en busb
            if (bmux.getText() == "0") {
                //a de MIR
                busb.setText(registro[Integer.parseInt(b.getText())].getText());
            } else {
                //a de rs2 de %ir
                busb.setText(registro[Integer.parseInt(irrs2.getText())].getText());
            }
        }
    }

    class opbusc {

        opbusc() {
            if (cmux.getText() == "0") {
                //c de MIR
                if (rd.getText() == "0") {  //registro <- alu
                    registro[Integer.parseInt(c.getText())].setText(busc.getText());
                } else {  //registro <- mem
                    registro[Integer.parseInt(c.getText())].setText(Integer.toString(memoria[Integer.parseInt(a.getText())]));
                }

            } else {
                //c de rd de %ir
                if (rd.getText() == "0") {  //registro <- alu
                    registro[Integer.parseInt(irrd.getText())].setText(busc.getText());
                } else {  //registro <- mem
                    registro[Integer.parseInt(irrd.getText())].setText(Integer.toString(memoria[Integer.parseInt(a.getText())]));
                }
            }

        }
    }

    class optarea {

        optarea() {
            if (wr.getText() == "1") {  //escribe en memoria busa=dir, busb=dato
                memoria[Integer.parseInt(busa.getText())] = Integer.parseInt(busb.getText());
            }
        }
    }

    class opcondicion {

        opcondicion() {
            
        }
    }
}
