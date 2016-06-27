package command;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MatriculaDao;
import dao.TurmaDao;
import model.Aluno;
import model.Matricula;
import model.Turma;

public class SalvarFormularioMatriculaComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, ServletException, Exception {
		
		verificaLoginEstudante(request, response);

		String idturma = request.getParameter("idturma");
		
		Turma turma = new TurmaDao().findById(Long.parseLong( idturma ) );
		HttpSession session = request.getSession();
		Aluno aluno = (Aluno) session.getAttribute("usuario.logado");
		
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Matricula matricula = new Matricula(turma, aluno, hoje.format(formatador) );
		
		new MatriculaDao().save(matricula);

		new FormularioMatriculaComando().executar(request, response);

	}

}
