package dao;

import domain.Account;

import java.sql.SQLException;

public interface AccountDao {
    /**
     * 转账操作
     * @param formname
     * @param toname
     * @param money
     */
    @Deprecated
    public  void updateAccount(String formname, String toname, double money) throws SQLException;

    /**
     * 根据账户信息修改金额
     * @param account
     */
    public void updateAccount(Account account) throws SQLException;

    /**
     * 根据用户名查找信息
     * @param name
     * @return
     */
    public Account findAccountByname(String name) throws SQLException;
}
