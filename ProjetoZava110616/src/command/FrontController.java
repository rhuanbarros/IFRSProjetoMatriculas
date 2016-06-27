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
        controle.put("salvarFormularioMatriculaComando", "command.SalvarFormularioMatriculaComando");
        controle.put("cancelarFormularioMatriculaComando", "command.CancelarFormularioMatriculaComando");
                
        //instrutores
        controle.put("loginInstrutores", "command.LoginInstrutoresComando");
        controle.put("matriculas", "command.MatriculasComando");
        controle.put("instrutores", "command.InstrutoresComando");
        controle.put("alunos", "command.AlunosComando");
        controle.put("cursos", "command.CursosComando");
        controle.put("turmas", "command.TurmasComando");
        controle.put("inserirCurso", "command.InserirCursoComando");
        controle.put("inserirAluno", "command.InserirAlunoComando");
        controle.put("inserirInstrutor", "command.InserirInstrutorComando");
        controle.put("inserirTurma", "command.InserirTurmaComando");
        controle.put("editarInstrutorComando", "command.EditarInstrutorComando");
        controle.put("editarAlunoComando", "command.EditarAlunoComando");
        controle.put("editarCursoComando", "command.EditarCursoComando");
        controle.put("editarTurmaComando", "command.EditarTurmaComando");
        controle.put("excluirInstrutorComando", "command.ExcluirInstrutorComando");
        controle.put("excluirAlunoComando", "command.ExcluirAlunoComando");
        controle.put("excluirCursoComando", "command.ExcluirCursoComando");
        controle.put("excluirTurmaComando", "command.ExcluirTurmaComando");
        
        //para os dois
        controle.put("logout", "command.LogoutComando");
        controle.put("404error", "command._404ErrorComando");
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String servlet = request.getParameter("servlet");

        Comando cmd;
        try {
        	String classe = controle.get(servlet);
			if (classe == null ) classe = controle.get("404error");
        		
            cmd = (Comando) Class.forName((String) classe).newInstance();
            cmd.executar(request, response);
        } catch (Exception e) {
        	log.log(Level.SEVERE, null, e);
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
