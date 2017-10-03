
package libro.cap08.app.ver2;

import java.util.Collection;

import libro.cap08.app.sql.ConsolaSQL;

public class ClientePruebaConsolaSQL
{
	public static void main(String[] args) throws Exception
	{
		ConsolaSQL f = (ConsolaSQL)ServiceLocatorRMI.lookup("ConsolaSQL");

		Collection<String> coll= f.executeQuery("SELECT * FROM EMP");
		
		for(String s:coll)
		{
			System.out.println(s);
		}
		
	
	}
}
