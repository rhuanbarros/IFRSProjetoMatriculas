package dao;

import java.util.ArrayList;
import java.util.List;

import models.Aluno;
import models.Curso;
import models.Instrutor;
import models.Matricula;
import models.Turma;

public class Dao {
	static private List<Curso> cursos = new ArrayList<>();
	static private List<Aluno> alunos = new ArrayList<>();
	static private List<Matricula> matriculas = new ArrayList<>();
	static private List<Instrutor> instrutores = new ArrayList<>();
	static private List<Turma> turmas = new ArrayList<>();
	
	public static List<Curso> getCursos() {
		return cursos;
	}

	public static List<Aluno> getAlunos() {
		return alunos;
	}

	public static List<Matricula> getMatriculas() {
		return matriculas;
	}

	public static List<Instrutor> getInstrutores() {
		return instrutores;
	}

	public static List<Turma> getTurmas() {
		return turmas;
	}

	static {
		System.out.println("FOI O STATICO");
		
		Aluno aluno1 = new Aluno(1234, "1234", "Aluno1", "aluno1@if","5144556611", "26/08/1986" );
		Aluno aluno2 = new Aluno(4321, "4321", "Aluno2", "aluno2@if","5177556611", "02/05/1992" );
		alunos.add(aluno1);
		alunos.add(aluno2);
		
		Instrutor instrutor1 = new Instrutor(1234, "1234", "Instrutor1", "instrutor1@ifrs", 100.00D, "Webdesign");
		Instrutor instrutor2 = new Instrutor(4321, "4321", "Instrutor2", "instrutor2@ifrs", 150.00D, "Estrutura de Dados");
		instrutores.add(instrutor1);
		instrutores.add(instrutor2);
		
		Curso curso1 = new Curso("Webdesign", "Nenhum", 60, 499.00D);
		Curso curso2 = new Curso("Estrutura de Dados", "Nenhum", 40, 399.00D);
		cursos.add(curso1);
		cursos.add(curso2);
		
		Turma turma1 = new Turma(instrutor1, curso1, "20/06/2016", "25/06/2016" );
		Turma turma2 = new Turma(instrutor2, curso2, "20/06/2016", "25/06/2016" );
		
		turmas.add(turma1);
		turmas.add(turma2);
		
		Matricula matricula1 = new Matricula(turma1, aluno1, "18/06/2016");
		Matricula matricula2 = new Matricula(turma2, aluno2, "17/06/2016");
		matriculas.add(matricula1);
		matriculas.add(matricula2);
	}
	
}
