package br.com.egr.banco.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	private String nome;
	private String endereco;
	private String telefone;
	private List<Produto> produtos;
	
	Cliente(String nome, String endereco, String telefone) {
		this.setNome(nome);
		this.setEndereco(endereco);
		this.setTelefone(telefone);
		this.produtos = new ArrayList<Produto>();
	}
	

	public void addCCorrente(int numero) {
		ContaCorrente cc = new ContaCorrente(numero);
		this.getProdutos().add(cc);
	}

	public void addCPoupanca(int numero) {
		this.getProdutos().add(new ContaPoupanca(numero));
	}

	public void addSeguro(int numero, double valor) {
		this.getProdutos().add(new Seguro(numero, valor));
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	
}
