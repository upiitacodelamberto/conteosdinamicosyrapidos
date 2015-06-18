#ifndef BASE_H
#define BASE_H

#include<string>

using std::string;

class Base {
       protected:
           string casilla;
       public:
           Base(string c)  { casilla= c; }
           virtual int    Entidad(void) = 0;
           virtual string Casilla(void) = 0;
      };


class BaseDip :  public Base {
      private:
          int    dist;
          
      public:
         BaseDip(string v);
         virtual int    Entidad(void)  { return dist; }
         virtual string Casilla(void)  { return casilla; }
      };

class BaseDel :  public Base {
      private:
          int    dele;
          
      public:
         BaseDel(string v);
         virtual int    Entidad(void)  { return dele; }
         virtual string Casilla(void)  { return casilla; }
      };
      
#endif
      
