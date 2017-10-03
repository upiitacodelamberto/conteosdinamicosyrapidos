package libro.cap08.app.sql;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Collection;

import libro.cap04.UConnection;

public interface ConsolaSQL extends Remote
{
	public Collection<String> executeQuery(String query) throws RemoteException;
	public int executeUpdate(String update) throws RemoteException;
}
