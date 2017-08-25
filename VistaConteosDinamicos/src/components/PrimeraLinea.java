/**
 * 00 PrimeraLinea.java
 */
package components;
import java.awt.*;	/* Frame*/
import java.awt.event.*;//1/5 WindowListener
public class PrimeraLinea extends Frame{
	public static void main(String[] args) {
		new PrimeraLinea();
	}
	public PrimeraLinea(){
		setTitle("Una linea");
		addWindowListener(new WindowAdapter() {//2/5 WindowListener
			public void windowClosing(WindowEvent e){//4/5 
				System.exit(0);//5/5 WindowListener
			}
		});
		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public void paint(Graphics g){
		g.drawLine(0,0,100,100);
	}
}//end class PrimeraLinea
