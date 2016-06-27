<%@page import="java.util.List"%>
<%@page import="model.Curso"%>
<%@page import="model.Instrutor"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Campus Digital - Cursos</title>
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
		List<Curso> cursos = (List<Curso>) request.getAttribute("cursos");
		
		Long id_curso = (Long) request.getAttribute("id_curso");
		String nome_ = (String) request.getAttribute("nome");
		String requisito = (String) request.getAttribute("requisito");
		Integer cargaHoraria = (Integer) request.getAttribute("cargaHoraria");
		Double preco = (Double) request.getAttribute("preco");
	%>

	<div class="container">
		<div class="row">
			<h3 class="page-header">Formulário curso</h3>
		</div>
		<div class="row">
			<form class="form-horizontal" role="form" action="FrontController?servlet=inserirCurso"
				method="post">

				<div class="form-group">
					<label class="control-label col-sm-2" for="nome">Nome</label>
					<div class="col-xs-3">
						<input type="text" class="form-control" name="nome"
							placeholder="Informe o nome"  <% if(nome_!=null) %>value="<%=nome_%>"
							>
					</div>

				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="nome">Requisito</label>
					<div class="col-xs-3">
						<input type="text" class="form-control" name="requisito"
							placeholder="Informe o requisito"  <% if(requisito !=null) %>value="<%=requisito%>"
							>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="nome">Carga horária</label>
					<div class="col-xs-3">
						<input type="text" class="form-control" name="cargaHoraria"
							placeholder="Informe a carga horária"  <% if(cargaHoraria !=null) %>value="<%=cargaHoraria%>"
							>
					</div>
				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="nome">Preço</label>
					<div class="col-xs-3">
						<input type="text" class="form-control" name="preco"
							placeholder="Informe o preço"  <% if(preco !=null) %>value="<%=preco%>"
							>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="hidden" name="id_curso" value="<%=id_curso%>">
						<button type="submit" class="btn btn-default">Salvar</button>
						<% if(nome_!=null) %> <a href="FrontController?servlet=cursos">Cancelar edição</a>
					</div>
				</div>

			</form>
		</div>

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
						<th>Editar/Excluir</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (Curso c : cursos) {
					%>
					<tr>
						<td><%=c.getNome()%></td>
						<td><%=c.getRequisito()%></td>
						<td><%=c.getCarga_horaria()%></td>
						<td><%=c.getPreco()%></td>
						<td><a href="FrontController?servlet=editarCursoComando&idCurso=<%=c.getId_curso()%>">Editar</a> / 
						<a href="FrontController?servlet=excluirCursoComando&idCurso=<%=c.getId_curso()%>">Excluir</a></td>
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

