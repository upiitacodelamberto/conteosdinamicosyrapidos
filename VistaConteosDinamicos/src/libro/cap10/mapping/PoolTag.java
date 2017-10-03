package libro.cap10.mapping;

public class PoolTag
{
	private String name;
	private int minsize;
	private int maxsize;
	private int steep;
	
	public String toString()
	{
		return name+", "+minsize+", "+maxsize+", "+steep; 
	}

	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getMinsize()
	{
		return minsize;
	}
	public void setMinsize(int minsize)
	{
		this.minsize = minsize;
	}
	public int getMaxsize()
	{
		return maxsize;
	}
	public void setMaxsize(int maxsize)
	{
		this.maxsize = maxsize;
	}
	public int getSteep()
	{
		return steep;
	}
	public void setSteep(int steep)
	{
		this.steep = steep;
	}
	
	
}
