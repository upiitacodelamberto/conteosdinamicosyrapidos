package ventanas;

import java.awt.*;
import java.awt.event.*;//1/5
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;

public class MostrandoPREP implements WindowListener {//2/5 WindowListener
	private JTable tabla;
	private JScrollPane panelScroll;
	private String titColumna[];
	private String datoColumna[][];
	JPanel JP;
	FileReader FR;
	BufferedReader BR;
	String linea;
	StringTokenizer ST;
	int NumDLinesMinOne;
	Dialog D;
	static final int OPC=1;
	
	public MostrandoPREP(File file,Frame f){
		JP = new JPanel();
		JP.setLayout(new BorderLayout());
		D=new Dialog(f,"Un archivo PREP",true);
		try {
//	FR=new FileReader(file);//Esto se esta haciendo en el meth CreaColumnas()
//	BR = new BufferedReader(FR);//y los meths ContarLineasFile(), CargaDatos()   
			CreaColumnas(file);
			ContarLineasFile(file);
			BR=new BufferedReader(FR);
			CargaDatos(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		tabla = new JTable(datoColumna, titColumna);
		// Aqu� se configuran algunos de los par�metros que permite
		// variar la JTable
		tabla.setShowHorizontalLines(true);
		tabla.setRowSelectionAllowed(true);
		tabla.setColumnSelectionAllowed(true);
		// Cambiamos el color de la zona seleccionada (rojo/blanco)
		tabla.setSelectionForeground(Color.white);
		tabla.setSelectionBackground(Color.red);
		// Incorporamos la tabla a un panel que incorpora ya una barra
		// de desplazamiento, para que la visibilidad de la tabla sea
		// autom�tica
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//ESTO ES PARA QUE SE MUESTRE 
		tabla.doLayout();					//LA BARRA DE DESPLAZAMIENTOHORIZONTAL 
		panelScroll = new JScrollPane(tabla);
		JP.add(panelScroll, BorderLayout.CENTER);
		D.add(JP);
		D.addWindowListener(this);// 3/5 WindowListener
	}//end MostrandoPREP(File,Frame)
	
	public MostrandoPREP(String ARR[][],Frame f){		
		JP = new JPanel();
		JP.setLayout(new BorderLayout());
		D=new Dialog(f,"ARCHIVO OBTENIDO A PARTIR DE CASILLA_00 y PREP_00",true);
		CreaColumnas(ARR);
		NumDLinesMinOne=ARR.length;/*instead of ContarLineasFile(File)*/
		CargaDatos(ARR);
		tabla = new JTable(datoColumna, titColumna);
		tabla.setShowHorizontalLines(true);
		tabla.setRowSelectionAllowed(true);
		tabla.setColumnSelectionAllowed(true);
		
		tabla.setSelectionForeground(Color.white);
		tabla.setSelectionBackground(Color.red);
		
		tabla.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);//ESTO ES PARA QUE SE MUESTRE 
		tabla.doLayout();					//LA BARRA DE DESPLAZAMIENTOHORIZONTAL 
		panelScroll = new JScrollPane(tabla);
		JP.add(panelScroll, BorderLayout.CENTER);
		D.add(JP);
		D.addWindowListener(this);// 3/5 WindowListener
	}//end MostrandoPREP(String[][],Frame)
	
	public void CreaColumnas(File file ) throws IOException {
		FR=new FileReader(file);
		BR = new BufferedReader(FR);
		linea=BR.readLine();
		ST=new StringTokenizer(linea,",");
//		System.out.println("ST.countTokens():"+ST.countTokens());
		titColumna = new String[ST.countTokens()];
		for (int i = 0; i < titColumna.length; i++) {
			titColumna[i] = ST.nextToken();
		}
	}//end CrearColumnas()
	public void CreaColumnas(String C[][]){
		titColumna=new String[C[0].length];
		for (int i=0;i<titColumna.length;i++){
			titColumna[i] = "";
		}
	}//end CrearColumnas(String [][])
	
	public void CargaDatos(File file) throws IOException {
		FR=new FileReader(file);
		BR = new BufferedReader(FR);
		linea=BR.readLine();linea=BR.readLine();
		ST=new StringTokenizer(linea,",");
		datoColumna = new String[NumDLinesMinOne][ST.countTokens()];
//		System.out.println("NumDLinesMinOne:"+NumDLinesMinOne);
//		System.out.println("ST.countTokens():"+ST.countTokens());
		for (int iY = 0; iY < NumDLinesMinOne; iY++) {
			for (int iX = 0; iX < datoColumna[0].length; iX++) {
				datoColumna[iY][iX] = ST.nextToken();
			}
			if((linea=BR.readLine())!=null){
				ST=new StringTokenizer(linea,",");
			}else{
				break;
			}
		}
	}//end CargaDatos()
	public void CargaDatos(String C[][]){
		datoColumna=C;
	}
	void ContarLineasFile(File f) throws IOException{
		int count=0;
		FR=new FileReader(f);
		BR=new BufferedReader(FR);
		while((linea=BR.readLine())!=null){
			count++;
		}
		NumDLinesMinOne=count-1;
	}
	

	@Override
	public void windowActivated(WindowEvent arg0) {// 4/5 WindowListener
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosed(WindowEvent arg0) {// 4/5 WindowListener
		// TODO Auto-generated method stub
	}

	@Override
	public void windowClosing(WindowEvent arg0) {// 4/5 WindowListener
		D.dispose();// 5/5 WindowListener 
		//Detener manualmente la maquina virtual si se esta pronando desde
		//esta misma clase (MostrandoPREP).
	}// end windowClosing()

	@Override
	public void windowDeactivated(WindowEvent arg0) {// 4/5 WindowListener
		// TODO Auto-generated method stub
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {// 4/5 WindowListener
		// TODO Auto-generated method stub
	}

	@Override
	public void windowIconified(WindowEvent arg0) {// 4/5 WindowListener
		// TODO Auto-generated method stub
	}

	@Override
	public void windowOpened(WindowEvent arg0) {// 4/5 WindowListener
		// TODO Auto-generated method stub
	}

	public static void main(String[] args) {
//		JFrame ventana = new JFrame("Un Archivo PREP");
//		ventana.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent evt) {
//				System.exit(0);
//			}
//		});
		switch(OPC){
		case 0:{
			JFileChooser JFC=new JFileChooser();
			int retVal = JFC.showOpenDialog(new JFrame());
			if (retVal == JFileChooser.APPROVE_OPTION) {
				File file = JFC.getSelectedFile();
				MostrandoPREP mp=new MostrandoPREP(file,new Frame());
//			ventana.getContentPane().add(mp.JP,BorderLayout.CENTER );
//		    ventana.setSize( 900,600 );
//		    ventana.setLocationRelativeTo(null);
		    
//		    ventana.setVisible( true );
				Dialog dialogo=mp.D;
				dialogo.setSize(900,600);
				dialogo.setLocationRelativeTo(null);
				dialogo.setVisible(true);
				break;
			}
		 }//end case 0:
		case 1:{
			int A[]={1,2,3,4,5,6,7,8,9,10};
			int B[]={1,5,2,4,2,4,4};
			System.out.print("A: ");
			utilitaria.print_array(A);
			System.out.print("B: ");
			utilitaria.print_array(B);
			System.out.println();
			String C[][]=utilitaria.conca(A,B);
			MostrandoPREP mp=new MostrandoPREP(C,new Frame());
			
			Dialog dialogo=mp.D;
			dialogo.setSize(300,200);
			dialogo.setLocationRelativeTo(null);
			dialogo.setVisible(true);
			break;
		}//end case 1:
		}//end switch()
	}//end main()
}//end class MostrandoPREP
