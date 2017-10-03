
package libro.apendiceA;

import java.util.Scanner;

public class SumaValores
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese un valor: ");
		int v1  = scanner.nextInt();

		System.out.print("Ingrese otro valor: ");
		int v2  = scanner.nextInt();
		
		int suma = v1 + v2;
		
		System.out.println("La suma de "+v1+" + "+v2+" es: "+suma);
	}
}
