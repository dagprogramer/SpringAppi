<%-- 
    Document   : homeMio
    Created on : 20/03/2018, 09:40:44
    Author     : yo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    </head>
    <body style="background: gray">
        <h1>Este es el sitio para visualizar los datos</h1><hr/>
        <div class="container">
            <div class="row">
                <p>
                    <a href="<c:url value="agregar.htm"/>" class="btn btn-success"><span class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>Agregar</a>
                </p>
                <table class="table table-inverse">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>NOMBRE</th>
                            <th>APELLIDO</th>
                            <th>EDAD</th>
                            <th>ACCIONES</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${datos}" var="dato">
                        <tr>
                            <td><c:out value="${dato.id}"/></td>
                            <td><c:out value="${dato.nombre}"/></td>
                            <td><c:out value="${dato.apellido}"/></td>
                            <td><c:out value="${dato.edad}"/></td>
                            <td>
                                <a href="<c:url value="editar.htm?id=${dato.id}"/>" class="btn btn-success"><span class="glyphicon glyphicon-plus-pencil" aria-hidden="true"></span>EDITAR</a>
                                <a href="<c:url value="eliminar.htm?id=${dato.id}"/>" class="btn btn-success"><span class="glyphicon glyphicon-plus-pencil" aria-hidden="true"></span>ELIMINAR</a>
                            </td>
                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
