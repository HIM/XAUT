package javawebclass.service;

import javawebclass.domain.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface UserService {

    /**
     * 根据Id查询，管理页面点击修改
     * @param id
     * @return
     */
    User findUserById(String id);

    /**
     * 修改用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 管理页面删除用户
     * @param id
     */
    void deleteUser(String id);

    /**
     * 封装用户
     * @param request
     * @return
     */
    User createUser(HttpServletRequest request);

    /**
     * 管理页面 查询用户
     * @param request
     */
    void findUser(HttpServletRequest request, HttpServletResponse response);

    /**
     * 注册用户
     * @param request
     */
    void regUser(HttpServletRequest request);

    /**
     * 登录
     * @param request
     * @param response
     */
    void login(HttpServletRequest request, HttpServletResponse response);
}
