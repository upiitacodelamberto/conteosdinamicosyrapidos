/**
 * main.c - El programa principal de la aplicacion.
 */
#include <stdio.h>
#include "modelo.h"

int main(int argc, char *argv[]){
  printf("Conteos dinamicos y conteos rapidos\n");
  inic_bins();
  proccess_commands(BIN);
  

  return 0;
}
