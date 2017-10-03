
package libro.cap03.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DemoSelect21
{
	public static void main(String[] args)
	{
		
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement pstm=null;
		
		try
		{
			con = UConnection.getConnection();
						
			String sql="";
			sql+="SELECT e.empno ";
		   sql+="      ,e.ename ";
		   sql+="      ,e.deptno ";
		   sql+="      ,d.dname ";
		   sql+="      ,e.hiredate ";
			sql+="FROM emp e, dept d ";
			sql+="WHERE e.empno = d.deptno ";
			
			pstm = con.prepareStatement(sql);
			
			rs = pstm.executeQuery();
			
			while( rs.next() )
			{
				System.out.print( rs.getInt(1)+", " );
				System.out.print( rs.getString(2)+", " );
				System.out.print( rs.getInt(3)+" (" );
				System.out.print( rs.getString(4)+"), " );
				System.out.println( rs.getDate(5) );
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
