
package libro.cap07.rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClienteRMI
{
	public static void main(String[] args) throws Exception
	{
		Registry registry = LocateRegistry.getRegistry("localhost",1099);
		
		ObjetoRemoto objRemoto = (ObjetoRemoto) registry.lookup("OBJREMOTO");
		String saludo = objRemoto.obtenerSaludo(args[0],Integer.parseInt(args[1]));
		
		System.out.println(saludo);
	}
}
