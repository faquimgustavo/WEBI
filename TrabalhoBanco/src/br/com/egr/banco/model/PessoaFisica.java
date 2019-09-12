package br.com.egr.banco.model;

public class PessoaFisica extends Cliente {
	private String cpf;
	private String nomeMae;
	private String nomePai;
	
	PessoaFisica(String nome, String endereco, String telefone, String cpf) {
		super(nome, endereco, telefone);
		this.cpf = cpf;
	}
	
	
}
