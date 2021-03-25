package javawebclass.dao;

import javawebclass.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserDao {

    User findById(String id);

    void update(User user);

    void deleteUser(String id);

    void findUser(HttpServletRequest request, HttpServletResponse response);

    void regUser(HttpServletRequest request);
}
