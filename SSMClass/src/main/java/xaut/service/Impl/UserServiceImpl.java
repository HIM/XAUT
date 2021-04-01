package xaut.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xaut.dao.UserDao;
import xaut.entity.User;
import xaut.service.UserService;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    User user;
    @Autowired
    UserDao userDao;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public String toString() {
        return "UserServiceImpl{" +
                "user=" + user +
                ", userDao=" + userDao +
                '}';
    }

    public void addUser() {
        this.userDao.addUser(this.user);
    }
    public void check(){

    }

    public void addCouple(){
        this.userDao.addUser(this.user);

    }
}
