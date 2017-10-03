
package libro.cap03.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DemoDelete
{
	public static void main(String[] args)
	{
		Connection con = null;
		PreparedStatement pstm = null;

		try
		{
			con = UConnection.getConnection();

			String sql = "";
			sql += "DELETE FROM emp WHERE empno = ? ";
			pstm = con.prepareStatement(sql);

			pstm.setInt(1,20);
			int rtdo = pstm.executeUpdate();

			if( rtdo == 1 )
			{
				con.commit();
			}
			else
			{
				throw new RuntimeException("Se intento borrar mas de una fila...");
			}

		}
		catch( Exception ex )
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try
			{
				if( con != null )
					con.rollback();

				if( pstm != null )
					pstm.close();
				if( con != null )
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
