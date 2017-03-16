package ventanas;

import java.awt.List;

public class Coalicion {
	String nombreDCoalicion;
	List LPartido;
	public Coalicion(String name,List L){
		nombreDCoalicion=name;
		LPartido=L;
	}//end Coalicion()
	
	public String toString(){
		String S=nombreDCoalicion;
		String LItem[ ]=LPartido.getItems();
		for(int i=0;i<LItem.length;i++){
			S+="\n"+LItem[i];
		}
		S+="\n";
		return S;
	}
	public static void main(String[] args) {
		List lista=new List();
		lista.add("PARTIDO 1");
		lista.add("PARTIDO 2");
		lista.add("PARTIDO 3");
		Coalicion Coal=new Coalicion("Coalición de Prueba",lista);
		System.out.println(Coal);
	}
}//end class Coalicion