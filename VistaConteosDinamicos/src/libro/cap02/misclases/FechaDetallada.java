
package libro.cap02.misclases;

import libro.cap02.fechas.Fecha;

public class FechaDetallada extends Fecha
{
	public FechaDetallada(int dia, int mes, int anio)
	{
		super(dia,mes,anio);
	}
	
	public FechaDetallada(String s)
	{
		super(s);
	}
	
	public FechaDetallada()
	{
		this(0,0,0);
	}
	
	
	
	private static String meses[]={"Enero"
											,"Febrero"
											,"Marzo"
		                           ,"Abril"
		                           ,"Mayo"
		                           ,"Junio"
		                           ,"Julio"
		                           ,"Agosto"
		                           ,"Septiembre"
		                           ,"Octubre"
		                           ,"Noviembre"
		                           ,"Diciembre"};
	
	
	
	public String toString()
	{
		return getDia()+" de "+meses[getMes()-1]+" de "+getAnio();
	}
}
