package components;
import java.awt.*;	/* Frame*/
import java.awt.event.*;//1/5 WindowListener
public class PrimerasFiguras extends Frame{
	public static void main(String[] args) {
		new PrimerasFiguras();
	}
	Frame f;
	public PrimerasFiguras(){//Constructor
		setTitle("PrimerasFiguras.class");
		addWindowListener(new WindowAdapter(){//3/5
			public void windowClosing(WindowEvent e){//4/5 WindowListener 
				System.exit(0);//5/5 WindowListener
			}
		});
		setSize(300, 220);
		setLocationRelativeTo(null);
		setVisible(true);
	}//end PrimerasFiguras()
	public void paint(Graphics g){
		//abscisa de EsquinaSupIzq, ordenada de EsquinaSupIzq, anchura, altura
		g.drawRect(30, 30, 80, 40);  
		g.drawOval(120, 30, 50, 50);
		g.setColor(Color.black);
		g.fillRect(30, 100, 80, 40);
		g.fillOval(120, 100, 50, 50);
		g.drawLine(30, 160, 130, 170);
		g.drawArc(30, 180, 50, 50, 60, 40);
		g.fillArc(120, 180, 50, 50, 60, 40);
	}
}//end class PrimerasFiguras