
package libro.cap03.demo;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class DemoBatchUpdate
{
	public static void main(String[] args)
	{		
		Connection con=null;
		Statement stm=null;
		
		try
		{
			Scanner scanner = new Scanner(System.in);
			
			System.out.print("Que departamento desea eliminar (deptno desde): ");
			int deptnoDesde=scanner.nextInt();
			
			System.out.print("A donde movemos a los empleados (deptno hasta): ");
			int deptnoHasta=scanner.nextInt();
						
			// obtenemos la conexion
			con = UConnection.getConnection();
			con.setAutoCommit(false);

			// creo el Statement y agrego updates batch
			stm = con.createStatement();
			stm.addBatch("UPDATE emp SET empno = "+deptnoHasta+" WHERE deptno = "+ deptnoDesde);
			stm.addBatch("DELETE FROM dept WHERE deptno = "+deptnoDesde);
			
			// ejecuto y obtengo los resultados
			int[] rtdos = stm.executeBatch();

			// en este caso solo verifico que se haya deleteado el departamento...
			if( rtdos[1]==1 )
			{
				con.commit();
			}
			else
			{
				throw new RuntimeException("Error...");
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
				if( stm!=null ) stm.close();
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
