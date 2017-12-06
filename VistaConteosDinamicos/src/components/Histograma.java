package components;

import java.util.Scanner; // Para el ingreso de datos

public class Histograma {
	
	public static void generarV(int[] v) { // Generamos un vector
		for (int i = 0; i < v.length; i++) {
			v[i] = (int) (Math.random() * 101);
		}
	}
	
	public static void histogramaV(int[] v) { // Hace el histograma
		int[] rep = new int[v.length]; // Repeticiones
		for (int i = 0; i < v.length; i++) {
			int ca = 0; // Cantidad (frecuencia)
			for (int j = 0; j < v.length; j++) {
				if (v[i] == v[j]) {
					ca++;
				}
			}
			if (rep[i] == 0) { // Si aun no se ha repetido
				System.out.print(v[i] + ": ");
				for (int k = 0; k < ca; k++) {
					System.out.print("*"); // Un '*' por cada punto frecuencial
				}
				System.out.println();
			}
			for (int j = 0; j < v.length; j++) {
				if (v[i] == v[j]) {
					rep[j]++; // Si ya esta visto esta parte
				}
			}
		}
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // Creamos el ingreso de datos
		
		System.out.print("Cantidad de elementos: ");
		int n = sc.nextInt(); // Almacenamos cantidad de elementos

		int[] v = new int[n]; // Creamos el vector

		generarV(v); // Lo generamos
		
		histogramaV(v); // Mostramos el histograma
		
	}
	
}
