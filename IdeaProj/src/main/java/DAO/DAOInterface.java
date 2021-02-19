package DAO;

public interface DAOInterface<T> {
    T findById(Integer id);
    void save(T entity);
    void update(T entity);
    void delete(T entity);
}
