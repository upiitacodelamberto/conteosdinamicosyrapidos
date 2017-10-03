
package libro.cap03.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DemoMultipleInsertBatch
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

			// seteo el autoCommit en false
			con.setAutoCommit(false);
						
			String sql="";
			sql+="INSERT INTO dept (deptno, dname, loc) VALUES(?,?,?)";
			
			// desde aqui todo sera parte de la transaccion hasta el commit o el rollback
			pstm = con.prepareStatement(sql);
			
			for(int i=80; i<150; i++)
			{
				System.out.println(i);
				pstm.setInt(1,i);
				pstm.setString(2,"NombreDept ("+i+")");
				pstm.setString(3,"LocDept"+i+")");
				int rtdo = pstm.executeUpdate();

				if( rtdo != 1 )
				{
					throw new RuntimeException("No se pudo insertar la fila");
				}
			}
			
			// todo andovo bien.... confirmo !
			con.commit();
			
			System.out.println("Todo insertado correctamente !");
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
				if( con!= null ) con.rollback();
				
				if( pstm!=null ) pstm.close();
				if( con!=null ) con.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}
}


