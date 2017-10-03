
package libro.cap01.cadenas;

public class Cadenas5
{
	public static void main(String[] args)
	{
		String s = "Un buen libro de Java, un buen material";

		int pos1 = s.indexOf("buen");     // retorna 3
		int pos2 = s.lastIndexOf("buen"); // returna 26 
		System.out.println(pos1);  
		System.out.println(pos2);
	}
}
