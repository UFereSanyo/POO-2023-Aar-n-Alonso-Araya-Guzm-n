import java.awt.*;
import java.awt.event.*;
class EventHandling2 extends Frame
{
    EventHandling2 ()
    {
        addWindowListener (new WindowAdapter() {
            public void windowClosing (WindowEvent e) {
                //System.exit(0);
                dispose();
            }
        });

        TextField textField = new TextField ();
        textField.setBounds (60, 50, 170, 20);
        Button button = new Button ("Show");
        button.setBounds (90, 140, 75, 40);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText ("Hello World");
            }
        });
        setLayout (null);
        add (button);
        add (textField);
        setSize (250, 250);

    }

    public static void main (String args[])
    {
        (new EventHandling2()).setVisible(true);
    }
}