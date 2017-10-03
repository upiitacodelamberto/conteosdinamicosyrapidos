
package libro.cap02.excepciones;

public class TestLogin 
{
	public static void main(String[] args)
	{
		try
		{
			Aplicacion app = new Aplicacion();
			Usuario u = app.login("juan","juan123sito");
		
			System.out.println(u);
   	}
		catch(ErrorFisicoException ex)
		{
			System.out.println( ex.getMessage() );
		}
	}
}
