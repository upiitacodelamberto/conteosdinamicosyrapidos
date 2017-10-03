package libro.cap05.mvc;

import java.awt.Color;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

public class MatrizModel implements TableModel
{

	private Object[][] datos;
	
	public MatrizModel(Object[][] datos)
	{
		this.datos=datos;
	}

	public int getColumnCount()
	{
		return datos[0].length;
	}

	public String getColumnName(int columnIndex)
	{
		return datos[0][columnIndex].toString();
	}

	public int getRowCount()
	{
		return datos.length-1;
	}

	public Object getValueAt(int rowIndex, int columnIndex)
	{
		return datos[rowIndex+1][columnIndex];
	}

	public boolean isCellEditable(int rowIndex, int columnIndex)
	{
		return false;
	}


	public void setValueAt(Object value, int rowIndex, int columnIndex)
	{
	}

	public Class<?> getColumnClass(int columnIndex)
	{
		// TODO Auto-generated method stub
		return String.class;
	}

	
	public void addTableModelListener(TableModelListener l)
	{
		// TODO Auto-generated method stub
		
	}
	public void removeTableModelListener(TableModelListener l)
	{
		// TODO Auto-generated method stub
		
	}

}
