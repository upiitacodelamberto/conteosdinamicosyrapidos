
package libro.cap04.contratos;

import java.util.Collection;

import libro.cap04.DeptDTO;
import libro.cap04.UFactory;

public class MuestraDepartamentos
{
	public static void main(String[] args)
	{
		Dept d = (Dept) UFactory.getInstancia("DEPT");
		Collection<DeptDTO> coll = d.buscarTodos();
		for(DeptDTO dto: coll)
		{
			System.out.println(dto);
		}
	}
}
