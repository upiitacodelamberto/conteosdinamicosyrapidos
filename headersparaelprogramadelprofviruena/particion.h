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
          vector<int> *Clase;
          void Recorte(vector<int>& P, double h);
          vector<int>::iterator iter;
          int  itcl;
          
      public:
          Particion(int n, double paso, vector<int>& P);
          Particion(int n, double paso, const Particion& P);
          Particion(const Particion& P);
          bool TieneVacias(void);
          void Ajuste(double h);
          int  size(void);
          double  Xi(double h);
          ~Particion(void);
          Particion& operator = (const Particion&);
          friend ostream& operator << (ostream& os, const Particion&  P);
          void Resultados(vector<Votos>& v, const int MAX, 
                                             double* prom, double* desv);
};

#endif
