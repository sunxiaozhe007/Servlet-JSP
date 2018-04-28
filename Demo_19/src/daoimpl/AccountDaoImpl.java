package daoimpl;

import dao.AccountDao;
import domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import util.C3P0Util;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountDaoImpl implements AccountDao {

    private final Connection connection;

    public AccountDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void updateAccount(String formname, String toname, double money) throws SQLException {
        //创建一个QueryRunner对象
        QueryRunner qr = new QueryRunner(C3P0Util.getDataSource());
        qr.update("update test set money=money-?  where name=?",money,formname);
        qr.update("update test set money=money+?  where name=?",money,toname);
    }

    @Override
    public void updateAccount(Account account) throws SQLException {
        QueryRunner qr = new QueryRunner();
        qr.update(connection,"update test set money=? where name=?",account.getMoney(),account.getName());
    }

    @Override
    public Account findAccountByname(String name) throws SQLException {
        QueryRunner qr = new QueryRunner();
        return qr.query(connection,"select * from test where name=?",new BeanHandler<Account>(Account.class),name);

    }
}
