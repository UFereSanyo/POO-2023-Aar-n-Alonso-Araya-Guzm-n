import javax.swing.*;
import java.awt.event.*;
class EventHandling3 extends JFrame
{
    EventHandling3 ()
    {
        //JPanel panelPrincipal = new JPanel();
        JTextField textField = new JTextField ();
        textField.setBounds (60, 50, 170, 20);
        JButton button = new JButton ("Show");
        button.setBounds (90, 140, 75, 40);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText ("Hello World" + e);
            }
        });
        setLayout(null);
        add (button);
        add (textField);
        setSize (250, 250);
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    }

}