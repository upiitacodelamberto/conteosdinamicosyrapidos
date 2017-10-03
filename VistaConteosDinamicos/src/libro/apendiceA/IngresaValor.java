
package libro.apendiceA;

import java.util.Scanner;

public class IngresaValor
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.print("Ingrese un valor: ");
	
		int v  = scanner.nextInt();
		
		System.out.println("Gracias por ingresar el valor: "+v);
	}
}
