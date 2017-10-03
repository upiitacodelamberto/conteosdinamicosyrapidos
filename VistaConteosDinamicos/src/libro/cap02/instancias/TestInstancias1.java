
package libro.cap02.instancias;

import libro.cap02.fechas.Fecha;
import libro.cap02.misclases.FechaDetallada;

public class TestInstancias1
{
	public static void main(String[] args)
	{
		mostrarFecha( new FechaDetallada("25/9/2009") );
	}

	public static void mostrarFecha(Fecha f)
	{
		System.out.println("La fecha es: " + f);
	}
}
