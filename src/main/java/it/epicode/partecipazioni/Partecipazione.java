package it.epicode.partecipazioni;

import it.epicode.eventi.Evento;
import it.epicode.persone.Persona;
import jakarta.persistence.*;

@Entity
@Table(name = "partecipazioni")
public class Partecipazione {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    private Persona persona;

    @ManyToOne
    private Evento evento;

    @Enumerated(EnumType.STRING)
    StatoEvento statoEvento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public StatoEvento getStatoEvento() {
        return statoEvento;
    }

    public void setStatoEvento(StatoEvento statoEvento) {
        this.statoEvento = statoEvento;
    }

    public Partecipazione() {
    }

    public Partecipazione(Long id, Persona persona, Evento evento, StatoEvento statoEvento) {
        this.id = id;
        this.persona = persona;
        this.evento = evento;
        this.statoEvento = statoEvento;
    }
}
