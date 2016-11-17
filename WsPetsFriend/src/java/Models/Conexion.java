/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco
 */
public class Conexion {

    private static Connection cnx = null;

    public static Connection getConnection()  {
        if (cnx == null) {
          
            try {
                Class.forName("com.mysql.jdbc.Driver");
                try {
                    cnx = DriverManager.getConnection("jdbc:mysql://localhost/petsfriend", "root", "alumno");
                } catch (SQLException ex) {
                    Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return cnx;
    }

    public static void CloseCnx()  {
        if (cnx != null) {
            try {
                cnx.close();
            } catch (SQLException ex) {
                Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
