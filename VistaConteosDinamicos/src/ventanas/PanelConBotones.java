package ventanas;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
//import javax.swing.JSplitPane;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;//1/5
//import java.awt.ActiveEvent;

public class PanelConBotones {
	JPanel JP;
//	JButton  boton1,boton2,boton3,boton4,boton5;
	JLabel DL;

	public PanelConBotones(JButton  boton1,JButton boton2,JButton boton3,JButton boton4,JButton boton5){
		JP=new JPanel();
		JP.setLayout(new GridBagLayout());
		GridBagConstraints GBC=new GridBagConstraints();
		
		DL=new JLabel("         ");
		GBC.gridx=0;GBC.gridy=1;GBC.gridwidth=GBC.gridheight=1;
		JP.add(DL,GBC);
		
//		boton1=new JButton("  >  ");
//		this.boton1=boton1;
		GBC.gridx=1;// Columna 0. No necesita estirarse, no ponemos weightx
		GBC.gridy=1;// Fila 0. No necesita estirarse, no hay que poner weighty
		GBC.gridwidth=1;
		GBC.gridheight=1;
		JP.add(boton1, GBC);
		
		DL=new JLabel("         ");
		GBC.gridx=2;GBC.gridy=1;GBC.gridwidth=GBC.gridheight=1;
		JP.add(DL,GBC);
		
//		 boton2=new JButton("  >>  ");
		GBC.gridx=3;GBC.gridy=1;GBC.gridwidth=GBC.gridheight=1;
		JP.add(boton2, GBC);
		
		DL=new JLabel("             ");
		GBC.gridx=4;GBC.gridy=2;GBC.gridwidth=GBC.gridheight=1;
		JP.add(DL, GBC);
		
//		boton3=new JButton("  <  ");
		GBC.gridx=5;GBC.gridy=1;GBC.gridwidth=GBC.gridheight=1;
		JP.add(boton3, GBC);
		
		DL=new JLabel("         ");
		GBC.gridx=6;GBC.gridy=1;GBC.gridwidth=GBC.gridheight=1;
		JP.add(DL,GBC);
		
//		boton4=new JButton("  <<  ");
		GBC.gridx=7;GBC.gridy=1;GBC.gridwidth=GBC.gridheight=1;
		JP.add(boton4, GBC);
		
		DL=new JLabel("               ");
		GBC.gridx=8;GBC.gridy=1;GBC.gridwidth=GBC.gridheight=1;
		JP.add(DL,GBC);
		
//		boton5=new JButton("Crear Coalición");
		GBC.gridx=9;GBC.gridy=1;GBC.gridwidth=GBC.gridheight=1;
		JP.add(boton5, GBC);
		
		DL=new JLabel("         ");
		GBC.gridx=10;GBC.gridy=1;GBC.gridwidth=GBC.gridheight=1;
		JP.add(DL,GBC);
	}//end PanelConBotones()
	
    public JPanel getJPanel() {
        return JP;
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
    	JButton  boton1,boton2,boton3,boton4,boton5;
    	boton1=new JButton("  >  ");
    	boton2=new JButton("  >>  ");
    	boton3=new JButton("  <  ");
    	boton4=new JButton(" <<  ");
    	boton5=new JButton("Crear coalición");
    	PanelConBotones ventana=new PanelConBotones(boton1,boton2,boton3,boton4,boton5);
    	//contd.F.pack();
    	//ventana.JF.setPreferredSize(new Dimension(400, 300));
    	
    	JFrame frame=new JFrame("marco");
    	frame.add(ventana.JP);
    	frame.setLocationRelativeTo(null);
    	frame.setSize(600, 200);
    	frame.setVisible(true);
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
