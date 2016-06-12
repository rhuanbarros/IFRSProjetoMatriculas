package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormularioMatriculaComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, ServletException {
		
		verificaLoginEstudante(request, response);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/formulario_matricula.jsp");
        rd.forward(request, response);
	}

}
