package service;

import domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {

    //查询所有用户信息
    public default List<User> findAll() {
        return null;
    }
}
