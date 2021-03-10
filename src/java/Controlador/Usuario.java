/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.M_Usuario;
import Service.Impl_Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author orteg
 */
public class Usuario extends HttpServlet {
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      // processRequest(request, response);
       
        String parametro = request.getParameter("instruccion");
        parametro= (parametro==null)? "listar": parametro;
        switch(parametro){
            case "listar" -> listarUsuario(request, response);
            case  "eliminaUsuario"-> eliminarUsuario(request, response);
            case  "enviaUsuario"-> enviaUsuario(request, response);

        }


    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);     
       
        ingreso(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    M_Usuario m_Usuario=new M_Usuario();
    Impl_Usuario implUsuario=new Impl_Usuario();
    
    public void ingreso(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
           //String ccontrasena = new String(request.getParameter("ccontrasena").getBytes("ISO-8859-1"),"UTF-8");   
           String parametro = request.getParameter("accion");
           
           m_Usuario.setNombre(request.getParameter("nombre"));
           m_Usuario.setUsuario(new String(request.getParameter("usuario").getBytes("ISO-8859-1"),"UTF-8"));
           m_Usuario.setContraseña(new String(request.getParameter("contrasena").getBytes("ISO-8859-1"),"UTF-8"));
           String con=new String(request.getParameter("ccontrasena").getBytes("ISO-8859-1"),"UTF-8");
        try {
            switch(parametro){
                case "ingresa" -> request.setAttribute("info",implUsuario.insertUsuario(m_Usuario,con));
                case "edita" ->{
                m_Usuario.setId(Integer.parseInt(request.getParameter("idUsuario")));
                request.setAttribute("info",implUsuario.updateUsuario(m_Usuario));
                }
            }
             request.setAttribute("usuarios", implUsuario.selectUsuario());
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
                request.getRequestDispatcher("ingresoUsuario.jsp").forward(request, response);
    }

    private void listarUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            request.setAttribute("usuarios", implUsuario.selectUsuario());
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error "+ex);
        }
        request.getRequestDispatcher("ingresoUsuario.jsp").forward(request, response);
    }

    private void eliminarUsuario(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
      
       int id=Integer.parseInt(request.getParameter("idUsuario"));
        try {
            implUsuario.deleteUsuario(id);
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("Usuario");
    }

    private void enviaUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
       int id=Integer.parseInt(request.getParameter("idUsuario"));
        try {
           request.setAttribute("usuarios", implUsuario.selectUsuario());
           request.setAttribute("usuari", implUsuario.selectUsuarioById(id));
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("ingresoUsuario.jsp").forward(request, response);    
    } 


    
    
}
