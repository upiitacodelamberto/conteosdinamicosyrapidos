package libro.cap06;

public class DemoThread3
{
	public static void main(String[] args)
	{
		MiThred t1 = new MiThred("Pablo");
		MiThred t2 = new MiThred("Pedro");
		
		t1.setPriority(Thread.MAX_PRIORITY);
		
		System.out.println(Thread.MAX_PRIORITY);
		System.out.println(Thread.MIN_PRIORITY);
				
		t1.start();
		t2.start();
	}
	
	static class MiThred extends Thread
	{
		String nom;
		
		public MiThred(String nom)
		{
			this.nom = nom;
		}
		
		public void run()
		{
			for(int i=0; i< 5; i++ )
			{
				System.out.println( nom +" - "+ i);
				yield();
			}
		}
	}
}