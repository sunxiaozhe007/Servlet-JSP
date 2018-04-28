package service;

import java.sql.SQLException;

public interface AccountService {

    public void transfer(String forname,String toname,double money) throws SQLException;

}
