package libro.cap05;

import java.awt.*;

import javax.swing.border.Border;

public class Calculadora extends Frame
{
   private Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
   private Button bDec,bMas,bMenos,bPor,bDiv,bIgual,bBorrar;
   private TextField tfDisplay;

   public Calculadora()
   {
   	super();

   	setLayout(new BorderLayout());
   	
   	// en el NORTE ubico el display
   	tfDisplay = new TextField();
   	add(tfDisplay,BorderLayout.NORTH);
   	
   	// en el CENTRO ubico el teclado
   	Panel pTeclado=_crearTeclado();
   	add(pTeclado, BorderLayout.CENTER);

   	// el metodo pack calcula el size exacto
   	// necesario para los componentes 
   	// que contiene el container
   	
      pack();
   	setVisible(true);
   }   	

	private Panel _crearTeclado()
   {
   	b0 = new Button("0");
   	b1 = new Button("1");
   	b2 = new Button("2");
   	b3 = new Button("3");
   	b4 = new Button("4");
   	b5 = new Button("5");
   	b6 = new Button("6");
   	b7 = new Button("7");
   	b8 = new Button("8");
   	b9 = new Button("9");
   	bDec = new Button(".");
   	bMas=new Button("+");
   	bMenos=new Button("-");
   	bPor = new Button("*");
   	bDiv = new Button("/");
   	bIgual = new Button("=");
   	
   	Panel p = new Panel( new GridLayout(4,4) );
   	p.add(b7);
   	p.add(b8);
   	p.add(b9);
   	p.add(bDiv);
   	p.add(b4);
   	p.add(b5);
   	p.add(b6);
   	p.add(bPor);
   	p.add(b1);
   	p.add(b2);
   	p.add(b3);
   	p.add(bMenos);

   	p.add(bDec);
   	p.add(b0);
   	
   	p.add(bIgual);
   	p.add(bMas);
   	return p;

   }
	
   public static void main(String[] args)
   {
      Calculadora v3 = new Calculadora();
   }
}
