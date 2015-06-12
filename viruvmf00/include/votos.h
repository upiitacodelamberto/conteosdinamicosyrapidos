#ifndef VOTOS_H
#define VOTOS_H
#include <iostream>
using namespace std;
//Clase Stub (La escribo inicialmente solo para poder compilar
//el programa y ver que tanta locura hace)
class Votos{
public:
  static int MAX;
  int *vo;
  int operator[](int);
  void operator[](int,Votos);
};//End class Votos



//extern char BaseNom[];  // Cadena que debera contener la base 
                        // de datos de la casilla (creo 2015.06.11)
//extern int NUMENT;   // Estoy usando alegremente la palabra reservada extern 
                     // para lograr alcance de archivo y evitar tener que 
                     // definir algunas cadenas y/o valores enteros 
                     // que por ahora no conozco, y aun asi poder compilar
                     // (aunque no enlazar)  Es un truco medio sucio, pero 
                     // ni modo  (2015.06.11)

//extern const char* candidado_comun;
#endif /* VOTOS_H */
