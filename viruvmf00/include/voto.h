#ifndef VOTO_H
#define VOTO_H

#include<string>
using std::string;


class Voto {
       public:
           virtual int    Entidad(void) = 0;
           virtual int    Partido(void) = 0;
           virtual int    Votos(void)   = 0;
           virtual string Casilla(void) = 0;
      };


class VotoDip :  public Voto {
      private:
          int    dist;
          int    secc;
          string tipoc;
          int    prel;
          int    part;
          int    numv;
          string casilla;
          
      public:
         VotoDip(string v);
         virtual int    Entidad(void) {return dist; }
         virtual int    Partido(void) {return part; }
         virtual int    Votos(void)   {return numv; }
         virtual string Casilla(void) {return casilla; }
      };

class VotoDel :  public Voto {
      private:
          int    dele;
          int    dist;
          int    secc;
          string tipo;
          int    prel;
          int    part;
          int    numv;
          string casilla;
          
      public:
         VotoDel(string v);
         virtual int    Entidad(void) {return dele; }
         virtual int    Partido(void) {return part; }
         virtual int    Votos(void)   {return numv; }
         virtual string Casilla(void) {return casilla; }
      };

#endif
