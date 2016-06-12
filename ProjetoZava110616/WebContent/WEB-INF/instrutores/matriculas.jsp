<%@page import="java.util.List"%>
<%@page import="models.Matricula"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Campus Digital - Matrícula solicitadas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
    </head>
    <body>
    	<%@ include file="menu.jsp" %>
    	
    	<%
    	List<Matricula> matriculas = (List<Matricula>) request.getAttribute("matriculas");
    	%>
    	
       <div class="container">
            <div class="row">
                <h3 class="page-header">Matrícula solicitadas</h3>
            </div>
            <div class="row">
                 <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Número Turma</th>
                            <th>Curso</th>
                            <th>Aluno</th>
                            <th>Data da Matrícula</th>
                        </tr>
                    </thead>
                    <tbody>
                        <% for (Matricula m : matriculas) {%>
                        <tr>
                            <td><%=m.getTurma().getId_turma()%></td>
                            <td><%=m.getTurma().getCurso().getNome()%></td>
                            <td><%=m.getAluno().getNome()%></td>
                            <td><%=m.getData_matricula()%></td>
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

