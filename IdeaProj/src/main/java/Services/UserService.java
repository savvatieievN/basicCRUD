package Services;

import DAO.DAOInterface;
import Model.User;
import DAO.UserDao;
import Utils.DBExecutor;
import Utils.IExecutor;

public class UserService {

    private IExecutor executor;
    private DAOInterface userDao;

    public UserService() {
        this.executor = new DBExecutor<User>();
        this.userDao =  new UserDao();
    }

    public UserService(DAOInterface dao, IExecutor exec) {
        this.executor = exec;
        this.userDao =  dao;
    }

    public User findById(int id) {
        return (User) userDao.findById(id);
    }

    public void save(User user) {
        userDao.save(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(User user) {
        userDao.delete(user);
    }
}
