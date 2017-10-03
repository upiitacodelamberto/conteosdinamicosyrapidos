package libro.cap06;

public class DemoThread2 implements Runnable
{
	private String nombre;
	
	public DemoThread2(String nombre)
	{
		this.nombre = nombre;
	}
	
	public void run()
	{
		try
		{
			int x = (int)(Math.random()*5000);
			Thread.sleep(x);
			System.out.println("Soy: "+nombre+" ("+x+")");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		Thread t1 = new Thread(new DemoThread("Pedro"));
		Thread t2 = new Thread(new DemoThread("Pablo"));
		Thread t3 = new Thread(new DemoThread("Juan"));
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}
