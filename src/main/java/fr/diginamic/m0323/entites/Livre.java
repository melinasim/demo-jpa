package fr.diginamic.m0323.entites;

import jakarta.persistence.*;

@Entity
@Table(name="LIVRE")
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="TITRE")
    private String titre;

    @Column(name="AUTEUR")
    private String auteur;

    public Livre() {}

    public Livre(Integer id,String titre, String auteur) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
    }

    public Integer getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }
}
