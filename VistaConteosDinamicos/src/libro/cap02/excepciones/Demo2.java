
package libro.cap02.excepciones;

public class Demo2
{
	public static void main(String[] args) throws Exception
	{
		try
		{
			int i = Integer.parseInt("Esto tira un NumberFormatException");
		}
		catch(ArrayIndexOutOfBoundsException ex)
		{
			System.out.println("Entre al catch...");
		}
		finally
		{
			System.out.println("Esto sale siempre !");
		}
	}
}
