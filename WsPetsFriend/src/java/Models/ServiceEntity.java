/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import static Models.Conexion.getConnection;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marco
 */
public class ServiceEntity extends Conexion {

    public int getServiceAction(Service service) {

        try {
            String sql = "{call service_Action (?,?,?,?)}";
            CallableStatement cst = getConnection().prepareCall(sql);
            cst.setInt("_service_id", service.getService_id());
            cst.setString("_description", service.getDescription());
            cst.setDouble("_Price", service.getPrice());
            cst.setBoolean("_status", service.isStatus());

            cst.execute();
            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public List<Service> getServiceList() {

        if (getConnection() == null) {
            return null;
        }

        try {
            String sql = "{call Service_List ()}";
            CallableStatement cst = getConnection().prepareCall(sql);

            cst.execute();
            ResultSet rs = cst.getResultSet();

            List<Service> services = new ArrayList<>();
            while (rs.next()) {
                Service service = new Service();
                service.setService_id(rs.getInt("service_id"));
                service.setDescription(rs.getString("description"));
                service.setPrice(rs.getDouble("Price"));
                service.setStatus(rs.getBoolean("status"));

                services.add(service);
            }
            return services;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
