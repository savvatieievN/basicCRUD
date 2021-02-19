package Utils;

import org.hibernate.Session;

public interface IExecutor<T> {
    T findById(Class<T> obj,Integer id);
    void create(T entity);
    void update(T entity);
    void delete(T entity);
}
