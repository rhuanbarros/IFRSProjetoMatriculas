package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CursoDao;
import model.Curso;

public class EditarCursoComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, ServletException, Exception {

		verificaLoginInstrutor(request, response);

		String idCurso = request.getParameter("idCurso");
		Curso curso = new CursoDao().findById( Long.parseLong(idCurso) );

		request.setAttribute("id_curso", curso.getId_curso());
		request.setAttribute("nome", curso.getNome());
		request.setAttribute("requisito", curso.getRequisito());
		request.setAttribute("cargaHoraria", curso.getCarga_horaria());
		request.setAttribute("preco", curso.getPreco());

		new CursosComando().executar(request, response);

	}

}
