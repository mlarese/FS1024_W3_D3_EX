package it.epicode.locations;

import it.epicode.eventi.Evento;
import jakarta.persistence.*;
import org.hibernate.sql.ast.tree.expression.Literal;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 100, nullable = false)
    private String nome;
    @Column(length = 100, nullable = false)
    private String citta;

    @OneToMany(mappedBy = "location")
    private List<Evento> eventi = new ArrayList<>();

    public Location(Long id, String nome, String citta, List<Evento> eventi) {
        this.id = id;
        this.nome = nome;
        this.citta = citta;
        this.eventi = eventi;
    }

    public Location() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }
}
