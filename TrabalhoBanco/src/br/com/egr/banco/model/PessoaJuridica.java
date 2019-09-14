package br.com.egr.banco.model;

public class PessoaJuridica extends Cliente {
	private String cnpj;
	private String nomeFantasia;
	
	public PessoaJuridica(String nome, String endereco, String telefone, String cnpj, String nomeFantasia) {
		super(nome, endereco, telefone);
		this.setCnpj(cnpj);
		this.setNomeFantasia(nomeFantasia);
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
}
