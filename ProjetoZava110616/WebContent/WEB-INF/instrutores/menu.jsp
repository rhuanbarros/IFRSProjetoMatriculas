<%@page import="model.Instrutor"%>

<nav class="navbar navbar-inverse">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="FrontController?servlet=matriculas">Campus Digital</a>
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
			<li><a class="atalho" href="javascript: zoom(mais)" onFocus="javascript: zoom(mais)" accesskey="A" title="Aumenta 10%">Aumenta letra<span id="ksht4"></span></a></li>
			<li><a class="atalho" href="javascript: zoom(menos)" onFocus="javascript: zoom(menos)" accesskey="D" title="Diminui 10%">Diminui letra<span id="ksht5"></span></a></li>
			<li><a class="atalho" href="javascript: index=9;zoom(mais)" onFocus="javascript: index=9;zoom(mais)" accesskey="N" title="Tamanho Normal">Letra normal<span id="ksht6"></span></a></li>
		</ul>
		
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#"><span class="glyphicon glyphicon-user"></span>Instrutor logado: <%=nome%></a></li>
			<li><a href="../Logout"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
		</ul>

	</div>
</nav>