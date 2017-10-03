
package libro.cap13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Demo5
{
	public static void main(String[] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader(args[0]));
		BufferedWriter bw = new BufferedWriter(new FileWriter(args[1]));
		
		int c = br.read();
		while( c != -1 )
		{
			bw.write(c);
			c = br.read();
		}
		
		bw.close();
		br.close();
	}
}






