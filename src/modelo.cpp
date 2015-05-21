#include <iostream>
#include <vector>
#include "modelo.h"
using namespace std;

Casilla **BIN;

void inic_bins(){
  BIN = new Casilla*[NUMDFILAS];
  for(int i = 0; i < NUMDFILAS; i++){
    *(BIN + i) = new Casilla[NUMDCOLUMNAS];
  }
}

/**
 * Agrego esta funcion con la idea de poder probar 
 * en esta etapa inicial si funcionan bien algunas funciones 
 * que haran uso de metodos de objetos de la clase Casilla, 
 * que aun no he agregado. Entre ellos tengo pensado una funcion 
 * que nos indique la informacion que se muestra en la columna fx
 * en la tabla de la derecha de la grafica I.3 (Pag. 23 del Docto).
 */
void proccess_commands(Casilla **bin){
  unsigned int item;
  vector<string> mdoitem;
  mdoitem.push_back("Mostrar casillas reportadas al PREP por cada bin");
  mdoitem.push_back("Salir");
  
  cout << "En esta version un bin es uno de 15 grupos de 8 casillas" << endl;
  do{
  for(unsigned int i = 0; i < mdoitem.size(); i++){
    cout << i << " " << mdoitem[i] << endl;
  }
  cout << "Teclea una opcion: ";
  cin >> item;
  switch(item){
    case 0:{proccess_show_reported_casillas(bin); break;}
    case 1:{proccess_salir(); break;}
    default: break;
  }
  }while(item != (mdoitem.size() - 1));
}

void proccess_show_reported_casillas(Casilla **bin){
}

void proccess_salir(){
   /* por ahora esta funcion queda vacia (2015.05.20) */
}
