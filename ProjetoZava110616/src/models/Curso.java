package models;

public class Curso {
	private int id_curso;
	private String nome;
	private String requisito;
	private Integer carga_horaria;
	private Double preco;
	
	
	public Curso(String nome, String requisito, Integer carga_horaria, Double preco) {
		super();
		this.nome = nome;
		this.requisito = requisito;
		this.carga_horaria = carga_horaria;
		this.preco = preco;
		
		this.id_curso=getIdProximo();
	}
	
	public int getId_curso() {
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



	private static int idProximo=0;
    private static int getIdProximo() {
        return idProximo++;
    }
}
