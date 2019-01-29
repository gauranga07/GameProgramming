
/**
 * Write a description of class Ball here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import java.util.*;
import java.applet.Applet;
import java.applet.AudioClip;

public class Ball extends Thread {

   private static final int XSIZE = 100;
   private static final int YSIZE = 100;

   private JPanel panel;
   private int x = 10;
   private int y = 10;
   private int dx = 5;
   private int dy = 5;
   int R,G,B;
   AudioClip clip;

   Graphics2D g2;
   private Color backgroundColor;

   public Ball(JPanel p) {
      panel = p;
      Graphics g = panel.getGraphics ();
      g2 = (Graphics2D) g;
      backgroundColor = panel.getBackground ();
      
      Dimension d = panel.getSize();
      Random r = new Random();
      x = r.nextInt(d.width-XSIZE);
      y = r.nextInt(d.height-YSIZE);
      clip = Applet.newAudioClip(getClass().getResource("bruh.au"));
      R = r.nextInt(233);
      G = r.nextInt(233);
      B = r.nextInt(233);
   }

   public void draw () {
      Color color = new Color(R,G,B);
      g2.setColor (color);
      g2.fill (new Ellipse2D.Double (x, y, XSIZE, YSIZE));
   }

   public void erase () {
      g2.setColor (backgroundColor);
      g2.fill (new Ellipse2D.Double (x, y, XSIZE, YSIZE));
   }

   public void move () {

      if (!panel.isVisible ()) return;

      x += dx;
      y += dy;

      Dimension d = panel.getSize();
        if(x+XSIZE == d.width || x+XSIZE > d.width  ){
            dx= dx*-1;
            clip.play();
        }
         if(y+YSIZE == d.height || y+YSIZE > d.height  ){
            dy= dy*-1;
            clip.play();
        }
        if(x == 0 || x < 0  ){
            dx= dx*-1;
            clip.play();
        }
         if(y == 0 || y < 0  ){
            dy= dy*-1;
            clip.play();
        }
       
        // d.width is the width of the panel
        // d.height is the height of the panel

      System.out.println (d.width);
      System.out.println (d.height);

   }

   public void run ()
   {  try
      {
        draw ();
         for (int i = 1; i <= 1000; i++) {
            erase();
            move ();
            draw();
            sleep (100);        // increase value to slow down ball
         }
      }
      catch(InterruptedException e) {}
   }

}
