package command;

import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	HashMap<String,String> controle;
	private static final Logger log= Logger.getLogger( FrontController.class.getName() );
    
    //@see HttpServlet#HttpServlet()
    public FrontController() {
        super();
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
       	super.init(config);
       	
        controle = new HashMap<>();
        //alunos
        controle.put("loginAluno", "command.LoginAlunoComando");
        controle.put("form_matricula", "command.FormularioMatriculaComando");
        
        //instrutores
        controle.put("loginInstrutores", "command.LoginInstrutoresComando");
        controle.put("matriculas", "command.MatriculasComando");
        
        //logout para os dois
        controle.put("logout", "command.LogoutComando");
        
    }

    //@see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servlet = request.getParameter("servlet");

        Comando cmd;
        try {
            cmd = (Comando) Class.forName((String) controle.get(servlet)).newInstance();
            cmd.executar(request, response);
        } catch (Exception e) {
        	log.log(Level.SEVERE, null, e);
			e.printStackTrace();
		}
		
	}

	//@see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
