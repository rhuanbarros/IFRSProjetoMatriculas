<%@page import="model.Aluno"%>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="FrontController?servlet=matriculas">Campus Digital</a>
		</div>
		<%
			Aluno aluno = (Aluno) session.getAttribute("usuario.logado");
			String nome = "";
			if (aluno != null ) {
				nome = aluno.getNome();
			}
		%>
		<ul class="nav navbar-nav">
			
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="#"><span class="glyphicon glyphicon-user"></span>Usuário logado: <%=nome%></a></li>
			<li><a href="../Logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
		</ul>

	</div>
</nav>