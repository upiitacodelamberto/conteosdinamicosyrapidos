#include "modelo.h"
Casilla **BIN;

void inic_bins(){
  BIN = new Casilla*[NUMDFILAS];
  for(int i = 0; i < NUMDFILAS; i++){
    *(BIN + i) = new Casilla[NUMDCOLUMNAS];
  }
}
