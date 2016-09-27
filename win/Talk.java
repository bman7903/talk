import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Color;
import javax.swing.text.*;

class Talk extends JFrame implements KeyListener
{
  JPanel pnl = new JPanel();
  JTextField field = new JTextField( 35 );
  JTextField sndto = new JTextField( 35 );
  JTextArea txtArea = new JTextArea( 20, 27 );
  String susr   = "roger";
  String domain = "legit-server.appspotmail.com";
  String sUsr  = susr + "@" + domain;
  JFrame frame = new JFrame ("Test");
  JScrollPane scroll = new JScrollPane (txtArea);

  public Talk()
  {
     super("Swing Window");
     field.addKeyListener( this );
     field.setForeground(Color.red);
     field.setBackground(Color.green);
     setSize( 480, 560 );
     pnl.setBackground(Color.red);
     setDefaultCloseOperation( EXIT_ON_CLOSE );
     frame.setSize(300,300);
     frame.setResizable(false);
     scroll.setSize(300,300);

     txtArea.setFont(new Font("Serif", Font.BOLD, 16 ));
     txtArea.setForeground(Color.magenta);
     txtArea.setBackground(Color.yellow);
     txtArea.setSize( 385, 385 );    
     txtArea.setLineWrap( true );
     txtArea.setEditable( false );
     sndto.setSize( 300, 300 );
     sndto.setForeground(Color.red);
     sndto.setBackground(Color.green);
     scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
          scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
     frame.add(scroll);
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     pnl.add( field );
     pnl.add( scroll );
     pnl.add( sndto );
     sndto.setText( "     " + sUsr); 
     add( pnl );
     setVisible( true );
  }

  public void keyPressed( KeyEvent event )
  {
     return;
  }

  public void keyTyped( KeyEvent event )
  {
     return;
  }

  public void keyReleased( KeyEvent event )
  {
     int keyCode = event.getKeyCode();
     String K = event.getKeyText( keyCode );
     String E = "Enter";
     String T = "\nYOU:  " + field.getText() + "\n";

     if ( K == E )
     {
        System.out.println("Enter Pressed!");
        txtArea.append( T );
        txtArea.setLineWrap(true);
        txtArea.setWrapStyleWord(true);
        field.setText("");
     }
  }

  public static void main ( String[] args )
  {
    Talk gui = new Talk();
  }

}
