package libro.cap07.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ObjetoRemoto extends Remote
{
	public String obtenerSaludo(String nombre, int delay) throws RemoteException;
}
