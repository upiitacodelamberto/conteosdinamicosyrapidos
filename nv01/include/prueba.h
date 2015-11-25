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
      ("Test 1 - Crear Casilla.", &TestCasilla::testUnaCasillaCreate));
    /* Aqui se pueden agregar mas tests */
    return suiteOfTests;
  }
   
  //Setup method
  void setUp() {}

  //Teardown method
  void tearDown() {}

  protected:
  //void testUnaCasillaCreate();
  void testUnaCasillaCreate(){
    string distrito="1";
    string seccion="918";
    string casilla="B";
    string delegacion="GUSTAVO A. MADERO";
    string tipo="JD";
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
  }
};//end class TestCasilla
