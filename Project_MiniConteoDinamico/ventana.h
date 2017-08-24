#ifndef VENTANA_H
#define VENTANA_H
#include <vector>
#include "punto.h"
using std::vector;

class ventana
{
	public:
		punto puntoSupIzq;
		punto puntoInfDer;
		punto puntoSupIzqDRAW;
		punto puntoInfDerDRAW;
		ventana();
		ventana(punto puntoSI,punto puntoID);
		void set_DRAW();
		void dibujar();
	protected:
};//end class ventana

#endif
