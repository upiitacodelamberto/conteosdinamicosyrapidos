package libro.cap06;

public class DemoThread extends Thread
{
	private String nombre;
	
	public DemoThread(String nombre)
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
	
	public static void main(String[] args) throws Exception
	{
		DemoThread t1 = new DemoThread("Pedro");
		DemoThread t2 = new DemoThread("Pablo");
		DemoThread t3 = new DemoThread("Juan");
		/*Esta es la forma correcta*/
		t1.start();
		t2.start();
		t3.start();
		/*La siguiente forma no es correcta*/
//		t1.run();t2.run();t3.run();
		/*y la siguiente menos*/
//		t1.run();t1.run();t2.run();t3.run();
		
		t1.join();
		t2.join();
		t3.join();
		
		System.out.println("Finalizo el programa !");
		
	}
}