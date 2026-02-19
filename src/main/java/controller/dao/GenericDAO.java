package controller.dao;

import java.sql.SQLException;

public interface GenericDAO<T> {
    void insert(T entity) throws SQLException;
    T findById(int id) throws SQLException;
    void update(T entity) throws SQLException;
    void delete(int id) throws SQLException;
}
