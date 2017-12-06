package ventanas;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ventana {
	JFrame JF;
	JTextArea areaTexto;
	JButton boton1,boton2,boton3,boton4;
	JTextField campoTexto;
	
	public Ventana(){
		JF=new JFrame("Ejemplo 1");
//		JF.getContentPane().setLayout(new GridBagLayout());
		JF.setLayout(new GridBagLayout());
		
		areaTexto=new JTextArea("Area texto");
		GridBagConstraints gbRestriccion=new GridBagConstraints();
		gbRestriccion.gridx=0;// Columna 0. No necesita estirarse, no ponemos weightx
		gbRestriccion.gridy=0;// Fila 0. Necesita estirarse, hay que poner weighty
		gbRestriccion.gridwidth=2;
		gbRestriccion.gridheight=2;
		// El area de texto debe estirarse en ambos sentidos. Ponemos el campo fill.
		gbRestriccion.fill=GridBagConstraints.BOTH;
		gbRestriccion.weighty = 1.0; // La fila 0 debe estirarse, le ponemos un 1.0
		JF.add(areaTexto,gbRestriccion);
		gbRestriccion.weighty = 0.0; // Restauramos al valor por defecto, para no afectar a los siguientes componentes.
		
		boton1 = new JButton ("Boton 1"); 
		gbRestriccion.gridx = 2;// Columna 2. No necesita estirarse, no ponemos weightx
		gbRestriccion.gridy = 0;// Fila 0. Necesita estirarse, hay que poner weighty
		gbRestriccion.gridwidth = 1;
		gbRestriccion.gridheight = 1;
		// El boton 1 debe ocupar la posicion NORTH de su celda
		gbRestriccion.anchor=GridBagConstraints.NORTH;
		// El boton 1 no debe estirarse. Habiamos cambiado este valor en el
		// area de texto, asi que lo restauramos.
		gbRestriccion.fill=GridBagConstraints.NONE;
		gbRestriccion.weighty = 1.0; /* La fila 0 debe estirarse, le ponemos un 1.0. Ya lo hicimos en el area de texto, 
		                                               pero aqui debemos ser coherentes y poner lo mismo.*/
		JF.add (boton1, gbRestriccion);
		// Restauramos valores por defecto
		gbRestriccion.anchor=GridBagConstraints.CENTER;
		gbRestriccion.weighty = 0.0;

		boton2 = new JButton ("Boton 2");
		gbRestriccion.gridx = 2;// Columna 2, no necesita estirarse, no ponemos weigthx
		gbRestriccion.gridy = 1;// Fila 1. Necesita estirarse, hay que poner weighty
		gbRestriccion.gridwidth = 1;
		gbRestriccion.gridheight = 1;
		gbRestriccion.weighty=1.0;// La fila 1 debe estirarse, le ponemos 1.0
		gbRestriccion.anchor=GridBagConstraints.NORTH;
		JF.add (boton2, gbRestriccion);
		gbRestriccion.weighty=0.0;// Restauramos el valor por defecto.
		gbRestriccion.anchor=GridBagConstraints.CENTER;

		boton3 = new JButton ("Boton 3");
		gbRestriccion.gridx = 0;// Columna 0, no necesita estirarse, no ponemos weigthx
		gbRestriccion.gridy = 2;// Fila 2, no necesita estirarse, no ponemos weigthy
		gbRestriccion.gridwidth = 1;
		gbRestriccion.gridheight = 1;
		JF.add (boton3, gbRestriccion);

		boton4 = new JButton ("Boton 4");
		gbRestriccion.gridx = 2;// Columna 2, no necesita estirarse, no ponemos weightx
		gbRestriccion.gridy = 2;// Fila 2, no necesita estirarse, no ponemos weigthy
		gbRestriccion.gridwidth = 1;
		gbRestriccion.gridheight = 1;
		JF.add (boton4, gbRestriccion);

		campoTexto = new JTextField ("Campo texto");
		gbRestriccion.gridx = 1;// Columna 1, debe estirarse, le ponemos el weigthx
		gbRestriccion.gridy = 2;// Fila 2, no necesita estirarse, no ponemos weigthy
		gbRestriccion.gridwidth = 1;
		gbRestriccion.gridheight = 1;
		gbRestriccion.weightx = 1.0; // La columna 1 debe estirarse, ponemos el 1.0 en weigthx
		gbRestriccion.fill=GridBagConstraints.HORIZONTAL;
		JF.add (campoTexto, gbRestriccion);
		gbRestriccion.weightx = 0.0;// Restauramos el valor por defecto
		gbRestriccion.anchor=GridBagConstraints.CENTER;
		gbRestriccion.fill=GridBagConstraints.NONE;
	}//end Ventana()
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
    	Ventana ventana=new Ventana();
    	//contd.F.pack();
    	//ventana.JF.setPreferredSize(new Dimension(400, 300));
    	ventana.JF.setSize(400, 200);
    	ventana.JF.setLocationRelativeTo(null);
    	ventana.JF.setVisible(true);
    }//end createAndShowGUI()
	public static void main(String[] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
	}

}
