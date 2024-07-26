package crm.api;

import com.google.gson.Gson;
import crm.pageLoad.ResponseData;
import crm.service.RoleService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "roleApi", urlPatterns = {"/api/roles"})
public class RoleApi extends HttpServlet {
    private RoleService roleService = new RoleService();
    private Gson gson = new Gson();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        boolean isSuccess = roleService.deleteRoleById(id);
        ResponseData responseData = new ResponseData();
        responseData.setSuccess(isSuccess);
        responseData.setDescription("");
        responseData.setData("");

        String json = gson.toJson(responseData);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print(json);
        out.flush();
    }
}
