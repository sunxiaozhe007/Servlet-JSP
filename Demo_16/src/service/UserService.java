package service;

import domain.User;

public interface UserService {
    /**
     *添加用户信息
     */

    public void reggister(User user)throws Exception;
}
