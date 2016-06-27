package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CursoDao;
import dao.InstrutorDao;
import dao.TurmaDao;
import model.Curso;
import model.Instrutor;
import model.Turma;

public class TurmasComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, ServletException {

		verificaLoginInstrutor(request, response);
		
		//List<Turma> turmas = Dao.getTurmas();
		List<Turma> turmas = new TurmaDao().findAll();
		List<Instrutor> instrutores = new InstrutorDao().findAll();
		List<Curso> cursos = new CursoDao().findAll();
		
		request.setAttribute("turmas", turmas);
		request.setAttribute("instrutores", instrutores);
		request.setAttribute("cursos", cursos);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/instrutores/turmas.jsp");
        rd.forward(request, response);

	}

}
