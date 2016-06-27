package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlunoDao;
import dao.CursoDao;
import dao.InstrutorDao;
import dao.TurmaDao;
import model.Aluno;
import model.Curso;
import model.Instrutor;
import model.Turma;

public class InserirTurmaComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, ServletException, Exception {
		
		verificaLoginInstrutor(request, response);
		
		String instrutor_s = request.getParameter("instrutor");
		String curso_s = request.getParameter("curso");
		String dataInicial_s = request.getParameter("dataInicial");
		String dataFinal_s = request.getParameter("dataFinal");
		
		Long instrutor_id = Long.parseLong(instrutor_s);
		Long curso_id = Long.parseLong(curso_s);
		
		Instrutor instrutor = new InstrutorDao().findById(instrutor_id);
		Curso curso = new CursoDao().findById(curso_id);
		
		String id_turma = request.getParameter("id_turma");
		Turma turma = null;
		if(!id_turma.equals("null")) {
			turma = new TurmaDao().findById( Long.parseLong( id_turma) );
			turma.setInstrutor(instrutor);
			turma.setCurso(curso);
			turma.setData_inicio(dataInicial_s);
			turma.setData_final(dataFinal_s);
			
			new TurmaDao().update(turma);
		} else {
			turma = new Turma( instrutor, curso, dataInicial_s, dataFinal_s);
			new TurmaDao().save(turma);
		}
		
		new TurmasComando().executar(request, response);
	}

}
