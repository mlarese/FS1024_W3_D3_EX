package it.epicode.persone;
 
import jakarta.persistence.EntityManager;

public class PersonaDAO {
    private EntityManager em;

    public PersonaDAO(EntityManager em) {
        this.em = em;
    }

    public void insert(Persona e) {
        em.persist(e);
    }

    public void update(Persona e) {
        em.merge(e);
    }

    public void delete(Long id) {
        Persona e = findById(id);
        em.remove(e);
    }

    public Persona findById(Long id) {
        return em.find(Persona.class, id);
    }
}
