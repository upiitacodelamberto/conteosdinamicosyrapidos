
package libro.cap09;

public class TestListaEnlazada
{
	public static void main(String[] args)
	{
		// instancio una lista enlazada
		ListaEnlazada<Integer> x = new ListaEnlazada<Integer>();
		
		// le agrego elementos
		x.agregarAlFinal(4);
		x.agregarAlFinal(5);
		x.agregarAlFinal(6);
		x.agregarAlPrincipio(3);
		x.agregarAlPrincipio(2);
		x.agregarAlPrincipio(1);
		
		// muestro el contenido de la lista
		System.out.println(x);
		
		// verifico si existe un nodo con valor 6
		System.out.println(x.buscar(6));
		
		// verifico si existe un nodo con valor 15
		System.out.println(x.buscar(15));
		
		// elimino el nodo cuyo valor es 3
		x.eliminar(3);
		
		// vuelvo a mostrar la lista
		System.out.println(x);
	}
}
