package libro.cap05;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoListener2 extends Frame
{
	private Button boton;
	
	public DemoListener2()
	{
		super("Demo");
		setLayout(new FlowLayout());
		
		boton = new Button("Boton");
		boton.addActionListener(new EscuchaBoton());
		
		add(boton);
		
		setSize(200,150);
		setVisible(true);
	}
	
	class EscuchaBoton implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// dimension de la ventana
			Dimension dimVentana = getSize();
			
			// dimension de la pantalla
			Dimension dimScreen = getToolkit().getScreenSize();
			
			// nuevas coordenadas (aleatorias) para reubicar la ventana
			int y = (int) (Math.random()*(dimScreen.height-dimVentana.height));
			int x= (int) (Math.random()*(dimScreen.width-dimVentana.width));
			
			// cambio la ubicacion de la ventana
			setLocation(x,y);
		}
	}
	
	public static void main(String[] args)
	{
		new DemoListener2();
	}
}
