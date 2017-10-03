
package libro.cap08.app.ver1;

import java.util.Collection;

import libro.cap04.DeptDTO;
import libro.cap04.EmpDTO;
import libro.cap04.FacadeTCPImple;

public class TestFacadeCliente
{
	public static void main(String[] args)
	{
		FacadeTCPImple f = new FacadeTCPImple();
		Collection<DeptDTO> depts = f.obtenerDepartamentos();
		
		for(DeptDTO dto: depts)
		{
			System.out.println( dto );
		}
		
		Collection<EmpDTO> emps = f.obtenerEmpleados(1);
		
		for(EmpDTO dto: emps)
		{
			System.out.println( dto );
		}
	}
}
