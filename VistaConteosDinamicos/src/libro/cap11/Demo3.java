
package libro.cap11;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@SuppressWarnings("unchecked")
public class Demo3
{
	public static void main(String[] args)
	{
		try 
		{
			// nombre de la clase
   		String sClass = "java.awt.Button";
   		Class clazz = Class.forName(sClass);
   		
   		// lista de metodos
   		Method mtdos[] = clazz.getDeclaredMethods();
   		
   		String m;
   		for(Method mtd: mtdos)
   		{
   			m = "";
   			
   			// determino que modificadores aplican al metodo
   			m += _evalModif(mtd,Modifier.PRIVATE,"private");
   			m += _evalModif(mtd,Modifier.PROTECTED,"protected");
   			m += _evalModif(mtd,Modifier.PUBLIC,"public");
   			m += _evalModif(mtd,Modifier.STATIC,"static");
   			m += _evalModif(mtd,Modifier.ABSTRACT,"abstract");
   			m += _evalModif(mtd,Modifier.FINAL,"final");
   			m += _evalModif(mtd,Modifier.SYNCHRONIZED,"synchronized");
   			
   			// determino que tipo de datos retorna
   			m+=" "+mtd.getReturnType().getSimpleName()+" ";
   				
   			// determino el nombre del metodo
   			m+=mtd.getName();
   			
   			// obtengo la lista de parametros
   			m+=_tiposParams(mtd.getParameterTypes());
   			
   			// muestro el prototipo del metodo
   			System.out.println(m);
   		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}

	private static String _tiposParams(Class[] parameterTypes)
	{
		String ret="";
		
		ret+="(";
		for(int i=0; i<parameterTypes.length; i++)
		{
			ret+=parameterTypes[i].getSimpleName()+((i<parameterTypes.length-1)?",":"");
		}
		ret+=")";
		return ret;
	}

	private static String _evalModif(Method mtd, int m, String desc)
	{
		return (mtd.getModifiers() & m ) == m ? " "+desc: "";
	}
}