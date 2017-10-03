package libro.cap05;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Ventana1 extends Frame
{
	private Button b1,b2,b3;
	
	public Ventana1()
	{
		super("Esta es la Ventana 1");
		setLayout(new FlowLayout( FlowLayout.LEFT) );
		
		b1=new Button("Boton 1");
		b1.addActionListener(new EscuchaBoton());
		add(b1);
		
		b2=new Button("Boton 2");
		b2.addActionListener(new EscuchaBoton());
		add(b2);
		
		b3=new Button("Boton 3");
		b3.addActionListener(new EscuchaBoton());
		add(b3);
		
		
		addWindowListener(new EscuchaVentana());
		
		setSize(300,300);
		setVisible(true);
	}
	
	class EscuchaBoton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Button b = (Button) e.getSource();
			System.out.println("Se presiono: "+b.getLabel());
		}
	}
	
	class EscuchaVentana implements WindowListener
	{

		public void windowActivated(WindowEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		public void windowClosed(WindowEvent e)
		{
			
			// TODO Auto-generated method stub
			
		}

		public void windowClosing(WindowEvent e)
		{
			System.out.println("Se cierra la ventana...");
			setVisible(false);
			dispose();
			System.out.println("Se cerro... bye !");
			
		}

		public void windowDeactivated(WindowEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		public void windowDeiconified(WindowEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		public void windowIconified(WindowEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		public void windowOpened(WindowEvent e)
		{
			// TODO Auto-generated method stub
			
		}
		
	}
	
	public static void main(String[] args)
	{
		Ventana1 v1 = new Ventana1();
	}
}
