
package Service;

import Modelo.M_Usuario;
import Repositorio.R_Usuario;
import java.sql.SQLException;
import java.util.List;

public class Impl_Usuario implements S_Usuario{
    
    R_Usuario Usuario= new R_Usuario();
    
    @Override
    public List<M_Usuario> selectUsuario() throws SQLException{
        return Usuario.selectUsuario();
    }

    @Override
    public String insertUsuario(M_Usuario usuario, String us) throws SQLException{
       if(us.equals(usuario.getContraseña())) {
           return (Usuario.insertUsuario(usuario))? "Registro exitoso" :"Registro fallido";}
       else{return "Contraseñas no identicas";}
        
    }

    @Override
    public String updateUsuario(M_Usuario usuario) throws SQLException{
   
        return Usuario.updateUsuario(usuario)? "Actualización exitosa" :"Fallo al actualizar";
    }

    @Override
    public String deleteUsuario(int idUsuario) throws SQLException{
   
        return Usuario.deleteUsuario(idUsuario)? "Eliminación exitosa" :"Fallo al eliminar";
    }

    @Override
    public M_Usuario selectUsuarioById(int idUsuario) throws SQLException{
   
        return Usuario.selectUsuarioById(idUsuario);
    }
    
}
