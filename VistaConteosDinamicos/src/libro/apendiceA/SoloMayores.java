
package libro.apendiceA;

import java.util.Scanner;

public class SoloMayores
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese su nombre: ");
		String nom = scanner.next();

		System.out.print("Ingrese su edad: ");
		int edad  = scanner.nextInt();
		
		while( edad >=21 )
		{
			System.out.println("He registrado a: "+nom+"("+edad+" anios)");
			System.out.print("Ingrese su nombre: ");
			nom = scanner.next();

			System.out.print("Ingrese su edad: ");
			edad  = scanner.nextInt();
		}
		
		System.out.println("Cuidado, hay un menor entre vosotros...");
	
	}
}
