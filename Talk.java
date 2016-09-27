import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Color;
import javax.swing.text.*;

class Talk extends JFrame implements KeyListener
{
  JPanel pnl = new JPanel();
  JTextArea field   = new JTextArea( 5, 35 );
  JTextField sndto   = new JTextField( 35 );
  JTextArea txtArea  = new JTextArea( 17, 23 );
  String server      = "legit-server";
  String susr        = "roger";
  String fusr        = "stewert";
  String nt          = "com";
  String domain      = "appspotmail";
  String femail      = fusr + "@" + server + "." + domain + "." + nt;
  String sUsr        = susr + "@" + server + "." + domain + "." + nt;
  JFrame frame       = new JFrame ("Test");
  JScrollPane scroll = new JScrollPane (txtArea);

  public Talk()
  {
     super( "Messanger" );
     field.addKeyListener( this );
     field.setForeground(Color.red);
     field.setBackground(Color.green);
     field.setSize( 75, 300 );
     field.setLineWrap( true );
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

     pnl.add( sndto );
     pnl.add( scroll );
     pnl.add( field );
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
     String txty = field.getText();
     int tlen    = txty.length();
     String K    = event.getKeyText( keyCode );
     String E    = "Enter";
     String T    = "\n " + fusr + ": " + txty + "\n";


     if ( ( K == E ) || ( tlen > 249 ) )
     {
        System.out.println("Enter Pressed!");
        txtArea.append( T );
        txtArea.setCaretPosition(txtArea.getDocument().getLength());
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
