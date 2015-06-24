#include <iostream>
#include "votos.h"
#include "voto.h"
using namespace std;

/*
void operator[](int index, Votos V){
	*(vo + index) = V;
}
*/
/* Stub resuelto unicamente para poder compilar 
 * y ver que onda (2015.06.22)*/
int& Votos::operator[](int index){
//  return *(vo + index);
  return votos[index];//(2015.06.22)
}
Votos::Votos(){
  sum=0;
}
VotoDip::VotoDip(string v){
  casilla=v;
}

int Votos::suma(int a){
  sum+=a;
  return sum;
}

Votos& Votos::operator += (const Votos& V){
  Votos& R = *this;
  R.sum+=V.sum;
  return R;
}

/**
 * Stub solo para poder compilar (2015.06.23)
 */
double Votos::pc(int a){
  return (double)a;
}

/**
 * Stub (2015.06.23)
 */
ostream& operator << (ostream& os, Votos& v){
  os << "Aqui debe imrimirse un objeto Votos" << endl;
return os;
}
