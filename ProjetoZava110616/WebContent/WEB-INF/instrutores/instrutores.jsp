<%@page import="java.util.List"%>
<%@page import="model.Matricula"%>
<%@page import="model.Instrutor"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Campus Digital - Instrutores</title>
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
		List<Instrutor> instrutores = (List<Instrutor>) request.getAttribute("instrutores");
	
		Long id_instrutor = (Long) request.getAttribute("id_instrutor");
		Integer matricula = (Integer) request.getAttribute("matricula");
		String nome_ = (String) request.getAttribute("nome");
		String email = (String) request.getAttribute("email");
		Double valorHora = (Double) request.getAttribute("valorHora");
		String certificados = (String) request.getAttribute("certificados");
		
	
	%>

	<div class="container">



		<div class="row">
			<h3 class="page-header">Formulário</h3>
		</div>
		<div class="row">
			<form class="form-horizontal" role="form"
				action="FrontController?servlet=inserirInstrutor" method="post">

				<div class="form-group">
					<label class="control-label col-sm-2" for="nome">Matrícula</label>
					<div class="col-xs-3">
						<input type="text" class="form-control" name="matricula"
							placeholder="Informe a matrícula" <% if(matricula!=null) %>value="<%=matricula%>"
							>
					</div>

				</div>
				
				<div class="form-group">
					<label class="control-label col-sm-2" for="nome">Senha</label>
					<div class="col-xs-3">
						<input type="text" class="form-control" name="senha"
							placeholder="Informe a senha">
					</div>

				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="nome">Nome</label>
					<div class="col-xs-3">
						<input type="text" class="form-control" name="nome"
							placeholder="Informe o nome" <% if(nome_!=null) %>value="<%=nome_%>"
							>
					</div>

				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="nome">E-mail</label>
					<div class="col-xs-3">
						<input type="text" class="form-control" name="email"
							placeholder="Informe o e-mail" <% if(email!=null) %>value="<%=email%>"
							>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="nome">Valor hora</label>
					<div class="col-xs-3">
						<input type="text" class="form-control" name="valor_hora"
							placeholder="Informe o valor hora" <% if(valorHora!=null) %>value="<%=valorHora%>"
							>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="nome">Certificados</label>
					<div class="col-xs-3">
						<textarea class="form-control" name="certificados"
							placeholder="Informe os certificados"><% if(certificados!=null) %><%=certificados%>
							</textarea>
					</div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="hidden" name="id_instrutor" value="<%=id_instrutor%>">
						<button type="submit" class="btn btn-default">Salvar</button>
						<% if(matricula!=null) %> <a href="FrontController?servlet=instrutores">Cancelar edição</a>
					</div>
				</div>

			</form>
		</div>


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
						<th>Valor hora</th>
						<th>Certificados</th>
						<th>Editar/Excluir</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (Instrutor i : instrutores) {
					%>
					<tr>
						<td><%=i.getMatricula()%></td>
						<td><%=i.getNome()%></td>
						<td><%=i.getEmail()%></td>
						<td><%=i.getValor_hora()%></td>
						<td><%=i.getCertificados()%></td>
						<td><a href="FrontController?servlet=editarInstrutorComando&instrutor=<%=i.getId_instrutor()%>">Editar</a> / 
						<a href="FrontController?servlet=excluirInstrutorComando&instrutor=<%=i.getId_instrutor()%>">Excluir</a></td>
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

