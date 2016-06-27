package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dao.MatriculaDao;
import model.Matricula;

public class MatriculasComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, ServletException {
		
		verificaLoginInstrutor(request, response);
		
		//List<Matricula> matriculas = Dao.getMatriculas();
		List<Matricula> matriculas = new MatriculaDao().findAll();
		
		request.setAttribute("matriculas", matriculas);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/instrutores/matriculas.jsp");
        rd.forward(request, response);
	}

}
