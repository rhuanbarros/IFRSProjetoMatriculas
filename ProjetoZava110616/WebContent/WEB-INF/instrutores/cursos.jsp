<%@page import="java.util.List"%>
<%@page import="models.Curso"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Campus Digital - Cursos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    </head>
    <body>
    	<%@ include file="menu.jsp" %>
    	
    	<%
    	List<Curso> cursos = (List<Curso>) request.getAttribute("cursos");
    	%>
    	
       <div class="container">
            <div class="row">
                <h3 class="page-header">Cursos</h3>
            </div>
            <div class="row">
                 <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Nome</th>
                            <th>Requisito</th>
                            <th>Carga horária</th>
                            <th>Preço</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Curso c : cursos) {%>
                        <tr>
                            <td><%=c.getNome()%></td>
                            <td><%=c.getRequisito()%></td>
                            <td><%=c.getCarga_horaria()%></td>
                            <td><%=c.getPreco()%></td>
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

