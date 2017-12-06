
package libro.cap05;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

//207.10.19.15.51
//import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
//import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;

public class ChatSwing extends JFrame
{
	private JTextField tfNick;
	private JTextField tfMensaje;
	private JButton bLogin;
	private JButton bLogout;
	private JButton bEnviar;
	private JList lstLog;
	
	private Border border;
	
	public ChatSwing() 
	{
		super("Chat");

		// pedimos el "panel de contencion" al JFrame
		Container content = getContentPane();
		
		// seteamos el layout
		content.setLayout(new BorderLayout());
		
		// este sera el tipo de borde que utilizamos en todos los paneles
		border = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

		// creamos el panel norte
		JPanel pNorth = _crearPNorte();
		content.add( pNorth, BorderLayout.NORTH);
		
		// creamos el panel central
		JPanel pCenter = _crearPCenter();
		content.add( pCenter, BorderLayout.CENTER);
		
		// creamos el panel sur
		JPanel pSouth = _crearPSur();
		content.add(pSouth, BorderLayout.SOUTH);
		
		setSize(400,300);
		setVisible(true);
	}

	
	private JPanel _crearPNorte()
	{
		JPanel p = new JPanel(new FlowLayout(FlowLayout.LEFT));
		
		TitledBorder titleBoder = BorderFactory.createTitledBorder(border,"Nick");
		p.setBorder(titleBoder);
		
		tfNick = new JTextField(10);
		p.add(tfNick);
		
		bLogin=new JButton("Login");
		p.add(bLogin);
		
		bLogout = new JButton("Logout");
		p.add(bLogout);

		return p;
	}
	
	private JPanel _crearPCenter()
	{
		JPanel p = new JPanel(new BorderLayout());
		
		TitledBorder titleBoder = BorderFactory.createTitledBorder(border,"Conversacion");
		
		p.setBorder(titleBoder);

		lstLog = new JList();
		JScrollPane scroll = new JScrollPane(lstLog);
		p.add(scroll,BorderLayout.CENTER);
		
		return p;
	}

	private JPanel _crearPSur()
	{
		JPanel p = new JPanel(new BorderLayout());

		TitledBorder titleBoder = BorderFactory.createTitledBorder(border,"Mensaje");		
		p.setBorder(titleBoder);
		
		tfMensaje = new JTextField();
		p.add(tfMensaje,BorderLayout.CENTER);

		bEnviar = new JButton("Enviar");
		p.add(bEnviar,BorderLayout.EAST);
		
		return p;
	}
	
	public static void main(String args[]) throws Exception
	{
//		UIManager.setLookAndFeel(new MotifLookAndFeel());
		ChatSwing c = new ChatSwing();
	}
}
