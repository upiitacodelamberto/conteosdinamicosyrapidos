
package libro.cap02.fechas;

public class TestFecha
{
	public static void main(String[] args)
	{
		Fecha f = new Fecha();
		
		Fecha fs = new Fecha("25/9/2008");
		System.out.println(fs);
		f.setDia(2);
		f.setMes(10);
		f.setAnio(1970);

		// imprimo el dia
		System.out.println("Dia="+f.getDia());
		
		// imprimo el mes
		System.out.println("Mes="+f.getMes());
		
		// imprimo el anio
		System.out.println("Anio="+f.getAnio());
		
		// imprimo la fecha
		System.out.println(f);
	}
}
