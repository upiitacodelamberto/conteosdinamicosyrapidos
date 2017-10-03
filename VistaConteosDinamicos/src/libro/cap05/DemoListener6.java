
package libro.cap05;

import java.awt.*;
import java.awt.event.*;

public class DemoListener6 extends Frame
{
	private TextField tf;
	private Label lab;
	
	public DemoListener6()
	{
		super("Key Listener");
		
		// defino el layout principal
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add( new Label("Ingrese Texto:"));
		
		tf= new TextField(15);
		add(tf);
		
		lab=new Label();
		add(lab);
		
		tf.addKeyListener(new EscuchaTecla());
		tf.addActionListener(new EscuchaEnter());

		setSize(350,100);
		setVisible(true);

		// el cursor aparecera por defecto en el TextField
		tf.requestFocus();
		
		addWindowListener(new EscuchaVentana());
	}
	
	class EscuchaEnter implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// tomo el texto ingresado en el TextField
			String texto = tf.getText();
			lab.setText(texto);
			validate();
			
			// lo agrego a la lista
			tf.setText(texto.toUpperCase());
			
			// selecciono todo el texto en el TextField
			tf.selectAll();
			
			// seteo el foco en el TextField
			tf.requestFocus();
		}
	}
	
	class EscuchaTecla implements KeyListener
	{

		public void keyPressed(KeyEvent e)
		{
			char c = e.getKeyChar();
			lab.setText(Character.toString(c));
		}

		public void keyReleased(KeyEvent e)
		{
			// TODO Auto-generated method stub
			
		}

		public void keyTyped(KeyEvent e)
		{
			// TODO Auto-generated method stub
			
		}
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
		new DemoListener6();
	}
}
