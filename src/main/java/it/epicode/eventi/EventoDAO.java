package it.epicode.eventi;

import it.epicode.eventi.concerti.Concerto;
import it.epicode.eventi.concerti.Genere;
import it.epicode.eventi.partite_di_calcio.PartitaDiCalcio;
import jakarta.persistence.EntityManager;

import java.util.List;

public class EventoDAO {
    private EntityManager em;

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Evento e) {
        em.persist(e);
    }

    public void update(Evento e) {
        em.merge(e);
    }

    public void delete(Long id) {
        Evento e = findById(id);
        em.remove(e);
    }

    public Evento findById(Long id) {
        return em.find(Evento.class, id);
    }

    public List<Concerto> getConcertiInStreaming(Boolean tipo ) {
        return em.createQuery("select c from Concerto c where c.inStreaming = :tipo", Concerto.class)
                .setParameter("tipo", tipo)
                .getResultList();
    }

    public List<Concerto> getConcertiPerGenere(Genere genere) {
        return em.createQuery("select c from Concerto c where c.genere = :genere", Concerto.class)
                .setParameter("genere", genere)
                .getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        return em.createNamedQuery("partita.find.vinte_in_casa", PartitaDiCalcio.class)
                .getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        return em.createNamedQuery("partita.find.vinta_in_trasferta", PartitaDiCalcio.class)
                .getResultList();
    }
}
