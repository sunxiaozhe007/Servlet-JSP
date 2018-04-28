package daoimpl;

import dao.AccountDao;
import org.apache.commons.dbutils.QueryRunner;
import util.C3P0Util;

import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void updateAccount(String formname, String toname, double money) throws SQLException {
        //创建一个QueryRunner对象
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("update test set money=money-?  where name=?",money,formname);
        qr.update("update test set money=money+?  where name=?",money,toname);
    }
}
