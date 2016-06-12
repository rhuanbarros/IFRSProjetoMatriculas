package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Aluno {
	private int id_aluno;
	private int matricula;
	private String senha;
	private String nome;
	private String email;
	private String fone;
	private LocalDate data_nascimento;
	
	
	
	public Aluno(int matricula, String senha, String nome, String email, String fone, String data_nascimento) {
		super();
		this.matricula = matricula;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.fone = fone;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(data_nascimento, formatter);
        this.data_nascimento = date;
		
		this.id_aluno = getIdProximo();
	}

	public int getMatricula() {
		return matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSenha() {
		return senha;
	}	
	
	private static int idProximo=0;
    private static int getIdProximo() {
        return idProximo++;
    }
}