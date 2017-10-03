/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MIGUEL
 */
public class prueba {
public static void main(String [] arg){
       Rectangulo uno;
       
       uno=new Rectangulo(5); //asig espacio de memoria
       //uno.coseno('A'); //llamada a coseno con herencia
       uno.dibuja();  //llamada al metodo

   }

}

class grafica{
    protected char [][] dibujo;
    private int ancho;
    private int largo;
    //constructor
    grafica(){
        ancho=80;
        largo=21;
        dibujo=new char [largo][ancho];
        for (int i=0;i<largo;i++){
            for (int j=0;j<ancho;j++){
               dibujo[i][j]= ' ';
            }
        }
    }

    //metodo para graficar
    public void dibuja(){
        for (int i=0;i<largo;i++){
            for (int j=0;j<ancho;j++){
               System.out.print(dibujo[i][j]);
            }
            System.out.println();
        }
    }

 

}

class Rectangulo extends grafica{  //herencia en java equivale a : en c
    private int base,altura;
    Rectangulo(int a){//constructor
        super();//llamada a la clase base
        base=20;
        altura=a;
        crearrect('R');
    }

    private void crearrect(char c){
        int i, j;
        for(i=0;i<altura;i++){
            for(j=0;j<base;j++){
                dibujo[i][j]=c;
            }
        }
    }
}
