
package libro.cap08.app.sql;

import java.sql.Connection;
import java.util.Collection;
import java.util.Vector;

public class TestPool implements Runnable
{
	int sleep;
	
	public TestPool(int n)
	{
		this.sleep=n;
	}
	
	public void run()
	{
		try
		{
			ConnectionPool pool = ConnectionPool.getPool();
									
			Connection con = pool.getConnection();
			
			System.out.println("obtengo, ahora duermo");
			
			Thread.sleep(sleep);
			System.out.println("despierto, ahora devuelvo");
			
			pool.releaseConnection(con);

			System.out.println("listo !");			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
	
	public static void main(String[] args) throws Exception
	{
		Collection<Thread> t = new Vector<Thread>();
		
		t.add(new Thread(new TestPool(10000)));
		t.add(new Thread(new TestPool(8000)));
		t.add(new Thread(new TestPool(7000)));
		t.add(new Thread(new TestPool(5000)));
		t.add(new Thread(new TestPool(2500)));
		t.add(new Thread(new TestPool(1000)));
		t.add(new Thread(new TestPool(500)));
		t.add(new Thread(new TestPool(200)));
		t.add(new Thread(new TestPool(100)));
		
		for(Thread aux: t)
		{
			aux.start();
		}
		
		for(Thread aux: t)
		{
			aux.join();
		}
		
		System.out.println("FIN --->>> " +ConnectionPool.getPool());
		
	
	}
}
