package libro.cap04.contratos;

import java.util.Collection;
import java.util.Vector;

import libro.cap04.DeptDTO;

public class DeptImpleTemp implements Dept
{

	public Collection<DeptDTO> buscarTodos()
	{
		DeptDTO d1 = new DeptDTO();
		d1.setDeptno(1);
		d1.setDname("Ventas");
		d1.setLoc("Capital");

		DeptDTO d2 = new DeptDTO();
		d2.setDeptno(2);
		d2.setDname("Compras");
		d2.setLoc("Capital");

		DeptDTO d3 = new DeptDTO();
		d3.setDeptno(3);
		d3.setDname("RRHH");
		d3.setLoc("Buenos Aires");
	
		Vector<DeptDTO> v = new Vector<DeptDTO>();
		v.add(d1);
		v.add(d2);
		v.add(d3);
		
		return v;
	}
}
