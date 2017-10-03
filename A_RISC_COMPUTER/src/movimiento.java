/*DIPLOMADO EN POO
PROGRAMACION EN JAVA
 * MIGUEL ANGEL RODRIGUEZ FUENTES
 PROGRAMA 1
 * MOVIMIENTO UNIFORMEMENTE ACELERADO EN 2D
 * *
 */

public class movimiento {

     public static void main(String[] arg) {
        double inix, iniy, inivx, inivy, aclx, acly, dtim, ttotal;
        inix = 0.;
        inivx = 10.;
        iniy = 0.;
        aclx = 0.;
        dtim = 0.2;
        ttotal = 4;
        inivy = 10.;
        acly = -9.8;

        Um1D dos;
        dos=new Um1D(inix, dtim, inivx, ttotal);
        dos.imprime();

        Um2D tres;
        tres=new Um2D(inix, dtim, inivx, ttotal, iniy, inivy);
        tres.imprime();

        Accm2D uno;
      
        uno = new Accm2D(inix, dtim, inivx, ttotal, iniy, inivy, aclx, acly);
        
        uno.imprime();
    }
   

    static class Um1D {

        protected double delt;
        protected int pasos;
        private double x00, vx, time;

        Um1D(double x0, double dt, double vx0, double tott) {   //constructor
            x00 = 0;
            delt = dt;
            vx = vx0;
            time = tott;
            pasos = (int) (tott / delt);
        }

        protected double x(double tt) {
            return (x00 + tt * vx);
        }

        public void imprime() {
            int i;
            double xx, tt;
            tt = 0;
            System.out.println("Calculo X = Xo + t*v");
            System.out.println("Tiempo   DesplazamientoX");
            for (i = 1; i <= pasos; i += 1) {
                xx = x(tt);
                System.out.println(" " + tt + " " + xx + " ");
                tt = tt + delt;
            }
        }
    }

  static  class Um2D extends Um1D {
        private double y00, vy;
        Um2D(double x0, double dt, double vx0, double tott, double y0, double vy0) {
            super(x0, dt, vx0, tott);
            y00 = y0;
            vy = vy0;
        }

        protected double y(double tt){
            return(y00+tt*vy);
        }

         public void imprime() {
            int i;
            double xx, yy, tt;
            tt = 0;
            System.out.println("Desplazamientoy   Desplazamientox");
            for (i = 1; i <= pasos; i += 1) {
                xx = x(tt);
                yy=y(tt);
                System.out.println(" " + yy + " " + xx + " ");
                tt = tt + delt;
           }
        }
    }

public static class Accm2D extends Um2D{
        private double ax,ay;
        Accm2D(double x0,double dt,double vx0,double tott,double y0,double vy0, double accx, double accy){
            super(x0,dt,vx0,tott,y0,vy0);
            ax=accx;
            ay=accy;
        }

        protected double xy(double tt, int i){
            double dt2,xxac,yyac;
            dt2=0.5*tt*tt;
            xxac=x(tt)+ax*dt2;
            yyac=y(tt)+ay*dt2;
            if(i==1) return xxac; else return yyac;
        }

        public void imprime(){
            int i;
            double tt, xxac, yyac;
            tt = 0;
            System.out.println("AceleracionX   AceleracionY");
            for (i = 1; i <= pasos; i += 1) {
                xxac = xy(tt,1);
                yyac =xy(tt,2);
                System.out.println(" " + xxac + " " + yyac + " ");
                tt = tt + delt;
            }
        }

    }



}




