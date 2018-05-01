package service;

import dao.UserDao;
import domain.User;

import java.sql.SQLException;

public class UserService {
    UserDao ud = new UserDao();
    public User findUser(String username,String userpwd) throws SQLException {
        return ud.findUser(username,userpwd);
    }
}
