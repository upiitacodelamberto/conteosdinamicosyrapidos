package ventanas;

import java.awt.*;
import java.awt.event.*;//1/5 ActionListener, ActionEvent
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class AgregaPartidos implements WindowListener, ActionListener {//// 2/5
																		//// WindowListener,
																		//// ActionListener
	Frame f;
	Dialog D;
	JPanel JP; // ANTES DE USAR JPANEL, INTENTAR USAR EL GridBagLayout
				// DIRECTO sobre este Dialog D. SE USO GridBagLayout sobre Dialog OK.
	JLabel LPartido;
	TextField TFPartido;
	List L;
	JButton BAgregar, BQuitar, BSiguiente;// Se recibiran como argumento en el
											// constructor
	JCheckBox JCBhayCoaliciones;

	public AgregaPartidos(Frame f) {
	//public AgregaPartidos(ContD cd) {
		this.f=f;
		// Se crea un Dialogo modal
		D = new Dialog(f, "CONFIGURACION INICIAL", true);// No existe
															// constructor de
															// Dialog sin
															// argumentos
		D.setLayout(new GridBagLayout());
		GridBagConstraints C = new GridBagConstraints();

		L = new List();
		C.gridx = C.gridy = 0;
		C.gridwidth = 6;
		C.gridheight = 1;
		// La List debe estirarse en ambos sentidos. Ponemos el campo fill.
		C.fill = GridBagConstraints.BOTH;
		C.weighty = 1.0;
		D.add(L, C);// Colocamos la List
		C.weighty = 0.0;

		LPartido = new JLabel("Partido: ");
		C.gridx = 0;
		C.gridy = 1;
		C.gridwidth = C.gridheight = 1;
		D.add(LPartido, C);

		TFPartido = new TextField(50);
		C.gridx = 1; // Columna 1 debe estirarse, le ponemos el weightx
		C.gridy = 1; // Fila 1 no no necesita estirarse, no ponemos weighty
		C.gridwidth = C.gridheight = 1;
		C.weightx = 1.0;
		C.fill = GridBagConstraints.HORIZONTAL;
		D.add(TFPartido, C);
		C.weightx = 0.0;// Restauramos el valor por defecto

		BAgregar = new JButton("Agregar");
		BAgregar.addActionListener(this);// 3/5 ActionListener
		C.gridx = 2;// Columna 2, no necesita estirarse, no ponemos weightx
		C.gridy = 1;// Fila 2, no necesita estirarse, no ponemos weigthy
		C.gridwidth = C.gridheight = 1;
		D.add(BAgregar, C);

		BQuitar = new JButton("Quitar");
		BQuitar.addActionListener(this);
		C.gridx = 3;// Columna 3, no necesita estirarse, no ponemos weightx
		C.gridy = 1;// Fila 1, no necesita estirarse, no ponemos weigthy
		C.gridwidth = C.gridheight = 1;
		D.add(BQuitar, C);

		JCBhayCoaliciones = new JCheckBox("Hay Coaliciones");
		C.gridx = 4;// Columna 4, no necesita estirarse, no ponemos weightx
		C.gridy = 1;// Fila 1, no necesita estirarse, no ponemos weigthy
		C.gridwidth = C.gridheight = 1;
		D.add(JCBhayCoaliciones, C);

		BSiguiente = new JButton("Siguiente");
		BSiguiente.addActionListener(this);//3/5 ActionListener
		C.gridx = 5;// Columna 5, no necesita estirarse, no ponemos weightx
		C.gridy = 1;// Fila 1, no necesita estirarse, no ponemos weigthy
		C.gridwidth = C.gridheight = 1;
		D.add(BSiguiente, C);

		D.addWindowListener(this);// 3/5 WindowListener
		//TFPartido.requestFocus();
	}// end AgregaPartidos()

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
		switch (JOptionPane.showConfirmDialog(null, "Confirma que ha terminado de agregar partidos?")) {// 5/5
																										// WindowListener
		case 0: {
			if(JCBhayCoaliciones.isSelected()){
				String imNam[ ]=L.getItems();
				Dialog dialogo=new VdConf(f,imNam).D;
				D.dispose();
				dialogo.pack();
		    	dialogo.setLocationRelativeTo(null);
		    	dialogo.setVisible(true);
			}else{
				//ADEMAS DE CERRAR EL DIALOGO DE AgregarPartidos AQUI HAY QUE HACER ALGO MAS
				D.dispose();
			}
			D.dispose();
			break;
		} // Cerrar Dialogo (clic en Si)
		case 1: {
			break;
		} // DO NOTHING (clic en No)
		case 2: {
			break;
		} // DO NOTHING (clic en Cancel)
		default:// DO NOTHING (clic en X)
		}
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

	@Override
	public void actionPerformed(ActionEvent e) {// 4/5 ActionListener
		String s;
		int idx;
		if (e.getSource().equals(BAgregar)) {// 5/5 ActionListener
			s = TFPartido.getText();
			L.add(s);
			TFPartido.setText("");
			TFPartido.requestFocus();
		}
		if(e.getSource().equals(BQuitar)){
			//if no item is selected, or if multiple items are selected, -1 is returned
			if((idx=L.getSelectedIndex())!=-1){
				L.remove(idx);
			}
			TFPartido.requestFocus();
		}
		if(e.getSource().equals(BSiguiente)){
			if(JCBhayCoaliciones.isSelected()){
				String imNam[ ]=L.getItems();
				Dialog dialogo=new VdConf(f,imNam).D;
				D.dispose();
				dialogo.pack();
		    	dialogo.setLocationRelativeTo(null);
		    	dialogo.setVisible(true);
			}else{
				//ADEMAS DE CERRAR EL DIALOGO DE AgregarPartidos AQUI HAY QUE HACER ALGO MAS
				D.dispose();
			}
		}
	}// end actionPerformed()

	private static void createAndShowGUI() {
		//AgregaPartidos AP = new AgregaPartidos(new ContD());
		AgregaPartidos AP = new AgregaPartidos(new Frame());
		Dialog dialogo = AP.D;
		AP.D.setSize(800, 300);
		// dialogo.pack();
		dialogo.setLocationRelativeTo(null);
		dialogo.setVisible(true);
	}// end createAndShowGUI()

	public static void main(String[] args) {
		// Schedule a job for the event-dispatching thread:
		// creating and showing this application's GUI.
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}// end main()

}// end class AgregaPartidos
	// Funci�n de densidad de probabilidad de Moyal
	// Distribuci�n de Moyal transformada
	// Distribuci�n Loglogistica, aplicaci�n en Economia: distribuci�n del
	// ingreso
	// Prueba de bondad de ajuste mediante el m�todo de Kolmogorov-Smirnov
	// para ver si una funci�n de distribuci�n de probabiliidad de
	// de la variaciones de amplitud de las se�alespiroel�ctricas
	// Descrita en Massey F. J., 1951, y en Lillie, 1967
	// M�todos no parametricos
	// histograma y estimaciones kernel
	// M�todo de estimaci�n de la densidad kernel
	//
	// Estimaci�n de la densidad mediante Kernel
	// serie de tiempo transformada Y=aZ-b

// HinnesW.W, , Montgomery D. C.,1990
// Tama\~no de muestra N=2809, num de clases \sqrt{N}

// Software STATGRAPHICS permite revisar que tanto se parece una distribuci�n
// teorica

// Se puedendescribir estadisticamente mediante la funci�n de
// densidad/distribuci�n de Moyal con un nivel
// de significancia