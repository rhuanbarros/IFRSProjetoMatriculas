<%@page import="java.util.List"%>
<%@page import="models.Aluno"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Campus Digital - Alunos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    </head>
    <body>
    	<%@ include file="menu.jsp" %>
    	
    	<%
    	List<Aluno> alunos = (List<Aluno>) request.getAttribute("alunos");
    	%>
    	
       <div class="container">
            <div class="row">
                <h3 class="page-header">Alunos</h3>
            </div>
            <div class="row">
                 <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Matrícula</th>
                            <th>Nome</th>
                            <th>Email</th>
                            <th>Telefone</th>
                            <th>Data de nascimento</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Aluno a : alunos) {%>
                        <tr>
                            <td><%=a.getMatricula()%></td>
                            <td><%=a.getNome()%></td>
                            <td><%=a.getEmail()%></td>
                            <td><%=a.getFone()%></td>
                            <td><%=a.getData_nascimento()%></td>
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

