package ua.mkorniie.DAO;

import lombok.Getter;
import ua.mkorniie.entity.PublishersEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 * Created by mkorniie on 6/1/19.
 */
public class UserDAO  {


    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ua.mkorniie.persistence");
        EntityManager entityManager = emf.createEntityManager();
        PublishersEntity publishersEntity = new PublishersEntity();
        publishersEntity.setName("MyTestPublisher");
        publishersEntity.setCountry("Ukraine");

        entityManager.getTransaction().begin();
        entityManager.persist(publishersEntity);
        entityManager.getTransaction().commit();
        System.out.println("Entity saved.");
    }
}
