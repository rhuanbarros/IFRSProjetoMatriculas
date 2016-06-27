package command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.InstrutorDao;
import model.Instrutor;

public class EditarInstrutorComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, ServletException, Exception {

		verificaLoginInstrutor(request, response);
		
		String instrutor_s = request.getParameter("instrutor");
		Long instrutor_id = Long.parseLong(instrutor_s);
		Instrutor instrutor = new InstrutorDao().findById(instrutor_id);
		
		request.setAttribute("id_instrutor", instrutor.getId_instrutor());
		request.setAttribute("matricula", instrutor.getMatricula());
		request.setAttribute("nome", instrutor.getNome());
		request.setAttribute("email", instrutor.getEmail());
		request.setAttribute("valorHora", instrutor.getValor_hora());
		request.setAttribute("certificados", instrutor.getCertificados());
		
		List<Instrutor> instrutores = new InstrutorDao().findAll();
		
		request.setAttribute("instrutores", instrutores);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/instrutores/instrutores.jsp");
        rd.forward(request, response);

	}

}
