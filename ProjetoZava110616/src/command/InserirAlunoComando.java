package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlunoDao;
import dao.InstrutorDao;
import model.Aluno;
import model.Instrutor;

public class InserirAlunoComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		verificaLoginInstrutor(request, response);

		String matricula_s = request.getParameter("matricula");
		String senha_s = request.getParameter("senha");
		String nome_s = request.getParameter("nome");
		String email_s = request.getParameter("email");
		String telefone_s = request.getParameter("telefone");
		String dataNascimento_s = request.getParameter("dataNascimento");

		Integer matricula = Integer.parseInt(matricula_s);
		
		String id_aluno = request.getParameter("id_aluno");
		Aluno aluno = null;
		if(!id_aluno.equals("null")) {
			aluno = new AlunoDao().findById( Long.parseLong( id_aluno) );
			aluno.setMatricula(matricula);
			aluno.setSenha(senha_s);
			aluno.setNome(nome_s);
			aluno.setEmail(email_s);
			aluno.setFone(telefone_s);
			aluno.setData_nascimento(dataNascimento_s);
			
			new AlunoDao().update(aluno);
		} else {
			aluno = new Aluno(matricula, senha_s, nome_s, email_s, telefone_s, dataNascimento_s);
			new AlunoDao().save(aluno);
		}

		new AlunosComando().executar(request, response);

	}

}
