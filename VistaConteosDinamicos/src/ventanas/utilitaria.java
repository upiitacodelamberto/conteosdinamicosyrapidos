package ventanas;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

public class utilitaria {
 /** Este metodo utilitaria.conca() se escribio inicialmente para hacer pruebas 
  * con arreglos de int. 
  * DOCUMENTAR Martes 2017.10.03
  * @param a
  * @param b
  * @return
  */
 public static String[][] conca(int a[],int b[]){
  int m=a.length,n;
  int c[][]=new int[a.length][2];
  for(int i=0;i<a.length;i++){
   c[i][0]=a[i];
   c[i][1]=contar(c[i][0],b);
  }
//  System.out.println("EN conca()");
//  print_array_bid(c);
  n=max_incol_1(c)+1;
  String r[][]=new String[m][n];
  for(int i=0;i<m;i++){
   r[i][0]=""+c[i][0];
   for(int j=1;j<n;j++){
    if(j<=c[i][1]){
     r[i][j]=""+c[i][0];
    }else{
     r[i][j]="";
    }
   }
  }
//  System.out.println("SALIENDO DE conca()");
  return r;
 }//end utilitaria.conca()
 /**
  * DOCUMENTAR Martes 2017.10.03
  * @param k
  * @param arr
  * @return
  */
 static int contar(int k,int arr[]){
  int count=0;
  for(int i=0;i<arr.length;i++){
   if(arr[i]==k)count++;
  }
  return count;
 }
 /**
  * DOCUMENTAR Martes 2017.10.03
  * @param arr
  * @return
  */
 static int max_incol_1(int arr[][]){
  int max=arr[0][1];
  for(int i=0;i<arr.length;i++){
   if(max<arr[i][1])
    max=arr[i][1];
  }
  return max;
 }
 /**
  * print_array(): imprime "horizontalmente" los elementos de un arreglo de int 
  * @param arr: un arreglo de int
  */
 static void print_array(int arr[]){
  for(int i=0;i<arr.length;i++){
   System.out.print(arr[i]+" ");
  }
  System.out.println();
 }
 /**
  * print_array(): imprime "horizontalmente" los elementos de un arreglo de float
  * @param arr: un arreglo de float
  */
 static void print_array(Float arr[]){
  for(int i=0;i<arr.length;i++){
   System.out.print(arr[i]+" ");
  }
  System.out.println();
 }
 /**
  * print_array(): imprime "horizontalmente" los elementos de un ArrayList de float
  * @param arr: un ArrayList de float 
  */
 static void print_array(ArrayList<Float> arr){
  for(int i=0;i<arr.size();i++){
   System.out.print(arr.get(i)+" ");
  }
  System.out.println();
 }
 /**
  * print_array_bid(): imprime "horizontalmente" los elementos de un 
  *                    arreglo bidimensional de int. 
  * @param arr: un arreglo bidimensional del int
  */
 static void print_array_bid(int arr[][]){
  for(int i=0;i<arr.length;i++){
   for(int j=0;j<arr[0].length;j++){
    System.out.print(arr[i][j]+" ");
   }
   System.out.println();
  }
  System.out.println();
 }
 /**
  * print_array_dstr_bid(): imprime "horizontalmente" los elementos de un 
  *                         arreglo bidimensional de String.
  * @param arr: arreglo bidimensional de String
  */
 static void print_array_dstr_bid(String arr[][]){
  for(int i=0;i<arr.length;i++){
   for(int j=0;j<arr[0].length;j++){
    System.out.print(arr[i][j]+" ");
   }
   System.out.println();
  }
 }
// public static void main(String arg[]){
//  int A[]={1,2,3,4,5,6,7,8,9,10};
//  int B[]={1,5,2,4,2,4,4};
//  System.out.print("A: ");
//  print_array(A);
//  System.out.print("B: ");
//  print_array(B);
//  System.out.println();
//  String C[][]=conca(A,B);
//  System.out.println("C.length="+C.length);
//  System.out.println("C[0].length="+C[0].length);
//  print_array_dstr_bid(C);
// }
 /**
  * CREAR UNA INTERFACE PARA LA IMPLEMENTACION DEL METODO 
  * public int reglaSturges(int n);
  * Y PODER ASI EVENTUALMENTE HACER QUE SEA FACIL CAMBIAR
  * LA IMPLEMENTACION DE ESTE METODO...........2017.08.15 
  */
 
 /**
  * reglaSturges
  * @param n es la cardinalidad del corte PREP
  * @return
  */
 public static int reglaSturges(int n){
  double d=1+3.33*Math.log10((double)n);
  return (int)Math.round(d);
 }
 /**
  * getLimSupInterv():MEJORAR esta documentacion Martes 2017.10.03
  * @param Adotlength es la cantidad de casillas registradas en PREP 
  * @param N es la cantidad de ``clases'' obtenida con reglaSturges
  * @return
  * 500/10=50: 1-50,51-100,101-150, ...,401-450,451-500
  * pero si 500/8=62
  */
 public static ArrayList<Float> getLimSupInterv(int Adotlength,int N){
  ArrayList<Float> r=new ArrayList<Float>();
  float m=((float)Adotlength)/((float)N);
//  System.out.println("Num. de clases N="+N);
//  System.out.println("MEDIDA DE INTERVALOS float m=((float)Adotlength)/((float)N)="+m);
  int i=1,index;float val;
  while((m*i)<=Adotlength){
   index=i-1;val=m*i;
//   System.out.println("INDICE i-1="+index+" valor a colocar="+val);
   r.add(m*i);
   i++;
  }
//  utilitaria.print_array(r);
  return r;
 }
 /**
  * ESTE ES EL METODO utilitaria.conca() QUE SE ESTA UTILIZANDO!!! //2017.10.10
  * conca(): DOCUMENTAR 2017.10.03
  * @param a: limites superiores de los intervalos de clase
  * @param b: identificadores de las casillas que se utilizaran para hacer la prueba 
  *           de bondad de ajuste.
  * @return
  */
 public static String[][] conca(Float a[],int b[]){
  String r[][]=new String[a.length][2];
  float liminf=0,limsup;
  int frec[]=new int[a.length],count=0;
  for(int i=0;i<a.length;i++){
   limsup=a[i];
   for(int j=0;j<b.length;j++){
    if((b[j]>=liminf)&&(b[j]<=limsup)){
     count++; /*se estan obteniendo las frecuencias observadas*/
       /** //2017.10.10.19.57 Para hacer lo que se menciona en el 
        * comentario 2017.10.10.19.56:
        * COMO AQUI SE ESTA IDENTIFICANDO LAS CASILLAS QUE ESTAN 
        * EN LOS INTERVALOS DE CLASE CUYOS LIMITES SUPERIORES ESTAN 
        * EN Float a[], SE PUEDE UTILIZAR ESTA INFORMACION PARA 
        * AGREGAR IDENTIFICADORES DE CASILLA A LOS a.length OBJETOS 
        * DE CLASE MyBin QUE VOY A PASAR COMO ARGUMENTO EN UNA 
        * VERSION SOBRECARGADA DE ESTE METODO QUE VOY A ESCRIBIR. 
        * */
    }
   }
   frec[i]=count;count=0;
   liminf=a[i];
  }
  
  int sum=0;
  for(int i=0;i<frec.length;i++){
   sum+=frec[i];
  }
  System.out.println("utilitaria.conca(Float[],int[]):Suma de "
    + "frecs relativas observadas="+sum);
  
  liminf=0;
  for(int i=0;i<a.length;i++){
   limsup=a[i];
   r[i][0]=new String(liminf+"--"+a[i]);
   r[i][1]=new String(""+frec[i]);
   liminf=a[i];
  }
  return r;
 }//end utilitaria.conca()
 
 /**
  * pre: a.length==Bin.length debe ser true
  * Para reutilizar (somehow) el codigo del metodo utilitaria.conca(),
  * sobrecargo ese metodo una segunda vez. VEASE COMENTARIO 2017.10.10.19.56 en el 
  * archivo MostrandoSTATUSDELEC.java en este mismo package.
  * @param a: arreglo que contiene los limites superiores de los intervalos
  *           de clase.
  * @para b: arreglo que contiene los enteros con los que se realizara la prueba 
  *          de bondad de ajuste. REVISAR SI CONTIENE LOS IDENTIFICADORES DE CASILLAS QUE "QUEDAN" DEL PREP
  *          (VEASE COMENTARIO MostrandoSTATUSDELEC.java::2017.11.07.16.26)
  */
 public static String[][] conca(Float a[],int b[],MyBin Bin[]){
  String r[][]=new String[a.length][2];
  float liminf=0,limsup;
  int frec[]=new int[a.length],count=0;
//  System.out.println("utilitaria.conca(Float a[],int b[],MyBin Bin[])");
  for(int i=0;i<a.length;i++){
   limsup=a[i];
   for(int j=0;j<b.length;j++){
    if((b[j]>=liminf)&&(b[j]<=limsup)){
     count++; /*se estan obteniendo las frecuencias observadas*/
        /** //2017.10.10 
         * COMO AQUI SE ESTA IDENTIFICANDO LAS CASILLAS QUE ESTAN 
         * EN LOS INTERVALOS DE CLASE CUYOS LIMITES SUPERIORES ESTAN 
         * EN Float a[], SE PUEDE UTILIZAR ESTA INFORMACION PARA 
         * AGREGAR IDENTIFICADORES DE CASILLA A LOS a.length OBJETOS 
         * DE CLASE MyBin QUE VOY A PASAR COMO ARGUMENTO EN UNA 
         * VERSION SOBRECARGADA DE ESTE METODO QUE VOY A ESCRIBIR. 
         * */
     Bin[i].VectorDInt.add(b[j]);//guardar identificador de casilla en el
            // bin correspondiente.
    }
   }
//   System.out.println(Bin[i].VectorDInt.size());/*Frecuencia Observada*/
   frec[i]=count;count=0;
   liminf=a[i];
  }
  
  int sum=0;
  for(int i=0;i<frec.length;i++){
   sum+=frec[i];
  }
//  System.out.println("utilitaria.conca(Float[],int[]):Suma de "
//    + "frecs relativas observadas="+sum);
  
  liminf=0;
  for(int i=0;i<a.length;i++){
   limsup=a[i];
   r[i][0]=new String(liminf+"--"+a[i]);
   r[i][1]=new String(""+frec[i]);
   liminf=a[i];
  }
  return r;
 }//end utilitaria.conca(Float a[],int b[],MyBin Bin[])
 
 public static int totalDCasillasNBins(MyBin MBin[]) {
  int sum=0;
  for(int i=0;i<MBin.length;i++) {
   sum+=MBin[i].VectorDInt.size();
  }
  return sum;
 }
 
 public static void showIds(MyBin MBin[]) {
  int sum=0;
  System.out.println("\nTenemos MBin.length="+MBin.length+" Bins, las casillas de estos son:");
  for(int i=0;i<MBin.length;i++) {
   sum+=MBin[i].VectorDInt.size();
   System.out.println("\nMBin["+i+"].VectorDInt.size()="+
        MBin[i].VectorDInt.size()+" Casillas acumuladas="+sum);
   for(int j=0;j<MBin[i].VectorDInt.size();j++){
    System.out.print(MBin[i].VectorDInt.get(j)+" ");
    if(((j+1)%10)==0){
     System.out.println();
    }
   }
  }
 }//end showIds()
 /**
  * muestra los primeros intNDItems elementos de la casilla cuyo identificador es k 
  * @param ALdC ArrayList de Casillas 
  * @param k: la casilla a mostrar 
  * @param intNDItems: la cantidad de items a mostrar, debe ser menor o igual que 
  * ALdC.CASILLA.get(i).datosDCasilla.length
  */
 public static void mostrar_casilla_yresult(ArrayList<Casilla> ALdC,int intNDCas,int intInicio,int intNDItems) {
  System.out.println("INICIO: "+intInicio);
  for(int i=intInicio;i<intInicio+intNDItems;i++) {
//   System.out.print("token["+i+"]"+ALdC.get(intNDCas).datosDCasilla[i]+" ");
   System.out.print("token["+i+"]"+ALdC.get(0).datosDCasilla[i].StringLineaDCasItem+" ");/*2017.11.28.18.14*/
  }
  System.out.println();
  for(int i=intInicio;i<intInicio+intNDItems;i++) {
//   System.out.print(ALdC.get(intNDCas).datosDCasilla[i]+" ");
   System.out.print(ALdC.get(intNDCas).datosDCasilla[i].StringLineaDCasItem+" ");
  }
  System.out.println();
 }
 /**
  * Muestra una linea
  * @param linea: la linea a mostrar
  * @param intNumDL: el Numero de Linea/Identificador de casilla a mostrar
  * intItemDInicio + intNDItems DEBE SER MENOR O IGUAL a linea.toCharArray().length
  */
 public static void show_line(String linea,int intNumDL,int intItemDInicio,int intNDItems) {
  StringTokenizer ST=new StringTokenizer(linea, ",");
  System.out.println("Num. de LINEA/Num. de Casilla/Id de casilla="+intNumDL
    +" ST.countTokens()="+ST.countTokens()+"\n"+"IndexInicio: "+intItemDInicio+
    " NumDItems: "+intNDItems);
//  System.out.println(linea);
  char cA[]=linea.toCharArray(),cA1[];
  int k=0,sumDCommas=0,sumDCommas1=0,cantDChars=0,index=0;
  while(sumDCommas<intItemDInicio) {
   if(cA[k]==',') {
    sumDCommas++;
    if(sumDCommas==intItemDInicio) {
     break;
    }
   }
   k++;
   if(k==cA.length) {
    break;
   }
  }/*==============while()*/
  if(cA.length-k>0) {
   //Ahora procedo a contar los caracteres hasta juntar intNDItems comas
   k++;
   do {
    if(cA[k+index]==',') {
     sumDCommas1++;
    }
    cantDChars++;
    index++;
   }while((sumDCommas1<intNDItems)&&(k+index<cA.length));
   cA1=new char[cantDChars];
   for(int intInd=0;intInd<cA1.length;intInd++) {
    cA1[intInd]=cA[k+intInd];
   }   
  }else {
   String StringPError="ALGO SALIO MAL";
   cA1=StringPError.toCharArray();
  }
  String StringToBePrinted=new String(cA1);
  System.out.println(StringToBePrinted);
 }//end show_line()
 public static int[] get_intArray(String line) {
  int i,r[],tamDr,cantDDComma=0;  /*tamanio del int r[], Cantidad De Dobles Commas*/
  char charArr[]=line.toCharArray();
  for(i=0;i<line.length()-1;i++) {
   if((charArr[i]==',')&&(charArr[i+1]==',')){
    cantDDComma++;
   }
  }
  if(cantDDComma>0) {/*si hay al menos un par de comas juntas*/
   r=new int[cantDDComma];r[0]=1;
  }else {/*si no hay dos comas juntas*/
   r=new int[1];
   r[0]=-1;
   return r;
  }
  /*ahora hay que colocar en el arreglo r las posiciones en charArr 
   * donde estan la primera de cada par de comas*/
  return r;
 }
 
 public static int 
// contar_votos(int intIndexPartido,char lineaH[128],
// char linea[],struct part *partPt)
 contar_votos(int intNumDCoalicion,int intIndexPartido,char lineaH[],
 char linea[],Coalicion partPt)
 {
      int i=0,cantDComas=0, intQ=0,j;
//      char *charVotos,*charNomDPart;
      char charVotos[],charNomDPart[];
      charVotos=charNomDPart=new char[1];
      do{
        if(linea[i]==','){
          cantDComas++;
        }
        if(cantDComas==intIndexPartido){
          break;
        }
        i++;
//      }while(i<128);
      }while(i<linea.length);
      if((intIndexPartido<=cantDComas+1) && (intIndexPartido>=0))
  {
//      printf("cantDComas=%d\n, i=%d, %s\n",cantDComas,i, linea);
      if (cantDComas==0){
//       while(linea[i+intQ]!=','&&(i+intQ)<128){
       while(linea[i+intQ]!=','&&(i+intQ)<linea.length){
        intQ++;
    }
//   charVotos=malloc(intQ*sizeof(char)+1);
   charVotos=new char[intQ+1];
   for(j=0;j<intQ;j++){
    charVotos[j]=linea[i+j];
   }
   if(intQ>0) {/*2017.12.05.18.13*/
    charVotos[intQ]='\0';
   }else {
    charVotos[intQ]='0';
   }
//   partPt->intVotos=atoi(charVotos);
//   System.out.println("LLEGAMOS AQUI!!! 2017.12.05.16.05");
   partPt.PARTIDO.get(intNumDCoalicion).intVotos=
//     Integer.parseInt(new String(charVotos));
     Integer.parseInt(new String(purify(charVotos)));
//   printf("Partido %s %s %d",charVotos,partPt->intVotos);
   }
      else {
//       while(linea[i+intQ+1]!=','&&(i+intQ)<128){
      while(linea[i+intQ+1]!=','&&(i+intQ)<linea.length){        
        intQ++;
         }
//    printf("\nintQ=%d\n",intQ);
//   charVotos=malloc(intQ*sizeof(char)+1);
      charVotos=new char[intQ+1];/*2017.12.07.16.57*/
   i++;
   for(j=0;j<intQ;j++){
    charVotos[j]=linea[(i)+j];
   }
//   charVotos[intQ]=0;
   if(intQ>0) {/*2017.12.05.18.19*/
//    System.out.println("DE AQUI");//2017.
    charVotos[intQ]='\0';
   }else {/*2017.12.07.16.50 Qu\'e puede ocasionar que intQ sea 0?, 
    * cu\'ando aqu\'i intQ es igual a 0?*/
    System.out.println("A ALLA");
    charVotos[intQ]='0';
   }
//   partPt->intVotos=atoi(charVotos);
   partPt.PARTIDO.get(intNumDCoalicion).intVotos=
     Integer.parseInt(new String(purify(charVotos)));
           i=intQ=cantDComas=0;
           do{
             if(lineaH[i]==','){
               cantDComas++;
             }
             if(cantDComas==intIndexPartido){
               break;
             }
             i++;
//           }while(i<128);
           }while(i<lineaH.length);
           if (cantDComas==0){
//           while(lineaH[i+intQ]!=','&&(i+intQ)<128){
          while(lineaH[i+intQ]!=','&&(i+intQ)<lineaH.length){
        intQ++;
      }
//             charNomDPart=malloc(intQ*sizeof(char)+1);
             charNomDPart=new char[intQ+1];
           for(j=0;j<intQ;j++){
         charNomDPart[j]=lineaH[i+j];
      }
      charNomDPart[intQ]=0;
//      System.out.println("LLEGAMOS ACA!!! 2017.12.05.16.55");
   /*partPt->intVotos=atoi(charVotos);*/
           }else{
//            while(lineaH[i+intQ+1]!=','&&(i+intQ)<128){
           while(lineaH[i+intQ+1]!=','&&(i+intQ)<lineaH.length){
             intQ++;
              }
        // printf("\nintQ=%d\n",intQ);
//              charNomDPart=malloc(intQ*sizeof(char)+1);
              charNomDPart=new char[intQ+1];
              i++;
              for(j=0;j<intQ;j++){
                charNomDPart[j]=lineaH[(i)+j];
              }
              charNomDPart[intQ]=0;
//              System.out.println("LLEGAMOS ACUYA!!! 2017.12.05.17.02\tintQ="+intQ);
           }
           
      }/*-----------end  else{}*/
//   printf("\nPartido |%s|  |%s| |%d|\n",charNomDPart,charVotos,partPt->intVotos);
      String str1=new String(charNomDPart),str2=new String(charVotos);
//   System.out.printf("\nPartido |"+str1+"|  |"+str2+"| |%d|\n",
//     partPt.PARTIDO.get(intNumDCoalicion).intVotos);
   return 0;
  }else{
   return -1;
  }
 }//end contar_votos()
 private static char[] purify(char charVotos[]) {
  char r[];
  int i=0;
  while(is_digit(charVotos[i])) {
   i++;
  }
//  r=new char[i];//2017.12.14, con esto espero que ya mas nuca se vuelva a 
  r=new char[i+1];r[0]='0';//presentar la excepcion java.lang.NumberFormatException 
//  for(int in=0;in<i;in++) {//en la linea (ahorita 455) 
// =Integer.parseInt(new String(purify(charVotos)));
//  for(int in=1;in<i+1;in++) {
  for(int in=1;in<r.length;in++) {
//   r[in]=charVotos[in];
	  r[in]=charVotos[in-1];
  }
  return r;
 }
 private static boolean is_digit(char c) {
  if(((c>='1')&&(c<='9'))||(c=='0')) {
   return true;
  }else {
   return false;
  }
 }
 public static void showCuentaDVotos(MyBin MBin[],int intIndexPartido) {
  int sum=0;
//  System.out.println("\nTenemos MBin.length="+MBin.length+" Bins, las casillas de estos son:");
  ArrayList<Partido> ALdP=new ArrayList<Partido>();/*2017.12.05.17.34*/
  ALdP.add(new Partido("pan"));
  Coalicion CoalicionFictitus=new Coalicion("FICTITUS Coallition", ALdP);
  for(int i=0;i<MBin.length;i++) {
//   sum+=MBin[i].VectorDInt.size();
//   System.out.println("\nMBin["+i+"].VectorDInt.size()="+
//        MBin[i].VectorDInt.size()+" Casillas acumuladas="+sum);
   for(int j=0;j<MBin[i].VectorDInt.size();j++){
//    System.out.print(MBin[i].VectorDInt.get(j)+" ");
//    if(((j+1)%10)==0){
//     System.out.println();
//    }
    contar_votos(0,intIndexPartido, ContD.CASILLA.get(0).CasillaLine.toCharArray(),
      ContD.CASILLA.get(MBin[i].VectorDInt.get(j)).CasillaLine.toCharArray(),
      CoalicionFictitus);
    sum+=ALdP.get(0).intVotos; 
   }
  }
  System.out.println("============>sum="+sum);
 }//end showCuentaDVotos()
 /**
  * main(): Driver de prueba para algunos de los metodos de esta clase utilitaria.
  * @param arr
  */
 public static void main(String arr[]){
  int totdcas=30,regSturgRes=20;
  ArrayList<Float> inters=utilitaria.getLimSupInterv(totdcas, regSturgRes);
  System.out.println("inters.size()="+inters.size());
  System.out.println("inters.get(0)="+inters.get(0));
  utilitaria.print_array(inters);
 }
}//end class utilitaria
