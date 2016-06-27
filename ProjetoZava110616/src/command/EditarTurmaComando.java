package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.TurmaDao;
import model.Turma;

public class EditarTurmaComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, ServletException, Exception {

		verificaLoginInstrutor(request, response);

		String idTurma = request.getParameter("idTurma");
		Turma turma = new TurmaDao().findById(Long.parseLong(idTurma));

		request.setAttribute("id_turma", turma.getId_turma() );
		request.setAttribute("id_instrutor", turma.getInstrutor().getId_instrutor());
		request.setAttribute("id_curso", turma.getCurso().getId_curso() );
		request.setAttribute("dataInicio", turma.getData_inicio() );
		request.setAttribute("dataFinal", turma.getData_final() );

		new TurmasComando().executar(request, response);

	}

}
