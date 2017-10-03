package libro.cap10.mapping;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;


public class ConnectionPoolTag extends DefaultHandler
{
	private JDBCTag jdbc;
	private PoolsTag pools;
	
	private static ConnectionPoolTag instancia = null;
	
	public String toString()
	{
		String x="";
		x+="-- JDBC --\n";
		x+=jdbc.toString();
		x+="-- POOLes --\n";
		x+=pools.toString();
		return x;
	}
	
	public JDBCTag getJdbc()
	{
		return jdbc;
	}

	public void setJdbc(JDBCTag jdbc)
	{
		this.jdbc = jdbc;
	}

	public PoolsTag getPools()
	{
		return pools;
	}

	public void setPools(PoolsTag pools)
	{
		this.pools = pools;
	}

	private ConnectionPoolTag()
	{
		jdbc = new JDBCTag();
		pools = new PoolsTag();
	}
	
	
	public static ConnectionPoolTag getInstancia()
	{
		try
		{
   		if( instancia == null )
   		{
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            
            sp.parse("connectionpool.xml", new ConnectionPoolTag() );     						
   		}
   		
   		return instancia;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException();
		}
	}
	
	public void startElement(String uri, String localName, String qName,
			Attributes attributes)
	{
		if( qName.equals("connection-pool") )
		{
			instancia = new ConnectionPoolTag();
		}

		if( qName.equals("jdbc") )
		{
			jdbc = new JDBCTag();
			instancia.setJdbc(jdbc);
		}

		if( qName.equals("pools") )
		{
			pools = new PoolsTag();
			instancia.setPools(pools);
		}

		if( qName.equals("connection") )
		{
			ConnectionTag c = new ConnectionTag();
			c.setName(attributes.getValue("name"));
			c.setDriver(attributes.getValue("driver"));
			c.setUrl(attributes.getValue("url"));
			c.setUsr(attributes.getValue("usr"));
			c.setPwd(attributes.getValue("pwd"));
			jdbc.addConnectionTag(c);
		}

		if( qName.equals("pool") )
		{
			int min = Integer.parseInt(attributes.getValue("minsize"));
			int max = Integer.parseInt(attributes.getValue("maxsize"));
			int steep = Integer.parseInt(attributes.getValue("steep"));
			
			PoolTag c = new PoolTag();
			c.setName(attributes.getValue("name"));
			c.setMinsize(min);
			c.setMaxsize(max);
			c.setSteep(steep);
			pools.addPoolTag(c);
		}		
	}

	public void endElement(String uri, String localName, String qName)
	{
	}


}
