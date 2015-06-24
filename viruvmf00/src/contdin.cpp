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

//#define DIPUTADOS                      // 2015.06.11 (2015.06.22)
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
  #define Candidato_comun	"Candidato_comun_jd.txt"

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


/*
  La funcion main de la aplicacion de conteos dinamicos
  y rapidos.
*/

int main(int nargs, char* args[]){
  const int MAX=Votos::MAX;
  const int MAXCON=30;

  if(nargs<2){// archivos de datos
    cerr << "forma de uso:\n\t" << args[0] << " arch1.txt arch2.txt ... archN.txt\n";
    return EXIT_FAILURE;
  }

  srand(time(NULL));       // semilla de numeros aleatorios
  time_t Time;             // computo de la hora del conteo
  time(&Time);


  ifstream f(BaseNom);     // base de datos de la casilla
  if(f==NULL){
    cerr << "Error al leer las casillas: " << BaseNom << endl;
    return EXIT_FAILURE;
  }


  set<int> caspar[NUMENT]; // casillas participantes en el conteo
  int         cnt[NUMENT]; // numero de casilllas por entidad 
  map<string,int> idx[NUMENT];// mapeo nombre de casilla->codigo (un int? 2015.05.28)
  vector<Votos>   inv[NUMENT];// votos de cada casilla.

  int coal[NUMENT];        // candidato comun por cada entidad.
  LeerCoal(coal, NUMENT, Candidato_comun);  //lectura del archivo de Candidato_comunes

  while(!f.eof()){// lectura de la base de datos de las casillas (proporcionada por
    string linea; // el instituto electoral)
    f >> linea;
     if(linea.size()>0){
       Base B(linea);
       int ent=B.Entidad();
       idx[ent].insert(make_pair(linea, cnt[ent]++));
       inv[ent].push_back(Votos()); // numero de votos= 0
     }
  }
  f.close();


  for(int d=0; d<NUMENT; ++d)    // inicio de los codificadores de las casillas
    cnt[d]=0;


  for(int fi=1; fi<nargs; fi++){ // lectura de votos ...
    ifstream prep;
    prep.open(args[fi]);
    if(!prep)
      cerr << "no fue posible abrir el archivo " << args[fi] << endl;
    else{
      cerr << "Leyendo archivo: \n\t" << args[fi] << endl;
      while(!prep.eof()){
        string linea;
        prep >> linea;
        if(linea.size()>0){
          Voto V(linea);
          string nom=V.Casilla();
          int entidad=V.Entidad();
          if(idx[entidad].find(nom)==idx[entidad].end()){
            cerr << "ERROR: casilla sin registro: " << nom << endl;
            //exit(1);
          }else{// los votos no se suman, solo se leen...
            int id=idx[entidad][nom];
            caspar[entidad].insert(id);
            inv[entidad][id][V.Partido()]=V.Votos();
          } 
        }
      }
      prep.close();
    }
  }


  // Empiezan los conteos dinamicos...


  ofstream out(Nombre(pref, &Time).c_str());


  for(int ent=0; ent<NUMENT; ++ent)// se hace conteo por cada entidad...
    if(!caspar[ent].empty()){
//      double emin;//(2015.06.18)
      vector<int> Par;
      int tamprep=caspar[ent].size();

      cerr << "Entidad=" << ent << " card: " << cnt[ent] << endl;

      Par.clear();
      for(set<int>::iterator k=caspar[ent].begin(); k!=caspar[ent].end(); ++k)
         Par.push_back(*k);


      Votos sum[MAXCON];
      double pords[MAXCON][MAX];
      int caspart[MAXCON];
      int sumavot[MAXCON];
      int n=0;     // numero conteos que pudieron realizarse


      for(int conteo=0; conteo<MAXCON; ++conteo){
        int casins=cnt[ent];    // numero de casillas instaladas.
        int casviv=Par.size();  // numero de casillas "vivas"
        int numclases=Log2(casviv);// tamano de la particion.


        double paso=double(casins)/double(numclases);// ancho de la clase
        Particion P(numclases, paso, Par);   // particion inicial.
        double Xi, h;


        bool Pmal=true;
        while(Pmal){
          if(numclases<=4){// no aceptamos particiones 4 clases o menos.
            cerr << "ERROR: Muy pocas clases; ent= " << ent << endl;
            break;
          }
          if(P.TieneVacias()){// tampoco particiones con clases vacias...
            cerr << "AVISO: Hay clases vacias, intentaremos con "
                 << --numclases << " clases; ent=" << ent << endl;


/*
           // si requerimos un analisis
           // detallado de la particion,
           // usamos este segmento de codigo...
           cerr << "Entidad: " << ent
                << "Participan, " << P.size()
                << " de " << tamprep << ", " << P.size()/double(tamprep)
                << endl;
           cerr << P;
           cerr << endl;
*/

           // si la particion tiene clases vacias, se intenta 
           // hacer el "ancho" de las clases mas grande.
           // i.e. se reduce el numero de clases y con esto 
           // se calcula una nueva particion, con la cual se intenta...
           paso=double(casins)/double(numclases);
           //Particion Q(numclases, paso, P);
           Particion Q(numclases, paso, &P);
           P=Q;
           continue;
          }
//        Asi, si sabemos ya que el numero de clases es >4
//        y la particion no tiene clases vacias, verificamos
//        si la particion cumple con Xi cuadrada de de las tablas.


          h= double(P.size())/double(numclases);
          Xi=P.Xi(h);
          if(Xi >= XiMax(numclases)){//Eliminacion de casillas por 
//            P.ajuste(h);             //encima de la altura maxima
            P.Ajuste(h);             //encima de la altura maxima
            casviv=P.size();         //se actualiza el numero de 
                                     //casillas "vivas"
            numclases= Log2(casviv); //se recalcula la particion
            paso= double(casins)/double(numclases);
            //Particion Q(numclases, paso, P);
            Particion Q(numclases, paso, &P);
            P=Q;
          }
          else
            Pmal=false;       //en este punto, tenemos una 
                              //particion adecuada para el conteo...
        }

        if(Pmal){//se reportan fallas...
          cerr << "Falla conteo: Xi=" << Xi << " XiMax=" << XiMax(numclases) << endl;
          continue;
        }
//      una vez encontrada la muestra, se procesa.
        out << endl << endl;
//      reporte de la particion que va a ser usada.
        out << "Entidad," << ent << ", conteo, " << n << "num casillas " << casins << endl;
        out << "Participan " << P.size() << " casillas de " << tamprep << ',' 
            << P.size()/double(tamprep) << endl;
        out << "Altura: " << h << " Xi2 " << Xi << endl;
        out << P;
        out << endl;

//      calculo de las sumas de la particion (conteo dinamico)
//	for(int t=P.begin(); t>=0; t=++P){//(2015.06.18)
	for(int t=0; t<P.size(); ++t){
          inv[ent][t].suma(coal[ent]);
          sum[n]+=inv[ent][t];
        }
        caspart[n]=P.size();
        sumavot[n]=sum[n].suma(coal[ent]);

//      calculo de promedios...
        double prom[MAX];
        for(int p=0; p<MAX; ++p){
          prom[p]=0.0;
        }
//        for(int t=P.begin(); t>=0; t=++P){
	for(int t=0; t<P.size(); ++t){
          for(int p=0; p<MAX; ++p)
            prom[p]+=inv[ent][t].pc(p);
        } 
        int nc=P.size();
        for(int p=0; p<MAX; ++p)
          prom[p]/=nc;

//      calculo de sus desviaciones...
        double dvst[MAX];
        for(int p=0; p<MAX; ++p)
          dvst[p]=0.0;
//        for(int t=P.begin(); t>=0; t=++P){
	for(int t=0; t<P.size(); ++t){
          for(int p=0; p<MAX; ++p){
            double s=inv[ent][t].pc(p)-prom[p];
            dvst[p]+=s*s;
          }
        }
        for(int p=0; p<MAX; ++p)
          pords[n][p]=sqrt(dvst[p]/nc);

//      el conteo pudo hacerse, se cuenta.
        ++n;
      }

// reporte de los conteos
      if(n==0)// si no pudieron hacerse conteos, se reporta.
        cerr << "ERROR: La entidad= " << ent << "no genera conteos\n";
      else{
        out << endl;
        out << "Sumas, Entidad= " << ent << endl;
        out << "No. de Suma, No. Cas.,";
        
        for(int p=1; p<MAX; ++p)
          out << ',' << nombrep[p];
        out << endl;

        for(int conteo=0; conteo<n; ++conteo){
          out << conteo << ',' << caspart[conteo] << ','
              << sum[conteo];
          out << ",,";
          for(int p=1; p<MAX; ++p)
            out << ',' << pords[conteo][p];
          out << endl;
        }
        out << endl;

// por ulltimo se hacen algunos calculos estadisticos sobre los 
// conteos: promedios, desviaciones, maximos, minimos.
        double dat[MAXCON];
        double ma[MAX],maxcas;
        double mi[MAX],mincas;
        double pr[MAX],procas;
        double sd[MAX],sdvcas;

        out << "Conteos " << n << endl;
        out << "Entidad " << ent << endl;

        for(int p=0; p<MAX; ++p){
          for(int conteo=0; conteo<n; ++conteo)
            dat[conteo]=sum[conteo][p]/double(sumavot[conteo]);
          pr[p]=prom(n,dat);
          sd[p]=sdev(n,dat);
          ma[p]=max(n,dat);
          mi[p]=min(n,dat);
        }

        for(int conteo=0; conteo<n; ++conteo)
          dat[conteo]=caspart[conteo];

        procas=prom(n,dat);
        sdvcas=sdev(n,dat);
        maxcas=max(n,dat);
        mincas=min(n,dat);

        out << "Promedio " << procas << ',';
        for(int p=1; p<MAX; ++p)
          out << ',' << pr[p];
        out << ",,";

        for(int p=1; p<MAX; ++p){
          for(int conteo=0; conteo<n; ++conteo)
            dat[conteo]=pords[conteo][p];
          out << ',' << prom(n,dat);
        }
        out << endl;

//      reporte del conteo dinamico.
        out << "Desv Est." << sdvcas << ',';
        for(int p=1; p<MAX; ++p)
          out << ',' << sd[p];
        out << ',' << sd[0];
        out << endl;

        out << "Maximos, ";
        out << maxcas << ',';
        for(int p=1; p<MAX; ++p)
          out << ',' << ma[p];
        out << ",," << ma[0];
        out << endl;

        out << "Minimos, ";
        out << mincas << ',';
        for(int p=1; p<MAX; ++p)
          out << ',' << mi[p];
        out << ",," << mi[0];
        out << endl;
      }
    }

    out.close();
    return EXIT_SUCCESS;
}// End of main()
