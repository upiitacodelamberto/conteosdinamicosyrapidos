package libro.cap06;

import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaDemora extends Frame
{
	private Button boton;
	private Choice combo;
	
	public VentanaDemora()
	{
		setLayout(new FlowLayout());
		add( boton = new Button("Esto va a demorar...") );
		boton.addActionListener(new EscuchaBoton());
		
		add( combo = new Choice() );
		combo.addItem("Item 1");
		combo.addItem("Item 2");
		combo.addItem("Item 3");
		
		setSize(300,300);
		setVisible(true);
	}
	
	class EscuchaBoton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
         boton.setEnabled(false);
         TareaBoton t = new TareaBoton();
         t.start();
		}
	}
	
	// thread
	class TareaBoton extends Thread
	{
		public void run()
		{
			try
			{
				Thread.sleep(10000);
				System.out.println("Termino la espera.... por fin !");
				boton.setEnabled(true);
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
	
	public static void main(String[] args)
	{
		new VentanaDemora();
	}
}



