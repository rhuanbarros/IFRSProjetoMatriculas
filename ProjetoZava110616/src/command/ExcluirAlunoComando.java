package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlunoDao;
import dao.InstrutorDao;
import model.Aluno;

public class ExcluirAlunoComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, ServletException, Exception {

		verificaLoginInstrutor(request, response);

		String idAluno = request.getParameter("idAluno");
		
		Aluno aluno = new AlunoDao().findById(Long.parseLong( idAluno ));
		
		new AlunoDao().delete(aluno);

		new AlunosComando().executar(request, response);

	}

}
