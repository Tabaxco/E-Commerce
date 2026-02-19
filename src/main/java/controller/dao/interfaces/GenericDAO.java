package controller.dao.interfaces;

public interface GenericDAO<T> {
    void insert(T entity);
    T findById(int id);
    void update(T entity);
    void delete(int id);
}
