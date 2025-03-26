package it.epicode;

import it.epicode.eventi.Evento;
import it.epicode.eventi.EventoDAO;
import it.epicode.eventi.TipoEvento;
import it.epicode.locations.Location;
import it.epicode.locations.LocationDAO;
import it.epicode.partecipazioni.Partecipazione;
import it.epicode.partecipazioni.PartecipazioneDAO;
import it.epicode.partecipazioni.StatoEvento;
import it.epicode.persone.Persona;
import it.epicode.persone.PersonaDAO;
import it.epicode.persone.Sesso;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("epicode");
        EntityManager em = emf.createEntityManager();

        EventoDAO eventoDAO = new EventoDAO(em);
        LocationDAO locationDAO = new LocationDAO(em);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(em);
        PersonaDAO personaDAO = new PersonaDAO(em);


        em.getTransaction().begin();
            Location l = new Location(null, "Palazzo pitti", "Roma", null);
            locationDAO.insert(l);

            Evento e = new Evento(null, "Evento 1", LocalDate.of(2021, 1, 1), "Concerto vasco rossi", TipoEvento.PUBBLICO,1000,null, l);
            eventoDAO.insert(e);

            Persona p = new Persona( null, "Mario", "Rossi", "mario.rossi@epicode.it",  LocalDate.of(1990, 1, 1), Sesso.MASCHIO, null);
            personaDAO.insert(p);

            Partecipazione partecipazione = new Partecipazione(null,  p, e, StatoEvento.CONFERMATO);
            partecipazioneDAO.insert(partecipazione);


        em.getTransaction().commit();


        em.close();
        emf.close();

    }
}
