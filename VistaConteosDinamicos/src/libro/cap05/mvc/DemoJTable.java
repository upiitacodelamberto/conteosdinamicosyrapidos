package libro.cap05.mvc;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DemoJTable extends JFrame
{
	public DemoJTable()
	{
		// sfsfs
		super("Demo JList");
		Container content = getContentPane();
		content.setLayout(new BorderLayout());
		
		
		Object[][] datos = _obtenerArrayDatos();
		JTable tabla= new JTable(new MatrizModel(datos));
		
		JScrollPane scrollLista = new JScrollPane(tabla);
		
		content.add(scrollLista, BorderLayout.CENTER);
		
		setSize(300,300);
		setVisible(true);
	}

	private Object[][] _obtenerArrayDatos()
	{
		Object [][]mat = {
				{ "Colum 0" , "Colum 1"  , "Colum 2" , "Colum 3" }
			  ,{ "Rojo"    , "Verde"    , "Azul"    , "Violeta" }
			  ,{ "Amarillo", "Naranja"  , "Blanco"  , "Griz"    }
			  ,{ "Negro"   , "Turqueza" , "Sepia"   , "Rosa"    }
			  ,{ "Salmon"  , "Maiz"     , "Marron"  , "Fucsia"  }			  
		};
		return mat;
	}
	
	public static void main(String[] args)
	{
		new DemoJTable();
	}
}
