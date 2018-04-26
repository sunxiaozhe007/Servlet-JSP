package serviceimpl;

import dao.UserDao;
import daoimpl.UserDaoImpl;
import domain.User;
import service.UserService;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();
    public void reggister(User user) throws Exception {
        userDao.addUser(user);
    }
}
