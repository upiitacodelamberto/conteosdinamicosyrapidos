package ventanas;
/**
 * 
 * @author Beto
 * ContD: Conteos Dinámicos
 */
import java.awt.*;
import java.awt.event.*;//1/5 ActionListener
import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class ContD implements ActionListener{ //2/5 ActionListener
	Frame F;
	MenuBar MB;
	static TextArea TA;
	Menu M,MCasillas,MPREP;/*Menus M, MenuCasillas, MenuPREP*/
 	MenuItem MIconfiguracion;
	MenuItem MIcargarEleccion;
	MenuItem MIeditarEleccion;
	MenuItem MIguardarEleccion;
	
	MenuItem MIcargarCasillas;
//	static List nombDCoalicion;
	static ArrayList<Coalicion> COAL;
	static ArrayList<Coalicion> PARTIDO;
	public ContD(){
//		nombDCoalicion=new List();
		COAL=new ArrayList<Coalicion>();
		PARTIDO=new ArrayList<Coalicion>();
		F = new Frame("CONTEOS DINAMICOS");
		MB = new MenuBar();
//		MB.setFont(new Font("Arial",Font.PLAIN,20));
		F.setMenuBar(MB);
//		F.setFont(new Font("Arial",Font.PLAIN,20));
		F.setLayout(new BorderLayout());
		TA = new TextArea();
		F.add(TA, BorderLayout.CENTER);
		F.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				switch(JOptionPane.showConfirmDialog(null, "Confirma que desea salir de la Aplicación?")){
				case 0:{System.gc();F.dispose();System.exit(0);break;}//Salir (clic en Si)
				case 1:{break;}//DO NOTHING (clic en No)
				case 2:{break;}//DO NOTHING (clic en Cancel)
				default://DO NOTHING (clic en X)
				}
			}//end windowClosing()
		});
		M = new Menu("ELECCION");
//		M.setFont(new Font("Arial",Font.PLAIN,20));
		MB.add(M);
		M.addSeparator();
		MIconfiguracion = new MenuItem("CREAR ELECCION");
		MIconfiguracion.addActionListener(this);// 3/5 ActionListener
		M.add(MIconfiguracion);
		M.addSeparator();
		MIcargarEleccion=new MenuItem("CARGAR ELECCION");
		MIcargarEleccion.addActionListener(this);// 3/5 ActionListener
		M.add(MIcargarEleccion);
		M.addSeparator();
		MIeditarEleccion=new MenuItem("EDITAR ELECCION");
		MIeditarEleccion.addActionListener(this);// 3/5 ActionListener
		M.add(MIeditarEleccion);
		M.addSeparator();
		MIguardarEleccion=new MenuItem("GUARDAR ELECCION");
		MIguardarEleccion.addActionListener(this);// 3/5 ActionListener
		M.add(MIguardarEleccion);
		
		MCasillas=new Menu("CASILLAS");
		MB.add(MCasillas);
		
		MPREP=new Menu("PREP");
		MB.add(MPREP);
		
		F.setSize(800, 300);
		//F.setLocationRelativeTo(null);
		F.setResizable(false);
		//F.setVisible(true);
	}//end ContD()
	
	public void actionPerformed(ActionEvent e){// 4/5 ActionListener
		if(e.getSource().equals(MIconfiguracion)){// 5/5 ActionListener
//			String tmp=ContD.TA.getText();
			ContD.TA.setText("");
			ContD.COAL.clear();
			ContD.PARTIDO.clear();
			JOptionPane.showMessageDialog(null, "POR AHORA SOLO ESTOY BORRANDO "
					+ "EL TEXTO EN ContD.TA, Cont.COAL.clear(), ContD.PARTIDO.clear(), PERO "
					+ "SEGURO HABRA QUE HACER ALGO DIFERENTE!!!");
			String nombdelec=JOptionPane.showInputDialog("Nombre de la elección");
			if(nombdelec!=null){
//				tmp+=nombdelec;
//				ContD.TA.setText("NOMBRE DE ELECCION: "+tmp);
				ContD.TA.setText("NOMBRE DE ELECCION: "+nombdelec);
				AgregaPartidos ap=new AgregaPartidos(F);
				Dialog dialogo=ap.D;
				//dialogo.pack();
				dialogo.setSize(800, 300);
				dialogo.setLocationRelativeTo(null);
				dialogo.setVisible(true);
			}
			//ap.TFPartido.requestFocus();
		}
	}
	 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
    	ContD contd=new ContD();
    	//contd.F.pack();
    	contd.F.setLocationRelativeTo(null);
    	contd.F.setVisible(true);
    }//end createAndShowGUI()
	
	public static void main(String[] args) {
		//new ContD();
		//Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}//end main()
}//end class ContD
//40 diputaciones,
//16 delegaciones
//1 jefatura de gobierno de la CDMX
//En Edo. Mex. candidatos al gobierno del estado:
//PRI: Alfredo Del Mazo Maza
//MORENA: Delfina Gomez
//PAN: Josefina Vazquez Mota
//En cada eleccion se sabra con semanas de anticipacion 
//Cuantos partidos politicos, cuales partidos politicos, cuantas coaliciones y los partidos integrantes de las 