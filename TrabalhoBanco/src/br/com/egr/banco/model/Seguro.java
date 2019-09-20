package br.com.egr.banco.model;

public class Seguro implements Produto {
	private int numero;
	private double valor;
	private boolean situacao;

	public Seguro() {
		
	}
	
	public Seguro(int numero, double valor) {
		this.setNumero(numero);
		this.valor = valor;
		this.situacao = true;
	}

	@Override
	public double valorImposto() {
		return (this.getValor() * 0.03) + 50;
	}

	public double getValor() {
		return valor;
	}

	/*@Override
	public String getTipo() {
		return "seguro";
	}*/

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public void setValor(int numero) {
		this.valor = numero;
	}

	public boolean getSituacao() {
		return situacao;
	}
	
}