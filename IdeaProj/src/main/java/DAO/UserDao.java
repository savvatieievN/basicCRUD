package DAO;

import Model.User;
import Utils.DBExecutor;
import Utils.IExecutor;

public class UserDao implements DAOInterface<User> {
    private IExecutor executor;

    public UserDao() {
        this.executor = new DBExecutor();
    }

    public UserDao(IExecutor executor) {
        this.executor = executor;
    }

    @Override
    public User findById(Integer id) {
        return (User) executor.findById(User.class,id);
    }

    @Override
    public void save(User user) {
        executor.create(user);
    }

    @Override
    public void update(User user) {
        executor.update(user);
    }

    @Override
    public void delete(User user) {
        executor.delete(user);
    }
}
