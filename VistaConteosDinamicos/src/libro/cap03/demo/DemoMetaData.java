
package libro.cap03.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class DemoMetaData
{
	public static void main(String[] args)
	{
		Connection con=null;
		ResultSet rs=null;
		PreparedStatement pstm=null;
		
		try
		{
			con = UConnection.getConnection();
			
			System.out.println(con.getClass().getName());
			
			String sql="";

			sql+="SELECT e.empno AS empno ";
			sql+="     , e.ename AS ename ";
			sql+="     , e.hiredate AS fecha ";
			sql+="     , e.deptno AS deptno ";
			sql+="     , d.dname AS dname ";
			sql+="     , d.loc AS loc ";
			sql+="FROM emp e, dept d ";
			sql+="WHERE e.deptno = d.deptno ";

			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			ResultSetMetaData md = rs.getMetaData();
			
			_mostrarMetaData(md);
			_mostrarData(rs);

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
	}

	private static void _mostrarMetaData(ResultSetMetaData md) throws Exception
	{
		int cantCols = md.getColumnCount();
		
		
		System.out.println(cantCols+" columnas obtenidas");
		System.out.println();
		for( int i=1; i<=cantCols; i++ )
		{
			System.out.print("Columna Nro. "+i+", ");
			System.out.print("Label: "+md.getColumnLabel(i)+", ");
			System.out.print("Type: "+md.getColumnType(i)+" (");
			System.out.print(md.getColumnTypeName(i)+"), " );
			System.out.println("Precision: "+md.getPrecision(i));
		}
		System.out.println();
	}
	
	
	private static void _mostrarData(ResultSet rs) throws Exception
	{
		int cantCols = rs.getMetaData().getColumnCount();
		while( rs.next() )
		{
			for( int i=1; i<=cantCols; i++ )
			{			
				System.out.print( rs.getString(i));
				System.out.print( i<cantCols?" ,":" ");
			}
			
			System.out.println();
		}
	}

}
