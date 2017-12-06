package components;

import java.awt.*;
import java.awt.event.*;
//2017.10.19.15.52
//import com.sun.java.swing.*;
import javax.swing.table.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.*;

//El Modelo de la Tabla es el que controla todos los
//datos que se colocan en ella
class ModeloDatos extends AbstractTableModel {
	Object datos[][] = { { "uno", "dos", "tres", "cuatro","cinco","seis","siete","ocho"}, 
{ "nueve", "diez", "once", "ocho","doce", "trece", "catorce", "quince", "diezyseis"},
{ "diezysite", "diezyocho", "diezynueve", "veinte", "veintiuno", "veintidos", "veintitres", "veinticuatro"},};

	// Esta clase imprime los datos en la consola cada vez
	// que se produce un cambio en cualquiera de las
	// casillas de la tabla
	class TablaListener implements TableModelListener {
		public void tableChanged(TableModelEvent evt) {
			for (int i = 0; i < datos.length; i++) {
				for (int j = 0; j < datos[0].length; j++)
					System.out.print(datos[i][j] + " ");
				System.out.println();
			}
		}
	}

	// Constructor
	ModeloDatos() {
		addTableModelListener(new TablaListener());
	}

	// Devuelve el numero de columnas de la tabla
	public int getColumnCount() {
		return (datos[0].length);
	}

	// Devuelve el numero de filas de la tabla
	public int getRowCount() {
		return (datos.length);
	}

	// Devuelve el valor de una determinada casilla de la tabla
	// identificada mediante fila y columna
	public Object getValueAt(int fila, int col) {
		return (datos[fila][col]);
	}

	// Cambia el valor que contiene una determinada casilla de
	// la tabla
	public void setValueAt(Object valor, int fila, int col) {
		datos[fila][col] = valor;
		// Indica que se ha cambiado
		fireTableDataChanged();
	}

	// Indica si la casilla identificada por fila y columna es
	// editable
	public boolean isCellEditable(int fila, int col) {
		return (true);
	}
}// end class ModeloDatos

public class java1416 extends JPanel {
	public java1416() {
		setLayout(new BorderLayout());
		JTable tabla = new JTable(new ModeloDatos());
		// La tabla se aniade a un ScrollPane para que sea este el
		// que controle automaticamente en tamanio de la tabla,
		// presentando una barra de desplazamiento cuando sea
		// necesario
		JScrollPane panel = new JScrollPane(tabla);
		add(panel, BorderLayout.CENTER);
	}

	public static void main(String args[]) {
		JFrame frame = new JFrame("Tutorial de Java, Swing");
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				System.exit(0);
			}
		});
		frame.getContentPane().add(new java1416(), BorderLayout.CENTER);
		frame.setSize(200, 200);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}//end class java1416
