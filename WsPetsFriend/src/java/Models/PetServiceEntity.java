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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marco
 */
public class PetServiceEntity extends Conexion {

    public int getPetServiceAction(PetService petService) {

        try {
            String sql = "{call petService_Action (?,?,?,?,?,?,?,?,?,?,?,?)}";
            CallableStatement cst = getConnection().prepareCall(sql);
            cst.setInt("_PetService_id", petService.getPetService_id());
            cst.setString("_pet_id", petService.getPet_id());
            cst.setInt("_service_id", petService.getService_id());
            cst.setString("_name_service", petService.getName_service());
            cst.setString("_weight", petService.getWeight());

            //Format to date
            DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String _Date = dateFormat.format(petService.getDate());
            String _NextDate = dateFormat.format(petService.getNext_date());

            cst.setString("_date", _Date);
            cst.setString("_next_date", _NextDate);
            cst.setDouble("_price", petService.getPrice());
            cst.setBoolean("_delivery", petService.isDelivery());
            cst.setString("_observation", petService.getObservation());
            cst.setBoolean("_status", petService.isStatus());

            cst.execute();
            return 1;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public List<PetService> getPetServiceListByPetId(PetService petService) {

        if (getConnection() == null) {
            return null;
        }

        try {
            String sql = "{call PetService_List_by_PetId (?)}";
            CallableStatement cst = getConnection().prepareCall(sql);
            cst.setString("_pet_id", petService.getPet_id());

            cst.execute();
            ResultSet rs = cst.getResultSet();

            List<PetService> petServices = new ArrayList<>();
            while (rs.next()) {
                PetService petService_Aux = new PetService();
                petService_Aux.setPetService_id(rs.getInt("PetService_id"));
                petService_Aux.setPet_id(rs.getString("pet_id"));
                petService_Aux.setService_id(rs.getInt("service_id"));
                petService_Aux.setName_service(rs.getString("name_service"));
                petService_Aux.setWeight(rs.getString("weight"));
                petService_Aux.setDate(rs.getDate("date"));
                petService_Aux.setNext_date(rs.getDate("next_date"));
                petService_Aux.setPrice(rs.getDouble("price"));
                petService_Aux.setDelivery(rs.getBoolean("delivery"));
                petService_Aux.setObservation(rs.getString("observation"));
                petService_Aux.setStatus(rs.getBoolean("status"));

                petServices.add(petService_Aux);
            }
            return petServices;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

}
