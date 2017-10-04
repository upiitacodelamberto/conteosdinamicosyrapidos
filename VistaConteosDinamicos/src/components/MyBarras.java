package components;
import java.awt.*;	/* Frame*/
import java.awt.event.*;	/*WindowAdapter,WindowEvent*/
public class MyBarras extends Frame implements ActionListener,MouseListener{
	private Barras B;
	private Tabla ventas;
	private TextField valor;
	private int dato[];			/* los datos a graficar */
	public static void main(String[] args) {
		int arr[]={20,30,15,40,50,80,45};
		new MyBarras(arr);
	}
	public MyBarras(int data[]){
		setTitle("MyBarras.class");
		setLayout(new FlowLayout());
		dato=data;
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){//4/5 WindowListener 
				System.exit(0);//5/5 WindowListener
			}
		});
		B=new Barras();
		
		ventas=new Tabla(3,7);
		Label L=new Label("Introduzca un n�mero y haga clic en componente");
		add(L);
		valor=new TextField(8);
		add(valor);
		valor.addActionListener(this);//3/5 ActionListener
		this.addMouseListener(this);//3/5 MouseListener
		
		setSize(600,350);
		setLocationRelativeTo(null);
//		System.out.print("hvjhfjekjklj,");
		setVisible(true);
	}//end MyBarras()
	public void paint(Graphics g){
		ventas.show(g);
		B.mostrarBarras(dato, g);
	}
	public void actionPerformed(ActionEvent event){//4/5 ActionLisnener
		int nuevoValor=Integer.parseInt(valor.getText());//5/5 ActionListener
		ventas.establecerValor(nuevoValor);
		repaint();
	}
	public void mouseClicked(MouseEvent event){//4/5 MouseListener
		int x=event.getX();
		int y=event.getY();
		ventas.seleccionarComponente(x, y);
		repaint();
	}
	public void mouseReleased(MouseEvent e){ }//4/5 MouseListener
	public void mousePressed(MouseEvent e){ }//4/5 MouseListener
	public void mouseEntered(MouseEvent e){ }//4/5 MouseListener
	public void mouseExited(MouseEvent e){ }//4/5 MouseListener
}//end class MyBarras


class Barras{
	public Barras(){
	}
	public void mostrarBarras(int datos[],Graphics g){
		int mayor;
		int datosEscalados[]=new int[datos.length];
		
		int yInicial=20;
		int yAltura=240;
		int xInicial=20;
		int anchura=40;
		int hueco=0;
		
		mayor=buscarMayor(datos);
		datosEscalados=escalarValores(datos,mayor,yAltura);
		int x=xInicial;
		for(int contador=0;contador<datosEscalados.length;contador++){
			g.fillRect(x, yInicial+yAltura-datosEscalados[contador], 
						anchura, datosEscalados[contador]);
			x=x+anchura+hueco;
		}
	}//end mostrarBarras()
	private int buscarMayor(int dat[]){
		int max=dat[0];
		for(int i=1;i<dat.length;i++){
			if(dat[i]>max)max=dat[i];
		}
		return max;
	}
	private int[] escalarValores(int dat[],int intMayor,int intYAltura){//Stub
//		int Res[]=new int[dat.length];
//		for(int i=0;i<dat.length;i++){
//			Res[i]=intYAltura*(dat[i]/intMayor);
//		}
//		return Res;
		return dat;
	}
}//end class Barras

class Tabla{
	private int datos[][];
	private int renglonIndice;
	private int colIndice;
	private int nuevoValor;
	
	private int suma;
	
	private final int xInicial=20;
	private final int yInicial=60;
	private final int cuadroAltura=20;
	private final int cuadroAnchura=40;
	
	public Tabla(int renglones,int columnas){
		datos=new int[renglones][columnas];
		for(int renglon=0;renglon<renglones;renglon++){
			for(int col=0;col<columnas;col++){
				datos[renglon][col]=0;
			}
		}
	}
	public void show(Graphics g){
		for(int renglon=0; renglon<datos.length;renglon++){
			for(int col=0;col<datos[0].length;col++){
				int x=xInicial+col*cuadroAnchura;
				int y=yInicial+renglon*cuadroAltura;
				g.drawRect(x, y, cuadroAnchura, cuadroAltura);
				g.drawString(Integer.toString(datos[renglon][col]), 
						x, y+cuadroAltura*3/4);
			}
		}
		calcularSuma();
		g.drawString("El total es "+suma,100,150);
	}//end show()
	
	public void seleccionarComponente(int x,int y){
		renglonIndice=(y-yInicial)/cuadroAltura;
		colIndice=(x-xInicial)/cuadroAnchura;
		datos[renglonIndice][colIndice]=nuevoValor;
	}
	
	public void establecerValor(int valor){
		nuevoValor=valor;
	}
	
	private void calcularSuma(){
		suma=0;
		for(int renglon=0;renglon<datos.length;renglon++){
			for(int col=0;col<datos[0].length;col++){
				suma=suma+datos[renglon][col];
			}
		}
	}
}//end class Tabla