package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlunoDao;
import model.Aluno;

public class AlunosComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, ServletException {
		
		verificaLoginInstrutor(request, response);
		
		//List<Aluno> alunos = Dao.getAlunos();
		List<Aluno> alunos = new AlunoDao().findAll();
		
		request.setAttribute("alunos", alunos);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/instrutores/alunos.jsp");
        rd.forward(request, response);

	}

}
