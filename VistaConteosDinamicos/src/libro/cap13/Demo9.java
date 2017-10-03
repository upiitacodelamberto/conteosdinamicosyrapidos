
package libro.cap13;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Demo9
{
	public static void main(String[] args) throws Exception
	{
		String arch = "personas.dat";
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(arch));
		ObjectInputStream ois = new ObjectInputStream(bis);
		
		Persona p = (Persona)ois.readObject();
		try
		{
   		while( true )
   		{
   			System.out.println( p );
   			p = (Persona)ois.readObject();
   		}
		}
		catch(EOFException ex)
		{
			System.out.println("-- EOF --");
		}
		
		ois.close();
		bis.close();
	}
}
