
package libro.cap02.excepciones;

@SuppressWarnings("serial")
public class LoginException extends Exception
{
	public LoginException()
	{
		super("Usuario y/o Password Incorrectos");
	}
}
