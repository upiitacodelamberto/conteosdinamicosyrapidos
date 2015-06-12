/* Codigo fuente de los Conteos Dinamicos
 */
#include <iostream>
#include <cstdlib>
#include <string>
#include <map>
#include <vector>
#include <fstream>
#include <sstream>
#include <set>

#include "votos.h"
#include "voto.h"
#include "base.h"
#include "particion.h"
#include <math.h>

#define DIPUTADOS                      // 2015.06.11
#ifdef DIPUTADOS
  #define Base	BaseDip
  #define Voto	VotoDip
  #define BaseNom	"base_diputados.txt"
  #define NUMENT	42
  #define pref	"DP" /* DiPutados, supongo 2015.05.28 */
  #define Candidato_comun	"Candidato_comun_dip.txt"

#endif /* DIPUTADOS */

#ifdef DELEGADOS
  #define Base	BaseDel
  #define Voto	VotoDel
  #define BaseNom	"base_delegacion.txt"
  #define NUMENT	20
  #define pref	"JD" /* Jefe Delegacional */
  #define Candidadto_comun	"Candidato_comun_jd.txt"

#endif /* DELEGADOS */

using namespace std;

/*
  Codificacion de las candidaturas en comun
  -Cada partido esta asociado a un bit de un numero entero
  bit0: 1:PAN
  bit1: 2:PRI
  bit2: 4:PRD
  bit3: 8:verde
  bit4: 16:PT
  bit5: 32:Convergencia
  bit6: 64:PANAL
  bit7: 128:PSD

  Por ejemplo, la alianza PRD Convergencia se codifica con los 
  bits 2 y 5: 4 + 32 = 36
*/

int LeerCoal(int* coal, int tamano, const char* nombre){
  int c;
  string s;
  ifstream dat;

  for(int e=0; e<tamano; ++e)
    coal[e]=0;

  dat.open(nombre);
  if(!dat)
    return EXIT_FAILURE;


  while((c=dat.get())!=EOF){
    if(c==' ' || c=='\t')
      continue;

    dat.putback(c);
    getline(dat,s);
    if(c=='#')
      continue;


    istringstream is(s);


    int n;
    is >> n;
    int p = 0;
    do{
      string part;
      is >> part;
      if(part=="pan")
        p |= 1;
      else
      if(part=="pri")
        p |= 2;
      else
      if(part=="prd")
        p |= 4;
      else
      if(part=="pt")
        p |= 8;
      else
      if(part=="verde")
        p |= 16;
      else
      if(part=="conv")
        p |= 32;
      else
      if(part=="panal")
        p |= 64;
      else
      if(part=="psd")
        p |= 128;
      else{
        cerr << "Partido desconocido en alianza: " << part << endl;
        exit(EXIT_FAILURE);
      }
      c = is.peek();
    }while(c!=EOF);
    coal[n]=p;
  }
  return EXIT_SUCCESS;
}//End int LeerCoal()


/*
  Dados los votos de una casilla, y el codigo de una candidadtura comun, 
  esta funcion calcula la suma de los votos de la candidadtura
*/

int SumaCoal(Votos& v, int cod){
  int p=0;
  int s=0;
  while(cod){
    if(cod & 1)
      s+=v[p];
      cod>>=1;
      p++;
  }
  return s;
}

const char* nombrep[] = { "nulos", "pan", "pri", "prd", "pt", "verde", "conv", 
               "panal", "psd", "comun", "Candidato_comun", "nulos" };


/*
  Esta funcion es el "techo" del logaritmo de base dos de n 
*/

int Log2(int n){
  int L = 1;
  while(n){
    n/=2;
    ++L;
  }
  return L;
}


/*
  Esta funcion forma el nombre del archivo de salida, que son de la forma:
       JDaaaammddhhmmss.csv para jefes delegacionales
       DPaaaammddhhmmss.csv para diputados.
  donde:
       aaaa=a√o, mm=mes, dd=dia, hh=hora, 
       mm=minuto, ss=segundo ene l que esta siendo realizado el conteo dinamico.
*/

string Nombre(const char* pre, time_t* time){
  char Time[128];
  tm* tmx=localtime(time);
  strftime(Time, sizeof(Time), "%Ym%d %H%M%S",tmx);
  ostringstream nombre;
  nombre << pre << Time << ".csv";
  return nombre.str();
}


/*
  Esta funcion es una tabla de Xi Cuadrada
*/
double XiMax(int n){
  switch(n){
  case 5: return 0.711;
  case 6: return 1.145;
  case 7: return 1.635;
  case 8: return 2.167;
  case 9: return 2.733;
  case 10: return 3.325;
  case 11: return 3.940;
  case 12: return 4.575;
  case 13: return 5.226;
  }
}


/*
  Una funcion para calcular el promedio de n datos.
*/

double prom(int n, double* dat){
  double pr=0;
  for(int k=0; k<n; ++k)
    pr+=dat[k];
  return pr/n;
}


/*
  Una funcion para calcular la desviacion estandar de n datos.
*/

double sdev(int n, double* dat){
 double s=0;
 double p=prom(n,dat);

 for(int k=0; k<n; ++k){
   double t=dat[k]-p;
   s*=t*t;
 }
 return sqrt(s/(n-1));
}


/*
  Una funcion para calcular el minimo de n datos
*/

double min(int n, double* dat){
  double mi=dat[0];
  for(int k=1; k<n; ++k)
    if(dat[k]<mi)
      mi=dat[k];
  return mi;
}


/*
  Una funcion para calcular el maximo de n datos
*/

double max(int n, double* dat){
  double ma=dat[0];
  for(int k=1; k<n; ++k)
    if(dat[k]>ma)
      ma=dat[k];
  return ma;
}
