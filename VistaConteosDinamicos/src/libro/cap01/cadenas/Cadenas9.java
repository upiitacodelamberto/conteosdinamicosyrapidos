
package libro.cap01.cadenas;

public class Cadenas9
{
	public static void main(String[] args)
	{
		// dos cadenas iguales
		String s1 = "Hola";
		String s2 = "Hola";

		System.out.println("s1 = [" + s1 + "]");
		System.out.println("s2 = [" + s2 + "]");

		if( s1 == s2 )
		{
			System.out.println("Son iguales");
		}
		else
		{
			System.out.println("Son distintas");
		}	
	}
}
