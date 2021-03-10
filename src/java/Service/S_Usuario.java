
package Service;

import Modelo.M_Usuario;
import java.sql.SQLException;
import java.util.List;

public interface S_Usuario {
    
    public List<M_Usuario> selectUsuario()throws SQLException;
    
    public String insertUsuario(M_Usuario usuario, String us) throws SQLException;
    
    public String updateUsuario(M_Usuario usuario) throws SQLException;
    
    public String deleteUsuario(int idUsuario) throws SQLException;
    
    public M_Usuario selectUsuarioById(int idUsuario) throws SQLException;
}
