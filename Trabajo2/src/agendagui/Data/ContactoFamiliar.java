/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendagui.Data;

/**
 *
 * @author oviquez
 */
public class ContactoFamiliar extends Contacto{
    private String parentezco;

    public ContactoFamiliar(String parentezco, String nombre, String telefono) {
        super(nombre, telefono);
        this.parentezco = parentezco;
    }

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "ContactoFamiliar: \n Nombre= " + getNombre() +
                                   "\nTelefono= " + getTelefono() +
                                   "\nParentezco= " + parentezco;
    }
    
    
}
