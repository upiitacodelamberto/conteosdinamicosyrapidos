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
<<<<<<< HEAD
   suiteOfTests->addTest(new CppUnit::TestCaller<TestCasilla>("Test 1 - Crear Casilla.", &TestCasilla::testUnaCasillaCreate));
=======
   suiteOfTests->addTest(new CppUnit::TestCaller<TestCasilla>("Test 1 - Crear Casilla", &TestCasilla::testUnaCasillaCreate));
>>>>>>> ed84b239faf9213c538c5c338a1130a1c04a7695
    /* Aqui se pueden agregar mas tests */
    return suiteOfTests;
  }
   
  //Setup method
  void setUp() {}

  //Teardown method
<<<<<<< HEAD
  void tearDown();
=======
//  void tearDown();
  void tearDown() {}
>>>>>>> ed84b239faf9213c538c5c338a1130a1c04a7695

  protected:
  //void testUnaCasillaCreate();
  void testUnaCasillaCreate(){
  string distrito="1";
  string seccion="918";
  string casilla="B";
  string delegacion="GUSTAVO A. MADERO";
  string tipo="JD";
//  Casilla CAS(distrito, seccion, casilla, delegacion, tipo);
<<<<<<< HEAD
  CasiCasilla CAS; CAS.distrito=100;
=======
  //CasiCasilla CAS; CAS.distrito=100;
  CasiCasilla CAS; CAS.distrito="ALGO";
>>>>>>> ed84b239faf9213c538c5c338a1130a1c04a7695
  CasiCasilla CASCAS=Casilla::getCasiCas();
//  CPPUNIT_ASSERT_EQUAL(CAS.get_distrito(), distrito);
  CPPUNIT_ASSERT(CAS==CASCAS);
//  CPPUNIT_ASSERT_EQUAL(CAS.get_seccion(), seccion);
//  CPPUNIT_ASSERT_EQUAL(CAS.get_delegacion(), delegacion);
//  CPPUNIT_ASSERT_EQUAL(CAS.get_tipo(), tipo);
}
  void testDosCasillaCreate(){}
};//end class TestCasilla
