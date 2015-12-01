//#include <cppunit/extensions/HelperMacros.h>
#include <iostream>
#include <cppunit/TestFixture.h>
#include <cppunit/TestAssert.h>
#include <cppunit/TestCaller.h>
#include <cppunit/TestSuite.h>
#include <cppunit/TestCase.h>

#include "modelo.h"

using namespace std;

class TestCasilla : public CppUnit::TestFixture {
//  CPPUNIT_TEST_SUITE(TestCasilla);
//  CPPUNIT_TEST(testUnaCasillaCreate);
//  CPPUNIT_TEST_SUITE_END();
  private:
  Casilla *testCasilla;

  public:
  TestCasilla() : testCasilla(NULL) {}
  virtual ~TestCasilla(){
    delete testCasilla;
  }

  static CppUnit::Test *suite(){
   CppUnit::TestSuite *suiteOfTests=new CppUnit::TestSuite("PruebaCasilla");
    suiteOfTests->addTest(new CppUnit::TestCaller<TestCasilla>
<<<<<<< HEAD
      ("Test 1 - Crear Casilla.", &TestCasilla::testCreacionDeUnaCasilla));
=======
      ("Test 1 - Crear Casilla.", &TestCasilla::testUnaCasillaCreate));
>>>>>>> ed84b239faf9213c538c5c338a1130a1c04a7695
    /* Aqui se pueden agregar mas tests */
    return suiteOfTests;
  }
   
  //Setup method
  void setUp() {}

  //Teardown method
  void tearDown() {}

  protected:
  //void testUnaCasillaCreate();
<<<<<<< HEAD
  void testCreacionDeUnaCasilla(){
=======
  void testUnaCasillaCreate(){
>>>>>>> ed84b239faf9213c538c5c338a1130a1c04a7695
    string distrito="1";
    string seccion="918";
    string casilla="B";
    string delegacion="GUSTAVO A. MADERO";
    string tipo="JD";
<<<<<<< HEAD
    Casilla CAS(distrito, seccion, casilla, delegacion, tipo);
    /* Con esto se revisa si los string usados para cada 
       atributo de un objeto casilla efectivamente tienen 
       los mismos valores que nos devueleven geters respectivos. */
    CPPUNIT_ASSERT_EQUAL(CAS.get_distrito(), distrito);
    CPPUNIT_ASSERT_EQUAL(CAS.get_seccion(), seccion);
    CPPUNIT_ASSERT_EQUAL(CAS.get_casilla(), casilla);
    CPPUNIT_ASSERT_EQUAL(CAS.get_delegacion(), delegacion);
    CPPUNIT_ASSERT_EQUAL(CAS.get_tipo(), tipo);
  }
  /**
    Con esta prueba busco revisar si la clase Clase Casilla 
    usa adecuadamente la clase String_Tokenizer para crear objetos
    de clase Casilla con los datos leidos de la primera linea del 
    archivo ``1 Resulatdos secciones.csv'' (en la version de este 
    archivo a la que ya le quite los encabezados). La eleccion de 
    columnas correctas debera omitir la primera columna de (cada) 
    fila leida de ese archivo ``adaptado'' (i.e. sin los encabezados)
    Esta prueba queda sin efecto, ya que no tiene sentido, la primera
    columna, corresponde al distrito, la segunda a la seccion, la 
    tercera es el nombre de casilla, la cuarta es la delegacion, y 
    la quinta el tipo de casilla. Habra que hacer una prueba distinta 
    entonces.
    Se puede notar que en el archivo hay cierta cantidad de casillas 
    que no tienen datos, en este caso se puede poner a prueba un metodo
    que determine cuales son las casillas que no tienen datos reportados 
    en el archivo que se este revisando. En este caso se trata del archivo 
    ``1 Resulatdos secciones.csv'' adaptado. Asi que habra que definir 
    el criterio con el cual se considerara que una casilla no tiene 
    datos. En este caso Por cada casilla habra que leer todas las columnas
    y buscar si alguna de las columnas despues de la columna que indica el
    ``tipo'' contiene una cadena vacia. Es decir, queiero determinar 
    si la clase String_Tokenizer efectivamente es capaz de 
    proporcionarle al constructor de la case Casilla la cadena "".
   */
  void testDiscriminaCasillaConsideradaComoNoReportada(){
=======
    Casilla UnaCasilla(distrito, seccion, casilla, delegacion, tipo);
    CasiCasilla CAS;
    CAS.distrito="1";
    CasiCasilla CASCAS=Casilla::get_CasiCas();
    CPPUNIT_ASSERT_EQUAL(UnaCasilla.get_distrito(), distrito);
//    CPPUNIT_ASSERT(CAS==CASCAS);
    CPPUNIT_ASSERT_EQUAL(UnaCasilla.get_seccion(), seccion);
    CPPUNIT_ASSERT_EQUAL(UnaCasilla.get_delegacion(), delegacion);
    CPPUNIT_ASSERT_EQUAL(UnaCasilla.get_tipo(), tipo);
    CPPUNIT_ASSERT(UnaCasilla.get_delegacion()==delegacion);
>>>>>>> ed84b239faf9213c538c5c338a1130a1c04a7695
  }
};//end class TestCasilla
