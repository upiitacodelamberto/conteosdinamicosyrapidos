package ventanas;
/**
 * 
 * @author Beto
 * VdConf: Ventana de Configuración
 */
import java.awt.*;
import java.awt.event.*;//1/5 ActionListener, ActionEvent

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class VdConf implements WindowListener,ActionListener{//2/5 WindowListener, ActionListener
	Dialog D;
	JButton  boton1,boton2,boton3,boton4,boton5;
	List LW,LE;//listW y listE se usan en la clase PanelDividido
	JButton BGT,BGTGT,BLT,BLTLT,BCreaCoa;
//	Button BVacio;
	private JLabel label;
	public VdConf(Frame f,String imNames[ ]) {//public SplitPaneDemo2()	
		//Se crea un Dialogo modal
		D=new Dialog(f,"CONFIGURACION INICIAL",true);//No existe constructor de Dialog sin argumentos
//		String imageNames[ ]={"Partido 1","Partido 2","Partido 3","Partido 4","Partido 5",
//			"Partido 6","Partido 7","Partido 8","Partido 9","Partido 10"};

		LW=new List();
        for(int i=0;i<imNames.length;i++)
        	LW.add(imNames[i]);
		LE=new List();
		//Para que en el metodo actionPerformed al menos inicialmente se tenga un item de esta lista seleccionado
//		LW.setSelectedIndex(0);//setSelectedIndex(int) is only available in JList but not in List
		//Create an instance of PanelDividido
        PanelDividido panelDividido = new PanelDividido(LW,LE);
        JSplitPane top = panelDividido.getSplitPane();
        //panelDividido.getImageList().addListSelectionListener(this);

        //XXXX: Bug #4131528, borders on nested split panes accumulate.
        //Workaround: Set the border on any split pane within
        //another split pane to null. Components within nested split
        //panes need to have their own border for this to work well.
        top.setBorder(null);
        
        //Create a regular old label
        label = new JLabel("Click on an image name in the list.",
                           JLabel.CENTER);
        JButton  boton1,boton2,boton3,boton4,boton5;
//    	boton1=new JButton("  >  ");
        BGT=new JButton("  >  ");
    	BGT.addActionListener(this);//3/5 ActionListener
//    	boton2=new JButton("  >>  ");
    	BGTGT=new JButton("  >>  ");
    	BGTGT.addActionListener(this);//3/5 ActionListener
//    	boton3=new JButton("  <  ");
    	BLT=new JButton("  <  ");
    	BLT.addActionListener(this);//3/5 ActionListener
//    	boton4=new JButton(" <<  ");
    	BLTLT=new JButton(" <<  ");
    	BLTLT.addActionListener(this);
    	BCreaCoa=new JButton("Crear coalición");
    	BCreaCoa.addActionListener(this);//3/5 ActionListener
//    	PanelConBotones PCB=new PanelConBotones(boton1,boton2,boton3,boton4,boton5);
        PanelConBotones PCB=new PanelConBotones(BGT,BGTGT,BLT,BLTLT,BCreaCoa);
        JPanel down=PCB.getJPanel();
        //down.setBorder(null);

        //Create a split pane and put "top" (a split pane)
        //and JLabel instance in it.
        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                                              top,down);
        		
        splitPane.setOneTouchExpandable(true);
        splitPane.setDividerLocation(240);

        //Provide minimum sizes for the two components in the split pane
        top.setMinimumSize(new Dimension(100, 50));
        label.setMinimumSize(new Dimension(100, 30));

        //Add the split pane to this frame
		D.add(splitPane);//getContentPane().add(splitPane);
        D.addWindowListener(this);// 3/5 WindowListener
		//D.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//D.setLocationRelativeTo(null);//en createAndShowGUI() 
		D.setResizable(false);
		//D.setVisible(true);//en createAndShowGUI()
	}//end VdConf()
	
	@Override
	public void windowActivated(WindowEvent arg0) {//4/5 WindowListener
		// TODO Auto-generated method stub
	}
	@Override
	public void windowClosed(WindowEvent arg0) {//4/5 WindowListener
		// TODO Auto-generated method stub
	}
	@Override
	public void windowClosing(WindowEvent arg0) {//4/5 WindowListener
		switch(JOptionPane.showConfirmDialog(null, "Confirma que ha terminado la Configuración?")){// 5/5 WindowListener
		case 0:{ 
			//AQUI  HAY QUE PONER COALICIONES Y PARTIDOS ENEL AREA DE TEXTO DE ContD
			System.gc();//execute the garbage colector
			String sta=ContD.TA.getText();
			for(int i=0;i<ContD.COAL.size();i++){
				sta+="\n"+"COALICION "+ContD.COAL.get(i).toString();
			}
			ContD.TA.setText(sta);
			List partido=new List();
			String a[ ]=LW.getItems();
			for(int i=0;i<a.length;i++){
				partido.add(a[i]);
				ContD.PARTIDO.add(new Coalicion("PARTIDO",partido));
				partido=new List();
			}
			sta=ContD.TA.getText();
			for(int i=0;i<ContD.PARTIDO.size();i++){
				sta+="\n"+ContD.PARTIDO.get(i).toString();
			}
			ContD.TA.setText(sta);
			D.dispose();break;//Cerrar Dialogo (clic en Si)
			}
		case 1:{break;}//DO NOTHING (clic en No)
		case 2:{break;}//DO NOTHING (clic en Cancel)
		default://DO NOTHING (clic en X)
		}
	}//end windowClosing()
	@Override
	public void windowDeactivated(WindowEvent arg0) {//4/5 WindowListener
		// TODO Auto-generated method stub
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {//4/5 WindowListener
		// TODO Auto-generated method stub
	}
	@Override
	public void windowIconified(WindowEvent arg0) {//4/5 WindowListener
		// TODO Auto-generated method stub
	}
	@Override
	public void windowOpened(WindowEvent arg0) {//4/5 WindowListener
		// TODO Auto-generated method stub		
	}

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        //JFrame frame=new VdConf().D;//JFrame frame = new SplitPaneDemo2();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String imageNames[ ]={"Partido 1","Partido 2","Partido 3","Partido 4","Partido 5",
		"Partido 6","Partido 7","Partido 8","Partido 9","Partido 10"};
    	VdConf VDC=new VdConf(new Frame(),imageNames);
    	Dialog dialogo=VDC.D;
    	//dialogo.addWindowListener(VDC);
    	
        //Display the window.
        //frame.pack();
        //frame.setVisible(true);
    	dialogo.pack();
    	dialogo.setLocationRelativeTo(null);
    	dialogo.setVisible(true);
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

	@Override
	public void actionPerformed(ActionEvent e) {//4/5 ActionListener
		String s;
		int idx;
		if(e.getSource().equals(BGT)){//5/5 ActionListener
			//if no item is selected, or if multiple items are selected, -1 is returned
			if((idx=LW.getSelectedIndex())!=-1){
				LE.add(LW.getSelectedItem());
				LW.remove(idx);
			}
		}
		if(e.getSource().equals(BGTGT)){
			while(LW.getItemCount()>0){
				LW.select(0);
				//if no item is selected, or if multiple items are selected, -1 is returned
				if((idx=LW.getSelectedIndex())!=-1){
					LE.add(LW.getSelectedItem());
					LW.remove(idx);
				}
			}//end while()
		}
		if(e.getSource().equals(BLT)){//5/5 ActionListener
			//if no item is selected, or if multiple items are selected, -1 is returned
			if((idx=LE.getSelectedIndex())!=-1){
				LW.add(LE.getSelectedItem());
				LE.remove(idx);
			} 
		}
		if(e.getSource().equals(BLTLT)){
			while(LE.getItemCount()>0){
				LE.select(0);
				//if no item is selected, or if multiple items are selected, -1 is returned
				if((idx=LE.getSelectedIndex())!=-1){
					LW.add(LE.getSelectedItem());
					LE.remove(idx);
				}
			}//end while()
		}
		if(e.getSource().equals(BCreaCoa)){
			String nomDCoal;
			List partido=new List();
			String a[ ]=LE.getItems();
			for(int i=0;i<a.length;i++){
				partido.add(a[i]);
			}
			nomDCoal=JOptionPane.showInputDialog("Nombre de la coalición: ");
			ContD.COAL.add(new Coalicion(nomDCoal,partido));
			LE.removeAll();
		}
	}//end actionPerformed()
}//end class VdConf
 