//#include <cppunit/CompilerOutputter.h>
//#include <cppunit/extensions/TestFactoryRegistry.h>
#include <iostream>
#include <cppunit/TestSuite.h>
#include <cppunit/ui/text/TestRunner.h>

//#include "modelo.h"
#include "prueba.h"

using namespace std;
//string Casilla::distrito="HOY 2015.11.24";
string Casilla::distrito="1";

int main(){
  //Obtener la prueba, suite del registro
  //CppUnit::Test *suite=CppUnit::TestFactoryRegistry::getRegistry().makeTest();

  //Agregar esta suite de prueba a la lista de pruebas a ejecutarse.
  CppUnit::TextUi::TestRunner runner;
  //runner.addTest(suite);
  cout<<"Creando suite de pruebas..."<<endl;
  runner.addTest(TestCasilla::suite());

  ////Colocar el emisor de resultados
  //runner.setOutputter(new CppUnit::CompilerOutputter(&runner.result(), std::cerr));

  //Correr pruebas
  cout<<"Corriendo pruebas de unidad..."<<endl;
  bool wasSuccessfull=runner.run();

  //Devolver codigo de error
  if(wasSuccessfull)
    return 0;
  else
    return 1;
}//end main()
