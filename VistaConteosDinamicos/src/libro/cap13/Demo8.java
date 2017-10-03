
package libro.cap13;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class Demo8
{
	public static void main(String[] args) throws Exception
	{
		String arch = "personas.dat";
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(arch));
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		
		oos.writeObject(new Persona(10,"Pablo","23.112.223"));
		oos.writeObject(new Persona(20,"Pedro","35.213.321"));
		oos.writeObject(new Persona(30,"Juan","17.554.843"));

		oos.close();
		bos.close();
	}
}
