package dao;

import java.sql.SQLException;

public interface AccountDao {
    /**
     * 转账操作
     * @param formname
     * @param toname
     * @param money
     */
    public  void updateAccount(String formname, String toname, double money) throws SQLException;
}
