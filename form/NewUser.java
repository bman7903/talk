import java.swing.*;
import java.awt.event.*;

public class NewUser extends JFrame implements ActionListener
{
  ClassLoader ldr = this.getClass().getCladdLoader();
  java.net.URL iconURL = ldr.getRescource("Lotto.png")
  ImageIcon icon = newImageIcon( iconURL );
  JLabel img = new JLabel( icon );
  JTextField txt = new JTextField( "", 15);
  
