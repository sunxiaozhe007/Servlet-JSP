package serviceimpl;

import dao.AccountDao;
import daoimpl.AccountDaoImpl;
import domain.Account;
import service.AccountService;
import util.C3P0Util;
import util.ManagerTheadLocal;

import java.sql.Connection;
import java.sql.SQLException;

public class AccountServiceImpl implements AccountService {
    Connection connection = C3P0Util.getConnection();
    AccountDao ad = new AccountDaoImpl(connection);
    @Override
    public void transfer(String forname, String toname, double money) throws SQLException {
        try {
            //开启事物
            ManagerTheadLocal.startTransacation();
        //分别得到转入转出账户
            Account fromAccount = ad.findAccountByname(forname);
            Account toAccount = ad.findAccountByname(toname);

        //修改账户各自的金额

            fromAccount.setMoney(fromAccount.getMoney()-money);
            toAccount.setMoney(toAccount.getMoney()+money);

        //完成转账操作
            ad.updateAccount(fromAccount);
            int i = 10/0;
            ad.updateAccount(toAccount);

            //提交事物
            ManagerTheadLocal.commit();
        } catch (SQLException e) {
            //事物回滚
            ManagerTheadLocal.rollback();
        }
          finally {
            //关闭事物
            ManagerTheadLocal.close();
        }
    }
}
