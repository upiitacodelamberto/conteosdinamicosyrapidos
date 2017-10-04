package ventanas;
/**
 * PruebaBondadAjuste -- Clase para realizar pruebas de bondad de ajuste 
 *                       JI cuadrada $X^{2}$ para determinar si un conjunto de datos 
 *                       sigue una distribucion uniforme. Se utiliza para ello 
 *                       el estadistico JIcuadarada .
 *                       Hipotesis nula: las frecuencias observadas corresponde a una 
 *                       distribucion uniforme.
 *                       Hipotesis uno: las frecuencias observadas no corresponden a 
 *                       una distribución uniforme.
 * @author Toshiba
 *
 */
public class PruebaBondadAjuste {
	float FE;		/*Frecuencia esperada (Distribucion Uniforme)*/
	int FO[];		/*Frecuencias observadas*/
	int intNDIntrvs;/*Numero de Intervalos*/
	double doubleJIcuad;		/*Estadistico de prueba X^{2}*/
	int suma;
	double difsCuads[];
	boolean H0;
	final static double TablaJIcuad[]= {
			/*0*/0,
			/*1*/3.841,
			/*2*/5.991,
			/*3*/7.815,
			/*4*/9.488,
			/*5*/11.070,
			/*6*/12.592,
			/*7*/14.067,
			/*8*/15.507,
			/*9*/16.919,
			/*10*/18.307,
			/*11*/19.675,
			/*12*/21.026,
			/*13*/22.362,
			/*14*/23.685,
			/*15*/24.996,
			/*16*/26.296,
			/*17*/27.587,
			/*18*/28.869,
			/*19*/30.144,
			/*20*/31.410,
			/*21*/32.671,
			/*22*/33.924,
			/*23*/35.172,
			/*24*/36.415,
			/*25*/37.652,
			/*26*/38.885,
			/*27*/40.113,
			/*28*/41.337,
			/*29*/42.557,
			/*30*/43.773,
			/*31*/44.985,
			/*32*/46.194,
			/*33*/47.400,
			/*34*/48.602,
			/*35*/49.802,
			
	};
	public PruebaBondadAjuste(int intArr[]) {
		FO=intArr;
		intNDIntrvs=intArr.length;
		difsCuads=new double[intArr.length];
		suma=0;
		/*Sumando frecuencias observadas*/
		for(int i=0;i<FO.length;i++) {
			suma+=FO[i];
		}
		FE=((float)suma)/((float)FO.length);
		for(int i=0;i<intArr.length;i++) {
			difsCuads[i]=(Math.pow(resta(FO[i]),2))/FE;
		}
		doubleJIcuad=0;
		for(int i=0;i<intArr.length;i++) {
			doubleJIcuad+=difsCuads[i];
		}/*Ahora se procede a comparar el valor de X^{2} con la entrada correspondiente
		   en la tabla <nombre de la tabla> usando como indices los grados de libertad 
		   intNDIntrvs-1 y \alpha=0.05*/
		
	}//PruebBondadAjuste()
	private float resta(int fo) {
		return fo-FE;
	}
	
}//end class PruebBondadAjuste
