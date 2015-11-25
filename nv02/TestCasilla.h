//#include <cppunit/extensions/HelperMacros.h>
#include <iostream>
#include <cppunit/TestFixture.h>
#include <cppunit/TestAssert.h>
#include <cppunit/TestCaller.h>
#include <cppunit/TestSuite.h>
#include <cppunit/TestCase.h>

#include "Casilla.h"

using namespace std;

class TestCasilla : public CppUnit::TestFixture {
  private:
  Casilla *testCasilla;

  public:
  TestCasilla() : testCasilla(NULL) {}
  virtual ~TestCasilla(){
    delete testCasilla;
  }

  static CppUnit::Test *suite(){
   CppUnit::TestSuite *suiteOfTests=new CppUnit::TestSuite("TestCasillaNOSEQUEMASPONER");
   suiteOfTests->addTest(new CppUnit::TestCaller<TestCasilla>("Test 1 - Crear Casilla", &TestCasilla::testUnaCasillaCreate));
    /* Aqui se pueden agregar mas tests */
    return suiteOfTests;
  }
   
  //Setup method
  void setUp() {}

  //Teardown method
//  void tearDown();
  void tearDown() {}

  protected:
  //void testUnaCasillaCreate();
  void testUnaCasillaCreate(){
  string distrito="1";
  string seccion="918";
  string casilla="B";
  string delegacion="GUSTAVO A. MADERO";
  string tipo="JD";
//  Casilla CAS(distrito, seccion, casilla, delegacion, tipo);
  //CasiCasilla CAS; CAS.distrito=100;
  CasiCasilla CAS; CAS.distrito="ALGO";
  CasiCasilla CASCAS=Casilla::getCasiCas();
//  CPPUNIT_ASSERT_EQUAL(CAS.get_distrito(), distrito);
  CPPUNIT_ASSERT(CAS==CASCAS);
//  CPPUNIT_ASSERT_EQUAL(CAS.get_seccion(), seccion);
//  CPPUNIT_ASSERT_EQUAL(CAS.get_delegacion(), delegacion);
//  CPPUNIT_ASSERT_EQUAL(CAS.get_tipo(), tipo);
}
  void testDosCasillaCreate(){}
};//end class TestCasilla
