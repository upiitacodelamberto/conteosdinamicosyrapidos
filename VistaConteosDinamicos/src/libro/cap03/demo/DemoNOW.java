
package libro.cap03.demo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Types;

public class DemoNOW
{
	public static void main(String[] args)
	{	
		Connection con = null;
		CallableStatement cstm = null;
		
		try
		{
			con = UConnection.getConnection();
	
			String sql=" {? = call CURDATE()} "; 
			cstm = con.prepareCall(sql);

			cstm.registerOutParameter(1,Types.DATE);
			
			cstm.execute();
			
			Date d = cstm.getDate(1);
			
			System.out.println(d);
			
			
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try
			{
				if( cstm!=null ) cstm.close();
				if( con!=null ) con.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
// pepepe
		}
}
