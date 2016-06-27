package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Aluno_0300152")
@SequenceGenerator(name = "SEQ_ALUNO_0300152", sequenceName = "SEQ_ALUNO_0300152", initialValue = 1, allocationSize=1)
public class Aluno {
	private Long id_aluno;
	private int matricula;
	private String senha;
	private String nome;
	private String email;
	private String fone;
	private String data_nascimento;
	
	
	
	public Aluno(int matricula, String senha, String nome, String email, String fone, String data_nascimento) {
		super();
		this.matricula = matricula;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.fone = fone;
		
		/*DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(data_nascimento, formatter);
        this.data_nascimento = date;*/
		
		this.data_nascimento = data_nascimento;
		
	}
	
	public Aluno(){
		
	}

	public void setId_aluno(Long id_aluno) {
		this.id_aluno = id_aluno;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	/*public void setData_nascimento(LocalDate data_nascimento) {
		this.data_nascimento = data_nascimento;
	}*/

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ALUNO_0300152")
	@Column(name="id_aluno")
	public Long getId_aluno() {
		return id_aluno;
	}



	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public String getEmail() {
		return email;
	}

	public String getFone() {
		return fone;
	}

	/*public String getData_nascimento() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return data_nascimento.format(formatter);
	}*/

	public int getMatricula() {
		return matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSenha() {
		return senha;
	}	
	
}