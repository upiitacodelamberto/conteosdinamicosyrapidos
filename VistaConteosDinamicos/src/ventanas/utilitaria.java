package ventanas;

import java.util.ArrayList;
import java.util.Vector;

public class utilitaria {
	/** Este metodo utilitaria.conca() se escribio inicialmente para hacer pruebas 
	 * con arreglos de int. 
	 * DOCUMENTAR Martes 2017.10.03
	 * @param a
	 * @param b
	 * @return
	 */
	public static String[][] conca(int a[],int b[]){
		int m=a.length,n;
		int c[][]=new int[a.length][2];
		for(int i=0;i<a.length;i++){
			c[i][0]=a[i];
			c[i][1]=contar(c[i][0],b);
		}
//		System.out.println("EN conca()");
//		print_array_bid(c);
		n=max_incol_1(c)+1;
		String r[][]=new String[m][n];
		for(int i=0;i<m;i++){
			r[i][0]=""+c[i][0];
			for(int j=1;j<n;j++){
				if(j<=c[i][1]){
					r[i][j]=""+c[i][0];
				}else{
					r[i][j]="";
				}
			}
		}
//		System.out.println("SALIENDO DE conca()");
		return r;
	}//end utilitaria.conca()
	/**
	 * DOCUMENTAR Martes 2017.10.03
	 * @param k
	 * @param arr
	 * @return
	 */
	static int contar(int k,int arr[]){
		int count=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]==k)count++;
		}
		return count;
	}
	/**
	 * DOCUMENTAR Martes 2017.10.03
	 * @param arr
	 * @return
	 */
	static int max_incol_1(int arr[][]){
		int max=arr[0][1];
		for(int i=0;i<arr.length;i++){
			if(max<arr[i][1])
				max=arr[i][1];
		}
		return max;
	}
	/**
	 * print_array(): imprime "horizontalmente" los elementos de un arreglo de int 
	 * @param arr: un arreglo de int
	 */
	static void print_array(int arr[]){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	/**
	 * print_array(): imprime "horizontalmente" los elementos de un arreglo de float
	 * @param arr: un arreglo de float
	 */
	static void print_array(Float arr[]){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	/**
	 * print_array(): imprime "horizontalmente" los elementos de un ArrayList de float
	 * @param arr: un ArrayList de float 
	 */
	static void print_array(ArrayList<Float> arr){
		for(int i=0;i<arr.size();i++){
			System.out.print(arr.get(i)+" ");
		}
		System.out.println();
	}
	/**
	 * print_array_bid(): imprime "horizontalmente" los elementos de un 
	 *                    arreglo bidimensional de int. 
	 * @param arr: un arreglo bidimensional del int
	 */
	static void print_array_bid(int arr[][]){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	/**
	 * print_array_dstr_bid(): imprime "horizontalmente" los elementos de un 
	 *                         arreglo bidimensional de String.
	 * @param arr: arreglo bidimensional de String
	 */
	static void print_array_dstr_bid(String arr[][]){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
//	public static void main(String arg[]){
//		int A[]={1,2,3,4,5,6,7,8,9,10};
//		int B[]={1,5,2,4,2,4,4};
//		System.out.print("A: ");
//		print_array(A);
//		System.out.print("B: ");
//		print_array(B);
//		System.out.println();
//		String C[][]=conca(A,B);
//		System.out.println("C.length="+C.length);
//		System.out.println("C[0].length="+C[0].length);
//		print_array_dstr_bid(C);
//	}
	/**
	 * CREAR UNA INTERFACE PARA LA IMPLEMENTACION DEL METODO 
	 * public int reglaSturges(int n);
	 * Y PODER ASI EVENTUALMENTE HACER QUE SEA FACIL CAMBIAR
	 * LA IMPLEMENTACION DE ESTE METODO...........2017.08.15 
	 */
	
	/**
	 * reglaSturges
	 * @param n es la cardinalidad del corte PREP
	 * @return
	 */
	public static int reglaSturges(int n){
		double d=1+3.33*Math.log10((double)n);
		return (int)Math.round(d);
	}
	/**
	 * getLimSupInterv():MEJORAR esta documentacion Martes 2017.10.03
	 * @param Adotlength es la cantidad de casillas registradas en PREP 
	 * @param N es la cantidad de ``clases'' obtenida con reglaSturges
	 * @return
	 * 500/10=50: 1-50,51-100,101-150, ...,401-450,451-500
	 * pero si 500/8=62
	 */
	public static ArrayList<Float> getLimSupInterv(int Adotlength,int N){
		ArrayList<Float> r=new ArrayList<Float>();
		float m=((float)Adotlength)/((float)N);
//		System.out.println("Num. de clases N="+N);
//		System.out.println("MEDIDA DE INTERVALOS float m=((float)Adotlength)/((float)N)="+m);
		int i=1,index;float val;
		while((m*i)<=Adotlength){
			index=i-1;val=m*i;
//			System.out.println("INDICE i-1="+index+" valor a colocar="+val);
			r.add(m*i);
			i++;
		}
//		utilitaria.print_array(r);
		return r;
	}
	/**
	 * ESTE ES EL METODO utilitaria.conca() QUE SE ESTA UTILIZANDO!!! //2017.10.10
	 * conca(): DOCUMENTAR 2017.10.03
	 * @param a: limites superiores de los intervalos de clase
	 * @param b: identificadores de las casillas que se utilizaran para hacer la prueba 
	 *           de bondad de ajuste.
	 * @return
	 */
	public static String[][] conca(Float a[],int b[]){
		String r[][]=new String[a.length][2];
		float liminf=0,limsup;
		int frec[]=new int[a.length],count=0;
		for(int i=0;i<a.length;i++){
			limsup=a[i];
			for(int j=0;j<b.length;j++){
				if((b[j]>=liminf)&&(b[j]<=limsup)){
					count++;	/*se estan obteniendo las frecuencias observadas*/
							/** //2017.10.10.19.57 Para hacer lo que se menciona en el 
							 * comentario 2017.10.10.19.56:
							 * COMO AQUI SE ESTA IDENTIFICANDO LAS CASILLAS QUE ESTAN 
							 * EN LOS INTERVALOS DE CLASE CUYOS LIMITES SUPERIORES ESTAN 
							 * EN Float a[], SE PUEDE UTILIZAR ESTA INFORMACION PARA 
							 * AGREGAR IDENTIFICADORES DE CASILLA A LOS a.length OBJETOS 
							 * DE CLASE MyBin QUE VOY A PASAR COMO ARGUMENTO EN UNA 
							 * VERSION SOBRECARGADA DE ESTE METODO QUE VOY A ESCRIBIR. 
							 * */
				}
			}
			frec[i]=count;count=0;
			liminf=a[i];
		}
		
		int sum=0;
		for(int i=0;i<frec.length;i++){
			sum+=frec[i];
		}
		System.out.println("utilitaria.conca(Float[],int[]):Suma de "
				+ "frecs relativas observadas="+sum);
		
		liminf=0;
		for(int i=0;i<a.length;i++){
			limsup=a[i];
			r[i][0]=new String(liminf+"--"+a[i]);
			r[i][1]=new String(""+frec[i]);
			liminf=a[i];
		}
		return r;
	}//end utilitaria.conca()
	
	/**
	 * pre: a.length==Bin.length debe ser true
	 * Para reutilizar (somehow) el codigo del metodo utilitaria.conca(),
	 * sobrecargo ese metodo una segunda vez. VEASE COMENTARIO 2017.10.10.19.56 en el 
	 * archivo MostrandoSTATUSDELEC.java en este mismo package.
	 * @param a: arreglo que contiene los limites superiores de los intervalos
	 *           de clase.
	 * @para b: arreglo que contiene los enteros con los que se realizara la prueba 
	 *          de bondad de ajuste.
	 */
	public static String[][] conca(Float a[],int b[],MyBin Bin[]){
		String r[][]=new String[a.length][2];
		float liminf=0,limsup;
		int frec[]=new int[a.length],count=0;
//		System.out.println("utilitaria.conca(Float a[],int b[],MyBin Bin[])");
		for(int i=0;i<a.length;i++){
			limsup=a[i];
			for(int j=0;j<b.length;j++){
				if((b[j]>=liminf)&&(b[j]<=limsup)){
					count++;	/*se estan obteniendo las frecuencias observadas*/
								/** //2017.10.10 
								 * COMO AQUI SE ESTA IDENTIFICANDO LAS CASILLAS QUE ESTAN 
								 * EN LOS INTERVALOS DE CLASE CUYOS LIMITES SUPERIORES ESTAN 
								 * EN Float a[], SE PUEDE UTILIZAR ESTA INFORMACION PARA 
								 * AGREGAR IDENTIFICADORES DE CASILLA A LOS a.length OBJETOS 
								 * DE CLASE MyBin QUE VOY A PASAR COMO ARGUMENTO EN UNA 
								 * VERSION SOBRECARGADA DE ESTE METODO QUE VOY A ESCRIBIR. 
								 * */
					Bin[i].VectorDInt.add(b[j]);//guardar identificador de casilla en el
												// bin correspondiente.
				}
			}
//			System.out.println(Bin[i].VectorDInt.size());/*Frecuencia Observada*/
			frec[i]=count;count=0;
			liminf=a[i];
		}
		
		int sum=0;
		for(int i=0;i<frec.length;i++){
			sum+=frec[i];
		}
		System.out.println("utilitaria.conca(Float[],int[]):Suma de "
				+ "frecs relativas observadas="+sum);
		
		liminf=0;
		for(int i=0;i<a.length;i++){
			limsup=a[i];
			r[i][0]=new String(liminf+"--"+a[i]);
			r[i][1]=new String(""+frec[i]);
			liminf=a[i];
		}
		return r;
	}//end utilitaria.conca()
	public static int totalDCasillasNBins(MyBin MBin[]) {
		int sum=0;
		for(int i=0;i<MBin.length;i++) {
			sum+=MBin[i].VectorDInt.size();
		}
		return sum;
	}
	
	/**
	 * main(): Driver de prueba para algunos de los metodos de esta clase utilitaria.
	 * @param arr
	 */
	public static void main(String arr[]){
		int totdcas=30,regSturgRes=20;
		ArrayList<Float> inters=utilitaria.getLimSupInterv(totdcas, regSturgRes);
		System.out.println("inters.size()="+inters.size());
		System.out.println("inters.get(0)="+inters.get(0));
		utilitaria.print_array(inters);
	}
}//end class utilitaria
