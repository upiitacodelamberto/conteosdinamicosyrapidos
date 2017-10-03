package libro.apendiceC;

import java.awt.Button;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class DemoGridBaglayout extends Frame
{
	public DemoGridBaglayout()
	{
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		Button button = new Button("Boton 1");
		c.weightx = 0.5;

		c.gridx = 0;
		c.gridy = 0;
		add(button, c);

		button = new Button("Button 2");
		//c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 1;
		c.gridy = 0;
		add(button, c);

		button = new Button("Button 3");
		//c.fill = GridBagConstraints.HORIZONTAL;
		c.weightx = 0.5;
		c.gridx = 2;
		c.gridy = 0;
		add(button, c);

		button = new Button("Long-Named Button 4");
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 40;      //make this component tall
		c.weightx = 0.0;
		c.gridwidth = 3;
		c.gridx = 0;
		c.gridy = 1;
		add(button, c);

		button = new Button("5");
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
		new DemoGridBaglayout();
	}
}
