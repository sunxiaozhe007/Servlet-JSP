package Test;

import service.AccountService;
import serviceimpl.AccountServiceImpl;

import java.sql.SQLException;

public class Test {
    public static void main(String[] args) throws SQLException {
        AccountService as = new AccountServiceImpl();
        as.transfer("xiao","sun",5000);

    }
}
