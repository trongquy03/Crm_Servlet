package crm.repository;

import crm.config.MysqlConnection;
import crm.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    public List<User> getUserByUserNameAndPassword(String username, String password){
        List<User> list = new ArrayList<>();
        Connection con = MysqlConnection.getConnection();
        String query = "select * from users u where u.username = ? and u.password = ?";
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setFullname(rs.getString("fullname"));
                user.setAge(rs.getInt("age"));
                user.setUsername(rs.getString("username"));

                list.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return list;
    }
}
