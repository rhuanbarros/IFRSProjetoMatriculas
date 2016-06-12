<%@page import="java.util.List"%>
<%@page import="models.Matricula"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Campus Digital - Instrutores</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    </head>
    <body>
    	<%@ include file="menu.jsp" %>
    	
    	<%
    	List<Instrutor> instrutores = (List<Instrutor>) request.getAttribute("instrutores");
    	%>
    	
       <div class="container">
            <div class="row">
                <h3 class="page-header">Instrutores</h3>
            </div>
            <div class="row">
                 <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Matrícula</th>
                            <th>Nome</th>
                            <th>Email</th>
                            <th>valor hora</th>
                            <th>Certificados</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Instrutor i : instrutores) {%>
                        <tr>
                            <td><%=i.getMatricula()%></td>
                            <td><%=i.getNome()%></td>
                            <td><%=i.getEmail()%></td>
                            <td><%=i.getValor_hora()%></td>
                            <td><%=i.getCertificados()%></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>


        <footer class="footer">
            <div class="container">
                <p>Copyright © 2016 Rhuan Barros & Diego Szmidtke</p>
            </div>
        </footer>
    </body>
</html>

