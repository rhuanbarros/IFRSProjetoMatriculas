package models;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Turma {
	private int id_turma;
	private Instrutor instrutor;
	private Curso curso;
	private LocalDate data_inicio;
	private LocalDate data_final;
	//private Integer carga_horaria;
	
	public Turma(Instrutor instrutor, Curso curso, String data_inicio, String data_final ) {
		super();
		this.instrutor = instrutor;
		this.curso = curso;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate date = LocalDate.parse(data_inicio, formatter);
		this.data_inicio = date;
		
        LocalDate date2 = LocalDate.parse(data_final, formatter);
		this.data_final = date2;
		
		this.id_turma = getIdProximo();
	}
	
	public int getId_turma() {
		return id_turma;
	}
	public Instrutor getInstrutor() {
		return instrutor;
	}
	public Curso getCurso() {
		return curso;
	}
	public String getData_inicio() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return data_inicio.format(formatter);
	}
	public String getData_final() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return data_final.format(formatter);
	}
	
	private static int idProximo=0;
    private static int getIdProximo() {
        return idProximo++;
    }
}
