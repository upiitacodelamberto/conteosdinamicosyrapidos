package libro.cap02.colecciones;

public class MiCola<T>
{
	private static final int capacidadInicial = 5;
	private MiColeccion<T> coll = new MiColeccion<T>(capacidadInicial);
	
	public void encolar(T elm)
	{
		coll.agregar(elm);
	}
	
	public T desencolar()
	{
		return coll.eliminar(0);
	}
}