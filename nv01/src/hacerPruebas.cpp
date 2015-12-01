//#include <cppunit/CompilerOutputter.h>
//#include <cppunit/extensions/TestFactoryRegistry.h>
#include <iostream>
#include <cppunit/TestSuite.h>
#include <cppunit/ui/text/TestRunner.h>

//#include "modelo.h"
#include "prueba.h"

using namespace std;

int main(){
  //Agregar esta suite de prueba a la lista de pruebas a ejecutarse.
  CppUnit::TextUi::TestRunner runner;
  cout<<"Creando suite de pruebas..."<<endl;
  runner.addTest(TestCasilla::suite());

  //Correr pruebas
  cout<<"Corriendo pruebas de unidad..."<<endl;
  bool wasSuccessfull=runner.run();

  //Devolver codigo de error
  if(wasSuccessfull)
    return 0;
  else
    return 1;
}//end main()
