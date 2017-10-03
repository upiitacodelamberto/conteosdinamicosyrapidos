
package libro.cap03.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DemoUpdate
{
	public static void main(String[] args)
	{
		String usr="sa";
		String pwd="";
		String driver="org.hsqldb.jdbcDriver";
		String url="jdbc:hsqldb:hsql://localhost/xdb";
		
		Connection con=null;
		PreparedStatement pstm=null;
		
		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(url,usr,pwd);
						
			String sql="";
			sql+="UPDATE dept SET loc = ? ";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1,"Buenos Aires");

			int rtdo = pstm.executeUpdate();
			System.out.println(rtdo+" filas updateadas");
			
			con.commit();
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
				if( pstm!=null ) pstm.close();
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
