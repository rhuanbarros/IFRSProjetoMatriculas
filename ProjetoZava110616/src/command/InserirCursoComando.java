package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlunoDao;
import dao.CursoDao;
import model.Aluno;
import model.Curso;

public class InserirCursoComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response) throws Exception {

		verificaLoginInstrutor(request, response);

		String nome = request.getParameter("nome");
		String requisito = request.getParameter("requisito");
		String cargaHoraria_s = request.getParameter("cargaHoraria");
		String preco_s = request.getParameter("preco");

		Integer cargaHoraria = Integer.parseInt(cargaHoraria_s);
		Double preco = Double.parseDouble(preco_s);

		String id_curso = request.getParameter("id_curso");
		Curso curso = null;
		if (!id_curso.equals("null")) {
			curso = new CursoDao().findById(Long.parseLong(id_curso));
			curso.setNome(nome);
			curso.setRequisito(requisito);
			curso.setCarga_horaria(cargaHoraria);
			curso.setPreco(preco);

			new CursoDao().update(curso);
		} else {
			curso = new Curso(nome, requisito, cargaHoraria, preco);
			new CursoDao().save(curso);
		}

		new CursosComando().executar(request, response);
	}

}
