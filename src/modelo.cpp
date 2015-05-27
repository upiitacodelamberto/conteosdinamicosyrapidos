#include <iostream>
#include <vector>
#include <malloc.h> /* malloc() */
#include "modelo.h"
using namespace std;

/* Casillas reportadas al PREP en un momento dado
   (en las primeras horas de su operacion) */
int repdas[NUMDFILAS][NUMDCOLUMNAS] = {
{0, 0, 0, 0, 0, 0, 1, 0}, {1, 1, 1, 1,
0, 0, 0, 0}, {0, 0, 1, 1, 0, 0, 0, 0},
{1, 0, 0, 0, 0, 1, 1, 1}, {0, 0, 0, 0,
0, 0, 0, 1}, {0, 0, 0, 1, 1, 0, 0, 0},
{0, 0, 0, 0, 0, 1, 1, 1}, {0, 1, 0, 0,
0, 0, 1, 1}, {0, 1, 1, 0, 1, 1, 0, 0},
{0, 0, 0, 0, 1, 0, 1, 0}, {0, 0, 1, 1,
0, 0, 0, 0}, {0, 0, 0, 1, 1, 0, 0, 1},
{1, 1, 0, 0, 0, 1, 1, 0}, {0, 0, 0, 1,
0, 0, 1, 0}, {0, 0, 0, 1, 0, 0, 0, 0}
};

Casilla **CAS;

struct bin *B[NUMDFILAS];

void inic_bins()
{
	CAS = new Casilla *[NUMDFILAS];
	for (int i = 0; i < NUMDFILAS; i++) {
		*(CAS + i) = new Casilla[NUMDCOLUMNAS];
	}
  int count = 1; 
  for(int i = 0; i < NUMDFILAS; i++){
    for(int j = 0; j < NUMDCOLUMNAS; j++){
      CAS[i][j].set_numDCasilla(count++);
    }
  }
  
  //Para indicar cuales casillas ya han sido reportadas 
  //al PREP en el estado inicial (en las primeras horas).
  for(int i = 0; i < NUMDFILAS; i++){
    for(int j = 0; j < NUMDCOLUMNAS; j++){
      CAS[i][j].set_reportadaAlPREP(repdas[i][j]);
    }
  }
  
  for(int i = 0; i < NUMDFILAS; i++){
    B[i] = (struct bin *)malloc(sizeof(struct bin));
  }
  B[0]->N = B[1]->N = B[2]->N = B[3]->N = B[4]->N = NUMDCOLUMNAS;
  B[5]->N = B[6]->N = B[7]->N = B[8]->N = B[9]->N = NUMDCOLUMNAS;
  B[10]->N = B[11]->N = B[12]->N = B[13]->N = B[14]->N = NUMDCOLUMNAS;
  
  for(int i = 0; i < NUMDFILAS; i++){
    B[i]->p = new int[B[i]->N];
  }

  *(B[0]->p) = 1; *(B[0]->p + 1) = 2; *(B[0]->p + 2) = 3; *(B[0]->p + 3) = 4;
  *(B[0]->p + 4) = 13; *(B[0]->p + 5) = 14; *(B[0]->p + 6) = 15; *(B[0]->p + 7) = 16;

  *(B[1]->p) = 5; *(B[1]->p + 1) = 6; *(B[1]->p + 2) = 7; *(B[1]->p + 3) = 8;
  *(B[1]->p + 4) = 17; *(B[1]->p + 5) = 18; *(B[1]->p + 6) = 19; *(B[1]->p + 7) = 20;

  *(B[2]->p) = 9; *(B[2]->p + 1) = 10; *(B[2]->p + 2) = 11; *(B[2]->p + 3) = 12;
  *(B[2]->p + 4) = 21; *(B[2]->p + 5) = 22; *(B[2]->p + 6) = 23; *(B[2]->p + 7) = 24;

  *(B[3]->p) = 25; *(B[3]->p + 1) = 26; *(B[3]->p + 2) = 37; *(B[3]->p + 3) = 38;
  *(B[3]->p + 4) = 49; *(B[3]->p + 5) = 50; *(B[3]->p + 6) = 61; *(B[3]->p + 7) = 62;

  *(B[4]->p) = 27; *(B[4]->p + 1) = 28; *(B[4]->p + 2) = 39; *(B[4]->p + 3) = 40;
  *(B[4]->p + 4) = 51; *(B[4]->p + 5) = 52; *(B[4]->p + 6) = 63; *(B[4]->p + 7) = 64;

  *(B[5]->p) = 29; *(B[5]->p + 1) = 30; *(B[5]->p + 2) = 31; *(B[5]->p + 3) = 32;
  *(B[5]->p + 4) = 41; *(B[5]->p + 5) = 42; *(B[5]->p + 6) = 43; *(B[5]->p + 7) = 44;

  *(B[6]->p) = 53; *(B[6]->p + 1) = 54; *(B[6]->p + 2) = 55; *(B[6]->p + 3) = 56;
  *(B[6]->p + 4) = 65; *(B[6]->p + 5) = 66; *(B[6]->p + 6) = 67; *(B[6]->p + 7) = 68;

  *(B[7]->p) = 33; *(B[7]->p + 1) = 34; *(B[7]->p + 2) = 45; *(B[7]->p + 3) = 46;
  *(B[7]->p + 4) = 57; *(B[7]->p + 5) = 58; *(B[7]->p + 6) = 69; *(B[7]->p + 7) = 70;

  *(B[8]->p) = 35; *(B[8]->p + 1) = 36; *(B[8]->p + 2) = 47; *(B[8]->p + 3) = 48;
  *(B[8]->p + 4) = 59; *(B[8]->p + 5) = 60; *(B[8]->p + 6) = 71; *(B[8]->p + 7) = 72;

  *(B[9]->p) = 73; *(B[9]->p + 1) = 74; *(B[9]->p + 2) = 75; *(B[9]->p + 3) = 76;
  *(B[9]->p + 4) = 77; *(B[9]->p + 5) = 78; *(B[9]->p + 6) = 79; *(B[9]->p + 7) = 80;

  *(B[10]->p) = 85; *(B[10]->p + 1) = 86; *(B[10]->p + 2) = 87; *(B[10]->p + 3) = 88;
  *(B[10]->p + 4) = 89; *(B[10]->p + 5) = 90; *(B[10]->p + 6) = 91; *(B[10]->p + 7) = 92;

  *(B[11]->p) = 97; *(B[11]->p + 1) = 98; *(B[11]->p + 2) = 99; *(B[11]->p + 3) = 100;
  *(B[11]->p + 4) = 101; *(B[11]->p + 5) = 102; *(B[11]->p + 6) = 103; *(B[11]->p + 7) = 104;

  *(B[12]->p) = 109; *(B[12]->p + 1) = 110; *(B[12]->p + 2) = 111; *(B[12]->p + 3) = 112;
  *(B[12]->p + 4) = 113; *(B[12]->p + 5) = 114; *(B[12]->p + 6) = 115; *(B[12]->p + 7) = 116;

  *(B[13]->p) = 81; *(B[13]->p + 1) = 82; *(B[13]->p + 2) = 83; *(B[13]->p + 3) = 84;
  *(B[13]->p + 4) = 93; *(B[13]->p + 5) = 94; *(B[13]->p + 6) = 95; *(B[13]->p + 7) = 96;

  *(B[14]->p) = 105; *(B[14]->p + 1) = 106; *(B[14]->p + 2) = 107; *(B[14]->p + 3) = 108;
  *(B[14]->p + 4) = 117; *(B[14]->p + 5) = 118; *(B[14]->p + 6) = 119; *(B[14]->p + 7) = 120;
}



/**
 * Agrego esta funcion con la idea de poder probar 
 * en esta etapa inicial si funcionan bien algunas funciones 
 * que haran uso de metodos de objetos de la clase Casilla, 
 * que aun no he agregado. Entre ellos tengo pensado una funcion 
 * que nos indique la informacion que se muestra en la columna fx
 * en la tabla de la derecha de la grafica I.3 (Pag. 23 del Docto).
 */
//void proccess_commands(Casilla ** bin)
void proccess_commands()
{
	unsigned int item;
	vector < string > mdoitem;
	mdoitem.push_back("Mostrar casillas reportadas al PREP por cada bin");
	mdoitem.push_back("Mostrar cantidad de casillas reportadas al PREP por cada bin");
	mdoitem.push_back("Salir");

	cout << "En esta version un bin es uno de 15 grupos de 8 casillas" <<
	    endl;
	do {
		for (unsigned int i = 0; i < mdoitem.size(); i++) {
			cout << i << " " << mdoitem[i] << endl;
		}
		cout << "Teclea una opcion: ";
		cin >> item;
		switch (item) {
		case 0:{
				proccess_show_reported_casillas();
				break;
			}
                case 1:{
                                proccess_show_cantdcasillas_por_bin();
                                break;
                        }
		case 2:{
				proccess_salir();
				break;
			}
		default:
			break;
		}
	} while (item != (mdoitem.size() - 1));
}

//void proccess_show_reported_casillas(Casilla ** bin)
void proccess_show_reported_casillas()
{
  int m, n;
  for(int i = 0; i < NUMDFILAS; i++){
    cout << "Bin " << i + 1 << ": ";
    for(int j = 0; j < B[i]->N; j++){
      m = (*(B[i]->p + j) - 1) / NUMDCOLUMNAS; //Con estas dos formulas se calcula a partir 
      n = (*(B[i]->p + j) - 1) % NUMDCOLUMNAS; //de los indices i y j se calculan los indices
                                               //m y n adecuados para su uso en el arreglo CAS.
                                               //Es decir, a partir de el numero de casilla 
                                               //*(B[i]->p + j) se calculan las cordenadas m y n
                                               //con que se obtiene la Casilla correspondiente en 
                                               //el arreglo bidimensional de Casillas CAS.
      if(CAS[m][n].yaReportadaAlPREP()){
        cout << CAS[m][n].get_numDCasilla() << "\t";
      }
    }
    cout << endl;
  }
}

void proccess_salir()
{
	/* por ahora esta funcion queda vacia (2015.05.20) */
}

bool Casilla::yaReportadaAlPREP()
{
	return reportadaAlPREP;
}

int Casilla::get_numDCasilla(){
  return numDCasilla;
}

void Casilla::set_reportadaAlPREP(bool b){
  reportadaAlPREP = b;
}

void Casilla::set_numDCasilla(int N){
  numDCasilla = N;
}

void proccess_show_cantdcasillas_por_bin(){
  int m, n, count = 0;
  for(int i = 0; i < NUMDFILAS; i++){
    for(int j = 0; j < B[i]->N; j++){
      m = (*(B[i]->p + j) - 1) / NUMDCOLUMNAS; 
      n = (*(B[i]->p + j) - 1) % NUMDCOLUMNAS;
      if(CAS[m][n].yaReportadaAlPREP()){
         count++;
      }
    }
    B[i]->cantDCRep = count;
    count = 0;
  }
  for(int i = 0; i < NUMDFILAS; i++){
    cout << "Bin " << i + 1 << ": " << B[i]->cantDCRep;
    cout << endl;
  }
}
