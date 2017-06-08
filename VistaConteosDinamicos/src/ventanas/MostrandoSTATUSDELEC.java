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

public class MostrandoSTATUSDELEC implements WindowListener {//2/5
	Dialog D;
	FileReader FR;
	BufferedReader BR;
	String linea;
	JLabel DL;
	JCheckBox JCBcasillas,JCBprep;
	JButton JBconteodinamico;
	int cordX=0;
	JButton JBcargarBdCasillas,JBcargarPrep;
	public MostrandoSTATUSDELEC(File file,Frame f){
		D=new Dialog(f,"MOSTRANDO STATUS DE ELECCION",true);
		D.setLayout(new GridBagLayout());
		GridBagConstraints GBC=new GridBagConstraints();
		DL=new JLabel(" ");
		GBC.gridx=0;GBC.gridy=1;GBC.gridwidth=GBC.gridheight=1;
		D.add(DL,GBC);//UN ESPACIO EN EL GridBagLayout
		
		try {
			FR=new FileReader(file);
			BR = new BufferedReader(FR);
			linea=BR.readLine();
			DL=new JLabel(linea);
			GBC.gridx=cordX;GBC.gridy=2;GBC.gridwidth=1;GBC.gridheight=1;
			GBC.anchor=GridBagConstraints.WEST;
			D.add(DL, GBC);//NOMBRE DE LA ELECCION
			
			DL=new JLabel(" ");
			GBC.gridx=cordX;GBC.gridy=3;GBC.gridwidth=1;GBC.gridheight=1;
			D.add(DL,GBC);//UN ESPACIO
			
			linea=BR.readLine();
			int N=Integer.parseInt(linea);
			if(N==1){
				JCBcasillas=new JCheckBox("BASE DE CASILLAS CARGADA", true);
			}else{
				JCBcasillas=new JCheckBox("BASE DE CASILLAS CARGADA", false);
			}
			GBC.gridx=cordX;GBC.gridy=4;GBC.gridwidth=1;GBC.gridheight=1;
			GBC.anchor=GridBagConstraints.WEST;
			D.add(JCBcasillas, GBC);//CHECKBOX CASILLAS CARGADAS
			
			DL=new JLabel(" ");
			GBC.gridx=cordX+1;GBC.gridy=4;GBC.gridwidth=1;GBC.gridheight=1;
			D.add(DL,GBC);
			
			JBcargarBdCasillas=new JButton("Cargar Base de Casillas");
			GBC.gridx=cordX+2;GBC.gridy=4;GBC.gridwidth=1;GBC.gridheight=1;
			D.add(JBcargarBdCasillas,GBC);
			
			DL=new JLabel(" ");
			GBC.gridx=cordX;GBC.gridy=5;GBC.gridwidth=1;GBC.gridheight=1;
			D.add(DL,GBC);//UN ESPACIO
			
			linea=BR.readLine();
			N=Integer.parseInt(linea);
			if(N==1){
				JCBprep=new JCheckBox("PREP CARGADO", true);
			}else{
				JCBprep=new JCheckBox("PREP CARGADO", false);
			}
			GBC.gridx=cordX;GBC.gridy=6;GBC.gridwidth=1;GBC.gridheight=1;
			GBC.anchor=GridBagConstraints.WEST;
			D.add(JCBprep, GBC);//CHECKBOX PREP CARGADO
			
			JBcargarPrep=new JButton("Cargar PREP");
			GBC.gridx=cordX+2;GBC.gridy=6;GBC.gridwidth=1;GBC.gridheight=1;
			GBC.anchor=GridBagConstraints.WEST;
			D.add(JBcargarPrep,GBC);
		}catch (Exception e) {
			e.printStackTrace();
		}
		DL=new JLabel(" ");
		GBC.gridx=cordX;GBC.gridy=7;GBC.gridwidth=1;GBC.gridheight=1;
		D.add(DL,GBC);//UN ESPACIO
		
		JBconteodinamico=new JButton("REALIZAR CONTEO DINAMICO");
		GBC.gridx=cordX;GBC.gridy=8;GBC.gridwidth=1;GBC.gridheight=1;
		D.add(JBconteodinamico,GBC);
		
		DL=new JLabel(" ");
		GBC.gridx=cordX;GBC.gridy=9;GBC.gridwidth=1;GBC.gridheight=1;
		D.add(DL,GBC);//UN ESPACIO
		
		D.addWindowListener(this);// 3/5 WindowListener
	}//end MostrandoESTATUSDELEC()
	
	public MostrandoSTATUSDELEC(Frame f){
		D=new Dialog(f,"MOSTRANDO STATUS DE ELECCION",true);
		D.setLayout(new GridBagLayout());
		GridBagConstraints GBC=new GridBagConstraints();
		DL=new JLabel(" ");
		GBC.gridx=0;GBC.gridy=1;GBC.gridwidth=GBC.gridheight=1;
		D.add(DL,GBC);//UN ESPACIO EN EL GridBagLayout
		
		try {
//			FR=new FileReader(file);
//			BR = new BufferedReader(FR);
//			linea=BR.readLine();
			
			DL=new JLabel("NOMBRE DE LA ELECCION");
			GBC.gridx=cordX;GBC.gridy=2;GBC.gridwidth=1;GBC.gridheight=1;
			GBC.anchor=GridBagConstraints.WEST;
			D.add(DL, GBC);//NOMBRE DE LA ELECCION
			
			DL=new JLabel(" ");
			GBC.gridx=cordX;GBC.gridy=3;GBC.gridwidth=1;GBC.gridheight=1;
			D.add(DL,GBC);//UN ESPACIO
			
//			linea=BR.readLine();
//			int N=Integer.parseInt(linea);
//			if(N==1){
//				JCBcasillas=new JCheckBox("BASE DE CASILLAS CARGADA", true);
//			}else{
				JCBcasillas=new JCheckBox("BASE DE CASILLAS CARGADA", false);
//			}
			GBC.gridx=cordX;GBC.gridy=4;GBC.gridwidth=1;GBC.gridheight=1;
			GBC.anchor=GridBagConstraints.WEST;
			D.add(JCBcasillas, GBC);//CHECKBOX CASILLAS CARGADAS
			
			DL=new JLabel(" ");
			GBC.gridx=cordX+1;GBC.gridy=4;GBC.gridwidth=1;GBC.gridheight=1;
			D.add(DL,GBC);
			
			JBcargarBdCasillas=new JButton("Cargar Base de Casillas");
			GBC.gridx=cordX+2;GBC.gridy=4;GBC.gridwidth=1;GBC.gridheight=1;
			D.add(JBcargarBdCasillas,GBC);
			
			DL=new JLabel(" ");
			GBC.gridx=cordX;GBC.gridy=5;GBC.gridwidth=1;GBC.gridheight=1;
			D.add(DL,GBC);//UN ESPACIO
			
//			linea=BR.readLine();
//			N=Integer.parseInt(linea);
//			if(N==1){
//				JCBprep=new JCheckBox("PREP CARGADO", true);
//			}else{
				JCBprep=new JCheckBox("PREP CARGADO", false);
//			}
			GBC.gridx=cordX;GBC.gridy=6;GBC.gridwidth=1;GBC.gridheight=1;
			GBC.anchor=GridBagConstraints.WEST;
			D.add(JCBprep, GBC);//CHECKBOX PREP CARGADO
			
			JBcargarPrep=new JButton("Cargar PREP");
			GBC.gridx=cordX+2;GBC.gridy=6;GBC.gridwidth=1;GBC.gridheight=1;
			GBC.anchor=GridBagConstraints.WEST;
			D.add(JBcargarPrep,GBC);
		}catch (Exception e) {
			e.printStackTrace();
		}
		DL=new JLabel(" ");
		GBC.gridx=cordX;GBC.gridy=7;GBC.gridwidth=1;GBC.gridheight=1;
		D.add(DL,GBC);//UN ESPACIO
		
		JBconteodinamico=new JButton("REALIZAR CONTEO DINAMICO");
		GBC.gridx=cordX;GBC.gridy=8;GBC.gridwidth=1;GBC.gridheight=1;
		D.add(JBconteodinamico,GBC);
		
		DL=new JLabel(" ");
		GBC.gridx=cordX;GBC.gridy=9;GBC.gridwidth=1;GBC.gridheight=1;
		D.add(DL,GBC);//UN ESPACIO
		
		D.addWindowListener(this);// 3/5 WindowListener
	}//end MostrandoESTATUSDELEC()
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
		JFileChooser JFC=new JFileChooser();
		int retVal = JFC.showOpenDialog(new JFrame());
		if (retVal == JFileChooser.APPROVE_OPTION) {
			File file = JFC.getSelectedFile();
			MostrandoSTATUSDELEC mp=new MostrandoSTATUSDELEC(file,new Frame());

			Dialog dialogo=mp.D;
			dialogo.setSize(400,200);
			dialogo.setLocationRelativeTo(null);
			dialogo.setVisible(true);
		}
	}//end main()
}//end class MostrandoSTATUSDELEC
