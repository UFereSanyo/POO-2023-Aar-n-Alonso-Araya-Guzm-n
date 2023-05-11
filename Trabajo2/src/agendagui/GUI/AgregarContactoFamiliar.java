package agendagui.GUI;

import agendagui.Data.Agenda;
import agendagui.Data.ContactoFamiliar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarContactoFamiliar extends JFrame{
    private JTextField txtNombre;
    private JTextField txtTelefono;
    private JTextField txtParentezco;
    private JButton agregarButton;
    private JPanel panel1;

    public AgregarContactoFamiliar(Agenda laAgenda) {
        setContentPane(this.panel1);
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String n = txtNombre.getText();
                String t = txtTelefono.getText();
                String p = txtParentezco.getText();
                laAgenda.addContacto(new ContactoFamiliar(p,n,t));
                dispose();
            }
        });

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
    }
}
