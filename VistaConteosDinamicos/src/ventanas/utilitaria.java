package ventanas;

import java.util.ArrayList;
import java.util.Vector;

public class utilitaria {
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
	} 
	static int contar(int k,int arr[]){
		int count=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]==k)count++;
		}
		return count;
	}
	static int max_incol_1(int arr[][]){
		int max=arr[0][1];
		for(int i=0;i<arr.length;i++){
			if(max<arr[i][1])
				max=arr[i][1];
		}
		return max;
	}
	static void print_array(int arr[]){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	static void print_array(Float arr[]){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	static void print_array(ArrayList<Float> arr){
		for(int i=0;i<arr.size();i++){
			System.out.print(arr.get(i)+" ");
		}
		System.out.println();
	}
	static void print_array_bid(int arr[][]){
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
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
	 * 
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
	public static String[][] conca(Float a[],int b[]){
		float liminf=0,limsup;
		int frec[]=new int[a.length],count=0;
		for(int i=0;i<a.length;i++){
			limsup=a[i];
			for(int j=0;j<b.length;j++){
				if((b[j]>=liminf)&&(b[j]<=limsup)){
					count++;
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
				+ "frecs relativas="+sum);
		String r[][]=new String[a.length][2];
		liminf=0;
		for(int i=0;i<a.length;i++){
			limsup=a[i];
			r[i][0]=new String(liminf+"--"+a[i]);
			r[i][1]=new String(""+frec[i]);
			liminf=a[i];
		}
		return r;
	}
	public static void main(String arr[]){
		int totdcas=30,regSturgRes=20;
		ArrayList<Float> inters=utilitaria.getLimSupInterv(totdcas, regSturgRes);
		System.out.println("inters.size()="+inters.size());
		System.out.println("inters.get(0)="+inters.get(0));
		utilitaria.print_array(inters);
	}
}//end class utilitaria
