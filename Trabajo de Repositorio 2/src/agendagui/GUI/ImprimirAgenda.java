package agendagui.GUI;

import agendagui.Data.*;

import javax.swing.*;

public class ImprimirAgenda extends JFrame{
    private JTextArea txtImpresion;
    private JPanel panel1;

    public ImprimirAgenda(Agenda laAgenda) {
        setContentPane(this.panel1);

        for(ObjAgenda o : laAgenda.getListaObjetos() )
            this.txtImpresion.append(o.toString()+"\n");

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        pack();
    }
}
