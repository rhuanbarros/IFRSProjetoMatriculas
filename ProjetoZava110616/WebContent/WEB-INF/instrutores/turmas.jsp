<%@page import="java.util.List"%>
<%@page import="model.Turma"%>
<%@page import="model.Curso"%>
<%@page import="model.Instrutor"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Campus Digital - Turmas</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
</head>
<body>
	<%@ include file="menu.jsp"%>

	<%
		List<Turma> turmas = (List<Turma>) request.getAttribute("turmas");

		Long id_turma = (Long) request.getAttribute("id_turma");
		Long idInstrutor = (Long) request.getAttribute("id_instrutor");
		Long idCurso = (Long) request.getAttribute("id_curso");
		String dataInicio = (String) request.getAttribute("dataInicio");
		String dataFinal = (String) request.getAttribute("dataFinal");
	%>

	<div class="container">

		<div class="row">
			<h3 class="page-header">Formulário turma</h3>
		</div>
		<div class="row">
			<form class="form-horizontal" role="form"
				action="FrontController?servlet=inserirTurma" method="post">

				<div class="form-group">
					<label class="control-label col-sm-2" for="nome">Instrutor</label>
					<div class="col-xs-3 selectContainer">
						<select class="form-control" name="instrutor">
							<%
								List<Instrutor> instrutores = (List<Instrutor>) request.getAttribute("instrutores");
								for (Instrutor i : instrutores) {
									Long id_instrutor = i.getId_instrutor();
									String nome_instrutor = i.getNome();
									
									if( idInstrutor !=null && i.getId_instrutor() == idInstrutor ) {
							%>
										<option value="<%=id_instrutor%>" selected><%=nome_instrutor%></option>
							<%
									} else {
							%>	
										<option value="<%=id_instrutor%>" ><%=nome_instrutor%></option>
							<%
									}
								}
							%>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="nome">Curso</label>
					<div class="col-xs-3 selectContainer">
						<select class="form-control" name="curso">
							<%
								List<Curso> cursos = (List<Curso>) request.getAttribute("cursos");
								for (Curso c : cursos) {
									Long id_curso = c.getId_curso();
									String nome_curso = c.getNome();
									
									if( idCurso !=null && c.getId_curso() == idCurso ) {
							%>
										<option value="<%=id_curso%>" selected><%=nome_curso%></option>
										<%
									} else {
							%>	
										<option value="<%=id_curso%>"><%=nome_curso%></option>
							<%
									}
								}
							%>
						</select>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="nome">Data
						inicial</label>
					<div class="col-xs-3">
						<input type="text" class="form-control" name="dataInicial"
							placeholder="Informe a data inicial" <% if(dataInicio!=null) %>value="<%=dataInicio%>"
							>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="nome">Data final</label>
					<div class="col-xs-3">
						<input type="text" class="form-control" name="dataFinal"
							placeholder="Informe a data final" <% if(dataFinal!=null) %>value="<%=dataFinal%>"
							>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="hidden" name="id_turma" value="<%=id_turma%>">
						<button type="submit" class="btn btn-default">Salvar</button>
						<% if(id_turma!=null) %> <a href="FrontController?servlet=turmas">Cancelar edição</a>
					</div>
				</div>

			</form>
		</div>



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
						<th>Editar/Excluir</th>
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
						<td><a
							href="FrontController?servlet=editarTurmaComando&idTurma=<%=t.getId_turma()%>">Editar</a>
							/ <a
							href="FrontController?servlet=excluirTurmaComando&idTurma=<%=t.getId_turma()%>">Excluir</a></td>
					</tr>
					<%
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

