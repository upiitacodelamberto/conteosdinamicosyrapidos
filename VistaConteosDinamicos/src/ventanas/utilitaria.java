package ventanas;

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
	public static void main(String arg[]){
		int A[]={1,2,3,4,5,6,7,8,9,10};
		int B[]={1,5,2,4,2,4,4};
		System.out.print("A: ");
		print_array(A);
		System.out.print("B: ");
		print_array(B);
		System.out.println();
		String C[][]=conca(A,B);
		System.out.println("C.length="+C.length);
		System.out.println("C[0].length="+C[0].length);
		print_array_dstr_bid(C);
	}
}//end class utilitaria
