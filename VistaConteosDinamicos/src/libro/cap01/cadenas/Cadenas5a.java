
package libro.cap01.cadenas;

public class Cadenas5a
{
	public static void main(String[] args)
	{
		long hi = System.currentTimeMillis();
		StringBuffer sb=new StringBuffer();
		int n=1000000;
		
		char c;
		for(int i=0; i<n; i++)
		{
			c = (char)('A' + i%('Z'-'A'+1));
			sb.append(c);
		}
		long hf = System.currentTimeMillis();
		System.out.println(sb.toString());
		System.out.println((hf-hi)+" milisegundos");
	}
}
