package crm.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "hello servlet", urlPatterns = {"/hello"})
public class HelloServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        System.out.println("Hello Init Servlet");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        System.out.println("Kiểm tra " + username);
        req.getRequestDispatcher("/hello.jsp").forward(req, resp);
//        System.out.println("Hello Doget Servlet");
//        resp.getWriter().append("Hello Servlet");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Hello DoPost Servlet");

    }
}
