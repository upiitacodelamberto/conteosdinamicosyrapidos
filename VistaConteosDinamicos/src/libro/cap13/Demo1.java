
package libro.cap13;

import java.io.FileInputStream;
import java.util.Scanner;

public class Demo1
{
	public static void main(String[] args) throws Exception
	{
		FileInputStream fis = null;
		fis = new FileInputStream("demo.txt");

		Scanner sc = new Scanner(fis);

		int leg = sc.nextInt();
		String nom = sc.next();

		while( !nom.equals("FIN") )
		{
			System.out.println(leg + ", " + nom);

			leg = sc.nextInt();
			nom = sc.next();
		}

		fis.close();
	}
}



// popfofpospfopfofp




