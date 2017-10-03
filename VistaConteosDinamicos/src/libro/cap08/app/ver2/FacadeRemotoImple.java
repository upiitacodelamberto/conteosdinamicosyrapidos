package libro.cap08.app.ver2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Collection;
import java.util.Vector;

import libro.cap04.DeptDAO;
import libro.cap04.DeptDTO;
import libro.cap04.EmpDAO;
import libro.cap04.EmpDTO;
import libro.cap04.UFactory;

public class FacadeRemotoImple extends UnicastRemoteObject implements FacadeRemoto
{
	public FacadeRemotoImple() throws RemoteException
	{
		super();
	}

	public Collection<String> obtenerDepartamentos() throws RemoteException
	{
		DeptDAO dao = (DeptDAO) UFactory.getInstancia("DEPT");
		Collection<DeptDTO> coll = dao.buscarTodos();
		Vector<String> ret = new Vector<String>();
		for(DeptDTO dto:coll )
		{
			ret.add(dto.toString());
		}
		
		return ret;
	}

	public Collection<String> obtenerEmpleados(int deptno) throws RemoteException
	{
		EmpDAO dao = (EmpDAO) UFactory.getInstancia("EMP");
		Collection<EmpDTO> coll = dao.buscarXDept(deptno);
		
		Vector<String> ret = new Vector<String>();
		for(EmpDTO dto:coll )
		{
			ret.add(dto.toString());
		}
		
		return ret;	
	}
}
