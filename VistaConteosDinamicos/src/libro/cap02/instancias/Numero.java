package libro.cap02.instancias;

public class Numero
{
	private double valor;
	
	public Numero(double v)
	{
		valor = v;
	}

	public Numero()
	{
		this(0);
	}	
	
	public Numero sumar(Numero n)
	{
		valor +=n.valor;
		return this;
	}
	
	public Numero sumar(double n)
	{
		valor+=n;
		return this;
	}
	
	public String toString()
	{
		return Double.toString(valor);
	}
	
	public double getValor()
	{
		return valor;
	}

	public void setValor(double valor)
	{
		this.valor = valor;
	}
}

