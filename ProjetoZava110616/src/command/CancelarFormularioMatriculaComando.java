package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MatriculaDao;
import model.Matricula;

public class CancelarFormularioMatriculaComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, ServletException, Exception {

		verificaLoginEstudante(request, response);

		String idturma = request.getParameter("idmatricula");
		
		Matricula matricula = new MatriculaDao().findById(Long.parseLong( idturma ));
		
		new MatriculaDao().delete(matricula);

		new FormularioMatriculaComando().executar(request, response);

	}

}
