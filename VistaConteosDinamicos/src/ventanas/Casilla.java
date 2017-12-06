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
	// String datosDCasilla[];
	PositionStringPair datosDCasilla[];
	String CasillaLine;

	public Casilla() {
	}

	public Casilla(int id, String id_e, String e, String id_d_l, String d_l, String s, String id_c, String tip_c,
			String s8) {
		IdCasilla = id;
		id_estado = id_e;
		estado = e;
		id_distrito_local = id_d_l;
		distrito_local = d_l;
		seccion = s;
		id_casilla = id_c;
		tipo_Casilla = tip_c;
		extraordinariacontigua = s8;
	}

	// public Casilla(int id,String datosCasilla[]) {/*2017.11.07.20.04*/
	public Casilla(int id, PositionStringPair datosCasilla[]) {/* 2017.11.07.20.04 */
		// IdCasilla=id;
		// id_estado=datosCasilla[0];
		// estado=datosCasilla[1];
		// id_distrito_local=datosCasilla[2];
		// distrito_local=datosCasilla[3];
		// seccion=datosCasilla[4];
		// id_casilla=datosCasilla[5];
		// tipo_Casilla=datosCasilla[6];
		// extraordinariacontigua=datosCasilla[7];
		IdCasilla = id;
		id_estado = datosCasilla[0].StringLineaDCasItem;
		estado = datosCasilla[1].StringLineaDCasItem;
		id_distrito_local = datosCasilla[2].StringLineaDCasItem;
		distrito_local = datosCasilla[3].StringLineaDCasItem;
		seccion = datosCasilla[4].StringLineaDCasItem;
		id_casilla = datosCasilla[5].StringLineaDCasItem;
		tipo_Casilla = datosCasilla[6].StringLineaDCasItem;
		extraordinariacontigua = datosCasilla[7].StringLineaDCasItem;
		this.datosDCasilla = datosCasilla;
	}
	public Casilla(int id,PositionStringPair datosCasilla[],String line) {/*2017.11.30.18.32*/
		IdCasilla = id;
		id_estado = datosCasilla[0].StringLineaDCasItem;
		estado = datosCasilla[1].StringLineaDCasItem;
		id_distrito_local = datosCasilla[2].StringLineaDCasItem;
		distrito_local = datosCasilla[3].StringLineaDCasItem;
		seccion = datosCasilla[4].StringLineaDCasItem;
		id_casilla = datosCasilla[5].StringLineaDCasItem;
		tipo_Casilla = datosCasilla[6].StringLineaDCasItem;
		extraordinariacontigua = datosCasilla[7].StringLineaDCasItem;
		this.datosDCasilla = datosCasilla;
		CasillaLine=line;
	}

	public String toString() {
		String str = "";
		// str+="Casilla "+IdCasilla+" ";
		// str+=id_estado+" ";
		// str+=estado+" ";
		// str+=id_distrito_local+" ";
		// str+=distrito_local+" ";
		// str+=seccion+ " ";
		// str+=id_casilla+" ";
		// str+=tipo_Casilla+" ";
		// str+=extraordinariacontigua;
		str += "Casilla " + IdCasilla + " ";
		str += datosDCasilla[0].StringLineaDCasItem + " ";
		str += datosDCasilla[1].StringLineaDCasItem + " ";
		str += datosDCasilla[2].StringLineaDCasItem + " ";
		str += datosDCasilla[3].StringLineaDCasItem + " ";
		str += datosDCasilla[4].StringLineaDCasItem + " ";
		str += datosDCasilla[5].StringLineaDCasItem + " ";
		str += datosDCasilla[6].StringLineaDCasItem + " ";
		str += datosDCasilla[7].StringLineaDCasItem;
		return str;
	}

	Boolean comparar(Casilla c) {
		if ((id_estado.equals(c.id_estado)) && (id_distrito_local.equals(c.id_distrito_local))
				&& (seccion.equals(c.seccion)) && (id_casilla.equals(c.id_casilla))
				&& (tipo_Casilla.equals(c.tipo_Casilla)) && extraordinariacontigua.equals(c.extraordinariacontigua)) {
			return true;
		} else {
			return false;
		}
	}

	void print() {
		for (int i = 0; i < datosDCasilla.length; i++) {
			System.out.print(datosDCasilla[i] + " ");
		}
		System.out.println();
	}// end print()
}// end class Casilla
