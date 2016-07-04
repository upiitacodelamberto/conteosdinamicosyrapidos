#include <iostream>
#include <vector>
#include <malloc.h> /* malloc() */
#include <stdlib.h> /* atoi() */
#include "modelo.h"
using namespace std;

/* Casillas reportadas al PREP en un momento dado
   (en las primeras horas de su operacion) 
   EN ESTA version del programa no se usara este arreglo, 
   lo dejo unicamente para posible uso posterior de la idea.
   2015.11.17 */
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

//Casilla **CAS;   /* vease archivo include/modelo.h */
vector <Casilla*>CAS;

/* En esta version no se usa, lo dejo unicamente para 
   posible uso futuro. 2015.11.17 */
struct bin *B[NUMDFILAS];


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

//	cout << "En esta version un bin es uno de 15 grupos de 8 casillas" <<
//	    endl;
	do {
		for (unsigned int i = 0; i < mdoitem.size(); i++) {
			cout << i << " " << mdoitem[i] << endl;
		}
		cout << "Teclea una opcion: ";
		cin >> item;
		switch (item) {
		case 0:{
//				proccess_show_reported_casillas();
				break;
			}
                case 1:{
//                                proccess_show_cantdcasillas_por_bin();
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


void proccess_salir()
{
	/* por ahora esta funcion queda vacia (2015.05.20) */
}

//bool Casilla::yaReportadaAlPREP()
//{
//	return reportadaAlPREP;
//}

//int Casilla::get_numDCasilla(){
//  return numDCasilla;
//}

//void Casilla::set_reportadaAlPREP(bool b){
//  reportadaAlPREP = b;
//}

//void Casilla::set_numDCasilla(int N){
//  numDCasilla = N;
//}

//void proccess_show_cantdcasillas_por_bin(){
//  int m, n, count = 0;
//  for(int i = 0; i < NUMDFILAS; i++){
//    for(int j = 0; j < B[i]->N; j++){
//      m = (*(B[i]->p + j) - 1) / NUMDCOLUMNAS; 
//      n = (*(B[i]->p + j) - 1) % NUMDCOLUMNAS;
//      if(CAS[m][n].yaReportadaAlPREP()){
//         count++;
//      }
//    }
//    B[i]->cantDCRep = count;
//    count = 0;
//  }
//  for(int i = 0; i < NUMDFILAS; i++){
//    cout << "Bin " << i + 1 << ": " << B[i]->cantDCRep;
//    cout << endl;
//  }
//}

string Casilla::get_distrito(){
  return distrito;
}

string Casilla::get_seccion(){
  return seccion;
}

string Casilla::get_casilla(){
  return casilla;
}

string Casilla::get_delegacion(){
  return delegacion;
}

string Casilla::get_tipo(){
  return tipo;
}

int Casilla::get_cdvotos(){
  return cdvotos;
}

Casilla::Casilla(string dis, string sec, string cas, string deleg, string tip):
distrito(dis), seccion(sec), casilla(cas), delegacion(deleg), tipo(tip){
}

Casilla::Casilla(string dis, string sec, string cas, string deleg, string tip, string PCC):
distrito(dis), seccion(sec), casilla(cas), delegacion(deleg), tipo(tip), PartCandCoal(PCC){ }

/**Este constructor por ahora inicializa (ver inicializador) indexinic a 5, posteriormente 
   habra que quitar esto del inicializador y calcular indexinic en el constructor antes 
   de contar los votos totales de la casilla.
*/
Casilla::Casilla(vector<string> vdt):tdl(vdt),cdvotos(0),indexinic(5){
  for(int i=indexinic;i<vdt.size();i++){
    cdvotos+=cad2int(vdt[i]);
  }
}

int Casilla::cad2int(std::string t){
  if(t=="")
    return 0;
  return atoi(&t[0]);
}

ostream&
operator<<(ostream& out,Casilla& c)
{
  //out<<"Casilla ";
  //for(int i=0;i<5;i++){
  for(int i=0;i<2;i++){//hay que ver si hay un identificador 
                       //unico en los archivos ``adaptados''
    if(i==0)
      out<<" "<<c.tdl[i];
    else
      out<<"\t"<<c.tdl[i];
  }
  out<<"\tVotos="<<c.cdvotos;
  
  return out;
}

/*
 A partir del numero de bin (1, 2, 3, ..., Num. de bins) hay que determinar 
 cual sera la cantidad de casillas que estaran contenidas 
 en ese bin en particular.
 Inicialmente (al menos) voy a suponer que las casillas correspondientes 
 a un determinado bin son las casillas ``consecutivas''. Por ejemplo: 
 para el caso de 39 casillas, la regla de sturges nos da como resultado 
 c=1+3.322*log10(39)=6.28\approx 6
 Ahora bien, dado que 39 = 6 * 6 + 3 = 5 * 7 + 4
 voy a suponer que  a los bins les corresponderan las casillas indicadas 
 en la siguiente tabla
 Num de Clase/bin   Casillas    Cant de casillas 
  1                  1 --  7        7
  2                  8 -- 14        7
  3                 15 -- 21        7
  4                 22 -- 28        7
  5                 29 -- 35        7
  6                 36 -- 39        4
 Los numero de bin como indico en esta tabla seran enteros empezando con el 1.
 Esta funcion debe devolver el numero de la tercera columna cuando el primer 
 argumento (binnum) es el numero de la primera columna, el segundo argumento 
(tamdbin) es 7 y el tercer argumento (totaldcsllas) es 39.
 */
int
numdcasillas_para_elbinnum(int binnum,int tamdbin,int totaldcsllas)
{
  /*casillas contempladas en los bins anteriores*/
  int cascontempl=(binnum-1)*tamdbin;
  if((cascontempl+tamdbin)<=totaldcsllas)
    return tamdbin;
  else
    return totaldcsllas-cascontempl;
}

/*
  inicializa una clase o bin (vease struct bin en modelo.h)
 */
void
inic_clbin(bin *b,int candcas,int inicio)
{
  int i;
  b->N=candcas;
  b->p=(int*)malloc(candcas*sizeof(int));
  for(i=0;i<candcas;i++){
    *(b->p+i)=inicio;
    inicio++;
  }
}

/**
 El tamanio de bin (tamdbin) se determina usando la cantidad (c) de clases (bins) 
 a utilizar y el total de datos disponibles (Total, en este caso Total=39). De 
 la siguiente forma:
 tamdbin=Total/(c-1)     (esta division debe ser calculada como division de dos int)
 Por ejemplo, para Total=39, c=6: tamdbin=39/(6-1)=39/5=7,
 De esta forma, como 5*7+4=39 nos dice que usaremos 5 clases de 7 casillas y una de 
 4 casillas, con lo que tendremos las 6 clases que nos indica la regla de Sturges.
 @pre c>1
 */
int
tamanio_dbin(int Total,int c)
{
  return Total/(c-1);
}
