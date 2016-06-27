package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InstrutorDao;
import model.Instrutor;

public class ExcluirInstrutorComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, ServletException, Exception {
		
		verificaLoginInstrutor(request, response);

		String idInstrutor = request.getParameter("instrutor");
		
		Instrutor instrutor = new InstrutorDao().findById(Long.parseLong( idInstrutor ));
		
		new InstrutorDao().delete(instrutor);

		new InstrutoresComando().executar(request, response);

	}

}
