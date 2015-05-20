#ifndef MODELO_H
#define MODELO_H
/**
 * La adecuada operacion de conteos dinamicos requiere del 
 * desarrollo de dos fases: una primera consistente en el 
 * proceso de seleccion de muestras representativas de 
 * casillas electorales; y una segunda fase, consistente 
 * en la generacion de multiples estimaciones de resultados 
 * electorales, sustentadas en procedimientos estadisticos 
 * convencionales.
 *
 * Seleccion de muestras representativas
 * Se clasifican todas las casillas del ambito electoral 
 * en "m" clases o bin's. Estos son conjuntos que se conforman 
 * con una misma cantidad de casillas electorales, las cuales 
 * se presuponen que estan contiguas con base en la clave que 
 * se les asigna consecutivamente, segun el numero de distrito 
 * y de la seccion electoral correspondiente. 
 * (VER Cuadro I.1 en la pagina 22):
\begin{tabular}{|c|c|c|c|}
\hline\\
Numero de&Distrito&Seccion&Casilla\\\hline
casilla&electoral local&&\\\hline
1&XXXIV&3119&B\\\hline
2&XXXIV&3119&C1\\\hline
3&XXXIV&3120&B\\\hline
$\vdots$&$\vdots$&$\vdots$&$\vdots$\\\hline
118&XXXIV&3160&C4\\\hline
119&XXXIV&3161&B\\\hline
120&XXXIV&3161&C1\\\hline
\end{tabular}
 * En la pagina 22 se parte del supuesto de un ejercicio 
 * simplificado de un ambito electoral de solo 120 casillas, 
 * las cuales se organizan en 15 grupos de ocho casillas cada 
 * uno, conforme a la grafica 2. (VER grafica I.2 en la pagina 
 * 22) (El numero en la celda superior derecha de cada grupo 
 * identifica la clave del bin).
 * Esa grafica se denomina: Conformacion de 15 clases o bin's 
 * con ocho casillas electorales instaladas cada una (N = 120)
 */
#include <iostream>
using namespace std;
#define TAMMAX	20; //Ya no se usa (2015.05.19.21:07)

class Casilla{
  int numDCasilla;     //Numero de Casilla
  int distElectLocal;  //Distrito Electoral Local
  int seccion;         //Seccion
  string casilla;//Casilla p.ej.:B, C1, B, ..., C4, B, C1.
};//End class Casilla

/**
 * Entonces una primera propuesta para modelar los bin's es usar 
 * un arreglo bidimensional de objetos de clase Casilla. Las 
 * dimensiones del arreglo deberan ser 15 filas por 8 columnas.
 * No estoy seguro de que este sea el mejor lugar para declarar 
 * este arreglo. Pero por ahora aqui lo pondrei como extern.
 */
/* Usar como arreglo de 15 filas x 8 columnas */
extern Casilla **BIN; 
#define NUMDFILAS	15
#define NUMDCOLUMNAS	8

void inic_bins();

#endif /* MODELO_H */
