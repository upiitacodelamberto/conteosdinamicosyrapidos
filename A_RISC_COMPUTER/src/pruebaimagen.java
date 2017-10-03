/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author MIGUEL
 */
import java.applet.Applet;
import java.awt.*;

public class pruebaimagen extends Applet {
   Image img;

   public void init(){
       img=getImage(getDocumentBase(),"arc3.gif");

   }

   public void paint(Graphics g){
       g.drawImage(img, 0, 0, this);
   }
}
