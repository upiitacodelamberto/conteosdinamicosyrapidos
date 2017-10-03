package libro.cap04;

import java.util.Hashtable;
import java.util.ResourceBundle;

public class UFactory
{
	private static Hashtable<String,Object> instancias = new Hashtable<String,Object>();
	
	public static Object getInstancia(String objName)
	{
		try
		{
			Object obj = instancias.get(objName);
			
			if( obj == null )
			{
   			ResourceBundle rb = ResourceBundle.getBundle("factory");
   			String sClassname = rb.getString(objName);
   			obj = Class.forName(sClassname).newInstance();
   			
   			instancias.put(objName,obj);
			}
			
			return obj;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
	
	public static void main(String[] args)
	{
		Object o1 = getInstancia("EMP");
		Object o2 = getInstancia("EMP");
	
		System.out.println(  (o1 == o2) ? "iguales": "distintos");
		
	}
	
	
}
