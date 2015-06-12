#inlcude "votos.h"

/* Stub resuelto unicamente para poder compilar 
 * y ver que onda*/
int Votos::operator[](int index){
  return *(vo + index);
}
void operator[](int index, Votos V){
	*(vo + index) = V;
}
