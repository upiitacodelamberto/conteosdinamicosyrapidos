#include <iostream>
#include <string>
#ifdef _WIN32
#include <conio.h>
#endif
#include "DdCasilla.h"
using namespace std;
extern DdCasilla DraCanseco;

int main(int argc, char *argv[]){
  DraCanseco.set_Nombre("Dra. Rosario Canseco");
////  Static_T<string>::REF="A una cuadra de Liverpool Insurgentes";
////  DraCanseco.referencia=Static_T<string>::REF;
  WHO_WHICH_WHAT(DraCanseco, REF, "A una cuadra de Liverpool Insurgentes");
  WHO_WHICH_WHAT(DraCanseco, codpost, "55070");
  cout<<DraCanseco;
#ifdef _WIN32
  getch();
#endif
  return 0;
}
