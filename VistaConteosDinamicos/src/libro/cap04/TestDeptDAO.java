
package libro.cap04;

import java.sql.Connection;
import java.util.Collection;

public class TestDeptDAO
{
	public static void main(String[] args)
	{
		Runtime.getRuntime().addShutdownHook(new ShutdownHook());

		Connection con = null;

		DeptDAO dept = new DeptDAO();

		Collection<DeptDTO> coll = dept.buscarTodos();

		for( DeptDTO dto : coll )
		{
			System.out.println(dto);
		}
	}

	static class ShutdownHook extends Thread
	{
		public void run()
		{
			try
			{
				Connection con = UConnection.getConnection();
				con.close();
			}
			catch( Exception ex )
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}

}
