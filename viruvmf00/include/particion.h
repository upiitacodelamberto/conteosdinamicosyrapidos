#ifndef PARTICION_H
#define PARTICION_H

#include <iostream>
#include <vector>
#include "votos.h"

using std::ostream;
using std::vector;

class Particion {
      private:
          int numclases;
//          vector<int> *Clase;//(2015.06.22)
          vector<int> Clase;//(2015.06.22)
          void Recorte(vector<int>& P, double h);
          vector<int>::iterator iter;
          int  itcl;
          const Particion *P;//(2015.06.22)
          
      public:
          Particion(int n, double paso, vector<int>& P);
//          Particion(int n, double paso, vector<int>* P);//(2015.06.22)
          Particion(int n, double paso, const Particion* P);//(2015.06.22)
          Particion(const Particion& P);
          //Particion(Particion& P);
          Particion();//(2015.06.22)
          bool TieneVacias(void);
          void Ajuste(double h);
          int  size(void);
          double  Xi(double h);
          ~Particion(void);
          //Particion& operator = (const Particion&);//(2015.06.22)
          Particion& operator = (Particion&);//(2015.06.22)
          friend ostream& operator << (ostream& os, const Particion&  P);
          void Resultados(vector<Votos>& v, const int MAX, 
                                             double* prom, double* desv);
//(2015.06.19)          void ajuste(double h){ }// (2015.06.18)
};

#endif
