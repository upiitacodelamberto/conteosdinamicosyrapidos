
package libro.cap04;

import java.sql.Connection;
import java.util.Collection;

public class TestFacade
{
	public static void main(String[] args)
	{
		Facade facade = (Facade)UFactory.getInstancia("FACADE");

		Collection<EmpDTO> collEmps = null;
		Collection<DeptDTO> collDepts = facade.obtenerDepartamentos();

		for( DeptDTO deptDto : collDepts )
		{
			System.out.println("--> "+deptDto+" <--");
			collEmps = facade.obtenerEmpleados(deptDto.getDeptno());
			for( EmpDTO empDto : collEmps )
			{
				System.out.println(empDto);
			}
		}
	}
}
