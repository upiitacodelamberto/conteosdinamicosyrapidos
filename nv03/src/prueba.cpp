#include <vector>
#include "modelo.h"
#include "prueba.h"

using std::string;

void TestCasilla::testUnaCasillaCreate(){
  string distrito="1";
  string seccion="918";
  string casilla="B";
  string delegacion="GUSTAVO A. MADERO";
  string tipo="JD";
  Casilla CAS(distrito, seccion, casilla, delegacion, tipo);
CAS.set_tipo("ZZ");
  CPPUNIT_ASSERT_EQUAL(CAS.get_distrito(), distrito);
  CPPUNIT_ASSERT_EQUAL(CAS.get_seccion(), seccion);
  CPPUNIT_ASSERT_EQUAL(CAS.get_delegacion(), delegacion);
  CPPUNIT_ASSERT_EQUAL(CAS.get_tipo(), tipo);
}
