
package libro.cap13;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;

public class Demo4
{
	public static void main(String[] args) throws Exception
	{
		FileReader fr = new FileReader(args[0]);
		FileWriter fw = new FileWriter(args[1]);
		
		int c = fr.read();
		while( c != -1 )
		{
			fw.write(c);
			c = fr.read();
		}
		
		fw.close();
		fr.close();
	}
}






