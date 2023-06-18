package fr.diginamic.m0323.entites;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table (name="EMPRUNT")

public class Emprunt {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="date_debut")
    private LocalDate dateDebut;
    @Column(name="delai")
    private int delai;
    @Column(name="date_fin")
    private LocalDate dateFin;
    @ManyToOne
    @JoinColumn(name="id_client")
    private Client client;

    @ManyToMany
    @JoinTable(name="compo",
        joinColumns = @JoinColumn(name = "ID_EMP",referencedColumnName="ID"),
        inverseJoinColumns = @JoinColumn(name = "ID_LIV", referencedColumnName = "ID"))
    private Set<Livre> livres;
    public Emprunt() {
    }
    public Emprunt(int id, LocalDate dateDebut, int delai, LocalDate dateFin) {
        this.id = id;
        this.dateDebut = dateDebut;
        this.delai = delai;
        this.dateFin = dateFin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate date_debut) {
        this.dateDebut = date_debut;
    }

    public int getDelai() {
        return delai;
    }

    public void setDelai(int delai) {
        this.delai = delai;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate date_fin) {
        this.dateFin = date_fin;
    }

    @Override
    public String toString() {
        return "Emprunt{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", delai=" + delai +
                ", dateFin=" + dateFin +
                '}';
    }
}
