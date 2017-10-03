
package libro.cap02.interfaces;


public class Util
{
	@SuppressWarnings("unchecked")
	public static void ordenar(Comparable arr[])
	{
		boolean ordenado = false;
		while( !ordenado )
		{
			ordenado = true;
			for( int i = 0, j = arr.length - 1; i <= j; i++, j-- )
			{
				if( arr[i + 1].compareTo(arr[i]) < 0 )
				{
					Comparable aux = arr[i];
					arr[i] = arr[i + 1];
					arr[i + 1] = aux;
					ordenado = false;
				}
			}
		}
	}
}
