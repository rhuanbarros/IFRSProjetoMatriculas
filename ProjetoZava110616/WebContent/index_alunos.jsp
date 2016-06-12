<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Campus Digital - Login alunos</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">
        <link rel="stylesheet" href="login.css" >
    </head>
    <body>
        
        <%
            String msg = request.getParameter("msg");
            if( msg != null && msg.equals("loginerror")  ) {
        %>
            <br>
            <br>
            <div class="alert alert-warning">
                <strong>Atenção</strong> Nome do usuário ou senha inválidos.
            </div>
        <% } %>
        
        <div class="login-page">
          <div class="form">
              <form class="login-form" method="post" action="FrontController">
                  <input autofocus type="text" placeholder="matricula" name="matricula"/>
                  <input type="password" placeholder="senha" name="senha"/>
                  <input type="hidden" name="servlet" value="loginAluno">
              <button>login</button>
            </form>
          </div>
        </div>
        
        
        <footer class="footer">
            <div class="container">
                <p>Copyright © 2016 Rhuan Barros & Diego Szmidtke</p>
            </div>
        </footer>
        
        
    </body>
</html>
