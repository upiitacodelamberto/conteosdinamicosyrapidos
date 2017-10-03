package libro.cap05;

import java.awt.Frame;
import java.awt.event.*;

public class DemoListener4 extends Frame
{
	public DemoListener4()
	{
		super("Demo");

		addWindowListener(new EscuchaVentana());
		
		setSize(200,150);
		setVisible(true);
	}

	class EscuchaVentana implements WindowListener
	{

		public void windowClosing(WindowEvent e)
		{
			System.out.println("oculto...");
			setVisible(false);
			
			System.out.println("Libero...");
			dispose();
			
			System.out.println("Bye bye...");
			System.exit(0);
		}
		
		public void windowActivated(WindowEvent e){}
		public void windowClosed(WindowEvent e){}
		public void windowDeactivated(WindowEvent e){}
		public void windowDeiconified(WindowEvent e){}
		public void windowIconified(WindowEvent e){}
		public void windowOpened(WindowEvent e){}
	}
	
	public static void main(String[] args)
	{
		new DemoListener4();
	}
}
