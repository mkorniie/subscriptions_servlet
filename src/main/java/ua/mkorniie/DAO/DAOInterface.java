package ua.mkorniie.DAO;

import java.util.List;

/**
 * Created by mkorniie on 6/1/19.
 */
public interface DAOInterface<T> {

    void insert(T object);

    Object selectById(T object, int id);
    List<T> selectAll();

    boolean delete(T object, int id);
    boolean update(T object);

}
