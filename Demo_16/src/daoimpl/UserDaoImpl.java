package daoimpl;

import dao.UserDao;
import domain.User;
import util.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;

public class UserDaoImpl implements UserDao {

    public void addUser(User user) throws Exception {
        Connection conn = null;
        PreparedStatement ps = null;
        try {

            conn = DBUtils.getConnection();
            ps = conn.prepareStatement("INSERT INTO users(username,PASSWORD,email,birthday) VALUES(?,?,?,?)");
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());
            ps.setString(4, user.getEmail());
            int i = ps.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("添加失败");
        }finally {
            DBUtils.closeAll(null,ps,conn);
        }

    }
}
