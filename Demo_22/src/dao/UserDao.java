package dao;

import domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.C3P0Util;

import java.sql.SQLException;

public class UserDao {

    public User findUser(String username, String userpwd) throws SQLException {
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        return qr.query("select * from admin where username=? and userpwd=?",new BeanHandler<User>(User.class),username,userpwd);
    }
}
