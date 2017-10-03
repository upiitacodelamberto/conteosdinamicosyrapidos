import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

public class objetos extends Applet implements ActionListener {
    private TextField f1;
    private Button b1;
    private Canvas c1;

    public void init(){
        this.setLayout(null);
        f1=new TextField(5);
        b1=new Button("Haz algo");
        c1=new Canvas();

        f1.setSize(50, 20);
        f1.setLocation(100,100);

        b1.setSize(70,30);
        b1.setLocation(100,50);

        c1.setSize(300,300);
        c1.setLocation(0,0);

        add(f1);
        add(b1);
        add(c1);

        b1.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e){
        Graphics g;
        int valor;
        if (e.getSource()==b1){
            g=c1.getGraphics();
            valor=Integer.parseInt(f1.getText());
            if(valor==1){
               
                g.setColor(Color.red);
                g.drawLine(0, 0, 30, 30);
            } else if (valor==0){
                g.setColor(Color.black);
                g.drawLine(30, 0, 30, 30);  
            }

        }

    }
}
