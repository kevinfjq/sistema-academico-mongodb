package model;

public class Aluno {
	private int ra;
	private String nome;
	private String email;
	private String dataNascimento;
	private String endereco;
	private String  periodo;
	
	public int getRa() {
		return ra;
	}
	
	public void setRa(int ra) {
		this.ra = ra;
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
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getPeriodo() {
		return periodo;
	}
	
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	
	public Aluno() {
	}
	
	public Aluno(int ra, String nome, String email, String dataNascimento, String endereco, String periodo) {
		this.ra = ra;
		this.nome = nome;
		this.email = email;
		this.dataNascimento = dataNascimento;
		this.endereco = endereco;
		this.periodo = periodo;
	}
	
	
}
