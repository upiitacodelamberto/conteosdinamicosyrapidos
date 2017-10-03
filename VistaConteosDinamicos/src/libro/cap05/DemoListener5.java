
package libro.cap05;

import java.awt.*;
import java.awt.event.*;

public class DemoListener5 extends Frame
{
	private Button bAgregar;
	private TextField tfItem;
	private List lista;
	
	public DemoListener5()
	{
		super("Action Listener");
		
		// defino el layout principal
		setLayout(new BorderLayout());
		
		// al norte
		Panel pn = _crearPNorte();
		add(pn,BorderLayout.NORTH);
		
	   // al centro		
		lista= new List();
		add(lista, BorderLayout.CENTER);
		
		// escucho cuando se cierra la ventana
		this.addWindowListener(new EscuchaVentana());
		bAgregar.addActionListener(new EscuchaAgregar());
		tfItem.addActionListener(new EscuchaAgregar());
		lista.addActionListener(new EscuchaDobleClick());

		setSize(300,300);
		setVisible(true);

		// el cursor aparecera por defecto en el TextField
		tfItem.requestFocus();
	}
	
	private Panel _crearPNorte()
	{
		Panel p = new Panel(new BorderLayout());
		
		p.add(new Label("Item:"),BorderLayout.WEST);
		
		// al este
		bAgregar = new Button("Agregar");
		p.add(bAgregar,BorderLayout.EAST);
		
		// al centro
		tfItem=new TextField();
		
		p.add(tfItem,BorderLayout.CENTER);
				
		return p;
	}
	
	class EscuchaAgregar implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// tomo el texto ingresado en el TextField
			String item = tfItem.getText();
			
			// lo agrego a la lista
			lista.add(item);
			
			// selecciono todo el texto en el TextField
			tfItem.selectAll();
			
			// seteo el foco en el TextField
			tfItem.requestFocus();
		}
	}
	
	class EscuchaDobleClick implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// tomo la posicion del item seleccionado
			int idx = lista.getSelectedIndex();
			
			// seteo el item selecciona en el TextField
			tfItem.setText(lista.getSelectedItem());
			
			// lo remuevo de la lista
			lista.remove(idx);
			
			// selecciono todo el texto del TextField
			tfItem.selectAll();
			
			// seteo el foco en el TextField
			tfItem.requestFocus();
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
		new DemoListener5();
	}
}
