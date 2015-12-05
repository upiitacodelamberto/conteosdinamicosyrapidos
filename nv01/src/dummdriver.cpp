#include <iostream>
#include <fstream>
#include <vector>
#include "modelo.h"
#include "String_Tokenizer.h"
string archivo="1 Resultados_secciones.csv";

using namespace std;

int main(){
    CasiCasilla CCasill;
            CCasill.distrito="dist";CCasill.seccion="sec";CCasill.casilla="cas";
            CCasill.delegacion="del";CCasill.tipo="ti";CCasill.PartCandCoal="PCC";
    Casilla *ap;
    string cadvacia="";
    vector<string> arr;
    arr.push_back("");arr.push_back("");arr.push_back("");
    arr.push_back("");arr.push_back("");arr.push_back("");
    ifstream in(archivo.c_str()); 
    if(in){//el stream existe
      string linea;
      int line_num=0, tokcount=0;
      while(getline(in, linea)){
        line_num++;
cout << "line_num="<<line_num<<"\n";
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
cout << "line_num="<<line_num<<"\n";
cout<<"ap->get_PartCandCoal()="<<ap->get_PartCandCoal()<<"  "<<"cadvacia="<<cadvacia<<"\n";
            }
          }
        }
      }
    }
    in.close();
  return 0;
}//end main()
