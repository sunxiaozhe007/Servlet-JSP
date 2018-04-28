package serviceimpl;

import dao.AccountDao;
import daoimpl.AccountDaoImpl;
import service.AccountService;

import java.sql.SQLException;

public class AccountServiceImpl implements AccountService {
    AccountDao ad = new AccountDaoImpl();
    @Override
    public void transfer(String forname, String toname, double money) throws SQLException {
        ad.updateAccount(forname, toname, money);
    }
}
