package Models;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 

/**
 * Created by Marco on 19/07/2016.
 */
public class UserEntity extends  Conexion{
    


    public int getUserAction(User user) {

        try {
            String sql = "{call user_Action (?,?,?,?,?)}";
            CallableStatement cst = getConnection().prepareCall(sql);
            cst.setString("_dni", user.getDni());
            cst.setString("_user_name", user.getUser_name());
            cst.setString("_password", user.getPassword());
            cst.setString("_type", user.getType());
            cst.setBoolean("_status", user.isStatus());

            cst.execute();
            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public User getUserLogin(User _user) {
        if (getConnection() == null) return null;
        try {
            String sql = "{call user_Login (?,?)}";
            CallableStatement cst = getConnection().prepareCall(sql);
            cst.setString("_user_name", _user.getUser_name());
            cst.setString("_password", _user.getPassword());

            cst.execute();
            ResultSet rs = cst.getResultSet();

            User users = new User();
            while (rs.next()) {
                users.setDni(rs.getString("dni"));
                users.setUser_name(rs.getString("user_name"));
                users.setPassword(rs.getString("password"));
                users.setType(rs.getString("type"));
                users.setStatus(rs.getBoolean("status"));
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


    public User getUserListByDNI(User user) {

        if (getConnection() == null) return null;

        try {
            String sql = "{call user_List_by_DNI (?)}";
            CallableStatement cst = getConnection().prepareCall(sql);
            cst.setString("_dni", user.getDni());

            cst.execute();
            ResultSet rs = cst.getResultSet();

            User users = new User();
            while (rs.next()) {
                users.setDni(rs.getString("dni"));
                users.setUser_name(rs.getString("user_name"));
                users.setPassword(rs.getString("password"));
                users.setType(rs.getString("type"));
                users.setStatus(rs.getBoolean("status"));
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }


}
