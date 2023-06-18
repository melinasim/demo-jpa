package fr.diginamic.m0323;

import fr.diginamic.m0323.entites.*;
import jakarta.persistence.*;

import java.util.Set;


public class TestBibliotheque {
    public static void main(String[] args){
        try(EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo-jpa-m0323");
            EntityManager em = emf.createEntityManager()){
            System.out.println(em);

            em.getTransaction().begin();

            //EXTRAIRE TOUS LES EMPRUNTS d'un CLIENT DONNE
            Client client = em.find(Client.class,1);
            System.out.println(client);
            if(client!= null){
                Set<Emprunt> empSet = client.getEmprunts();
                for (Emprunt e:empSet){
                    System.out.println(e);
                }
            }

            //EXTRAIRE TOUS LES LIVRES d'un EMPRUNT DONNE
            Emprunt emprunt = em.find(Emprunt.class,1);
            System.out.println(emprunt);
            if(emprunt!= null){
                Set<Livre> livSet = emprunt.getLivres();
            }

        em.getTransaction().commit();

        }
    }

}
