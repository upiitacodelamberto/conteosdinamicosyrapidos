package libro.apendiceB;

import java.applet.Applet;
import java.awt.FlowLayout;
import java.awt.Label;

public class HolaMundoApplet extends Applet
{
	public void init()	
	{
		setLayout(new FlowLayout());
		
		String p = getParameter("nombre");
		Label lbl = new Label("Hola Mundo Applet " + p);
		add( lbl );
	}
	
	
	public void start()
	{
		System.out.println("start...");
	}
	
	public void stop()
	{
		System.out.println("stop...");
	}
	
	
	//.....
	
	public void destroy()
	{
		System.out.println("destroy...");
	}
}
