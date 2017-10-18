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
import java.util.Random;

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
	final static int RUTA_MANUAL=0;/*1 prueba inicial, 0 prueba actual*/
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
		boolean resultPBA;		/*resultaso de Prueba de Bondad de Ajuste*/
		if(e.getSource().equals(JBcargarBdCasillas)){//5/5 ActionListener
//			new File("C:\\image\\img1.jpg");
			//La ruta relativa desde el paquete ventanas 
//			switch(RUTA_MANUAL){
//				case 0:{ 
////				FdCasillas=new File("../../ARCHIVOS_AUXILIARES/CASILLAS_00.csv");
//			/*ARCHIVO con el que estoy haciendo pruebas:MEX_GOB_2017.csv
//			  en el directorio VistaConteosDinamicos/ARCHIVOS_AUXILIARES*/
					JFileChooser jfc=new JFileChooser();
					int rv=jfc.showDialog(FdMSDE,"Cargar Base de Casillas");
					if(rv==JFileChooser.APPROVE_OPTION){
						FdCasillas=jfc.getSelectedFile();
						RutaAbsDFdC=FdCasillas.getAbsolutePath();
					}
//					break;
//				}
//				case 1:{
//				RutaAbsDFdC="c:/Users/Toshiba/conteosdinamicosyrapidos/VistaConteosDinamicos/ARCHIVOS_AUXILIARES/CASILLAS_00.csv";
////				"C:\Users\Toshiba\conteosdinamicosyrapidos\VistaConteosDinamicos\ARCHIVOS_AUXILIARES"
//				break;
//				}//case 1;
//				default:{
//					break;
//				}
//			}//end switch()
			JCBcasillas.setSelected(true);//AQUI ANTES DE ESTO SE DEBERA CARGAR LA BASE DE CASILLAS
			if((JCBcasillas.isSelected())&&(JCBprep.isSelected())){
				JBconteodinamico.setEnabled(true);
			}
		}
		if(e.getSource().equals(JBcargarPrep)){//5/5 ActionListener
			//La ruta relativa desde el paquete ventanas
//				switch(RUTA_MANUAL){
//				case 0:{
////					FdCortePREP=new File("../../ARCHIVOS_AUXILIARES/PREP_00.csv");
////					/*ARCHIVO con el que estoy haciendo pruebas:MEX_GOB_2017_ordenado_00001_00500.csv
////					  en el directorio VistaConteosDinamicos/ARCHIVOS_AUXILIARES*/
					JFileChooser jfc_prep=new JFileChooser();
					int rv_prep=jfc_prep.showDialog(FdMSDE,"Cargar PREP");
					if(rv_prep==JFileChooser.APPROVE_OPTION){
						FdCortePREP=jfc_prep.getSelectedFile();
						RutaAbsDFdP=FdCortePREP.getAbsolutePath();
					}
//					break;
//				}//end case 0:
//				case 1:{
//					RutaAbsDFdP="c:/Users/Toshiba/conteosdinamicosyrapidos/VistaConteosDinamicos/ARCHIVOS_AUXILIARES/PREP_00.csv";
//					break;
//				}//end case 1:
//			}//end switch()
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
			int N,intCasNExceso;
			ArrayList<Float> LSinter;
			Object _lsinter[];
			Float lsinter[];		/*arrrglo que contiene l_IMITES_s_SUPERIORES_DE_LOS_inter_VALOS_DE_CLASES */
			String C[][];
			int A[]={1,2,3,4,5,6,7,8,9,10};//en int A[] se tienen Ids de casillas? 
			                               //o Ids de candidatos?
			int B[]={1,5,2,4,2,4,4};//en int B[] se tienen Ids de casillas? o de 
			                        //candidatos?
//En lugar de usar estos arreglos, hay que obtenerlos de dos archivos csv:
//Uno casillas_csv y otro corte_prep_csv
//			A=leerCasillas(RutaAbsDFdC);
			A=leerCasillas(RutaAbsDFdC,7);//RutaAbsDDdC:Ruta Absoluta De File de Casillas /*2017.10.10*/  
			//En el arreglo A se tiene los identificadores de las casillas 
			//asignados en leerCasillas() y ``guardadas'' en el 
			// ArrayList<ventanas.Casilla> ContD.CASILLA. Y el tamanio del arreglo
			//A es la cantidad total de casillas registradas en el PREP, esta 
			//cantidad debe coincidir con ContD.CASILLA.size() 
//			B=leerCasillas(RutaAbsDFdP);
			B=leePREP(RutaAbsDFdP,7);//RutaAbsDFdP:Ruta Absoluta De File de PREP /*2017.10.10*/
			//En B se tienen los identificadores de las casillas reportadas al PREP 
			//en el corete PREP que se esta trabajando.
			
			//Procedo a calcular el numero de ``clases'' con la regla de Sturges
			System.out.println("B.length="+B.length);
//			System.out.println(ContD.CASILLA.size());
			
			N=utilitaria.reglaSturges(B.length);
			System.out.println("Cantidad de \"clases\" N="+N);
			//Este numero es la cantidad de clases

			//ArrayList<Float>
			LSinter=utilitaria.getLimSupInterv(ContD.CASILLA.size(),N);
			utilitaria.print_array(LSinter);
			
			//Object 
			//_lsinter[]=LSinter.toArray();
			_lsinter=LSinter.toArray();
			//Float lsinter[]=new Float[_lsinter.length];
			lsinter=new Float[_lsinter.length];
			for(int i=0;i<_lsinter.length;i++){
				lsinter[i]=(Float)_lsinter[i];
			}
			System.out.println("Float lsinter[]");
			utilitaria.print_array(lsinter);

			//Ahora hay que construir otro tipo de arreglo bidimensional 
			//C[][] tal que la primera columna contenga intervalos liminf--limsup
			//y la segunda columna contenga la cantidad de casillas presentes en 
			//"el" corte PREP 
			//String C[][]=utilitaria.conca(lsinter, B);
//			C=utilitaria.conca(lsinter, B);
			MyBin MBin[];
			MBin=new MyBin[lsinter.length];
			for(int i=0;i<MBin.length;i++) {
				MBin[i]=new MyBin();
			}
			C=utilitaria.conca(lsinter,B,MBin);
			/**
			 * 2017.10.17.16.52
			 * Ahora en cada entrada del arreglo MyBin MBin[], en el Vector 
			 * MBin[i].VectorDInt se tienen los enteros identificadores?^{1} de casilla
			 * de las casillas del corte PREP que se utilizaran para prueba de bondad.
			 * 1. Revisar de donde y como se obtienen los enteros que estan en las entradas 
			 *    del arreglo B.	(2017.10.17.16.58)
			 * Ahora, es necesario determinar en cuales bins voy a eliminar casillas 
			 * aleatoriamente. Deberan ser los bins del arreglo MyBin MBin[] en los que 
			 * las longitudes de los vectores MBin[i].VectorDInt sean mayores que la media 
			 * aritmetica de las frecuencias observadas C[:][1], como esta media 
			 * aritmetica se calcula en el metodo 
			 * private boolean hacer_prueba_dbondad(String C[][]) de 
			 * esta misma clase, voy a redefinir ese metodo como
			 * struct boolYprom{boolean ajuste; 
			 * double doubleProm;} hacer_prueba_dbondad(String C[][]);
			 * 
			 * struct boolYprom{boolean ajuste; 
			 * double doubleProm;} puede ser una clase interna.
			 */
			/** 2017.10.10.19.56
			 * String C[][] depende tanto de los limites superiores de los intervalos 
			 * de clases (Float lsinter[];) como de los identificadores de las casillas 
			 * consideradas (int B[];) para llevar a cabo la prueba de bondad de ajuste.
			 * Los limites superiores de los intervalos dependen de la cantidad de clases 
			 * calculadas con el metodo utilitaria.reglaSturges(B.length);, es decir el 
			 * tamanio y contenido de Float lsinter[] depende de el tamanio de B, o sea 
			 * de la cantidas de casillas consideradas para hacer la prueba de bondad de 
			 * ajuste. Lo que quiere decir que debo escribir una funcion que redefina 
			 * el tamanio y contenido de B a fin de poder volver a hacer la prueba de 
			 * bondad de ajuste. Por otra parte, el "nuevo" contenido de B se debe obtener 
			 * de las clases (cuyos limites speriores estan en Float lsinter[]), lo que 
			 * quiere decir que es necesaria una clase para almacenar las casillas que se 
			 * tienen reportadas inicialmente en el corte PREP en los intervalos de clase 
			 * iniciales del corte PREP.   
			 */
			System.out.println("MostrandoSTATUS utilitaria.print_array_dstr_bid(C):");
			utilitaria.print_array_dstr_bid(C);
//			System.exit(0);
//			String C[][]=utilitaria.conca(A,B);
			
//			//ESTA PARTE FUNCIONA CON LOS ARCHIVOS:
//			//MEX_GOB_2017_ordenado_00001_00500.csv y
//			//MEX_GOB_2017.csv
//			MostrandoPREP mp=new MostrandoPREP(C,FdMSDE);
//			
//			Dialog dialogo=mp.D;
//			dialogo.setSize(400,300);
//			dialogo.setLocationRelativeTo(null);
//			dialogo.setVisible(true);
			boolYProm boolYPromD=hacer_prueba_dbondad(C);
			resultPBA=boolYPromD.ajuste;
//			//En el arreglo A se tiene los identificadores de las casillas 
//			//asignados en leerCasillas() y ``guardadas'' en el 
//			// ArrayList<ventanas.Casilla> ContD.CASILLA. Y el tamanio del arreglo
//			//A es la cantidad total de casillas registradas en el PREP, esta 
//			//cantidad debe coincidir con ContD.CASILLA.size()
//				B=leePREP(RutaAbsDFdP,7);
//				//En B se tienen los identificadores de las casillas reportadas al PREP 
//				//en el corte PREP que se esta trabajando.
//			
//				//Procedo a calcular el numero de ``clases'' con la regla de Sturges
//				N=utilitaria.reglaSturges(B.length);
//				LSinter=utilitaria.getLimSupInterv(ContD.CASILLA.size(),N);
//				_lsinter=LSinter.toArray();
//				lsinter=new Float[_lsinter.length];
//				for(int i=0;i<_lsinter.length;i++){
//					lsinter[i]=(Float)_lsinter[i];
//				}
//				//Ahora hay que construir otro tipo de arreglo bidimensional 
//				//C[][] tal que la primera columna contenga intervalos liminf--limsup
//				//y la segunda columna contenga la cantidad de casillas presentes en 
//				//"el" corte PREP 
//				C=utilitaria.conca(lsinter, B);
//			}while((resultPBA=hacer_prueba_dbondad(C))!=true);
			while((!boolYPromD.ajuste)&&(utilitaria.totalDCasillasNBins(MBin)>=30)){
//				/**
//				 * Dado que aun no se cumple la prueba de bondad de ajuste y aun 
//				 * hay >= 30 casillas, procedo a redefinir el arreglo String C[][] 
//				 * que se obtuvo con utilitaria.conca(lsinter, B, MBin); y el arreglo B 
//				 * que se obtuvo con B=leePREP(RutaAbsDFdP,7);
//				 */
//				Pero primero debo retirar las casillas en exceso de los Vectores de 
//				casillas de los Bins en el arreglo MyBin MBin[]
				Random random=new Random();
				for(int i=0;i<MBin.length;i++) {
					if(MBin[i].VectorDInt.size()>boolYPromD.doubleProm) {
						intCasNExceso=getCasNExceso(boolYPromD.doubleProm,MBin[i].VectorDInt);
						while((intCasNExceso--)>0) {
							MBin[i].VectorDInt.remove(random.nextInt(MBin[i].VectorDInt.size()-1)+0);
						}/*En teoria, despues de este while se debe tener que 
						   boolYPromD.doubleProm<=MBin[i].VectorDInt.<=boolYPromD.doubleProm+1*/	
					}//end if()
				}//end for()
				/**
				 * Ahora que ya se han quitado las casillas en exceso, se debe redefinir 
				 * el numero de clases, para ello se debe calcular la cantidad 
				 * de casillas que quedan
				 */
				B=leePREP(MBin);
				N=utilitaria.reglaSturges(B.length);
				//ArrayList<Float>
				LSinter=utilitaria.getLimSupInterv(ContD.CASILLA.size(),N);
				utilitaria.print_array(LSinter);
				//Object 
				//_lsinter[]=LSinter.toArray();
				_lsinter=LSinter.toArray();
				//Float lsinter[]=new Float[_lsinter.length];
				lsinter=new Float[_lsinter.length];
				for(int i=0;i<_lsinter.length;i++){
					lsinter[i]=(Float)_lsinter[i];
				}
				MBin=new MyBin[lsinter.length];
				for(int i=0;i<MBin.length;i++) {
					MBin[i]=new MyBin();
				}
				C=utilitaria.conca(lsinter,B,MBin);
				//Finalmente, volver a hacer la prueba de bondad de ajuste
				boolYPromD=hacer_prueba_dbondad(C);
				resultPBA=boolYPromD.ajuste;
			}//end while()
			System.out.println("SALIMOS DEL while(()&&()), HAY QUE VER"
					+ " CUANTAS CASILLAS QUEDAN!!!");
		}//end if(e.getSource().equals(JBconteodinamico)){//5/5 ActionListener
	}//end actionPerformed() 
//	struct boolYprom{boolean ajuste; 
//	 * double doubleProm;}
	class boolYProm{
		boolean ajuste;
		double doubleProm;
	}
	private int getCasNExceso(double Prom,Vector<Integer> VectorInt) {
		return (int)Math.floor(VectorInt.size()-Prom);
	}

	int[] leerCasillas(String path){
		long count=0;int A[];
		A=new int[1];
		try {
			FileReader fr=new FileReader(new File(path));
			BufferedReader br=new BufferedReader(fr);
			//Tmb se puede instanciar un BufferedReader pasandole como 
			//argumento 'new InputStreamReader(System.in)'
//			while(br.readLine()!=null){
//				count++;
//			}
//			//despues del while en el int count tenemos la cantidad de casillas
//			//(o de candidatos?). En esta prueba espero obtener count=50 y count=20
			count=br.lines().count();//Esta es otra forma de contar las lineas de un 
									 //archivo de texto. 
//System.out.println("if(e.getSource().equal(JBconteodinamico)){: count="+count);
			br.close();fr.close();
			A=new int[(int)count];
			fr=new FileReader(new File(path));
			br=new BufferedReader(fr);
			for(int i=0;i<count;i++){
				A[i]=Integer.parseInt(br.readLine());
			}
			br.close();fr.close();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return A;
	}//end leerCasillas()

	/**
	 * Sobrecargo leerCasillas() (por comodidad) 
	 * @param path
	 * @param rowstoskip debe ser menor que la cantidad de lineas del archivo
	 * @return
	 */
	int[] leerCasillas(String path,int rowstoskip){
		String linea;
		StringTokenizer st;
		long count;
		int A[]=new int[1];
		//Este arreglo, con el tamanio adecuado y las entradas 
		//adecuadas (1,2,3,4,5,...), se podra obtener a traves de la clase 
		//ventanas.utilitaria una vez que se sepa cuantas casillas 
		//se instalaron para la realizacion de una eleccion, lo cual se 
		//procede a determinar a continuaion.
		try{
			FileReader fr=new FileReader(new File(path));
			BufferedReader br=new BufferedReader(fr);
			count=br.lines().count();
			br.close();fr.close();
			A=new int[(int)count-rowstoskip];
			fr=new FileReader(path);br=new BufferedReader(fr);
			for(int i=0;i<rowstoskip;i++){
				br.readLine();
			}//Ahora si el siguiente br.readLine() debe darnos la primera linea del
			 //archivo que corresponde a una casilla registrada en el corte PREP.
			int tamdarr=8;
			String arr[]=new String[tamdarr];
			int id=1;
			while((linea=br.readLine())!=null){
//				System.out.println(linea);
				st=new StringTokenizer(linea, ",");
//				if(id==1){
//			System.out.println(linea);
//			System.out.println("st.countTokens(): "+st.countTokens());
//				}
				for(int i=0;i<tamdarr;i++){
					arr[i]=st.nextToken();
				}
				ContD.CASILLA.add(new Casilla(id,arr[0],
						arr[1],arr[2],arr[3],arr[4],arr[5],
						arr[6],arr[7]));
				id++;
			}//end while()
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}catch(NegativeArraySizeException e){
			System.out.println("TAMANIO DE ARRAY NEGATIVO");
		}
		for(int i=0;i<5;i++){
			System.out.println(ContD.CASILLA.get(i));
		}
		for(int i=1;i<=A.length;i++){
			A[i-1]=i;
		}
		return A;
	}
	int[] leePREP(File FdP){
		int count=0,B[];
		B=new int[1];
		//AQUI VA A SER NECESARIO PROGRAMAR ALGO, AUN NO SE EXACATMENTE QUE.
		return B;
	}
	
	/**
	 * Sobrecargo leePREP() (por comodidad)
	 * @param path
	 * @param rowstoskip
	 * @return
	 */
	int[] leePREP(String path,int rowstoskip){
		String linea;
		StringTokenizer st;
		long count;
		int B[]=new int[1];
		Casilla cdp;/*Casilla de prueba*/
		Casilla ce;/*Casilla encontrada*/
		int cdenc=0;/*cuenta de encontradas*/
		int cbusc=0;/*casillas buscadas*/
		try{
			FileReader fr=new FileReader(new File(path));
			BufferedReader br=new BufferedReader(fr);
			count=br.lines().count();
			br.close();fr.close();
			B=new int[(int)count-rowstoskip];
			fr=new FileReader(path);br=new BufferedReader(fr);
			for(int i=0;i<rowstoskip;i++){
				br.readLine();
			}
			int tamdarr=8;
			String arr[]=new String[tamdarr];
			int id=0;
			while((linea=br.readLine())!=null){
				st=new StringTokenizer(linea, ",");
				for(int i=0;i<tamdarr;i++){
					arr[i]=st.nextToken();
				}
				cdp=new Casilla(id,arr[0],
						arr[1],arr[2],arr[3],arr[4],arr[5],
						arr[6],arr[7]);
				cbusc++;
				for(int i=0;i<ContD.CASILLA.size();i++){
					ce=ContD.CASILLA.get(i);
					if(cdp.comparar(ce)){
						B[id]=ce.IdCasilla;
						cdenc++;
						break;
					}
				}//end for()
				id++;
			}//end while()
			System.out.println("leePREP(): Total de casillas="+ContD.CASILLA.size());
			System.out.println("leePREP(): Se buscaron "+cbusc+" de "+B.length+" casillas");
			System.out.println("leePREP(): Se encontraron "+cdenc+" de "+B.length+" casillas");
		}catch(FileNotFoundException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}catch(NegativeArraySizeException e){
//			System.out.println("TAMANIO DE ARRAY NEGATIVO");
		}
		
		return B;
	}//end leePREP()
	/** 2017.10.17.19.46
	 * Nuevamente Sobrecargo leePREP() (por comodidad)
	 * @param path
	 * @param rowstoskip
	 * @return
	 */
	int[] leePREP(MyBin MBin[]){
//		Recorrer los Vectores de cada Bin y guardar en int B[] los 
//		identificadores de las casillas guardados en ellos.
		int intDimDB,index,B[];
		index=intDimDB=0;
		for(int i=0;i<MBin.length;i++) {/*hago la suma de las casillas que quedaron 
										en todos los Bins*/
			intDimDB+=MBin[i].VectorDInt.size();
		}
		B=new int[intDimDB];
		for(int i=0;i<MBin.length;i++) {
			for(int j=0;j<MBin[i].VectorDInt.size();j++) {
				B[index++]=MBin[i].VectorDInt.get(j);
			}
		}
		return B;
	}
//	//ESTA PARTE FUNCIONA CON LOS ARCHIVOS:
//	//MEX_GOB_2017_ordenado_00001_00500.csv y
//	//MEX_GOB_2017.csv
//	MostrandoPREP mp=new MostrandoPREP(C,FdMSDE);
//	
//	Dialog dialogo=mp.D;
//	dialogo.setSize(400,300);
//	dialogo.setLocationRelativeTo(null);
//	dialogo.setVisible(true);
//	// 
//	//
//	private boolean hacer_prueba_dbondad(String C[][]) {
	private boolYProm hacer_prueba_dbondad(String C[][]) {	
		int tmp[]=new int[C.length];
//		boolean result=false;
		boolYProm boolYPromResult=new boolYProm();
		boolYPromResult.ajuste=false;
		for(int i=0;i<C.length;i++){
			tmp[i]=Integer.parseInt(C[i][1]);
		}
		Thread MyThread=new Thread(new RunnableImplementator(tmp));
		MyThread.start();/*Se muestra un histograma*/
		PruebaBondadAjuste PBA=new PruebaBondadAjuste(tmp);
		boolYPromResult.doubleProm=PBA.FE;
		if(PBA.pruebaCompletada) {
			System.out.println("Estadistico JI cuadrada = "
				+PBA.doubleJIcuad+", en tabla JI cuadrada = "
				+PBA.TablaJIcuad[PBA.intNDIntrvs-1]);
			if(PBA.H0) {
				System.out.println("Las frecuencias SI corresponden a una "
						+"distribucion uniforme.");
//				result=true;
				boolYPromResult.ajuste=true;
			}else{
				System.out.println("Las frecuencias NO corresponden a una "
						+"distribucion uniforme.");
			}
		}else{
			System.out.println("La prueba de bondad de ajuste no se pudo completar!!!");
		}
//		return result;
		return boolYPromResult;
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
/**
 * CIIMAT Centro de Investigacion  ...
 */
