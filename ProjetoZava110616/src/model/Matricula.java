package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Matricula_0300152")
@SequenceGenerator(name = "SEQ_MATRICULA_0300152", sequenceName = "SEQ_MATRICULA_0300152", initialValue = 1, allocationSize=1)

public class Matricula {
	private Long id_matricula;
	private Turma turma;
	private Aluno aluno;
	private String data_matricula;
	
	public Matricula(Turma turma, Aluno aluno, String data_matricula) {
		super();
		this.turma = turma;
		this.aluno = aluno;
		
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //LocalDate date = LocalDate.parse(data_matricula, formatter);
		this.data_matricula = data_matricula;
		
		
	}
	
	public Matricula() {
		
	}
	
	public void setId_matricula(Long id_matricula) {
		this.id_matricula = id_matricula;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public void setData_matricula(String data_matricula) {
		this.data_matricula = data_matricula;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MATRICULA_0300152")
	@Column(name="id_matricula")	
	public Long getId_matricula() {
		return id_matricula;
	}
	
	@OneToOne
    @JoinColumn(name="id_turma")
	public Turma getTurma() {
		return turma;
	}
	
	@OneToOne
    @JoinColumn(name="id_aluno")
	public Aluno getAluno() {
		return aluno;
	}
	
	@Column(name="data_matricula")
	public String getData_matricula() {
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		//return data_matricula.format(formatter);
		return data_matricula;
	}	
	
    
}
