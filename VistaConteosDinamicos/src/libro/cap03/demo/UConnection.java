
package libro.cap03.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class UConnection
{
	private static Connection con=null;
	
	public static Connection getConnection()
	{
		try
		{
			if( con== null )
			{
				ResourceBundle rb=ResourceBundle.getBundle("jdbc");
				String driver=rb.getString("driver");
				String url=rb.getString("url");
				String pwd=rb.getString("pwd");
				String usr=rb.getString("usr");
				
				Class.forName(driver);
				con = DriverManager.getConnection(url,usr,pwd);
			}
			
			return con;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException("Error al crear la conexion",ex);
		}
	}


	public static Object getDAO(String daoName)
	{
		try
		{
			ResourceBundle rb=ResourceBundle.getBundle("jdbc");
			String impleName = rb.getString(daoName);			
			Object imple = Class.forName(impleName).newInstance();
			
			return imple;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
