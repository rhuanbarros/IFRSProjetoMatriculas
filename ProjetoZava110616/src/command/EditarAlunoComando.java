package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlunoDao;
import dao.InstrutorDao;
import model.Aluno;
import model.Instrutor;

public class EditarAlunoComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, ServletException, Exception {

		verificaLoginInstrutor(request, response);
		
		String idAluno = request.getParameter("idAluno");
		Aluno aluno = new AlunoDao().findById( Long.parseLong(idAluno) );
		
		request.setAttribute("id_aluno", aluno.getId_aluno() );
		request.setAttribute("matricula", aluno.getMatricula());
		request.setAttribute("nome", aluno.getNome());
		request.setAttribute("email", aluno.getEmail());
		request.setAttribute("telefone", aluno.getFone());
		request.setAttribute("data_nascimento", aluno.getData_nascimento() );
		
		new AlunosComando().executar(request, response);

	}

}
