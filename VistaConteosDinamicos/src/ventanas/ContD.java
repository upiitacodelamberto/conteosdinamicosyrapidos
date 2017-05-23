package ventanas;

/**
 * 
 * @author Beto
 * ContD: Conteos Dinámicos
 */
import java.awt.*;
import java.awt.event.*;//1/5 ActionListener
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class ContD implements ActionListener { // 2/5 ActionListener
	Frame F;
	MenuBar MB;
	static JTextArea TA;
	Menu M, MCasillas, MPREP;/* Menus M, MenuCasillas, MenuPREP */
	MenuItem MIconfiguracion;
	MenuItem MIcargarEleccion;
	MenuItem MIeditarEleccion;
	MenuItem MIguardarEleccion;

	MenuItem MIcargarCasillas;
	// static List nombDCoalicion;
	static ArrayList<Coalicion> COAL;
	static ArrayList<Coalicion> PARTIDO;
	PanelPartidOCoalicion ppc[];
	static ArrayList<String> PartCand;
//	ArrayList<String> PartCand;
	static String NombDEleccion;
	
	static private final String newline = "\n";
	JFileChooser JFC;
	static String LogoDPartOCoal[]={
			"images/coalicion_1_1.gif","images/teresa_1_1.gif",
//			"images/middle.gif","images/teresa.gif",
			"images/morena_1_1.gif","images/pan_1_1.gif",
			"images/prd_1_1.gif","images/pt_1_1.gif"
	};

	public ContD() {
		// nombDCoalicion=new List();
		COAL = new ArrayList<Coalicion>();
		PARTIDO = new ArrayList<Coalicion>();
		PartCand=new ArrayList<String>();
		F = new Frame("CONTEOS DINAMICOS");
		MB = new MenuBar();
		// MB.setFont(new Font("Arial",Font.PLAIN,20));
		F.setMenuBar(MB);
		// F.setFont(new Font("Arial",Font.PLAIN,20));
		F.setLayout(new BorderLayout());
		TA = new JTextArea();
		JScrollPane TAScrollPane=new JScrollPane(TA);
		//F.add(TA, BorderLayout.CENTER);
		F.add(TAScrollPane, BorderLayout.CENTER);
		F.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				switch (JOptionPane.showConfirmDialog(null, "Confirma que desea salir de la Aplicación?")) {
				case 0: {
					System.gc();
					F.dispose();
					System.exit(0);
					break;
				} // Salir (clic en Si)
				case 1: {
					break;
				} // DO NOTHING (clic en No)
				case 2: {
					break;
				} // DO NOTHING (clic en Cancel)
				default:// DO NOTHING (clic en X)
				}
			}// end windowClosing()
		});
		JFC = new JFileChooser();
		M = new Menu("ELECCION");
		// M.setFont(new Font("Arial",Font.PLAIN,20));
		MB.add(M);
		M.addSeparator();
		MIconfiguracion = new MenuItem("CREAR ELECCION");
		MIconfiguracion.addActionListener(this);// 3/5 ActionListener
		M.add(MIconfiguracion);
		M.addSeparator();
		MIcargarEleccion = new MenuItem("CARGAR ELECCION");
		MIcargarEleccion.addActionListener(this);// 3/5 ActionListener
		M.add(MIcargarEleccion);
		M.addSeparator();
		MIeditarEleccion = new MenuItem("EDITAR ELECCION");
		MIeditarEleccion.addActionListener(this);// 3/5 ActionListener
		M.add(MIeditarEleccion);
		M.addSeparator();
		MIguardarEleccion = new MenuItem("GUARDAR ELECCION");
		MIguardarEleccion.addActionListener(this);// 3/5 ActionListener
		M.add(MIguardarEleccion);

		MCasillas = new Menu("CASILLAS");
		MB.add(MCasillas);

		MPREP = new Menu("PREP");
		MB.add(MPREP);

		F.setSize(800, 300);
		// F.setLocationRelativeTo(null);
		F.setResizable(false);
		// F.setVisible(true);
	}// end ContD()

	public void actionPerformed(ActionEvent e) {// 4/5 ActionListener
		String LogoPartCand[]; //Array de tamanio 3:
		                       //Indice a Logotipo de Part/Coal,
		                       //Nombre de Part/Coal, Nombre de Candidato(a)
		ImageIcon ImagIcon;
		JButton Boton;
		StringTokenizer ST;
		if (e.getSource().equals(MIconfiguracion)) {// 5/5 ActionListener
			// String tmp=ContD.TA.getText();
			ContD.TA.setText("");
			ContD.COAL.clear();
			ContD.PARTIDO.clear();
			JOptionPane.showMessageDialog(null,
					"POR AHORA SOLO ESTOY BORRANDO "
							+ "EL TEXTO EN ContD.TA, Cont.COAL.clear(), ContD.PARTIDO.clear(), PERO "
							+ "SEGURO HABRA QUE HACER ALGO DIFERENTE!!!");
			String nombdelec = JOptionPane.showInputDialog("Nombre de la elección");
			if (nombdelec != null) {
				// tmp+=nombdelec;
				// ContD.TA.setText("NOMBRE DE ELECCION: "+tmp);
				ContD.TA.setText("NOMBRE DE ELECCION: " + nombdelec);
				AgregaPartidos ap = new AgregaPartidos(F);
				Dialog dialogo = ap.D;
				// dialogo.pack();
				dialogo.setSize(800, 300);
				dialogo.setLocationRelativeTo(null);
				dialogo.setVisible(true);
			}
			// ap.TFPartido.requestFocus();
		}
		// Handle open button action.
		if (e.getSource() == MIcargarEleccion) {// 5/5 ActionListener
			// int returnVal = JFC.showOpenDialog(FileChooserDemo.this);
			int returnVal = JFC.showOpenDialog(F);
			LogoPartCand=new String[3];
			PartCand.clear();

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = JFC.getSelectedFile();
				// This is where a real application would open the file.
				// log.append("Opening: " + file.getName() + "." + newline);
				try {
					FileReader FR = new FileReader(file);
					BufferedReader BR = new BufferedReader(FR);
					String linea;
					TA.setText("");
					NombDEleccion=BR.readLine();//La primera linea del archivo 
					                            //en el que se guarda una eleccion
					                            //debe contener el nombre de la eleccion.
					TA.append(NombDEleccion + "\n");
					while ((linea = BR.readLine()) != null) {
						TA.append(linea + "\n");
						PartCand.add(linea);//En este ArrayList estoy guardando las lineas (a 
						//partir de la segunda) del archivo que contiene la eleccion. El 
						//formato en que deberan estar ``escritas'' estas lineas es:
						//<LogoDPartidoIndex>&<Nombre de Partido/Coalicion>&Nombre de Candidato
					}   // end while()
//System.out.println("PartCand.size()="+PartCand.size());
					ppc=new PanelPartidOCoalicion[PartCand.size()];
					for(int i=0;i<ppc.length;i++){
						ST=new StringTokenizer(PartCand.get(i),"&");
						LogoPartCand[0]=ST.nextToken();
						LogoPartCand[1]=ST.nextToken();
						LogoPartCand[2]=ST.nextToken();
						ImagIcon=PanelPartidOCoalicion.createImageIcon(LogoDPartOCoal[i]);
//System.out.println(ImagIcon.getIconWidth()+" x "+ImagIcon.getIconHeight());
						Boton=new JButton(ImagIcon);
//						Boton.setSize(100, 100);
						ppc[i]=new PanelPartidOCoalicion(Boton,LogoPartCand[1],
								LogoPartCand[2],PanelPartidOCoalicion.LONGI);
					}
					MostrandoElec MosElec=new MostrandoElec(F,NombDEleccion,ppc);
					//POR FIN, AHORA HAY QUE CREAR UN ARCHIVO DE ELECCION CON 
					//EL FORMATO IMPLICITAMENTE AQUI ARRIBA DEFINIDO PARA PROBAR
					//(2017.05.16.17.11)
					Dialog dialogo=MosElec.getDialog();
					dialogo.pack();
					dialogo.setLocationRelativeTo(null);
					dialogo.setVisible(true);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else {
				TA.append("Comando ABRIR ELECCION cancelado por el usuario." + newline);
			}
			TA.setCaretPosition(TA.getDocument().getLength());

			// Handle save button action.
		} else if (e.getSource() == MIguardarEleccion) {// 5/5 ActionListener
			// int returnVal = JFC.showSaveDialog(FileChooserDemo.this);
			int returnVal = JFC.showSaveDialog(F);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = JFC.getSelectedFile();
				// This is where a real application would save the file.
				// log.append("Saving: " + file.getName() + "." + newline);
				try {
					FileOutputStream FOS = new FileOutputStream(file);
					PrintWriter PW = new PrintWriter(FOS);
					PW.write(TA.getText());
					PW.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				TA.setText("ELECCION GUARDADA EN EL ARCHIVO "+file.getName()+newline);
			} else {
				TA.append("Comando GUARDAR ELECCION cancelado por el usuario." + newline);
			}
			TA.setCaretPosition(TA.getDocument().getLength());
		}
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	private static void createAndShowGUI() {
		// Create and set up the window.
		ContD contd = new ContD();
		// contd.F.pack();
		contd.F.setLocationRelativeTo(null);
		contd.F.setVisible(true);
	}// end createAndShowGUI()

	public static void main(String[] args) {
		// new ContD();
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}// end main()
}// end class ContD
	// 40 diputaciones,
	// 16 delegaciones
	// 1 jefatura de gobierno de la CDMX
	// En Edo. Mex. candidatos al gobierno del estado:
	// PRI-PVEM-PANAL-PES: Alfredo Del Mazo Maza
	// MORENA: Delfina Gomez Alvarez
	// PAN: Josefina Vazquez Mota
	// PT: Oscar Gonzalez
	// PRD: Juan Zepeda
	// Candidata Independiente: Teresa Castel
	// En cada eleccion se sabra con semanas de anticipacion
	// Cuantos partidos politicos, cuales partidos politicos, cuantas
	// coaliciones y los partidos integrantes de las