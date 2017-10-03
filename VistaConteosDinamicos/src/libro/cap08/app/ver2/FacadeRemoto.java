package libro.cap08.app.ver2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

public interface FacadeRemoto extends Remote
{
	public Collection<String> obtenerDepartamentos() throws RemoteException;
	public Collection<String> obtenerEmpleados(int deptno) throws RemoteException;
}
