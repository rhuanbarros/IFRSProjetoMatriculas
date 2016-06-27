<%@page import="java.util.List"%>
<%@page import="model.Turma"%>
<%@page import="model.Matricula"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Campus Digital - formulário de matrícula</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
</head>

<%
	List<Turma> turmas = (List<Turma>) request.getAttribute("turmas");
	List<Matricula> matriculas = (List<Matricula>) request.getAttribute("matriculas");
%>

<body>
	<%@ include file="menu.jsp"%>
	<div class="container">
		<div class="row">
			<h3 class="page-header">Formulário de matrícula</h3>
		</div>
		<div class="row">
			<table class="table table-hover">
				<thead>
					<tr>
						<th>Instrutor</th>
						<th>Curso</th>
						<th>Data Inicial</th>
						<th>Data Final</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<%
						for (Turma t : turmas) {
					%>
					<tr>
						<td><%=t.getInstrutor().getNome()%></td>
						<td><%=t.getCurso().getNome()%></td>
						<td><%=t.getData_inicio()%></td>
						<td><%=t.getData_final()%></td>
						<%
								Boolean jaMatriculado = false;
								Long idMatricula = null;
								for (Matricula m : matriculas) {
									if (m.getTurma().getId_turma() == t.getId_turma()) {
										jaMatriculado = true;
										idMatricula = m.getId_matricula();
									}
								}
								if (jaMatriculado != true) {
						%>
						<td><a href="FrontController?servlet=salvarFormularioMatriculaComando&idturma=<%=t.getId_turma()%>">Solicitar matricula</a></td>
							<%
								} else {
							%>
						<td><a href="FrontController?servlet=cancelarFormularioMatriculaComando&idmatricula=<%=idMatricula%>">Cancelar matricula</a></td>
							<%
								}
							%>
					</tr>
					<%
							//jaMatriculado = false;
						}
					%>
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

