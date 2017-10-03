
package libro.cap13;

import java.io.FileInputStream;

public class Demo3
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fis = new FileInputStream(args[0]);
		
		int c = fis.read();
		
		while( c!=-1 )
		{
			System.out.print((char)c);
			c = fis.read();
		}
		
		fis.close();
	}
}






