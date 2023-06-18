package fr.diginamic.m0323.entites;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table (name="CLIENT")
public class Client {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @Column(name="nom",length=50)
        private String nom;
        @Column(name="prenom",length=50)
        private String prenom;

        @OneToMany (mappedBy="client")
        private Set<Emprunt> emprunts;
        public Client() {
        }

        public Client(Integer id, String nom, String prenom) {
                this.id = id;
                this.nom = nom;
                this.prenom = prenom;
        }

        public Integer getId() {
                return id;
        }

        public String getNom() {
                return nom;
        }

        public void setNom(String nom) {
                this.nom = nom;
        }

        public String getPrenom() {
                return prenom;
        }

        public void setPrenom(String prenom) {
                this.prenom = prenom;
        }

        public Set<Emprunt> getEmprunts() {
                return emprunts;
        }

        @Override
        public String toString() {
                return "Client{" +
                        "id=" + id +
                        ", nom='" + nom + '\'' +
                        ", prenom='" + prenom + '\'' +
                        '}';
        }
}
