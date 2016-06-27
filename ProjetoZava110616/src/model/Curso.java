package model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Curso_0300152")
@SequenceGenerator(name = "SEQ_CURSO_0300152", sequenceName = "SEQ_CURSO_0300152", initialValue = 1, allocationSize=1)
public class Curso {
	private Long id_curso;
	private String nome;
	private String requisito;
	private Integer carga_horaria;
	private Double preco;
	
	@OneToMany(mappedBy="turma")
	private List<Turma> listaTurma;	
	
	public Curso(String nome, String requisito, Integer carga_horaria, Double preco) {
		super();
		this.nome = nome;
		this.requisito = requisito;
		this.carga_horaria = carga_horaria;
		this.preco = preco;
		
		
	}
	
	
	
	public Curso() {

	}



	public void setId_curso(Long id_curso) {
		this.id_curso = id_curso;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setRequisito(String requisito) {
		this.requisito = requisito;
	}

	public void setCarga_horaria(Integer carga_horaria) {
		this.carga_horaria = carga_horaria;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public void setListaTurma(List<Turma> listaTurma) {
		this.listaTurma = listaTurma;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CURSO_0300152")	
	@Column(name="id_curso")
	public Long getId_curso() {
		return id_curso;
	}
	public String getNome() {
		return nome;
	}
	public String getRequisito() {
		return requisito;
	}
	
	public Integer getCarga_horaria() {
		return carga_horaria;
	}
	public Double getPreco() {
		return preco;
	}


}
