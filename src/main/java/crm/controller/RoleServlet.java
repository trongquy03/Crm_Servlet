package crm.controller;

import crm.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "roleServlet", urlPatterns = {"/roles"})
public class RoleServlet extends HttpServlet {
    private RoleService roleService = new RoleService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       req.setAttribute("roles", roleService.getRoles());
       req.setCharacterEncoding("UTF-8");
       req.getRequestDispatcher("/roles.jsp").forward(req, resp);
    }
}
