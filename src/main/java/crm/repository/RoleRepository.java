package crm.repository;

import crm.config.MysqlConnection;
import crm.model.Role;
import crm.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoleRepository {
    public List<Role> getRoles(){
        List<Role> list = new ArrayList<>();
        Connection con = MysqlConnection.getConnection();
        String query = "select * from roles";
        try {
            PreparedStatement ps = con.prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Role role = new Role();
                role.setId(rs.getInt("id"));
                role.setRoleName(rs.getString("roleName"));
                role.setDescription(rs.getString("description"));

                list.add(role);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if (con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }

}
