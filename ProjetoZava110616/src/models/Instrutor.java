package models;

public class Instrutor {
	private int id_instrutor;
	private int matricula;
	private String senha;
	private String nome;
	private String email;
	private Double valor_hora;
	private String certificados;
		
	public Instrutor(int matricula, String senha, String nome, String email, Double valor_hora, String certificados) {
		super();
		this.matricula = matricula;
		this.senha = senha;
		this.nome = nome;
		this.email = email;
		this.valor_hora = valor_hora;
		this.certificados = certificados;
		
		this.id_instrutor=getIdProximo();
	}
	
	public int getId_instrutor() {
		return id_instrutor;
	}
	public void setId_instrutor(int id_instrutor) {
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

	private static int idProximo=0;
    private static int getIdProximo() {
        return idProximo++;
    }
}
