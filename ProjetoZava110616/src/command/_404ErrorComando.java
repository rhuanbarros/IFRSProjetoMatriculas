package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class _404ErrorComando extends Comando {

	@Override
	public void executar(HttpServletRequest request, HttpServletResponse response)
			throws ClassNotFoundException, IOException, ServletException {
		
		RequestDispatcher rd = request.getRequestDispatcher("404error.jsp");
        rd.forward(request, response);
	}

}
