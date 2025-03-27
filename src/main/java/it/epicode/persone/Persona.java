package it.epicode.persone;

import it.epicode.eventi.gara_atletica.GaraDiAtletica;
import it.epicode.partecipazioni.Partecipazione;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "persone")
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false)
    private String cognome;

    @Column(length = 100, nullable = false)
    private String email;
    private LocalDate dataNascita;
    @Enumerated(EnumType.STRING)
    private Sesso sesso;

    @OneToMany(mappedBy = "persona")
    List<Partecipazione> listaPartecipazioni = new ArrayList<>();

    @OneToMany(mappedBy = "vincitore")
    List<GaraDiAtletica> gareVinte = new ArrayList<>();

    @ManyToMany(mappedBy = "atleti")
    List<GaraDiAtletica> garePartecipate = new ArrayList<>();


    public Persona(Long id, String nome, String cognome, String email, LocalDate dataNascita, Sesso sesso, List<Partecipazione> listaPartecipazioni) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.dataNascita = dataNascita;
        this.sesso = sesso;
        this.listaPartecipazioni = listaPartecipazioni;
    }

    public Persona() {
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

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascita() {
        return dataNascita;
    }

    public void setDataNascita(LocalDate dataNascita) {
        this.dataNascita = dataNascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }
}

