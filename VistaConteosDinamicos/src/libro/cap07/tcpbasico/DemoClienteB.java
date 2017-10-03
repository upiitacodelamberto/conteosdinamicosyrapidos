
package libro.cap07.tcpbasico;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class DemoClienteB
{
	private static final int BUFFER_LENGTH = 3;
	
	public static void main(String[] args) throws Exception
	{
		
		BufferedReader br = null;
		BufferedWriter bw = null;

		Socket s = null;
		
		try
		{
			s = new Socket("127.0.0.1",5432);
			bw = new BufferedWriter(new PrintWriter(s.getOutputStream()));
			br= new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			char bEnvia[] = "Pablo".toCharArray();
			char bRecibe[] = new char[BUFFER_LENGTH];
			bw.write(bEnvia);
			bw.flush();
			
			int n;
			StringBuffer sb = new StringBuffer();
			while( (n=br.read(bRecibe)) == BUFFER_LENGTH )
			{
				sb.append(bRecibe);
			}
			sb.append(bRecibe,0,n);
			
			System.out.println(sb);
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			if( br != null ) br.close();
			if( bw != null ) bw.close();
			if( s != null ) s.close();
		}
	}
}
