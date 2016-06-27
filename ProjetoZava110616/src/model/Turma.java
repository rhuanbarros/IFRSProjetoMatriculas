package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Turma_0300152")
@SequenceGenerator(name = "SEQ_TURMA_0300152", sequenceName = "SEQ_TURMA_0300152", initialValue = 1, allocationSize=1)

public class Turma {
	private Long id_turma;
	private Instrutor instrutor;
	
	@OneToOne(cascade = CascadeType.REFRESH)
	@JoinColumn(name = "curso", unique = false)	
	private Curso curso;
	private String data_inicio;
	private String data_final;

	public Turma(Instrutor instrutor, Curso curso, String data_inicio, String data_final) {
		super();
		this.instrutor = instrutor;
		this.curso = curso;
		
		/*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(data_inicio, formatter);
		this.data_inicio = date;
		
        LocalDate date2 = LocalDate.parse(data_final, formatter);
		this.data_final = date2;*/
		
		this.data_inicio = data_inicio;
		this.data_final = data_final;
	}
	
	public Turma() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TURMA_0300152")
	@Column(insertable =false, updatable =false, name="id_turma")	
	public Long getId_turma() {
		return id_turma;
	}
	
	@ManyToOne
	@JoinColumn(name="id_instrutor", referencedColumnName="id_instrutor")
	public Instrutor getInstrutor() {
		return instrutor;
	}
	
	@ManyToOne
	@JoinColumn(name="id_curso", referencedColumnName="id_curso")
	public Curso getCurso() {
		return curso;
	}
	
	/*public String getData_inicio() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return data_inicio.format(formatter);
	}
	public String getData_final() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return data_final.format(formatter);
	}*/

	public void setId_turma(Long id_turma) {
		this.id_turma = id_turma;
	}

	public void setInstrutor(Instrutor instrutor) {
		this.instrutor = instrutor;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}

	public String getData_final() {
		return data_final;
	}

	public void setData_final(String data_final) {
		this.data_final = data_final;
	}

	/*public void setData_inicio(LocalDate data_inicio) {
		this.data_inicio = data_inicio;
	}

	public void setData_final(LocalDate data_final) {
		this.data_final = data_final;
	}*/
	
}

