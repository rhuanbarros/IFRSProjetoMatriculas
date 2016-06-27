<%@page import="java.util.List"%>
<%@page import="model.Aluno"%>
<%@page import="model.Instrutor"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Campus Digital - Alunos</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7"
	crossorigin="anonymous">
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
        <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	
	<link rel="stylesheet" type="text/css" media="screen" href="http://tarruda.github.com/bootstrap-datetimepicker/assets/css/bootstrap-datetimepicker.min.css">
</head>
<body>
	<%@ include file="menu.jsp"%>

	<%
		List<Aluno> alunos = (List<Aluno>) request.getAttribute("alunos");
	
		Long id_aluno = (Long) request.getAttribute("id_aluno");
		Integer matricula = (Integer) request.getAttribute("matricula");
		String nome_ = (String) request.getAttribute("nome");
		String email = (String) request.getAttribute("email");
		String telefone = (String) request.getAttribute("telefone");
		String data_nascimento = (String) request.getAttribute("data_nascimento");
	
	%>

	<div class="container">
		<div class="row"  id="esse">
			<h3 class="page-header">Formulário aluno</h3>
		</div>
		<div class="row">
			<form class="form-horizontal" role="form"
				action="FrontController?servlet=inserirAluno" method="post">

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
							placeholder="Informe o e-mail" <% if(email!=null) %>value="<%=email%>">
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="nome">Telefone</label>
					<div class="col-xs-3">
						<input type="text" class="form-control" 
							name="telefone" placeholder="Informe o telefone" <% if(telefone!=null) %>value="<%=telefone%>"
							>
					</div>
				</div>

				<div class="form-group">
					<label class="control-label col-sm-2" for="nome">Data de nascimento</label>
					<div class="col-xs-3">
						<div id="datetimepicker" class="input-append date">
	                        <input type="text" class="form-control" name="dataNascimento" <% if(data_nascimento!=null) %>value="<%=data_nascimento%>" 
	                        >
	                        <span class="add-on"><i data-time-icon="icon-time" data-date-icon="icon-calendar"></i></span>
	                    </div>
                    </div>
				</div>

				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="hidden" name="id_aluno" value="<%=id_aluno%>">
						<button type="submit" class="btn btn-default">Salvar</button>
						<% if(matricula!=null) %> <a href="FrontController?servlet=alunos">Cancelar edição</a>
					</div>
				</div>

			</form>
		</div>


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
						<th>Editar/Excluir</th>
					</tr>
				</thead>
				<tbody>
					<%
						for (Aluno a : alunos) {
					%>
					<tr>
						<td><%=a.getMatricula()%></td>
						<td><%=a.getNome()%></td>
						<td><%=a.getEmail()%></td>
						<td><%=a.getFone()%></td>
						<td><%=a.getData_nascimento()%></td>
						<td><a href="FrontController?servlet=editarAlunoComando&idAluno=<%=a.getId_aluno()%>">Editar</a> / 
						<a href="FrontController?servlet=excluirAlunoComando&idAluno=<%=a.getId_aluno()%>">Excluir</a></td>
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
	
	  <script type="text/javascript"
                        src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.8.3/jquery.min.js">
                </script> 
                <script type="text/javascript"
                        src="http://netdna.bootstrapcdn.com/twitter-bootstrap/2.2.2/js/bootstrap.min.js">
                </script>
	
	<script type="text/javascript"
                        src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.min.js">
                </script>
                <script type="text/javascript"
                        src="http://tarruda.github.com/bootstrap-datetimepicker/assets/js/bootstrap-datetimepicker.pt-BR.js">
                </script>
                <script type="text/javascript">
                    $('#datetimepicker').datetimepicker({
                        format: 'dd/MM/yyyy',
                        language: 'pt-BR'
                    });
                </script>

<script language="javascript" src="textzoom.js" type="text/javascript"></script>
	
</body>
</html>

