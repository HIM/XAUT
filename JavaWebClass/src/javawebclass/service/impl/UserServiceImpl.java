package javawebclass.service.impl;

import javawebclass.dao.UserDao;
import javawebclass.dao.impl.UserDaoImpl;
import javawebclass.domain.User;
import javawebclass.service.UserService;
import javawebclass.utils.JDBCUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    @Override
    public User findUserById(String id) { return dao.findById(id); }

    @Override
    public void updateUser(User user) {
        dao.update(user);
    }

    @Override
    public void deleteUser(String id) {
        dao.deleteUser(id);
    }

    @Override
    public User createUser(HttpServletRequest request) {
        User user = new User();
        HttpSession session = request.getSession();
        user.setId((int)session.getAttribute("id"));
        user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setName(request.getParameter("name"));
        user.setPhone(request.getParameter("phone"));
        user.setEmail(request.getParameter("email"));
        user.setDepartment(request.getParameter("department"));
        return user;
    }

    @Override
    public void findUser(HttpServletRequest request, HttpServletResponse response) {
        dao.findUser(request,response);
    }

    @Override
    public void regUser(HttpServletRequest request) {
        dao.regUser(request);
    }

    @Override
    public void login(HttpServletRequest request, HttpServletResponse response) {
        String usrname = request.getParameter("username");
        String pasword = request.getParameter("password");
        try{
            String sql = "select * from tb_useraccount where ausername ='"+usrname+"' and apassword ='"+pasword+"'";
            ResultSet rs = JDBCUtils.query(sql);
            if(rs.next()){
                HttpSession session = request.getSession();
                session.setAttribute("username",usrname);
                session.setAttribute("password",pasword);

                //if语句用户是否勾选了记住密码选项
                if (request.getParameter("checkbox")!=null) {
                    //记住密码:生成新的cookie用来保存账号密码
                    Cookie username = new Cookie("username",request.getParameter("username"));
                    username.setMaxAge(1296000);//设置cookie最长保存时间15天
                    Cookie password = new Cookie("password",request.getParameter("password"));
                    password.setMaxAge(1296000);
                    //覆盖旧的cookie
                    response.addCookie(username);
                    response.addCookie(password);
                } else
                {
                    Cookie [] cookies = request.getCookies();
                    Cookie username=null;
                    Cookie password=null;
                    //寻找是否已经存在cookie
                    for (Cookie cookie:cookies) {
                        if (cookie.getName().equals("username")) {
                            username=cookie;
                        } else
                        if (cookie.getName().equals("password")) {
                            password=cookie;
                        }
                    }
                    //若cookie存在则通过设置cookie保存时间为0的方法来删除cookie
                    if (username!=null) {
                        username.setMaxAge(0);
                        response.addCookie(username);
                    }
                    if (password!=null) {
                        password.setMaxAge(0);
                        response.addCookie(password);
                    }
                }
                rs.close();
                JDBCUtils.close();
                request.getRequestDispatcher("/loginSuccess.jsp").forward(request,response);
//                response.getWriter().write("1");
            }else {
                response.setHeader("refresh", "3;login.jsp");

                response.setContentType("text/html");
                response.setCharacterEncoding("utf-8");

                PrintWriter writer = response.getWriter();
                writer.println("<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "    <meta charset=\"UTF-8\">\n" +
                        "    <title>登录失败</title>\n" +
                        "    <link href=\"css/javaweb.css\" rel=\"stylesheet\">\n" +
                        "</head>\n" +
                        "<body>\n" +
                        "    <div id=\"box\">\n" +
                        "        <div id=\"head\">\n" +
                        "            <div id=\"head_left\"><a href=\"#\">登录失败，请检查用户名或密码</a></div>\n" +
                        "            <div id=\"head_right\">2020/9/14</div>\n" +
                        "        </div>\n" +
                        "        <div id=\"context\">\n" +
                        "            <div id=\"context_head\">登录失败，3秒后跳转...</div>\n" +
                        "        </div>\n" +
                        "        <div id=\"foot\">\n" +
                        "            <div id=\"foot_word\">Liugm@xaut.edu.cn</div>\n" +
                        "        </div>\n" +
                        "    </div>\n" +
                        "</body>\n" +
                        "</html>");
                writer.flush();
                writer.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }


}
