/**
 * 03 JugarGlobo.java
 */
package components;
import java.awt.*;
import java.awt.event.*;//1/5 ActionListener,WindowListener
//public class JugarGlobo implements ActionListener,WindowListener{//2/5 ActionListener,WindowListener
public class JugarGlobo extends Frame implements ActionListener,WindowListener{//2/5 ActionListener,WindowListener
//	private Frame f;
	private Button ButtonAgrandar,ButtonReducir;
	private Globo miGlobo;
	public static void main(String[] args) {
		JugarGlobo JG=new JugarGlobo();
		//JG.f.setSize(300,300);
		//JG.f.setLocationRelativeTo(null);
		//JG.f.setVisible(true);
		JG.setSize(300,300);
		JG.setLocationRelativeTo(null);
		JG.setVisible(true);
	}
	public JugarGlobo(){
		/*
		f=new Frame();
		f.setTitle("Globo");
		f.setLayout(new FlowLayout());
		ButtonAgrandar=new Button("Agrandar");
		f.add(ButtonAgrandar);
		ButtonAgrandar.addActionListener(this);//3/5 ActionListener
		ButtonReducir=new Button("Reducir");
		f.add(ButtonReducir);
		ButtonReducir.addActionListener(this);//3/5 ActionListener
		miGlobo=new Globo(10,50,50);
		f.addWindowListener(this);
		*/
//		f=new Frame();
		setTitle("Globo");
		setLayout(new FlowLayout());
		ButtonAgrandar=new Button("Agrandar");
		add(ButtonAgrandar);
		ButtonAgrandar.addActionListener(this);//3/5 ActionListener
		ButtonReducir=new Button("Reducir");
		add(ButtonReducir);
		ButtonReducir.addActionListener(this);//3/5 ActionListener
		miGlobo=new Globo(10,150,150);
		addWindowListener(this);
	}//end JugarGlobo()
	@Override
	public void actionPerformed(ActionEvent arg0) {//4/5 ActionListener
		if(arg0.getSource()==ButtonAgrandar){//5/5 ActionListener
			miGlobo.cambiarTamanio(10);
		}
		if(arg0.getSource()==ButtonReducir){//5/5 ActionListener
			miGlobo.cambiarTamanio(-10);
		}
//		f.repaint();
		repaint();
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
		System.exit(0);
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
	public void paint(Graphics g){
		miGlobo.mostrar(g);
	}
}//end class JugarGlobo

class Globo{
	private int diametro;
	private int xCoord,yCoord;
	public Globo(int diametroInicial,int xInicial,int yInicial){
		diametro=diametroInicial;
		xCoord=xInicial;
		yCoord=yInicial;
	}
	public void cambiarTamanio(int cambio){
		diametro+=cambio;
		xCoord=150;
		yCoord=150;
	}
	public void mostrar(Graphics g){
		g.drawOval(xCoord, yCoord, diametro, diametro);
	}
}//end class Globo
