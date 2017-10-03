package libro.cap04;

import java.util.Collection;

public interface Facade
{
	public Collection<DeptDTO> obtenerDepartamentos();
	public Collection<EmpDTO> obtenerEmpleados(int deptno);
}
