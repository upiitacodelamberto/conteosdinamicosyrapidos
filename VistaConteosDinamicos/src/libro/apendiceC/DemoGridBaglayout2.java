package libro.apendiceC;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Label;
import java.awt.TextField;

public class DemoGridBaglayout2 extends Frame
{
	public DemoGridBaglayout2()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		Label lblNick= new Label("Nick");

		c.gridx = 0;
		c.gridy = 0;
		add(lblNick, c);

		TextField tfNick = new TextField();
		//c.fill = GridBagConstraints.HORIZONTAL;
		//c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		c.gridwidth = 2;
		add(tfNick, c);

		Button bLogin = new Button("Login");
		//c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		add(bLogin, c);

		Button bLogout= new Button("Logout");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40;      //make this component tall
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 3;
		c.gridy = 0;
		add(bLogout, c);

		Button button = new Button("5");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 0;       //reset to default
		c.weighty = 1.0;   //request any extra vertical space
		c.anchor = GridBagConstraints.PAGE_END; //bottom of space
		c.insets = new Insets(10,0,0,0);  //top padding
		c.gridx = 1;       //aligned with button 2
		c.gridwidth = 2;   //2 columns wide
		c.gridy = 2;       //third row
		add(button, c);
		
		pack();
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		new DemoGridBaglayout2();
	}
}
