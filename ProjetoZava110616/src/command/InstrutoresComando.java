package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.Dao;
import dao.InstrutorDao;
import model.Instrutor;
import model.Matricula;

public class InstrutoresComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, ServletException {
		
		verificaLoginInstrutor(request, response);
		
		//List<Instrutor> instrutores = Dao.getInstrutores();
		List<Instrutor> instrutores = new InstrutorDao().findAll();
		
		request.setAttribute("instrutores", instrutores);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/instrutores/instrutores.jsp");
        rd.forward(request, response);
	}

}
