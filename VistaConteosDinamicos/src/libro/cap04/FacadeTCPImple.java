
package libro.cap04;

import java.util.Collection;

import libro.cap08.app.ver1.ServiceLocator;


public class FacadeTCPImple implements Facade
{
	public Collection<DeptDTO> obtenerDepartamentos()
	{
		return ServiceLocator.obtenerDepartamentos();
	}
	
	public Collection<EmpDTO> obtenerEmpleados(int deptno)
	{
		return ServiceLocator.obtenerEmpleados(deptno);
	}
}
