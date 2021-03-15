package Utils;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DBExecutor<T> implements IExecutor<T> {
    private final static Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

    public DBExecutor() {
    }

    @Override
    public T findById(Class<T> obj, Integer id) {
        return  session.get(obj,id);
    }

    @Override
    public void create(T entity) {
        Transaction tx = session.beginTransaction();
        session.save(entity);
        tx.commit();
    }

    @Override
    public void update(T entity) {
        Transaction tx = session.beginTransaction();
        session.update(entity);
        tx.commit();
    }

    @Override
    public void delete(T entity) {
        Transaction tx = session.beginTransaction();
        session.delete(entity);
        tx.commit();
    }
}
