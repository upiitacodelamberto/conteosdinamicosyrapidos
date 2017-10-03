
package libro.cap02.instancias;

public class TestNumero
{
	public static void main(String[] args)
	{
		// creo un numero (inicialmente en cero)
		Numero n1 = new Numero();
		n1.sumar(5); // sumo 5
		n1.sumar(3); // sumo 3
		n1.sumar(2); // sumo 2

		// muestro el valor (de instancia) de n
		System.out.println(n1);

		// sumo 6 + 3 + 1
		n1.sumar(6).sumar(3).sumar(1);

		// muestro el valor resultante
		System.out.println(n1);
	}
}
