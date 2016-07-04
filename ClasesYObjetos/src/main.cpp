/**
 * main.cpp - El programa principal de la aplicacion.
 * Ahora solo lee los datos del archivo ``adaptado''
 * 1 Resultados_secciones.csv y despliega lo que 
 * ``encuentra'' dentro de este archivo ``adaptado''.
 */
#include <stdio.h>
#include <iostream>
//#include <istream>
#include <fstream>
#include <vector>
#include <cmath>       /*log10()*/
#include <stdlib.h>    /*malloc()*/
#include "modelo.h"
#include "String_Tokenizer.h"

using namespace std;

string archivo="1 Resultados_secciones.csv";           /*un archivo ``adaptado''*/
string source_file;
bin *binPt;

void load_data_CAS(string& source_name);
void add(vector<string>& A);
int regla_sturges(int);      /* Regla de Sturges */
int tamanio_dbin(int Total,int c);
int numdcasillas_para_elbinnum(int binnum,int tamdbin,int totaldcsllas);
void inic_clbin(bin *b,int candcas,int inicio);    /* inicializar clase/bin */
int contar_votosnbin(bin *);/*cuenta los votos en las casillas del bin*/

int
main(int argc, char *argv[])
{
  printf("Conteos din\'amicos\n");
  printf("Leyendo datos del archivo %s\n", &archivo[0]);
  //inic_bins();
  /*Se cargan como objetos <nombredeunaclase> los datos del archivo ``adaptado'' 1 Resultados_secciones.csv*/
  load_data_CAS(archivo);       
  //proccess_commands();
  for(int i=0;i<CAS.size();i++){
    if(i<9)
      cout<<"Casilla  "<<i+1<<" ";
    else
      cout<<"Casilla "<<i+1<<" ";
    cout<<*CAS[i]<<"\n";
  }
  int x=regla_sturges(CAS.size());
  /*es necesario escribir una funcion que dado el total de casillas N (en este caso 39) 
    y dado el numero de clases c (obtenido con la regla de Sturges, en este caso 6) nos 
    indique cuantas casillas deben tener los primeros c-1 (o c) bins (en este caso 7 casillas). 
    Ya que para N=39, c=regla_sturges(N)=6.28\approx 6 y tenemos que nos salen 5 bins de 7 
    casillasy 1 bin de 4 casillas. La funci\'on propuesta es tamanio_dbin(int,int)
  */
  cout<<"\n";
  int tamdbin=tamanio_dbin(CAS.size(),x);
  printf("Se \"repartir\'an\" las %d casillas en clases o bins que \
contendr\'an %d casillas\n",CAS.size(),tamdbin);
  printf("%d bins de %d casillas \"consecutivas\" y 1 bin de \
%d casillas\n",CAS.size()/tamdbin,tamdbin,CAS.size()-tamdbin*(CAS.size()/tamdbin));
  binPt=(bin*)malloc(x*sizeof(bin));
  /*Ahora se inicializan los bins*/
  for(int i=0;i<x;i++)
    inic_clbin(binPt+i,numdcasillas_para_elbinnum(i+1,tamdbin,CAS.size()),tamdbin*i+1);

  cout<<"\n";
  /*se muestran las casillas contenidas en los bins considerados al momento*/
  cout<<"Los bins considerados inicalmente:\n";
  for(int i=0;i<x;i++){
    cout<<"Clase/bin No. "<<i+1<<" ";
    cout<<*(binPt+i)<<"\n";          /*Aqui se usa la sobrecarga del operador <<*/
                                     /*para las struct bin*/
  }                                 

  cout<<"\n";
  /*se muestran los votos en las casillas de los bins*/
  cout<<"Los votos en los bins:\n";
  for(int i=0;i<x;i++){
    cout<<"Clase/bin No. "<<i+1<<" votos: ";
    cout<<contar_votosnbin(binPt+i)<<"\n";
  }

  return 0;
}//end main()

void
load_data_CAS(string& source_name)
{
  source_file=source_name; //recordar nombre de archivo de datos.
  //un vector de string en el que se colocaran tokens de las lineas 
  //del archivo ``adaptado'' cuyo nombre se guardo en el string source_file.
  vector<string> arr;
  ifstream in(source_name.c_str());
  if(in){//el ifstream (flujo de entrada desde archivo) existe
    string linea;
    while(getline(in, linea)){
      String_Tokenizer tokenizer(linea, ",");
      while(tokenizer.has_more_tokens()){
        arr.push_back(tokenizer.next_token());
      }
      //ahora tenemos todos los tokens de una linea de archivo ``adaptado''
      //en el vector de string arr. Se agrega un apuntador a Casilla 
      //al vector CAS (declarado en modelo.h como extern)
      add(arr);
      //Imprimir la cantidad de tokens encontrados en la linea  
      //cout<<linea<<"\n";
      //cout<<"Num. de linea:"<<CAS.size()<<" Tokens:"<<arr.size()<<"\n";
      arr.clear();  /*se limpia el vector arr para empezar con los tokens 
                      de la siguiente linea*/
    }//end while()

    in.close();  //cerrar el archivo
  }else{
    printf("load_data_CAS(string& source_name):No se pudo crear un flujo \
de entrada desde archivo %s\nALGO MUY GRAVE SUCEDIO!!",&source_file[0]);
  }//end if - else
}//end load_data_CAS()
    

void
add(vector<string>& A)
{
  CAS.push_back(new Casilla(A));//CAS es un vector<Casilla*>, declarado en 
                                //modelo.h como extern y recibe tipo de 
                                //almacenamiento en modelo.cpp
}    

int
regla_sturges(int n)
{
  return floor(1+3.322*log10(n));
}

int
contar_votosnbin(bin *b)
{
  int suma=0;
  for(int i=0;i<b->N;i++)
    suma+=CAS[*(b->p+i)-1]->get_cdvotos();
  return suma;
}

