package libro.cap10.mapping;

import java.util.Enumeration;
import java.util.Hashtable;

public class PoolsTag
{
	private Hashtable<String,PoolTag> pool;
	
	public String toString()
	{
		String x="";
		
		PoolTag aux;
		for(Enumeration<String> e=pool.keys(); e.hasMoreElements(); )
		{
			aux = pool.get(e.nextElement());
			x+=aux+"\n";
		}
		return x;
	}
	
	public PoolsTag()
	{
		pool = new Hashtable<String, PoolTag>();
	}
	
	public PoolTag getPoolTag(String name)
	{
		return pool.get(name);
	}
	
	public void addPoolTag(PoolTag c)
	{
		pool.put(c.getName(),c);
	}
}
