package it.epicode.eventi;

import jakarta.persistence.EntityManager;

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
}
