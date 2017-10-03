
package libro.apendiceA;

import java.util.Scanner;

public class MayorDeEdad
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese su nombre: ");
		String nom = scanner.next();

		System.out.print("Ingrese su edad: ");
		int edad  = scanner.nextInt();
		
		if( edad >= 21 )
		{
			System.out.println(nom+", Ud. es mayor de edad");
		}
		else
		{
			System.out.println(nom+", eres muy joven aun...");
		}
	}
}
