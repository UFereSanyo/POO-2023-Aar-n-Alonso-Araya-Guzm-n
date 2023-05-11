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
    private LinkedList<ObjAgenda> listaObjetos;

    public Agenda() {
        this.listaObjetos=new LinkedList<ObjAgenda>();
    }
    
    public void addContacto(Contacto c){
        this.listaObjetos.add(c);
    }
    
    public void addEvento(Evento e){
        this.listaObjetos.add(e);
    }

    public LinkedList<ObjAgenda> getListaObjetos() {
        return listaObjetos;
    }
    
    
    
}
