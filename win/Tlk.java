import javax.swing.*;

class Tlk extends JFrame
{
  JPanel pnl = new JPanel();
  public Tlk()
  {
     super("Swing Window");
     setSize( 480, 560 );
     setDefaultCloseOperation( EXIT_ON_CLOSE );
     add( pnl );
     setVisible( true );
  }
  public static void main ( String[] args )
  {
    Tlk gui = new Tlk();
  }
}
