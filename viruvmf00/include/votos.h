#ifndef VOTOS_H
#define VOTOS_H

#include <iostream>
using std::ostream;

class Votos{
      public:
         static const int MAX=    11; 
         static const int PNUL=    9;
         static const int COAL=   10;
         static const int CUENTA= 10;   
         static const int NULOS=  24;
      protected:
         int    votos[MAX];
         int    sum;
      public:
         Votos(void);
         int&   operator[] (int);
         Votos& operator+= (const Votos&);
         int    suma(int);
         double pc(int p);
         friend ostream& operator << (ostream& os, Votos& v);
         int S() { return sum; };
      };
      
#endif
