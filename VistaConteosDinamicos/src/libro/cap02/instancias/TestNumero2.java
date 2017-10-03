
package libro.cap02.instancias;

public class TestNumero2
{
	public static void main(String[] args)
	{
		// creo un numero (inicialmente en cero)
		Numero n1 = new Numero(2);
		Numero n2 = new Numero(3);

		// a n1 le sumo el objeto n2
		n1.sumar(n2);

		System.out.println(n1);

		// a n1 le sumo una instancia de Numero
		n1.sumar(new Numero(5));

		System.out.println(n1);
	}
}
