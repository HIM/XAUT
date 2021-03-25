package javawebclass.dao.impl;

import javawebclass.dao.UserDao;
import javawebclass.domain.User;
import javawebclass.utils.JDBCUtils;
import net.sf.json.JSONArray;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public User findById(String id) {
        String sql = "select * from tb_useraccount where id = " + id;
        ResultSet rs = JDBCUtils.query(sql);
        User user = new User();
        try {
            while (rs.next()){
                int idd = Integer.parseInt(rs.getString("id"));
                user.setId(idd);
                user.setUsername(rs.getString("ausername"));
                user.setPassword(rs.getString("apassword"));
                user.setUsertype(rs.getString("usertype"));
                user.setName(rs.getString("truename"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("tel"));
                user.setDepartment(rs.getString("dept"));
            }
            rs.close();
            JDBCUtils.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public void update(User user) {
        String sql = "update tb_useraccount "+"set ausername='"+user.getUsername()+"',apassword='"
                +user.getPassword()+"',usertype='"+user.getUsertype()+"',truename='"
                +user.getName()+"',tel='"+user.getPhone()+"',email='"
                +user.getEmail()+"',dept='"+user.getDepartment()+"' where id = " + user.getId();
        System.out.println(sql);
        JDBCUtils.update(sql);
        JDBCUtils.close();
    }

    @Override
    public void deleteUser(String id) {
        String sql = "delete from tb_useraccount where id = " + id;
        System.out.println(sql);
        JDBCUtils.update(sql);
        JDBCUtils.close();
    }

    @Override
    public void findUser(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("utf-8");
        response.setCharacterEncoding("utf-8");
        List<User> list = new ArrayList<User>();
        try{
            String searchtext = request.getParameter("search");
            String sql = "select * from tb_useraccount";
            if(searchtext!=null&&!searchtext.equals("")){
                sql = sql + " where ausername like '%"+searchtext+"%' or truename like '%"+searchtext+"%'";
            }
            System.out.println(sql);
            ResultSet rs = JDBCUtils.query(sql);
            int id;
            while (rs.next()){
                User user= new User();
                id = Integer.parseInt(rs.getString("id"));
                user.setId(id);
                user.setUsername(rs.getString("ausername"));
                user.setPassword(rs.getString("apassword"));
                user.setUsertype(rs.getString("usertype"));
                user.setName(rs.getString("truename"));
                user.setEmail(rs.getString("email"));
                user.setPhone(rs.getString("tel"));
                user.setDepartment(rs.getString("dept"));
                list.add(user);
            }

            request.setAttribute("list",list);
            rs.close();
            JDBCUtils.close();

            JSONArray jsonArray = JSONArray.fromObject(list);
            System.out.println(jsonArray);
            response.getWriter().print(jsonArray);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void regUser(HttpServletRequest request) {
        HttpSession session = request.getSession();

        String sql = "insert into tb_useraccount (ausername,apassword,usertype,truename,tel,email,dept) values ('"
                +session.getAttribute("username")+"','"+session.getAttribute("password")+"','"
                +session.getAttribute("usertype")+"','"+session.getAttribute("truename")+"','"
                +session.getAttribute("phone")+"','"+session.getAttribute("email")+"','"
                +session.getAttribute("department")+"')";
        System.out.println(sql);
        JDBCUtils.add(sql);
        JDBCUtils.close();
//        int rows = JDBCUtils.add(sql);
//        if(rows>0){
//            request.getRequestDispatcher("/findServlet").forward(request,response);
//        }
    }
}
