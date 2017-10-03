import java.applet.Applet;
import java.awt.*;
//import java.awt.event.*;

public class rutadato1 extends Applet{
    private TextField [] registro;
    private Label [] etiqueta;

    public void init(){
        setLayout(null);
        registro=new TextField[38];
        etiqueta=new Label[38];
        
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
                         
        for (int i=0;i<38;i++){
            registro[i].setText("00000000");
            add(registro[i]);
            add(etiqueta[i]);
        }
              
        
    }
}
