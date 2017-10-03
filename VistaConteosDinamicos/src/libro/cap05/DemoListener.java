package libro.cap05;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DemoListener extends Frame
{
	private Button boton;
	
	public DemoListener()
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
			System.out.println("Se presiono el boton...");
		}
	}
	
	public static void main(String[] args)
	{
		new DemoListener();
	}
}
