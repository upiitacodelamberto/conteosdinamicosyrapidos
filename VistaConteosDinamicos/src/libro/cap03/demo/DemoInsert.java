
package libro.cap03.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DemoInsert
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
			sql+="INSERT INTO dept (deptno, dname, loc) VALUES(?,?,?)";
			
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1,4);
			pstm.setString(2,"Logistica");
			pstm.setString(3,"Mar del Plata");
			int rtdo = pstm.executeUpdate();

			if( rtdo == 1 )
			{
				System.out.println("1 fila correctamente insertada");
			}
			else
			{
				throw new RuntimeException("No se pudo insertar la fila");
			}
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
