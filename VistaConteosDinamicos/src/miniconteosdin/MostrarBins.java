/**
 * MostrarBins.java
 */
package miniconteosdin;
import java.awt.*;
import java.awt.event.*;//1/5 ActionListener,WindowListener
public class MostrarBins extends Frame{
	final static int YOFFSET=20;
	Rectangulo Bin[];
	public static void main(String[] args) {
		Rectangulo Bin[]=new Rectangulo[15];
		Bin[0]=new Rectangulo(new Punto(0,0),new Punto(4,2));
		Bin[1]=new Rectangulo(new Punto(4,0),new Punto(8,2));
		Bin[2]=new Rectangulo(new Punto(8,0),new Punto(12,2));
		Bin[3]=new Rectangulo(new Punto(0,2),new Punto(2,6));
		Bin[4]=new Rectangulo(new Punto(2,2),new Punto(4,6));
		Bin[5]=new Rectangulo(new Punto(4,2),new Punto(8,4));
		Bin[6]=new Rectangulo(new Punto(4,4),new Punto(8,6));
		Bin[7]=new Rectangulo(new Punto(8,2),new Punto(10,6));
		Bin[8]=new Rectangulo(new Punto(10,2),new Punto(12,6));
		Bin[9]=new Rectangulo(new Punto(0,6),new Punto(8,7));
		Bin[10]=new Rectangulo(new Punto(0,7),new Punto(8,8));
		Bin[11]=new Rectangulo(new Punto(8,6),new Punto(12,8));
		Bin[12]=new Rectangulo(new Punto(0,8),new Punto(8,7));
		Bin[13]=new Rectangulo(new Punto(0,9),new Punto(8,10));
		Bin[14]=new Rectangulo(new Punto(8,8),new Punto(12,10));
		new MostrarBins(Bin);
	}
	Frame f;
	public MostrarBins(Rectangulo arr[]){
		Bin=arr;
		setTitle("MostrarBins.class");
		addWindowListener(new WindowAdapter(){//2/5, 3/5 WindowListener
			public void windowClosing(WindowEvent e){//4/5 WindowListener
				System.exit(0);//5/5 WindowListener
			}
		});
		setSize(600, 500+YOFFSET);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void paint(Graphics g){
		for(int i=0;i<Bin.length;i++){
			Bin[i].show(g);
		}
	}
}//end class MostrarBins

class Rectangulo{
	private Punto PuntoSupIzq;
	private Punto PuntoInfDer;
//	public Rectangulo(){ }
	public Rectangulo(Punto supizq,Punto infder){
		PuntoSupIzq=supizq;
		PuntoInfDer=infder;
	}
	public void show(Graphics g){
		g.drawRect(PuntoSupIzq.intX, PuntoSupIzq.intY,
				PuntoInfDer.intX-PuntoSupIzq.intX, PuntoInfDer.intY-PuntoSupIzq.intY);
	}
}//end class Rectangulo

class Punto{
	final static int FACTOR=50;
	int intX;
	int intY;
	public Punto(){
		intX=intY=0;
	}
	public Punto(int intAbsc,int intOrd){
		intX=FACTOR*intAbsc;intY=MostrarBins.YOFFSET+FACTOR*intOrd;
	}
}//end class Punto