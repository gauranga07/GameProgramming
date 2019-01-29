
/**
 * Write a description of class BounceFrame here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.awt.event.*;
import javax.swing.*;

public class BounceFrame extends JFrame
			 implements ActionListener {  

   private JPanel ballPanel;

   public BounceFrame () {  
      setSize (500, 400);
      setTitle ("Bouncing Ball");

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

/*    This code does same thing as setDefaultCloseOperation () above.

      addWindowListener(new WindowAdapter ()
         {  public void windowClosing(WindowEvent e) {  
               System.exit (0);
            }
         } );

*/
      ballPanel = new JPanel ();
      add (ballPanel, "Center");
      
      JPanel buttonPanel = new JPanel ();
      
      JButton startB = new JButton ("Start");
      startB.addActionListener (this);
      buttonPanel.add (startB);

      JButton closeB = new JButton ("Close");
      closeB.addActionListener (this);
      buttonPanel.add (closeB);

      add (buttonPanel, "South");

   }

   public void actionPerformed (ActionEvent e) {
      String command = e.getActionCommand ();

      if (command.equals ("Start")) {
         Ball b = new Ball (ballPanel);
         b.start ();
      }
      else
      if (command.equals ("Close")) {
         ballPanel.setVisible (false);
         System.exit (0);
      }
   }

}
