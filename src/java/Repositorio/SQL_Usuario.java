package Repositorio;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import Config.Conexion;
import java.sql.SQLException;

public class SQL_Usuario {
    
    static ResultSet rs;
    CallableStatement procedimiento;
    Conexion DB = new Conexion();

    //cierra conexion para las consultas de select
    public void cerrarconexion() {
        try {
            rs.close();
            procedimiento.close();
            DB.Conectar().close();
        } catch (SQLException e) {
        }

    }
    
    //cierra conexion para las consultas de insert, update y delete
    public void cerrarconexion2() {
        try {
            procedimiento.close();
            DB.Conectar().close();
        } catch (SQLException e) {
        }
    }

    public CallableStatement sp_insert_usuario() {
        try {
            procedimiento = DB.Conectar().prepareCall("{call insertUsuario(?,?,?)}");
        } catch (SQLException e) {
        }
        return procedimiento;
    }

    public CallableStatement sp_select_usuario() throws SQLException {
        try {
            procedimiento = DB.Conectar().prepareCall("{call selectUsuario()}");
            rs = procedimiento.executeQuery();
        } catch (SQLException e) {
        }
        return procedimiento;
    }

    public CallableStatement sp_delete_usuario(int id) throws SQLException {
        try {
            procedimiento = DB.Conectar().prepareCall("{call deleteUsuario("+id+")}");
            rs = procedimiento.executeQuery();
        } catch (SQLException e) {
        }
        return procedimiento;
    }
    
    public CallableStatement sp_update_empleado() {
        try {
            procedimiento = DB.Conectar().prepareCall("{call updateUsuario(?,?,?,?)}");
        } catch (SQLException e) {
        }
        return procedimiento;
    }
    
    public CallableStatement sp_select_UsuarioById(int idUsuario) throws SQLException {
        try {
            procedimiento = DB.Conectar().prepareCall("{call selectUsuarioById(" +idUsuario+")}");
            rs = procedimiento.executeQuery();
        } catch (SQLException e) {
        }
        return procedimiento;
    }
        
}