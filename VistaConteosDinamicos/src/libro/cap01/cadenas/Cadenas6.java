
package libro.cap01.cadenas;

import java.util.Scanner;

public class Cadenas6
{
	public static void main(String[] args)
	{
		Scanner scanner=new Scanner(System.in);
		System.out.print("Ingrese un valor entero: ");
		int v = scanner.nextInt();
		
		System.out.println("Valor Ingresado: "+v);
		System.out.println("binario = "+Integer.toBinaryString(v));
		System.out.println("octal = "+Integer.toOctalString(v));
		System.out.println("hexadecimal = "+Integer.toHexString(v));
	
		System.out.print("Ingrese una base numerica: ");
		int b = scanner.nextInt();

		String sBaseN=Integer.toString(v,b);
		System.out.println(v + " en base("+b+") = " + sBaseN);	
	}
}
