package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.AlunoDao;
import dao.Dao;
import model.*;

public class LoginAlunoComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		String matricula_s = request.getParameter("matricula");
        String senha = request.getParameter("senha");

        HttpSession session = request.getSession();
        
        List<Aluno> alunos = new AlunoDao().findAll();
        Integer matricula = Integer.parseInt( matricula_s );
        
        for( Aluno a: alunos ) {
        	
            if( a.getMatricula() == matricula && a.getSenha().equals(senha) ) {
                session.setAttribute("usuario.logado", a);
                session.setAttribute("usuario.tipo", "aluno");
                System.out.printf("Usuario %s logado", a.getNome() );
                
                Comando formularioMatricula = new FormularioMatriculaComando();
                formularioMatricula.executar(request, response);
                return;
            }
        }
        
        //fazer login para professores tbm
        
        System.out.println("login e/ou senhas incorreto");
        RequestDispatcher rd = request.getRequestDispatcher("/index_alunos.jsp?msg=loginerror");
        rd.forward(request, response);
        return;

	}

}
