//#include <cppunit/CompilerOutputter.h>
//#include <cppunit/extensions/TestFactoryRegistry.h>
#include <iostream>
#include <cppunit/TestSuite.h>
#include <cppunit/ui/text/TestRunner.h>

//#include "modelo.h"
#include "TestCasilla.h"

using namespace std;
<<<<<<< HEAD
//string Casilla::distrito="ALGO";
=======
//int Casilla::distrito=100;
string Casilla::distrito="ALGO";
>>>>>>> ed84b239faf9213c538c5c338a1130a1c04a7695

int main(){
  //Agregar esta suite de prueba a la lista de pruebas a ejecutarse.
  CppUnit::TextUi::TestRunner runner;

  cout<<"Creando suite de pruebas..."<<endl;
  runner.addTest(TestCasilla::suite());
  //Correr pruebas
  cout<<"Corriendo pruebas de unidad..."<<endl;
//  bool wasSuccessfull=runner.run();
  runner.run();

  //Devolver codigo de error
//  if(wasSuccessfull)
//
//    return 0;
//  else
//    return 1;
return 0;
}//end main()
