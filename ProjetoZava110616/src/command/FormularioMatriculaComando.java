package command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MatriculaDao;
import dao.TurmaDao;
import model.Aluno;
import model.Matricula;
import model.Turma;

public class FormularioMatriculaComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, ServletException {
		
		verificaLoginEstudante(request, response);

		List<Turma> turmas = new TurmaDao().findAll();
		
		List<Matricula> matriculas = new MatriculaDao().findAll();
		
		HttpSession session = request.getSession();
		Aluno aluno = (Aluno) session.getAttribute("usuario.logado");
		
		List<Matricula> matriculas2 = new ArrayList();
		for( Matricula m : matriculas) {
			//System.out.println("===========>"+m.getTurma().getInstrutor().getMatricula() );
			//System.out.println("===========>"+m.getTurma().getInstrutor().getSenha() );
			if( m.getAluno().getId_aluno() == aluno.getId_aluno() )
				matriculas2.add(m);
		}
		
		request.setAttribute("turmas", turmas);
		request.setAttribute("matriculas", matriculas2);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/alunos/formulario_matricula.jsp");
        rd.forward(request, response);
	}

}
