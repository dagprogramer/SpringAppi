<%-- 
    Document   : editar
    Created on : 21/03/2018, 11:40:24
    Author     : yo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sp" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
    </head>
    <body style="background: greenyellow">
        <h1>Esta es la pagina de editar datos</h1><hr/>
        <div class="container">
            <ol>
                <li class="breadcrumb"><a href="<c:url value="/homeMio.htm"/>">Lista de Personas</a></li>
                <li class="active">Agregar</li>
            </ol>
                <div class="panel panel-primary">
                    <div class="panel-heading">Formaulario</div>
                    <div class="panel-body">
                        <sp:form commandName="persona" method="post">
                            <h2>Complete el Formulario</h2>
                            <sp:errors path="*" element="div" cssClass="alert alert-danger"/>
                            <table>
                                <tr>
                                    <td><sp:label path="nombre">NOMBRE</sp:label></td>
                                    <td><sp:input path="nombre" cssClass="form-control"/></td>
                                </tr>
                                <tr>
                                    <td><sp:label path="apellido">APELLIDO</sp:label></td>
                                    <td><sp:input path="apellido" cssClass="form-control"/></td>
                                </tr>
                                <tr>
                                    <td><sp:label path="edad">EDAD</sp:label></td>
                                    <td><sp:input path="edad" cssClass="form-control"/></td>
                                </tr>
                                <tr>
                                    <td><sp:button>Enviar Datos</sp:button></td>
                                </tr>
                            </table>
                        </sp:form>
                    </div>
                </div>
        </div>
    </body>
</html>
