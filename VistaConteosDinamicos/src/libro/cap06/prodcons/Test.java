package libro.cap06.prodcons;

public class Test
{
	public static void main(String[] args)
	{
		Monitor m = new Monitor(3);
		
		Productor p = new Productor(m,8,2000);
		Consumidor c = new Consumidor(m,8,5000);
		
		p.start();
		c.start();
	}
}
