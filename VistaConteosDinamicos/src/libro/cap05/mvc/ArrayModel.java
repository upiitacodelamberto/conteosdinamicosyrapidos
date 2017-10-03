package libro.cap05.mvc;

import java.util.Vector;

import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class ArrayModel implements ListModel
{
	private Object[] datos;
	
	public ArrayModel(Object[] datos)
	{
		this.datos=datos;
	}
	
	public Object getElementAt(int index)
	{ 
		return datos[index]; 
	}
	
	public int getSize()
	{
		return datos.length;
	}
	
	public void removeListDataListener(ListDataListener l){}		
	public void addListDataListener(ListDataListener l){}
}
