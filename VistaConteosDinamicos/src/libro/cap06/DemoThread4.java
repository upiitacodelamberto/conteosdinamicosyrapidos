package libro.cap06;

public class DemoThread4 extends Thread
{
	private String name;
	
	public DemoThread4(String n)
	{
		this.name = n;
	}
	
	public void run()
	{
		try
		{
			for(int i=0; i<5; i++)
			{
				System.out.println(name);
				yield();
			}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public static void main(String[] args)
	{
		new DemoThread4("Pablo").start();
		new DemoThread4("Pedro").start();
		new DemoThread4("Juan").start();
	}
}
