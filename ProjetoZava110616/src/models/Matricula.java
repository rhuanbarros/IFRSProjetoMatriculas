package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Matricula {
	private int id_matricula;
	private Turma turma;
	private Aluno aluno;
	private LocalDate data_matricula;
	
	public Matricula(Turma turma, Aluno aluno, String data_matricula) {
		super();
		this.turma = turma;
		this.aluno = aluno;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(data_matricula, formatter);
		this.data_matricula = date;
		
		this.id_matricula = getIdProximo();
	}
	
	public int getId_matricula() {
		return id_matricula;
	}
	public Turma getTurma() {
		return turma;
	}
	public Aluno getAluno() {
		return aluno;
	}
	public LocalDate getData_matricula() {
		return data_matricula;
	}
	
	private static int idProximo=0;
    private static int getIdProximo() {
        return idProximo++;
    }
}
