
package libro.cap13;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.Scanner;

public class Demo6
{
	public static void main(String[] args) throws Exception
	{
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(args[0]));
		DataOutputStream dos = new DataOutputStream(bos);
		
		Scanner scanner = new Scanner(System.in);
		
		int i = scanner.nextInt();
		while( i>0 )
		{
			dos.writeInt(i);
			i = scanner.nextInt();
		}
		
		dos.close();
		bos.close();
	}
}
