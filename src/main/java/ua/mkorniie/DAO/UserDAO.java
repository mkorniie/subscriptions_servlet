package ua.mkorniie.DAO;

import ua.mkorniie.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.apache.tomcat.jdbc.pool.PoolProperties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by mkorniie on 6/1/19.
 */
public class UserDAO  {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("ua.mkorniie.persistence");
        EntityManager em = entityManagerFactory.createEntityManager();
    }
}
