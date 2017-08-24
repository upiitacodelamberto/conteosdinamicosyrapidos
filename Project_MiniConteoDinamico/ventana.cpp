#include <windows.h>
#include "punto.h"
#include "ventana.h"
#include <stdio.h>
extern int intArr[11];
	
//Defines gotoxy() for ANSI C compilers.
void gotoxy(short x, short y) {
	COORD pos = {x, y};
	SetConsoleCursorPosition(GetStdHandle(STD_OUTPUT_HANDLE), pos);
}

ventana::ventana():puntoSupIzq(punto(0,0)),puntoInfDer(punto(0,0)){  }

ventana::ventana(punto puntoSI,punto puntoID)
{
	puntoSupIzq=punto(puntoSI.intX,puntoSI.intY);
	puntoInfDer=punto(puntoID.intX,puntoID.intY);
}

void ventana::dibujar()
{
	gotoxy(puntoSupIzqDRAW.intX,puntoSupIzqDRAW.intY);
	for(int i=0;i<=(puntoInfDerDRAW.intX-puntoSupIzqDRAW.intX);i++){
		printf("%s","-");
	}
	gotoxy(puntoSupIzqDRAW.intX,puntoSupIzqDRAW.intY+1);
	for(int j=0;j<(puntoInfDerDRAW.intY-puntoSupIzqDRAW.intY);j++){
		printf("%c",'|');gotoxy(puntoSupIzqDRAW.intX,puntoSupIzqDRAW.intY+1+j+1);
	}
	gotoxy((puntoInfDerDRAW.intX),puntoSupIzqDRAW.intY+1);
	for(int j=0;j<(puntoInfDerDRAW.intY-puntoSupIzqDRAW.intY);j++){
		printf("%c",'|');gotoxy((puntoInfDerDRAW.intX),puntoSupIzqDRAW.intY+1+j+1);
	}
	gotoxy(puntoSupIzqDRAW.intX,puntoInfDerDRAW.intY+1);
	for(int i=0;i<=(puntoInfDerDRAW.intX-puntoSupIzqDRAW.intX);i++){
		printf("%s","-");
	}
}
int cuenta(int index){
	int sum=0;
	for(int i=0;i<=index;i++){
		sum+=2*i*intArr[i];
	}
	return sum;
}
void ventana::set_DRAW(){
	puntoSupIzqDRAW=punto(puntoSupIzq.intX,cuenta(puntoSupIzq.intY));
	puntoInfDerDRAW=punto(puntoInfDer.intX,cuenta(puntoInfDer.intY));
}
