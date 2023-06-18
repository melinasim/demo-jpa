package fr.diginamic.m0323;

import fr.diginamic.m0323.entites.Livre;
import jakarta.persistence.*;

public class App {
    public static void main(String[] args) {
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa-m0323");
            EntityManager em = emf.createEntityManager()){
            System.out.println(em);

            em.getTransaction().begin();

            //CRUD : R by ID
            Livre findLivre = em.find(Livre.class,1);
            if (null != findLivre){
                System.out.println("Titre: " +findLivre.getTitre());
                System.out.println("Titre: " +findLivre.getAuteur());
            }

            //CRUD : R by titre
            TypedQuery<Livre> queryParTitre = em.createQuery("select l from Livre l where l.titre ='Germinal'",Livre.class);
            Livre l2=queryParTitre.getResultList().get(0);

            //CRUD : R by auteur
            TypedQuery<Livre> queryParAuteur = em.createQuery("select l from Livre l where l.auteur ='Jules Verne'",Livre.class);
            Livre l3=queryParAuteur.getResultList().get(0);
            System.out.println(l3);

            //CRUD : Create
            //Livre nvLivre = new Livre(@id,"Java pour les nuls","Collectif");
            //em.persist(nvLivre);

            //CRUD : Upd
            Livre updLivre = em.find(Livre.class,5);
            if (null != updLivre) {
                updLivre.setTitre("Du plaisir dans la cuisine");
                System.out.println("Titre: " +updLivre.getTitre());
                System.out.println("Auteur: " +updLivre.getAuteur());
            }

            //CRUD : Delete
            Livre rmLivre = em.find(Livre.class,4);
            if (null!=rmLivre) {
                em.remove(rmLivre);
            }

            //CRUD : Read all
            TypedQuery<Livre> queryAllBooks = em.createQuery("select l from Livre l",Livre.class);
            Livre l0 = queryAllBooks.getResultList().get(0);
            System.out.println(l0);
            System.out.println(queryAllBooks.getResultList());

            em.getTransaction().commit();



            }
    }
}