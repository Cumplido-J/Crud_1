package Repositorio;
import Modelo.M_Usuario;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class R_Usuario {
    
    SQL_Usuario sql = new SQL_Usuario();
    CallableStatement procedimiento;
    ResultSet rs;
    
    public List<M_Usuario> selectUsuario() throws SQLException {
        List<M_Usuario> getUsuario = new ArrayList<>();
        try {
            rs = sql.sp_select_usuario().executeQuery();
            while (rs.next()) {
                getUsuario.add(new M_Usuario(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getString(4)));
            }
        } catch (SQLException e) {} finally {
            sql.cerrarconexion();
            rs.close();}
        return getUsuario;
    }
                
    public Boolean insertUsuario(M_Usuario usuario) throws SQLException {
        try {
            procedimiento = sql.sp_insert_usuario();
            procedimiento.setString(1, usuario.getNombre());
            procedimiento.setString(2, usuario.getUsuario());
            procedimiento.setString(3, usuario.getContraseña());
            procedimiento.execute();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            sql.cerrarconexion2();
            procedimiento.close(); }
    }
    
    public Boolean updateUsuario(M_Usuario usuario) throws SQLException {
        try {
            procedimiento = sql.sp_update_empleado();
            procedimiento.setInt(1, usuario.getId());
            procedimiento.setString(2, usuario.getNombre());
            procedimiento.setString(3, usuario.getUsuario());
            procedimiento.setString(4, usuario.getContraseña());
            procedimiento.execute();
            return true;
        } catch (SQLException e) {
            return false;
        } finally {
            sql.cerrarconexion2();
            procedimiento.close();  }
    }
        
    public Boolean deleteUsuario(int id) throws SQLException {
        try {
            rs = sql.sp_delete_usuario(id).executeQuery();
            return true;
        } catch (SQLException e) {
            return false; } finally {
            sql.cerrarconexion();
            rs.close();     }
    }  
    
    public M_Usuario selectUsuarioById(int idUsuario) throws SQLException {
        M_Usuario getUsuario = new M_Usuario();
        try {
            rs = sql.sp_select_UsuarioById(idUsuario).executeQuery();
            while (rs.next()) {
                getUsuario.setId(rs.getInt(1));
                getUsuario.setNombre(rs.getString(2));
                getUsuario.setUsuario(rs.getString(3));
                getUsuario.setContraseña(rs.getString(4));
            }
        } catch (SQLException e) {} finally {
            sql.cerrarconexion();
            rs.close();}
        return getUsuario;
    }
}