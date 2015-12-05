//#include <cppunit/extensions/HelperMacros.h>
#include <iostream>
#include <cppunit/TestFixture.h>
#include <cppunit/TestAssert.h>
#include <cppunit/TestCaller.h>
#include <cppunit/TestSuite.h>
#include <cppunit/TestCase.h>
#include <fstream>

#include "modelo.h"
#include "String_Tokenizer.h"

using namespace std;
string archivo="1 Resultados_secciones.csv";

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
      ("Test 1 - Crear Casilla.", &TestCasilla::testCreacionDeUnaCasilla));
    suiteOfTests->addTest(new CppUnit::TestCaller<TestCasilla>
      ("Test2 - Detectar Casilla sin votos para partido, candidato, o coalicion. Por ahora solo busca revisar si el primer partido no tiene votos.", &TestCasilla::testDiscriminaCasillaConsideradaComoNoReportada));
    /* Aqui se pueden agregar mas tests */
    return suiteOfTests;
  }
   
  //Setup method
  void setUp() {}

  //Teardown method
  void tearDown() {}

  protected:
  void testCreacionDeUnaCasilla(){
    string distrito="1";
    string seccion="918";
    string casilla="B";
    string delegacion="GUSTAVO A. MADERO";
    string tipo="JD";
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
    Utilizare la denominacion de ``archivo adaptado'' para 
    referirme a un archivo de MSExel exportado al formato 
    csv (comma separated values) en el cual ya he borrado 
    las ``primeras lineas'', ya que estas contiene solo 
    los datos de las cabeceras de las tablas de exel, que no se 
    ocupan para la creacion de los objetos de clase Casilla. 

    Se puede notar que en el archivo ``1 Resultados secciones.csv'' 
    hay cierta cantidad de casillas que no tienen datos, en este 
    caso se puede poner a prueba un metodo que determine cuales son 
    las casillas que no tienen datos reportados en el archivo que 
    se este revisando. En este caso se trata del archivo 
    ``1 Resultados secciones.csv'' adaptado. Asi que habra que definir 
    el criterio con el cual se considerara que una casilla no tiene 
    datos. En este caso Por cada casilla habra que leer todas las columnas
    y buscar si alguna de las columnas despues de la columna que indica el
    ``tipo'' contiene una cadena vacia. Es decir, queiero determinar 
    si la clase String_Tokenizer efectivamente es capaz de 
    proporcionarle al constructor de la case Casilla la cadena "".
   */
  void testDiscriminaCasillaConsideradaComoNoReportada(){
    CasiCasilla CCasill;
    Casilla *ap;
    string cadvacia="";
    vector<string> arr;
    arr.push_back("");arr.push_back("");arr.push_back("");
    arr.push_back("");arr.push_back("");arr.push_back("");
    //crear una cadena de entrada para ese archivo
    /* string archivo definido al inicio de este archivo */
    ifstream in(archivo.c_str()); 
    if(in){//el stream existe
      string linea;
      int line_num=0, tokcount=0;
      while(getline(in, linea)){
        line_num++;
        String_Tokenizer tokenizer(linea, ",");
        while(tokenizer.has_more_tokens()){
          arr[tokcount]=tokenizer.next_token();
          tokcount++;
          if(tokcount==6){
            //add(arr);
            CCasill.distrito=arr[0];CCasill.seccion=arr[1];CCasill.casilla=arr[2];
            CCasill.delegacion=arr[3];CCasill.tipo=arr[4];CCasill.PartCandCoal=arr[5];
            ap=new Casilla(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
            tokcount=0;
            if(line_num==3){
//cout<<"ap->get_PartCandCoal()="<<ap->get_PartCandCoal()<<"  "<<"cadvacia="<<cadvacia<<"\n";
              CPPUNIT_ASSERT_EQUAL(ap->get_PartCandCoal(),cadvacia);
            }
            break;
          }
        }
      }
    }
    in.close();
  }
};//end class TestCasilla
