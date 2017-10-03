package libro.cap06;

import java.awt.Button;
import java.awt.Choice;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import libro.cap06.VentanaDemora.EscuchaBoton;
import libro.cap06.VentanaDemora.TareaBoton;

public class VentanaDemora0 extends Frame{
	private Button boton;
	private Choice combo;
	
	public VentanaDemora0()
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
			try
			{
				Thread.sleep(10000);
				System.out.println("Termino la espera.... por fin !");
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
	public static void main(String[] args) {
		new VentanaDemora0();
	}

}
