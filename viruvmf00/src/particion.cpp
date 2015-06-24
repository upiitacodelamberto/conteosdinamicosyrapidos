#include <iostream>
#include <math.h>
#include "particion.h"
using namespace std;
extern double XiMax(int);

Particion::Particion(int n, double paso, vector<int>& P){
  numclases=n;
  Clase=P;
}


bool Particion::TieneVacias(){
  if(Clase.size()<(unsigned int)numclases){//Stub solo para compilar y ver
    return true;
  }else{
    return false;
  }
}

Particion::Particion(int n, double paso, const Particion *P){
  numclases=n;
  this->P=P; 
}

//Particion& Particion::operator=(const Particion& P){
Particion& Particion::operator=(Particion& P){
  *this=P;
  return P;
}

Particion::Particion(){ }
Particion::~Particion(){ }

int Particion::size(){
  return Clase.size();
}

double Particion::Xi(double h){
  return XiMax(floor(h));
}

/**
 * Aqui hay que codificar lo que se entienda por 
 * hacer un ajuste a la particion. (2015.06.23)
 */
void Particion::Ajuste(double h){
}

/**
 * Aqui se debe programar el equivalente al metodo 
 * public String toString() para una clase de Java.
 * Por ahora solo imprimire algo bobo despues vere 
 * que es relevante imprimir. (2015.06.23)
 */
ostream& operator << (ostream& os, const Particion& P){
  os << "Esta es una particion" << endl;
  return os;
}
