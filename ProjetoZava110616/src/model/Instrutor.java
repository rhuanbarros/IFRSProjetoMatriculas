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
@Table(name = "Instrutor_0300152")
@SequenceGenerator(name = "SEQ_INSTRUTOR_0300152", sequenceName = "SEQ_INSTRUTOR_0300152", initialValue = 1, allocationSize=1)
public class Instrutor {
	private Long id_instrutor;
	private int matricula;
	private String senha;
	private String nome;
	private String email;
	private Double valor_hora;
	private String certificados;
	
	@OneToMany(mappedBy="turma")
	private List<Turma> listaTurma;
		
	public Instrutor(int matricula, String senha, String nome, String email, Double valor_hora, String certificados) {
		super();
		this.matricula = matricula;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.valor_hora = valor_hora;
		this.certificados = certificados;	
		
	}
	
	public Instrutor() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_INSTRUTOR_0300152")
	@Column(name="id_instrutor")
	public Long getId_instrutor() {
		return id_instrutor;
	}
	public void setId_instrutor(Long id_instrutor) {
		this.id_instrutor = id_instrutor;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Double getValor_hora() {
		return valor_hora;
	}
	public void setValor_hora(Double valor_hora) {
		this.valor_hora = valor_hora;
	}
	public String getCertificados() {
		return certificados;
	}
	public void setCertificados(String certificados) {
		this.certificados = certificados;
	}
	
}
