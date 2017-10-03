
package libro.cap08.app.ver2;

import java.util.Collection;

public class ClientePruebaRMI
{
	public static void main(String[] args) throws Exception
	{
		FacadeRemoto f = (FacadeRemoto)ServiceLocatorRMI.lookup("FacadeRemoto");
		Collection<String> sDepts = f.obtenerDepartamentos();
		
		for(String s:sDepts )
		{
			System.out.println(s);
		}
		
		Collection<String> sEmps = f.obtenerEmpleados(1);

		for(String s:sEmps)
		{
			System.out.println(s);
		}
	}
}
