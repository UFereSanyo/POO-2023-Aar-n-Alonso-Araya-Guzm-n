/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendagui.Data;

import java.util.LinkedList;

/**
 *
 * @author oviquez
 */
public class Agenda {
    private LinkedList<Evento> listaEventos;
    private LinkedList<Contacto> listaContactos;

    public Agenda() {
        this.listaContactos=new LinkedList<Contacto>();
        this.listaEventos=new LinkedList<Evento>();
    }
    
    public void addContacto(Contacto c){
        this.listaContactos.add(c);
    }
    
    public void addEvento(Evento e){
        this.listaEventos.add(e);
    }

    public LinkedList<Contacto> getListaContactos() {
        return listaContactos;
    }
    
    
    
}
