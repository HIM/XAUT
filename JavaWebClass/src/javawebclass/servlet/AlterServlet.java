package javawebclass.servlet;

import javawebclass.domain.User;
import javawebclass.service.UserService;
import javawebclass.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/alterServlet")
public class AlterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

        UserService service = new UserServiceImpl();
        User user = service.findUserById(id);

        request.setAttribute("user",user);

        request.getRequestDispatcher("/alterUser.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
