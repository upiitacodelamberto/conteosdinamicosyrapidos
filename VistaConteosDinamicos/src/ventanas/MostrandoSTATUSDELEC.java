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
		if(e.getSource().equals(JBcargarBdCasillas)){//5/5 ActionListener
//			new File("C:\\image\\img1.jpg");
			//La ruta relativa desde el paquete ventanas 
			switch(RUTA_MANUAL){
				case 0:{ 
//				FdCasillas=new File("../../ARCHIVOS_AUXILIARES/CASILLAS_00.csv");
					JFileChooser jfc=new JFileChooser();
					int rv=jfc.showDialog(FdMSDE,"Cargar Base de Casillas");
					if(rv==JFileChooser.APPROVE_OPTION){
						FdCasillas=jfc.getSelectedFile();
						RutaAbsDFdC=FdCasillas.getAbsolutePath();
					}
					break;
				}
				case 1:{
				RutaAbsDFdC="c:/Users/Toshiba/conteosdinamicosyrapidos/VistaConteosDinamicos/ARCHIVOS_AUXILIARES/CASILLAS_00.csv";
//				"C:\Users\Toshiba\conteosdinamicosyrapidos\VistaConteosDinamicos\ARCHIVOS_AUXILIARES"
				break;
				}//case 1;
				default:{
					break;
				}
			}//end switch()
			JCBcasillas.setSelected(true);//AQUI ANTES DE ESTO SE DEBERA CARGAR LA BASE DE CASILLAS
			if((JCBcasillas.isSelected())&&(JCBprep.isSelected())){
				JBconteodinamico.setEnabled(true);
			}
		}
		if(e.getSource().equals(JBcargarPrep)){//5/5 ActionListener
			//La ruta relativa desde el paquete ventanas
				switch(RUTA_MANUAL){
				case 0:{
//					FdCortePREP=new File("../../ARCHIVOS_AUXILIARES/PREP_00.csv");
					JFileChooser jfc_prep=new JFileChooser();
					int rv_prep=jfc_prep.showDialog(FdMSDE,"Cargar PREP");
					if(rv_prep==JFileChooser.APPROVE_OPTION){
						FdCortePREP=jfc_prep.getSelectedFile();
						RutaAbsDFdP=FdCortePREP.getAbsolutePath();
					}
					break;
				}//end case 0:
				case 1:{
					RutaAbsDFdP="c:/Users/Toshiba/conteosdinamicosyrapidos/VistaConteosDinamicos/ARCHIVOS_AUXILIARES/PREP_00.csv";
					break;
				}//end case 1:
			}//end switch()
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
//			A=leerCasillas(RutaAbsDFdC);
			A=leerCasillas(RutaAbsDFdC,7);
//			B=leerCasillas(RutaAbsDFdP);
			B=leePREP(RutaAbsDFdP,7);
			//En el arreglo A se tiene los identificadores de las casillas 
			//asignados en leerCasillas() y ``guardadas'' en el 
			// ArrayList<ventanas.Casilla> ContD.CASILLA. Y el tamanio del arreglo
			//A es la cantidad total de casillas registradas en el PREP, esta 
			//cantidad debe coincidir con ContD.CASILLA.size() 
			//Procedo a calcular el numero de ``clases'' con la regla de Sturges
			System.out.println("B.length="+B.length);
//			System.out.println(ContD.CASILLA.size());
			
			int N=utilitaria.reglaSturges(B.length);
			System.out.println("Cantidad de \"clases\" N="+N);
			//Este numero es la cantidad de clases

			ArrayList<Float>
			LSinter=utilitaria.getLimSupInterv(ContD.CASILLA.size(),N);
			utilitaria.print_array(LSinter);
			
			Object _lsinter[]=LSinter.toArray();
			Float lsinter[]=new Float[_lsinter.length];
			for(int i=0;i<_lsinter.length;i++){
				lsinter[i]=(Float)_lsinter[i];
			}
			utilitaria.print_array(lsinter);

			//Ahora hay que construir otro tipo de arreglo bidimensional 
			//C[][] tal que la primera columna contenga intervalos liminf--limsup
			//y la segunda columna contenga la cantidad de casillas presentes en 
			//"el" corte PREP 
			String C[][]=utilitaria.conca(lsinter, B);
			System.out.println("MostrandoSTATUS utilitaria.print_array_dstr_bid(C):");
			utilitaria.print_array_dstr_bid(C);
//			System.exit(0);
//			String C[][]=utilitaria.conca(A,B);
			MostrandoPREP mp=new MostrandoPREP(C,FdMSDE);
			
			Dialog dialogo=mp.D;
			dialogo.setSize(400,300);
			dialogo.setLocationRelativeTo(null);
			dialogo.setVisible(true);
		}
	}//end actionPerformed() 

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
			System.out.println("TAMANIO DE ARRAY NEGATIVO");
		}
		
		return B;
	}//end leePREP()

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
