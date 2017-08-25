package components;

import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;//1/5
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import sun.awt.WindowClosingListener;
import sun.awt.WindowClosingSupport;
import sun.awt.AWTAccessor.WindowAccessor;
import ventanas.AgregaPartidos;
import ventanas.PanelPartidOCoalicion;

//public class MostrandoElec implements WindowListener, ActionListener {//// 2/5
public class MostrandoElec implements WindowListener, ActionListener {//// 2/5
	Frame f;
	Dialog D;
	
//	public MostrandoElec(Frame f,//La ventana padre de este dialogo
//			String elecName,//Nombre de eleccion
//			PanelPartidOCoalicion ppc[]//Paneles con boton con Logo 
//					//de Partido/Coalicion, Nombre de Partido/Coalicion 
//					//y Candidato(a)
//			){
//		this.f=f;
//		D=new Dialog(f,elecName, true);
//	}
	public MostrandoElec(){
		
	}
	public MostrandoElec(Frame f2, String nombDEleccion, PanelPartidOCoalicion ppc[]) {
		this.f=f;
		D=new Dialog(f,nombDEleccion, true);
		D.setLayout(new FlowLayout());
//		D.setLayout(new GridLayout(1,2));
System.out.println("Se recibieron "+ppc.length+" PanelPartidOCoalicion");
		for(int i=0;i<ppc.length;i++){
			D.add(ppc[i].getJPanel());
		}
		D.addWindowListener(this);
	}
	public void actionPerformed(ActionEvent ae){
		
	}
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent arg0) {
		D.dispose();
	}
	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	private static void createAndShowGUI() {
		//AgregaPartidos AP = new AgregaPartidos(new ContD());
		JButton  BPartidoCoal;
		JButton  BPartidoCoal1;
    	ImageIcon partidoButtonIcon=
    			PanelPartidOCoalicion.createImageIcon("images/middle.gif");
    	BPartidoCoal=new JButton("PARTIDO/COALICION",partidoButtonIcon);
    	BPartidoCoal.setVerticalTextPosition(AbstractButton.BOTTOM);
    	BPartidoCoal.setHorizontalTextPosition(AbstractButton.CENTER);
    	BPartidoCoal.setMnemonic(KeyEvent.VK_M);
    	BPartidoCoal1=new JButton("PARTIDO/COALICION",partidoButtonIcon);
    	BPartidoCoal1.setVerticalTextPosition(AbstractButton.BOTTOM);
    	BPartidoCoal1.setHorizontalTextPosition(AbstractButton.CENTER);
    	BPartidoCoal1.setMnemonic(KeyEvent.VK_M);
    	PanelPartidOCoalicion ventana=new 
    			PanelPartidOCoalicion(BPartidoCoal,
    					"PARTIDO DE NOMBRE LARGO MUY LARGO",
    					"CANDIDATO DE NOMBRE LARGO PROBANDO "
    					+ "UN NOMBRE DE CANDIDATO MUY LARGO",
    					PanelPartidOCoalicion.LONGI);
    	PanelPartidOCoalicion ventana1=new 
    			PanelPartidOCoalicion(BPartidoCoal1,
    					"PARTIDO DE NOMBRE LARGO MUY LARGO",
    					"CANDIDATO DE NOMBRE LARGO PROBANDO "
    					+ "UN NOMBRE DE CANDIDATO MUY LARGO",
    					PanelPartidOCoalicion.LONGI);
		PanelPartidOCoalicion PPC[]=new PanelPartidOCoalicion[2];
		PPC[0]=ventana;PPC[1]=ventana1;
    	MostrandoElec AP = new MostrandoElec(new Frame(),"ELECCION DE PRUEBA",PPC);
		Dialog dialogo = AP.D;
//		AP.D.setSize(800, 300);
		dialogo.pack();
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
}//end class MostrandoElec