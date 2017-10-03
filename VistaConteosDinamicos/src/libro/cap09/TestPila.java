
package libro.cap09;

public class TestPila
{
	public static void main(String[] args)
	{
		Pila<Integer> pila = new Pila<Integer>();
		pila.apilar(3);
		pila.apilar(2);
		pila.apilar(1);
		
		System.out.println(pila.desapilar().getInfo());
		System.out.println(pila.desapilar().getInfo());
		System.out.println(pila.desapilar().getInfo());
	}
}
