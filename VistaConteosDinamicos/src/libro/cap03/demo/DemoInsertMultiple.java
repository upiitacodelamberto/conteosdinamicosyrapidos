
package libro.cap03.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DemoInsertMultiple
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
			con = UConnection.getConnection();

			// seteo el autoCommit en false
			con.setAutoCommit(false);
						
			String sql="";
			sql+="INSERT INTO dept (deptno, dname, loc) VALUES(?,?,?)";
			
			// desde aqui todo sera parte de la transaccion hasta el commit o el rollback
			pstm = con.prepareStatement(sql);
			
			for(int i=100; i<150; i++)
			{
				pstm.setInt(1,i);
				pstm.setString(2,"NombreDept ("+i+")");
				pstm.setString(3,"LocDept"+i+")");
				pstm.addBatch();
			}

			int rtdo[] = pstm.executeBatch();
			
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


