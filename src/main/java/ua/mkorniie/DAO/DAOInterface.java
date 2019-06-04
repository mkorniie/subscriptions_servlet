package ua.mkorniie.DAO;

import java.util.List;

/**
 * Created by mkorniie on 6/1/19.
 */
public interface DAOInterface<E> {

    void insert(E object);

    E selectById(int id);
    List<E> selectAll();

    boolean delete(int id);
    boolean update(E object);

}
