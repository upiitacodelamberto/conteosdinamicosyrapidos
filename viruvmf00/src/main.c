/*
  La funcion main de la aplicacion de conteos dinamicos
  y rapidos.
*/

int main(int nargs, char* args[]){
  const int MAX=Votos::MAX;
  const int MAXCON=30;

  if(nargs<2){// archivos de datos
    cerr << "forma de uso:\n\t" << args[0] << "arch1.txt arch2.txt ... archN.txt\n";
    return EXIT_FAILURE;
  }

  srand(time(NULL));       // semilla de numeros aleatorios
  time_t Time;             // computo de la hora del conteo
  time(&Time);


  ifstream f(BaseNom);     // base de datos de la casilla
  if(f==NULL){
    cerr << "Error al leer las casillas: " << BaseNom << endl;
    return EXIT_FAILURE;
  }


  set<int> caspar[NUMENT]; // casillas participantes en el conteo
  int         cnt[NUMENT]; // numero de casilllas por entidad 
  map<string,int> idx[NUMENT];// mapeo nombre de casilla->codigo (un int? 2015.05.28)
  vector<Votos>   inv[NUMENT];// votos de cada casilla.

  int coal[NUMENT];        // candidato comun por cada entidad.
  LeerCoal(coal, NUMENT, candidado_comun);  //lectura del archivo de Candidato_comunes

  while(!f.eof()){// lectura de la base de datos de las casillas (proporcionada por
    string linea; // el instituto electoral)
    f >> linea;
     if(linea.size()>0){
       Base B(linea);
       int ent=B.Entidad();
       idx[ent].insert(make_pair(linea, cnt[ent]++));
       inv[ent].push_back(Votos()); // numero de votos= 0
     }
  }
  f.close();


  for(int d=0; d<NUMENT; ++d)    // inicio de los codificadores de las casillas
    cnt[d]=0;


  for(int fi=1; fi<nargs; fi++){ // lectura de votos ...
    ifstream prep;
    prep.open(args[fi]);
    if(!prep)
      cerr << "no fue posible abrir el archivo " << args[fi] << endl;
    else{
      cerr << "Leyendo archivo: \n\t" << args[fi] << endl;
      while(!prep.eof()){
        string linea;
        prep >> linea;
        if(linea.size()>0){
          Voto V(linea);
          string nom=V.Casilla();
          int entidad=V.Entidad();
          if(idx[entidad].find(nom)==idx[entidad].end()){
            cerr << "ERROR: casilla sin registro: " << nom << endl;
            //exit(1);
          }else{// los votos no se suman, solo se leen...
            int id=idx[entidad][nom];
            caspar[entidad].insert(id);
            inv[entidad][id][V.Partido()]=V.Votos();
          } 
        }
      }
      prep.close();
    }
  }


  // Empiezan los conteos dinamicos...


  ofstream out(Nombre(pref, &Time).c_str());


  for(int ent=0; ent<NUMENT; ++ent)// se hace conteo por cada entidad...
    if(!caspar[ent].empy()){
      double emin;
      vector<int> Par;
      int tamprep=caspar[ent].size();

      cerr << "Entidad=" << ent << " card: " << cnt[ent] << endl;

      Par.clear();
      for(set<int>::iterator k=caspar[ent].begin(); k!=caspar[ent].end(); ++k)
         Par.push_back(*k);


      Votos sum[MAXCON];
      double pords[MAXCON]MAX[];
      int caspart[MAXCON];
      int sumvot[MAXCON];
      int n=0;     // numero conteos que pudieron realizarse


      for(int conteo=0; conteo<MAXCON; ++conteo){
        int casins=cnt[ent];    // numero de casillas instaladas.
        int casviv=Par.size();  // numero de casillas "vivas"
        int numclases=Log2(casviv);// tamano de la particion.


        double paso=double(casins)/double(numclases);// ancho de la clase
        Particion P(numclases, paso, Par);   // particion inicial.
        double Xi, h;


        bool Pmal=true;
        while(Pmal){
          if(numclases<=4){// no aceptamos particiones 4 clases o menos.
            cerr << "ERROR: Muy pocas clases; ent= " << ent << endl;
            break;
          }
          if(P.TieneVacias()){// tampoco particiones con clases vacias...
            cerr << "AVISO: Hay clases vacias, intentaremos con "
                 << --numclases << " clases; ent=" << ent << endl;


/*
      // si requerimos un analisis
      // detallado de la particion,
      // usamos este segmento de codigo...
      cerr << "Entidad: " << ent
           << "Participan, " << P.size()
           << " de " << tamprep << ", " << P.size()/double(tamprep)
           << endl;
*/
          }
        }
      }
    }
}// End of main()
