package libro.cap02.excepciones;

public class Usuario
{
	private String usrname;
	private String password;
	private String nombre;
	private String email;
	
	public String toString()
	{
		return usrname+", "+ nombre+ ", "+email;
	}
	
	public String getUsrname()
	{
		return usrname;
	}
	public void setUsrname(String usrname)
	{
		this.usrname = usrname;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getNombre()
	{
		return nombre;
	}
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
}
