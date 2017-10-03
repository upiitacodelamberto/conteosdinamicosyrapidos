
package libro.cap10;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import libro.cap10.mapping.ConnectionPoolTag;
import libro.cap10.mapping.ConnectionTag;
import libro.cap10.mapping.JDBCTag;
import libro.cap10.mapping.PoolTag;
import libro.cap10.mapping.PoolsTag;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class CPoolXMLHandler extends DefaultHandler
{
	private static ConnectionPoolTag connectionpoolTag;
	private JDBCTag jdbc;
	private PoolsTag pools;
	

	public void startElement(String uri, String localName, String qName,
			Attributes attributes)
	{
		if( qName.equals("connection-pool") )
		{
			//connectionpoolTag = new ConnectionPoolTag();
		}

		if( qName.equals("jdbc") )
		{
			jdbc = new JDBCTag();
			connectionpoolTag.setJdbc(jdbc);
		}

		if( qName.equals("pools") )
		{
			pools = new PoolsTag();
			connectionpoolTag.setPools(pools);
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
	
	public static ConnectionPoolTag getConnectionPoolTag()
	{
		try
		{
   		if( connectionpoolTag == null )
   		{
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            
            sp.parse("connectionpool.xml", new CPoolXMLHandler() );     			
   		}
		
   		return connectionpoolTag;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			throw new RuntimeException(ex);
		}
	}
}
