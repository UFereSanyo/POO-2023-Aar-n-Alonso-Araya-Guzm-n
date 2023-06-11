package agendagui.GUI;

import agendagui.Data.Agenda;
import agendagui.Data.EventoReunion;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AgregarEventoReunion extends JFrame {
    private JTextField txtNombre;
    private JTextField txtFecha;
    private JTextField txtAsist;
    private JButton btnAdd;
    private JLabel txtLabelPanel1;
    private JLabel labelNombre;
    private JLabel laberFecha;
    private JLabel LabelCantidadAsistentes;
    private JPanel panelReunion;
    public AgregarEventoReunion(Agenda laAgenda){
        this.setContentPane(this.panelReunion);
        this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        //this.pack();
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int ca = Integer.parseInt(txtAsist.getText());
                String n = txtNombre.getText();
                laAgenda.addEvento(new EventoReunion(ca, null, n));
                dispose();
            }
        });
    }
}
