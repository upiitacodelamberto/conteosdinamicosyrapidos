
package libro.cap09;

public class TestCola
{
	public static void main(String[] args)
	{
		Cola2<Integer> c = new Cola2<Integer>();
		c.encolar(1);
		c.encolar(2);
		c.encolar(3);
		System.out.println(c.desencolar().getInfo());
		c.encolar(4);
		c.encolar(5);
		System.out.println(c.desencolar().getInfo());
		System.out.println(c.desencolar().getInfo());
		System.out.println(c.desencolar().getInfo());
		System.out.println(c.desencolar().getInfo());
	}
}
