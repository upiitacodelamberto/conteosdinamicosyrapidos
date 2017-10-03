package libro.cap05.mvc;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class DemoJList extends JFrame
{
	public DemoJList()
	{
		
		
		// sfsfs
		super("Demo JList");
		Container content = getContentPane();
		content.setLayout(new BorderLayout());
		
		
		Object[] datos = _obtenerArrayDatos();
		JList lista = new JList(new ArrayModel(datos));
		
		JScrollPane scrollLista = new JScrollPane(lista);
		
		content.add(scrollLista, BorderLayout.CENTER);
		
		setSize(300,300);
		setVisible(true);
	}

	private Object[] _obtenerArrayDatos()
	{
		Object []arr = {"John Lennon"
				        , "Paul McCartney"
                     ,"George Harrison"
                     ,"Ringo Star"
                     ,"Sandro (Roberto Sanchez"
                     ,"Charly Garcia"
                     ,"Caetano Veloso"};
		return arr;
	}
	
	public static void main(String[] args)
	{
		new DemoJList();
	}
}
