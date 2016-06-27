package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Aluno;
import model.Instrutor;

public abstract class Comando {
	
	public abstract void executar(HttpServletRequest request, HttpServletResponse response) 
			throws ClassNotFoundException, IOException, ServletException, Exception;
	
	public void verificaLoginEstudante(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String usuarioTipo = (String) session.getAttribute("usuario.tipo");
        if( usuarioTipo != null ) {
	        if( usuarioTipo.equals("aluno") ) {
	        	Aluno usuarioLogado = (Aluno) session.getAttribute("usuario.logado");
		        if( usuarioLogado != null ) { //aluno logado
		            System.out.println("Aluno logado matricula: "+usuarioLogado.getMatricula() );
		        } 
	        }
        
        } else {    //usuario nao logado
            System.out.println("ACESSO RESTRITO - Faça login.");
            
            RequestDispatcher rd = request.getRequestDispatcher("/index_alunos.jsp");
            rd.forward(request, response);
            return;
        }
	}
	
	public void verificaLoginInstrutor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        String usuarioTipo = (String) session.getAttribute("usuario.tipo");
        if( usuarioTipo != null ) {
	        if( usuarioTipo.equals("instrutor") ) {
	        	Instrutor usuarioLogado = (Instrutor) session.getAttribute("usuario.logado");
		        if( usuarioLogado != null ) { //logado
		            System.out.println("Instrutor logado matricula: "+usuarioLogado.getMatricula() );
		        } 
	        }
        
        } else {    //usuario nao logado
            System.out.println("ACESSO RESTRITO - Faça login.");
            
            RequestDispatcher rd = request.getRequestDispatcher("/index_instrutores.jsp");
            rd.forward(request, response);
            return;
        }
	}
}
