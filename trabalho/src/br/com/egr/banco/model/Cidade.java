package br.com.lucasfaria.projetoExemplo1.model;

public class Cidade {
	private int id;
	private String nome;
	private String estado;

	public String getNome() {
		return this.nome;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
}
