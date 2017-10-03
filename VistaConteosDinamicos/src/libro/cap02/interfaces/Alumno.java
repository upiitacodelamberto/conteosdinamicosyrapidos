
package libro.cap02.interfaces;

public class Alumno implements Comparable<Alumno>
{
	private String nombre;
	private int edad;
	private double notaPromedio;

	public Alumno(String nom, int e, double np)
	{
		this.nombre = nom;
		this.edad = e;
		this.notaPromedio = np;
	}

	public int compareTo(Alumno otroAlumno)
	{
		return this.edad - otroAlumno.edad;
	}
	
	public String toString()
	{
		return nombre+", "+edad+", "+notaPromedio;
	}

	public String getNombre()
	{
		return nombre;
	}

	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}

	public int getEdad()
	{
		return edad;
	}

	public void setEdad(int edad)
	{
		this.edad = edad;
	}

	public double getNotaPromedio()
	{
		return notaPromedio;
	}

	public void setNotaPromedio(double notaPromedio)
	{
		this.notaPromedio = notaPromedio;
	}

}
