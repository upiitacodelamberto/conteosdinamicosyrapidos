package ventanas;

public class Casilla {
	int IdCasilla;
	String id_estado;
	String estado;
	String id_distrito_local;
	String distrito_local;
	String seccion;
	String id_casilla;
	String tipo_Casilla;
	String extraordinariacontigua;
	public Casilla(){ }
	public Casilla(int id,String id_e,String e,String id_d_l,
			String d_l,String s,String id_c,String tip_c,String s8){
		IdCasilla=id;
		id_estado=id_e;
		estado=e;
		id_distrito_local=id_d_l;
		distrito_local=d_l;
		seccion=s;
		id_casilla=id_c;
		tipo_Casilla=tip_c;
		extraordinariacontigua=s8;
	}
	public String toString(){
		String str="";
		str+="Casilla "+IdCasilla+" ";
		str+=id_estado+" ";
		str+=estado+" ";
		str+=id_distrito_local+" ";
		str+=distrito_local+" ";
		str+=seccion+ " ";
		str+=id_casilla+" ";
		str+=tipo_Casilla+" ";
		str+=extraordinariacontigua;
		return str;
	}
	Boolean comparar(Casilla c){
		if((id_estado.equals(c.id_estado))&&
				(id_distrito_local.equals(c.id_distrito_local))&&
				(seccion.equals(c.seccion))&&
				(id_casilla.equals(c.id_casilla))&&
				(tipo_Casilla.equals(c.tipo_Casilla))&&
				extraordinariacontigua.equals(c.extraordinariacontigua)){
			return true;
		}else{
			return false;
		}
	}
}//end class Casilla
