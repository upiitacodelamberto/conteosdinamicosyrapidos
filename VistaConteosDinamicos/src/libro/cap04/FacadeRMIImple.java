package libro.cap04;

import java.util.Collection;
import java.util.Vector;

import libro.cap08.app.ver1.UDto;
import libro.cap08.app.ver2.FacadeRemoto;
import libro.cap08.app.ver2.ServiceLocatorRMI;

public class FacadeRMIImple implements Facade
{
	public FacadeRemoto remoto;
	
	public FacadeRMIImple()
	{
		// obtengo el objeto remoto
		remoto = (FacadeRemoto) ServiceLocatorRMI.lookup("FacadeRemoto");
	}
	
	public Collection<DeptDTO> obtenerDepartamentos()
	{
		try
		{
			// delego la llamada
   		Collection<String> coll = remoto.obtenerDepartamentos();
   		
   		// convierto la coleccion
   		Vector<DeptDTO> ret = new Vector<DeptDTO>();
   		for(String s:coll)
   		{
   			ret.add(UDto.stringToDeptDTO(s));
   		}
   		
   		return ret;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	public Collection<EmpDTO> obtenerEmpleados(int deptno)
	{
		try
		{
			// delego la llamada
   		Collection<String> coll = remoto.obtenerEmpleados(deptno);
   		
   		// convierto la coleccion
   		Vector<EmpDTO> ret = new Vector<EmpDTO>();
   		for(String s:coll)
   		{
   			ret.add(UDto.stringToEmpDTO(s));
   		}
   		return ret;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}	
	}
}
