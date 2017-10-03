package libro.cap08.app.ver2;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import libro.cap08.app.sql.ConsolaSQLImple;


public class ServerRMI
{
	public static void main(String[] args) throws Exception
	{
		Registry registry = LocateRegistry.getRegistry(1099);

		FacadeRemotoImple f= new FacadeRemotoImple();
		registry.rebind("FacadeRemoto",f);
		
		ConsolaSQLImple c = new ConsolaSQLImple();
		registry.rebind("ConsolaSQL",c);
	}
}
