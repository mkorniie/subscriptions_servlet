package ua.mkorniie.DAO;

import java.util.List;

/**
 * Created by mkorniie on 6/1/19.
 */
public interface DAOInterface {

    void insert(Object object);

    Object selectById(Object object, int id);
    List<Object> selectAll();

    boolean delete(Object object, int id);
    boolean update(Object object);

}
