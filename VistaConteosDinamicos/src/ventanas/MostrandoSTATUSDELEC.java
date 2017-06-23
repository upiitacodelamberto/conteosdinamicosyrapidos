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

public class MostrandoSTATUSDELEC implements WindowListener,ActionListener{//2/5 WindowListener,ActionListener
	Dialog D;
	FileReader FR;
	BufferedReader BR;
	String linea;
	JLabel DL;
	JCheckBox JCBcasillas,JCBprep;
	JButton JBconteodinamico;
	int cordX=0;
	JButton JBcargarBdCasillas,JBcargarPrep;
	Frame FdMSDE;
	File FdCasillas;
	File FdCortePREP;
	String RutaAbsDFdC,RutaAbsDFdP;
	public MostrandoSTATUSDELEC(File file,Frame f){
		FdMSDE=f;
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
			JCBcasillas.addActionListener(this);//3/5 ActionListener
			
			GBC.gridx=cordX;GBC.gridy=4;GBC.gridwidth=1;GBC.gridheight=1;
			GBC.anchor=GridBagConstraints.WEST;
			D.add(JCBcasillas, GBC);//CHECKBOX CASILLAS CARGADAS
			
			DL=new JLabel(" ");
			GBC.gridx=cordX+1;GBC.gridy=4;GBC.gridwidth=1;GBC.gridheight=1;
			D.add(DL,GBC);
			
			JBcargarBdCasillas=new JButton("Cargar Base de Casillas");
			JBcargarBdCasillas.addActionListener(this);//3/5 ActionListener
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
			JCBprep.addActionListener(this);//3/5 ActionListener
			GBC.gridx=cordX;GBC.gridy=6;GBC.gridwidth=1;GBC.gridheight=1;
			GBC.anchor=GridBagConstraints.WEST;
			D.add(JCBprep, GBC);//CHECKBOX PREP CARGADO
			
			JBcargarPrep=new JButton("Cargar PREP");
			JBcargarPrep.addActionListener(this);//3/5 ActionListener
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
		JBconteodinamico.addActionListener(this);//3/5 ActionListener
		
		DL=new JLabel(" ");
		GBC.gridx=cordX;GBC.gridy=9;GBC.gridwidth=1;GBC.gridheight=1;
		D.add(DL,GBC);//UN ESPACIO
		
		if((!JCBcasillas.isSelected())||(!JCBprep.isSelected())){
			JBconteodinamico.setEnabled(false);
		}
		D.addWindowListener(this);// 3/5 WindowListener
	}//end MostrandoESTATUSDELEC(File,Frame)
	
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
			JCBcasillas.addActionListener(this);//3/5 ActionListener
			GBC.gridx=cordX;GBC.gridy=4;GBC.gridwidth=1;GBC.gridheight=1;
			GBC.anchor=GridBagConstraints.WEST;
			D.add(JCBcasillas, GBC);//CHECKBOX CASILLAS CARGADAS
			
			DL=new JLabel(" ");
			GBC.gridx=cordX+1;GBC.gridy=4;GBC.gridwidth=1;GBC.gridheight=1;
			D.add(DL,GBC);
			
			JBcargarBdCasillas=new JButton("Cargar Base de Casillas");
			JBcargarBdCasillas.addActionListener(this);//3/5 ActionListener
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
			JCBprep.addActionListener(this);//3/5 ActionListener
			GBC.gridx=cordX;GBC.gridy=6;GBC.gridwidth=1;GBC.gridheight=1;
			GBC.anchor=GridBagConstraints.WEST;
			D.add(JCBprep, GBC);//CHECKBOX PREP CARGADO
			
			JBcargarPrep=new JButton("Cargar PREP");
			JBcargarPrep.addActionListener(this);//3/5 ActionListener
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
		JBconteodinamico.addActionListener(this);//3/5 ActionListener
		GBC.gridx=cordX;GBC.gridy=8;GBC.gridwidth=1;GBC.gridheight=1;
		D.add(JBconteodinamico,GBC);
		
		DL=new JLabel(" ");
		GBC.gridx=cordX;GBC.gridy=9;GBC.gridwidth=1;GBC.gridheight=1;
		D.add(DL,GBC);//UN ESPACIO
		
		if((!JCBcasillas.isSelected())||(!JCBprep.isSelected())){
			JBconteodinamico.setEnabled(false);
		}
		D.addWindowListener(this);// 3/5 WindowListener
	}//end MostrandoESTATUSDELEC(Frame)
	
	
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
	
	public void actionPerformed(ActionEvent e){//4/5 ActionListener
		if(e.getSource().equals(JBcargarBdCasillas)){//5/5 ActionListener
//			new File("C:\\image\\img1.jpg");
			//La ruta relativa desde el paquete ventanas 
			FdCasillas=new File("../../ARCHIVOS_AUXILIARES/CASILLAS_00.csv");
			RutaAbsDFdC="c:/Users/Toshiba/conteosdinamicosyrapidos/VistaConteosDinamicos/ARCHIVOS_AUXILIARES/CASILLAS_00.csv";
//			"C:\Users\Toshiba\conteosdinamicosyrapidos\VistaConteosDinamicos\ARCHIVOS_AUXILIARES"
			JCBcasillas.setSelected(true);//AQUI ANTES DE ESTO SE DEBERA CARGAR LA BASE DE CASILLAS
			if((JCBcasillas.isSelected())&&(JCBprep.isSelected())){
				JBconteodinamico.setEnabled(true);
			}
		}
		if(e.getSource().equals(JBcargarPrep)){//5/5 ActionListener
			//La ruta relativa desde el paquete ventanas
			FdCortePREP=new File("../../ARCHIVOS_AUXILIARES/PREP_00.csv");
			RutaAbsDFdP="c:/Users/Toshiba/conteosdinamicosyrapidos/VistaConteosDinamicos/ARCHIVOS_AUXILIARES/PREP_00.csv";
			JCBprep.setSelected(true);//AQUI ANTES DE ESTO SE DEBERA CARGAR LA BASE DEL CORTE DE PREP
			if((JCBcasillas.isSelected())&&(JCBprep.isSelected())){
				JBconteodinamico.setEnabled(true);
			}
		}
		if(e.getSource().equals(JCBcasillas)){//5/5 ActionListener
			if(!JCBcasillas.isSelected()){
				JBconteodinamico.setEnabled(false);
			}
			if((JCBcasillas.isSelected())&&(JCBprep.isSelected())){
				JBconteodinamico.setEnabled(true);
			}
		}
		if(e.getSource().equals(JCBprep)){//5/5 ActionListener
			if(!JCBprep.isSelected()){
				JBconteodinamico.setEnabled(false);
			}
			if((JCBcasillas.isSelected())&&(JCBprep.isSelected())){
				JBconteodinamico.setEnabled(true);
			}
		}
		if(e.getSource().equals(JBconteodinamico)){//5/5 ActionListener
			int A[]={1,2,3,4,5,6,7,8,9,10};//en int A[] se tienen Ids de casillas? 
			                               //o Ids de candidatos?
			int B[]={1,5,2,4,2,4,4};//en int B[] se tienen Ids de casillas? o de 
			                        //candidatos?
//En lugar de usar estos arreglos, hay que obtenerlos de dos archivos csv:
//Uno casillas_csv y otro corte_prep_csv
			A=leerCasillas(RutaAbsDFdC);
//			B=leerPREP(FdCortePREP);
			B=leerCasillas(RutaAbsDFdP);
			
			String C[][]=utilitaria.conca(A,B);
			MostrandoPREP mp=new MostrandoPREP(C,FdMSDE);
			
			Dialog dialogo=mp.D;
			dialogo.setSize(400,300);
			dialogo.setLocationRelativeTo(null);
			dialogo.setVisible(true);
		}
	}//end actionPerformed() 

	int[] leerCasillas(String path){
		int count=0,A[];
		A=new int[1];
		try {
			FileReader fr=new FileReader(new File(path));
			BufferedReader br=new BufferedReader(fr);
			while(br.readLine()!=null){
				count++;
			}
			//despues del while en el int count tenemos la cantidad de casillas
			//(o de candidatos?). En esta prueba espero obtener count=50 y count=20
//System.out.println("if(e.getSource().equal(JBconteodinamico)){: count="+count);
			br.close();fr.close();
			A=new int[count];
			fr=new FileReader(new File(path));
			br=new BufferedReader(fr);
			for(int i=0;i<count;i++){
				A[i]=Integer.parseInt(br.readLine());
			}
			br.close();fr.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return A;
	}

	int[] leePREP(File FdP){
		int count=0,B[];
		B=new int[1];
		//AQUI VA A SER NECESARIO PROGRAMAR ALGO, AUN NO SE EXACATMENTE QUE.
		return B;
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
