package ventanas;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class myjava1417 {
	private JTable tabla;
	private JScrollPane panelScroll;
	private String titColumna[];
	private String datoColumna[][];
	JPanel JP;

	public myjava1417() {
		JP = new JPanel();
		JP.setLayout(new BorderLayout());
		CreaColumnas();
		CargaDatos();
		// Creamos una instancia del componente Swing
		tabla = new JTable(datoColumna, titColumna);
		// Aqui se configuran algunos de los parametros que permite
		// variar la JTable
		tabla.setShowHorizontalLines(true);
		tabla.setRowSelectionAllowed(true);
		tabla.setColumnSelectionAllowed(true);
		// Cambiamos el color de la zona seleccionada (rojo/blanco)
		tabla.setSelectionForeground(Color.white);
		tabla.setSelectionBackground(Color.red);
		// Incorporamos la tabla a un panel que incorpora ya una barra
		// de desplazamiento, para que la visibilidad de la tabla sea
		// automatica
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//ESTO ES PARA QUE SE MUESTRE 
		tabla.doLayout();					//LA BARRA DE DESPLAZAMIENTOHORIZONTAL 
		panelScroll = new JScrollPane(tabla);
		JP.add(panelScroll, BorderLayout.CENTER);
	}// end myjava1417()

	// Creamos las etiquetas que sirven de titulo a cada una de
	// las columnas de la tabla
	public void CreaColumnas() {
		titColumna = new String[8];
		for (int i = 0; i < 8; i++) {
			titColumna[i] = "Col: " + i;
		}
	}

	// Creamos los datos para cada uno de los elementos de la tabla
	public void CargaDatos() {
		datoColumna = new String[100][8];
		for (int iY = 0; iY < 100; iY++) {
			for (int iX = 0; iX < 8; iX++) {
				datoColumna[iY][iX] = "" + iX + "," + iY;
			}
		}
	}

	public static void main(String args[]) {
		JFrame ventana = new JFrame("Tutorial de Java, Swing");
		ventana.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				System.exit(0);
			}
		});
//		myjava1417 MyJ1417=new myjava1417();
//	    ventana.getContentPane().add( MyJ1417.JP,BorderLayout.CENTER );
		ventana.getContentPane().add(new myjava1417().JP,BorderLayout.CENTER );
	    ventana.setSize( 400,200 );
	    ventana.setLocationRelativeTo(null);
	    
	    ventana.setVisible( true );
	}//end main()
}// end class myjava1417
