package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InstrutorDao;
import model.Instrutor;

public class InserirInstrutorComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		verificaLoginInstrutor(request, response);
		
		String matricula_s = request.getParameter("matricula");
		String senha_s = request.getParameter("senha");
		String nome_s = request.getParameter("nome");
		String email_s = request.getParameter("email");
		String valor_hora_s = request.getParameter("valor_hora");
		String certificados_s = request.getParameter("certificados");

		Integer matricula = Integer.parseInt(matricula_s);
		Double valor_hora = Double.parseDouble(valor_hora_s);
		
		String id_instrutor = request.getParameter("id_instrutor");
		Instrutor instrutor = null;
		if(!id_instrutor.equals("null")) {
			System.out.println("=======================> FOI");
			instrutor = new InstrutorDao().findById(Long.parseLong( id_instrutor) );
			instrutor.setMatricula(matricula);
			instrutor.setSenha(senha_s);
			instrutor.setNome(nome_s);
			instrutor.setEmail(email_s);
			instrutor.setValor_hora(valor_hora);
			instrutor.setCertificados(certificados_s);
			
			new InstrutorDao().update(instrutor);
		} else {
			instrutor = new Instrutor(matricula, senha_s, nome_s, email_s, valor_hora, certificados_s);
			
			new InstrutorDao().save(instrutor);
		}
		
		new InstrutoresComando().executar(request, response);
	}

}
