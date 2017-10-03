
package libro.cap11;

import java.lang.reflect.Method;

public class Demo1
{
	public static void main(String[] args)
	{
		try 
		{
   		String sClass = "libro.cap04.DeptDAO";
   		Class<?> clazz = Class.forName(sClass);
   		
   		Method mtdos[] = clazz.getDeclaredMethods();
   		
   		for(Method mtd: mtdos)
   		{
   			System.out.println(mtd.getName());
   		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
