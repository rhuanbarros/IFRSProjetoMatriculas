<%@page import="java.util.List"%>
<%@page import="models.Turma"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Campus Digital - Turmas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    </head>
    <body>
    	<%@ include file="menu.jsp" %>
    	
    	<%
    	List<Turma> turmas = (List<Turma>) request.getAttribute("turmas");
    	%>
    	
       <div class="container">
            <div class="row">
                <h3 class="page-header">Turma</h3>
            </div>
            <div class="row">
                 <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Instrutor</th>
                            <th>Curso</th>
                            <th>Data Inicial</th>
                            <th>Data Final</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Turma t : turmas) {%>
                        <tr>
                            <td><%=t.getInstrutor().getNome()%></td>
                            <td><%=t.getCurso().getNome()%></td>
                            <td><%=t.getData_inicio()%></td>
                            <td><%=t.getData_final()%></td>
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

