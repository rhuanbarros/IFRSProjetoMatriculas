package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CursoDao;
import model.Curso;

public class CursosComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, ServletException {
		
		verificaLoginInstrutor(request, response);
		
		//List<Curso> cursos = Dao.getCursos();
		List<Curso> cursos = new CursoDao().findAll();
		
		request.setAttribute("cursos", cursos);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/instrutores/cursos.jsp");
        rd.forward(request, response);

	}

}
