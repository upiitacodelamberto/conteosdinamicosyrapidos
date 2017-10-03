package libro.cap07.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ObjetoRemotoImple extends UnicastRemoteObject implements ObjetoRemoto
{
	
	private int contador=0;
	
	public ObjetoRemotoImple() throws RemoteException
	{
		super();
	}
	
	public String obtenerSaludo(String nombre, int delay) throws RemoteException
	{
		try
		{
   		Thread.sleep(delay);
   		contador++;
   		System.out.println(contador);
   		return "Hola Mundo RMI - "+nombre;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
