package br.com.egr.banco.model;

public class PessoaFisica extends Cliente {
	private String cpf;
	private String nomeMae;
	private String nomePai;
	
	public  PessoaFisica() {
		
	}
	public PessoaFisica(String nome, String endereco, String telefone, String cpf) {
		super(nome, endereco, telefone);
		this.cpf = cpf;
	}
	
	public PessoaFisica(String nome, String endereco, String telefone, String cpf, String nomeMae, String nomePai) {
		super(nome, endereco, telefone);
		this.cpf = cpf;
		this.nomeMae = nomeMae;
		this.nomePai = nomePai;
	}
	public String getCpf() {
		return this.cpf;
	}
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public String getNomePai() {
		return nomePai;
	}
	public void setNomePai(String nomePai) {
		this.nomePai = nomePai;
	}
	
	
}
