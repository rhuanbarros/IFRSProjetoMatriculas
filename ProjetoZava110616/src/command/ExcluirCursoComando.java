package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CursoDao;
import dao.InstrutorDao;
import model.Curso;

public class ExcluirCursoComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, ServletException, Exception {

		verificaLoginInstrutor(request, response);

		String idCurso = request.getParameter("idCurso");
		
		Curso curso = new CursoDao().findById(Long.parseLong( idCurso ));
		
		new CursoDao().delete( curso );

		new CursosComando().executar(request, response);

	}

}
