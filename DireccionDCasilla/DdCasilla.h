#ifndef DDCASILLA_H
#define DDCASILLA_H
#include <iostream>
using namespace std;

#include <string>
#include <stdlib.h>
using std::string;
using std::ostream;

//Para tener listos valores por defecto para algunos atributos 
//de las direcciones.
template <typename T> /* Esto parece funcionar 'aprox' como */
class Static_T        /* __attribute__((weak))      */
{
public:
  static T name ;    // Nombre de persona o de casilla
  static T codpost ; // Codigo Postal
  static T REF;      // REFerencia para mayor facilidad de ubicacion de la direccion 
} ;
template <typename T>T Static_T<T>::name="FALTA Nombre";
template <typename T>
T Static_T<T>::codpost="FALTA C.P.";
template <typename T>
T Static_T<T>::REF="FALTA REFERENCIA!";

#define TIPO_CUAL_VALOR(tipo, cual, valor) void dummy##_##cual(){\
Static_T<tipo>::cual=valor;\
}

#define WHO_WHICH_WHAT(a,b,c) \
Static_T<string>::b=c;\
a.b=Static_T<string>::b;

//Ahora la clase Direccion de Casilla
class DdCasilla{     //Direccion de Casilla
  string Nombre;     //Nombre de persona o nombre de casilla 
  string calle;      //nombre de la calle
  string numExt;     //numero Exterior (desafortunadamente, los 'numeros' a veces
                     //incluyen letras, por eso no puedo usar aqui un int)
  string numInt;     //numero Interior (tambien a veces incluyen letras)
  string colonia;    //colonia
public:
  string codpost;    //codigo postal
  string REF;        //alguna referencia

public:
  DdCasilla(string, string, string, string);//Calle, num ext, num int, colonia, aqui no se pasa CP
  void set_Nombre(string name);

  friend ostream& operator<<(ostream&, DdCasilla&);
private:
  void set_Nombre();
  void set_CodPost();
  void set_Referencia();
};//end class DdCasilla
#endif  /* DDCASILLA_H */
