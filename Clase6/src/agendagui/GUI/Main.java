import java.util.Date;
import agendagui.Data.Agenda;
import agendagui.Data.ContactoFamiliar;
import agendagui.Data.EventoReunion;
package agendagui;


public static void main(String[] args){
        Agenda miAgenda = new Agenda();

        miAgenda.addContacto(new ContactoFamiliar("hermano","Juan","88888888"));
        miAgenda.addEvento(new EventoReunion(20,new Date(),"Reunion"));
        System.out.println(miAgenda.getListaContactos().get(0).toString());

        }


