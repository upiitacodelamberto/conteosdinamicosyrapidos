package libro.cap06.prodcons;

public class Monitor
{
	private char[] buff = null;
	private int tope = 0;
	
	private boolean lleno = false;
	private boolean vacio = true;
	
	public Monitor(int capacidad)
	{
		buff = new char[capacidad];
	}
	
	public synchronized void poner(char c) throws Exception
	{
		while( lleno )
		{
			wait();
		}
		
		// seccion critica
		buff[tope++] = c;
		//tope++;
		
		vacio = false;
		lleno = tope>=buff.length;

		
		notifyAll();
	}
	
	public synchronized char sacar() throws Exception
	{
		while( vacio )
		{
			wait();
		}
	
		// seccion critica
		//tope--;
		char c = buff[--tope];

		lleno = false;
		vacio = tope<=0;
		
		notifyAll();
		
		return c;
	}	
}
