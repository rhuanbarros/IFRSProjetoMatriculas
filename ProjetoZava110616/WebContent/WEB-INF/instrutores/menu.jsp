<%@page import="models.Instrutor"%>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="Principal">Clínica Médica</a>
		</div>
		<%
			Instrutor instrutor = (Instrutor) session.getAttribute("usuario.logado");
			String nome = "";
			if (instrutor != null ) {
				nome = instrutor.getNome();
			}
		%>
		<ul class="nav navbar-nav">
			<li><a href="FrontController?servlet=matriculas">Matrículas</a></li>
			<li><a href="FrontController?servlet=instrutores">Instrutores</a></li>
			<li><a href="FrontController?servlet=alunos">Alunos</a></li>
			<li><a href="FrontController?servlet=cursos">Cursos</a></li>
			<li><a href="FrontController?servlet=turmas">Turmas</a></li>
		</ul>

		<ul class="nav navbar-nav navbar-right">
			<li><a href="#"><span class="glyphicon glyphicon-user"></span>Instrutor logado: <%=nome%></a></li>
			<li><a href="../Logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
		</ul>

	</div>
</nav>