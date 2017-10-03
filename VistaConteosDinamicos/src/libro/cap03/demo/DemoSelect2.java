
package libro.cap03.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DemoSelect2
{
	public static void main(String[] args)
	{
		String usr="sa";
		String pwd="";
		String driver="org.hsqldb.jdbcDriver";
		String url="jdbc:hsqldb:hsql://localhost/xdb";
		
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement pstm=null;
		
		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(url,usr,pwd);
						
			String sql="";
			sql+="SELECT e.empno as empno";
		   sql+="      ,e.ename as ename ";
		   sql+="      ,e.hiredate as hiredate ";
		   sql+="      ,e.deptno as deptno";
		   sql+="      ,d.dname as dname ";
			sql+="FROM emp e, dept d ";
			sql+="WHERE e.empno = d.deptno ";
			
			pstm = con.prepareStatement(sql);
			
			rs = pstm.executeQuery();

			while( rs.next() )
			{
				System.out.print( rs.getInt("empno")+", " );
				System.out.print( rs.getString("ename")+", " );
				System.out.print( rs.getInt("deptno")+" (" );
				System.out.print( rs.getString("dname")+"), " );
				System.out.println( rs.getDate("hiredate") );

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
				if( rs!=null ) rs.close();
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
