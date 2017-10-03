
package libro.cap07;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class DemoCliente
{
	public static void main(String[] args) throws Exception
	{
		
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		Socket s = null;
				
		try
		{
			s = new Socket("127.0.0.1",5432);
			oos = new ObjectOutputStream(s.getOutputStream());
			ois = new ObjectInputStream(s.getInputStream());
		
			oos.writeObject("Pablo");
			
			String ret = (String)ois.readObject();
			
			System.out.println(ret);
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if( ois != null ) ois.close();
			if( oos != null ) oos.close();
			if( s != null ) s.close();
		}
	}
}
