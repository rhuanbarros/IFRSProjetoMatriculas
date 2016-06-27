package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InstrutorDao;
import dao.TurmaDao;
import model.Turma;

public class ExcluirTurmaComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, ServletException, Exception {
		
		verificaLoginInstrutor(request, response);

		String idTurma = request.getParameter("idTurma");
		
		Turma turma = new TurmaDao().findById(Long.parseLong( idTurma ));
		
		new TurmaDao().delete(turma);

		new TurmasComando().executar(request, response);

	}

}
