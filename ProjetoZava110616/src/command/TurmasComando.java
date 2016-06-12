package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import models.Curso;
import models.Turma;

public class TurmasComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, ServletException {

		verificaLoginInstrutor(request, response);
		
		List<Turma> turmas = Dao.getTurmas();
		request.setAttribute("turmas", turmas);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/instrutores/turmas.jsp");
        rd.forward(request, response);

	}

}
