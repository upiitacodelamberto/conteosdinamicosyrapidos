
package libro.cap02;

import libro.cap02.fechas.Fecha;
import libro.cap02.misclases.FechaDetallada;
import libro.cap02.misclases.FechaHora;

public class TestMuestraConjunto
{
	public static void main(String[] args)
	{
		Object[] arr = { new Fecha(2,10,1970)
		               , new FechaDetallada("23/12/1948")
      			      , new FechaHora("4/9/2003",21,15,0)
						   , new String("Esto es una cadena")
		               , new Integer(34) };
		
		MuestraConjunto mc = new MuestraConjunto();
		
		mc.mostrar(arr);
		
	
	}
}
