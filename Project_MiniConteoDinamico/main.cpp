#include <iostream>
#include "punto.h"
#include "ventana.h"

/* run this program using the console pauser or add your own getch, system("pause") or input loop */

int intArr[11];
#define NUMDVENT	3
extern void gotoxy(short,short);
/**
 * Las cordenadas de cualquier punto deben ser tales que 0<=x<=12 y 0<=y<=10
*/

int main(int argc, char** argv) {
	punto puntoSI(0,0);
	punto puntoID(4,2);
	ventana ventanaUNO(puntoSI,puntoID);
	//ventanaUNO.dibujar();
	punto puntoSI1(4,0);
	punto puntoID1(8,2);
	ventana ventanaDOS(puntoSI1,puntoID1);
	//ventanaDOS.dibujar();
	punto puntoSI2(4,2);
	punto puntoID2(12,4);
	ventana ventanaTRES(puntoSI2,puntoID2);
	//ventanaTRES.dibujar();
	punto puntoSI3(8,4);
	punto puntoID3(12,6);
	ventana ventanaCUATRO(puntoSI3,puntoID3);
	//ventanaCUATRO.dibujar();
	ventana ventanaArr[3];
	ventanaArr[0]=ventanaUNO;
	ventanaArr[1]=ventanaDOS;
	ventanaArr[2]=ventanaTRES;
	for(int i=0;i<NUMDVENT;i++){
		intArr[ventanaArr[i].puntoSupIzq.intY]=1;
		intArr[ventanaArr[i].puntoInfDer.intY]=1;
	}//Todos los demas elementos del arreglo los dejo como cero.
	void print(int []);
	print(intArr);
	for(int i=0;i<NUMDVENT;i++){
		ventanaArr[i].set_DRAW();
	}
	for(int i=0;i<NUMDVENT;i++){
		ventanaArr[i].dibujar();
	}
	return 0;
}
void print(int intAr[]){
	gotoxy(0,11);
	for(int i=0;i<11;i++){
		printf("%d   ",intAr[i]);
	}
}
