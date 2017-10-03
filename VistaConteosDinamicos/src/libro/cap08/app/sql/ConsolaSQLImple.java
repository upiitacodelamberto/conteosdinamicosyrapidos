package libro.cap08.app.sql;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Collection;
import java.util.Vector;

import libro.cap04.UConnection;

public class ConsolaSQLImple extends UnicastRemoteObject implements ConsolaSQL
{
	private Connection con = null;
	
	public ConsolaSQLImple() throws RemoteException
	{
		super();
		con = UConnection.getConnection();
	}

	public Collection<String> executeQuery(String query) throws RemoteException
	{
		ResultSet rs = null;
		Statement stm = null;
		try
		{
			stm = con.createStatement();
			rs = stm.executeQuery(query);
			
			Vector<String> ret = new Vector<String>();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			
			StringBuffer sb = new StringBuffer();
			while( rs.next() )
			{
				for( int i=1 ; i<= columnCount; i++)
				{
					sb.append(rs.getString(i));
					sb.append(i<=columnCount?", ":" ");
				}
				
				ret.add(sb.toString());
				sb.delete(0,sb.length());
			}
			
			return ret;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try
			{
				if( rs!= null ) rs.close();
				if( stm!=null ) stm.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}

	public int executeUpdate(String update) throws RemoteException
	{
		Statement stm = null;
		try
		{
			stm = con.createStatement();
			int res = stm.executeUpdate(update);
			
			return res;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
		finally
		{
			try
			{
				if( stm!=null ) stm.close();
			}
			catch(Exception ex)
			{
				ex.printStackTrace();
				throw new RuntimeException(ex);
			}
		}
	}

}
