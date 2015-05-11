

import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class TestMenuSwing3 extends JPanel {

  public TestMenuSwing3() {
    super(true);

    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    Box box1 = new Box(BoxLayout.X_AXIS);
    Box box2 = new Box(BoxLayout.X_AXIS);
    Box box3 = new Box(BoxLayout.X_AXIS);
    Box box4 = new Box(BoxLayout.X_AXIS);
    Box box5 = new Box(BoxLayout.X_AXIS);
    box1.add(new JButton("Bouton 1"));
    box1.add(new JButton("Bouton 2"));
    box1.add(new JButton("Bouton 3"));
    box2.add(new JSeparator());
    box3.add(new JTextField(""));
    box4.add(new JSeparator());
    box5.add(new JButton("Bouton 4"));
    box5.add(new JButton("Bouton 5"));
    box5.add(new JButton("bouton 6"));
    add(box1);
    add(box2);
    add(box3);
    add(box4);
    add(box5);
  }

  public static void main(String s[]) {
    JFrame frame = new JFrame("Test separator");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setContentPane(new TestMenuSwing3());
    frame.setMinimumSize(new Dimension(250, 200));
    frame.pack();
    frame.setVisible(true);
  }
}
