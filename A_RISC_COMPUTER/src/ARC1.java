//registros + mem principal
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;


public class ARC1 extends Applet implements ActionListener{
    //registros
    private TextField [] registro;
    private Label [] etiqueta;
    private TextField irop,irrd,irop3,irrs1,iri,irrs2,irsimm13;
    private Label labir;
    //memoria principal
    private TextField[] localidad, contenido;
    private Integer memoria[];
    private Button read, write;


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
        
    }

    public void actionPerformed(ActionEvent e) {
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

        }
    }


}
