package libro.cap10.mapping;

public class ConnectionTag
{
	private String name;
	private String usr;
	private String pwd;
	private String url;
	private String driver;
	
	public String toString()
	{
		return name+", "+usr+", "+pwd+", "+url+", "+driver; 
	}
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getUsr()
	{
		return usr;
	}
	public void setUsr(String usr)
	{
		this.usr = usr;
	}
	public String getPwd()
	{
		return pwd;
	}
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}
	public String getUrl()
	{
		return url;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public String getDriver()
	{
		return driver;
	}
	public void setDriver(String driver)
	{
		this.driver = driver;
	}
	
	
}
