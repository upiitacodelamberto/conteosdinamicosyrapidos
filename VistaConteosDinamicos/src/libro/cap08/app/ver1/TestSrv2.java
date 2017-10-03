
package libro.cap08.app.ver1;

import java.util.Collection;

import libro.cap04.EmpDTO;


public class TestSrv2
{
	public static void main(String[] args) throws Exception
	{
		Collection<EmpDTO> coll = ServiceLocator.obtenerEmpleados(1);
		for(EmpDTO dto:coll )
		{
			System.out.println(dto);
		}
	}
}
