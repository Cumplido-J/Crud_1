/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author orteg
 */
public class Conexion {
    public Connection conexion;
    public Connection Conectar() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud_1","root","12728497JUAN");
        } catch (ClassNotFoundException | SQLException e) {
        }
        return conexion;
    }
}