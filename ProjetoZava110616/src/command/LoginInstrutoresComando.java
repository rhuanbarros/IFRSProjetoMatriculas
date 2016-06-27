package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Dao;
import dao.InstrutorDao;
import model.Instrutor;

public class LoginInstrutoresComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, ServletException {
		String matricula_s = request.getParameter("matricula");
        String senha = request.getParameter("senha");

        HttpSession session = request.getSession();
        
        //List<Instrutor> instrutores = Dao.getInstrutores();
        List<Instrutor> instrutores = new InstrutorDao().findAll();
        
        Integer matricula = Integer.parseInt( matricula_s );
        
        for( Instrutor i: instrutores ) {
            if( i.getMatricula() == matricula && i.getSenha().equals(senha) ) {
                session.setAttribute("usuario.logado", i);
                session.setAttribute("usuario.tipo", "instrutor");
                System.out.printf("Usuario %s logado", i.getNome() );
                
                new MatriculasComando().executar(request, response);
                //new AlunosComando().executar(request, response);
                return;
            }
        }
        
        System.out.println("login e/ou senhas incorreto");
        RequestDispatcher rd = request.getRequestDispatcher("/index_instrutores.jsp?msg=loginerror");
        rd.forward(request, response);
        return;

	}

}
