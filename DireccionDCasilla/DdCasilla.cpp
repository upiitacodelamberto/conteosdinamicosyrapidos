#include <iostream>
#include "DdCasilla.h"
#include "DEFSCanseco.h"
using std::endl;
using std::cout;

extern void dummy_REF();

ostream& operator<<(ostream& out, DdCasilla& DdC){
  out<<DdC.Nombre<<endl
     <<DdC.calle<<" "<<DdC.numExt<<", "<<DdC.numInt<<endl
     <<"Col. "<<DdC.colonia<<" C.P. "<<DdC.codpost<<endl
     <<"REFERENCIA: "<<DdC.REF<<endl;
  return out;
}

DdCasilla::DdCasilla(string Calle, string NumExt, string NumInt, string Col){
  calle=Calle; numExt=NumExt; numInt=NumInt; colonia=Col;
  set_CodPost();
  set_Referencia();
}
void DdCasilla::set_Nombre(string name){
  Nombre=name;
//#ifdef DUMMY_REF
//cout << "NOMBRE: " << name << endl;
//  dummy_REF();
//#endif
}

void DdCasilla::set_Nombre(){
  Nombre="FALTA Nombre";
//  Nombre=Static_T<string>::name;
}

void DdCasilla::set_CodPost(){
  codpost=Static_T<string>::codpost;
}
void DdCasilla::set_Referencia(){
  REF=Static_T<string>::REF;
}
