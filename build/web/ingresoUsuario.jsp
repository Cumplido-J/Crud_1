<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>

        <jsp:include page="Include/header.jsp" flush="true"/>
    </head>
    <body>
    <h1 class="text-center mt-4">Usuarios </h1>
    <div class="container ">
                    <c:if test="${info!=null}">
                        <div class="alert alert-primary text-center" role="alert">
                             ${info}
                        </div>
                    </c:if>                
        <div class="row gx-5">
            <div class="col-8 ">
              
                        <table class="table">
                          <thead>
                              <tr class="text-center">
                              <th scope="col">#</th>
                              <th scope="col">Nombre</th>
                              <th scope="col">Usuario</th>
                              <th scope="col">Contraseña</th>
                              <th scope="col" class="">Acción</th>
                            </tr>
                          </thead>
                          <tbody>
                              <c:forEach   var="usuario" items="${usuarios}">
                                  <c:url var="eliminaUsuario" value="Usuario">
                                        <c:param name="instruccion" value="eliminaUsuario"></c:param>
                                        <c:param name="idUsuario" value="${usuario.id}"></c:param>
                                  </c:url>
                                  <c:url var="enviaUsuario" value="Usuario">
                                        <c:param name="instruccion" value="enviaUsuario"></c:param>
                                        <c:param name="idUsuario" value="${usuario.id}"></c:param>
                                  </c:url>
                            <tr>
                              <th scope="row">${usuario.id}</th>
                              <td>${usuario.nombre}</td>
                              <td>${usuario.usuario}</td>
                              <td>${usuario.contraseña}</td>
                              <td class="text-center">
                                  <a href="${enviaUsuario}" type="button" class="btn btn-outline-primary btn-sm">Actualizar</a>
                                  <a href="${eliminaUsuario}" type="button" class="btn btn-outline-danger btn-sm">Eliminar</a></td>
                            </tr>
                               </c:forEach>

                          </tbody>
                        </table>
                
            </div>
            <div class="col-4">
                    <form class="row g-3 needs-validation" novalidate action="Usuario" method="post">
                        <input type="hidden" name="accion" value="${(usuari!=null) ? "edita":"ingresa"}"/>
                        <input type="hidden" name="idUsuario" value="${(usuari!=null) ? usuari.id:"0"}"/>
                      <div class="col-md-6">
                        <label for="validationCustom01"  class="form-label">Nombre</label>
                        <input type="text" name="nombre" value="${usuari.nombre}" class="form-control" id="validationCustom01"  required>
                      </div>
                      <div class="col-md-6">
                        <label for="validationCustom02" class="form-label">Usuario</label>
                        <input type="text" name="usuario" value="${usuari.usuario}" class="form-control" id="validationCustom02"  required>
                      </div>
                      <div class="col-md-6">
                        <label for="validationCustomUsername" class="form-label">Contraseña</label>
                        <div class="input-group has-validation">
                            <input type="text" name="contrasena" value="${usuari.contraseña}" class="form-control" id="validationCustomUsername" required>
                        </div>
                      </div>
                      <div class="col-md-6">
                        <label for="validationCustomUsername"  class="form-label">Confirmar Contraseña</label>
                        <div class="input-group has-validation">
                            <input type="text" name="ccontrasena" value="${usuari.contraseña}" class="form-control" id="validationCustomUsername" required>
                        </div>
                      </div>
                      <div class="col-12 text-center">
                        <button class="btn btn-primary" type="reset">Cancelar</button>
                        <button class="btn btn-primary" type="submit">Ingresar</button>
                      </div>
                    </form>
            </div>
        </div>
    </div>
        
        
        
        
        <jsp:include page="Include/footer.jsp" flush="true"/>
    </body>
</html>
