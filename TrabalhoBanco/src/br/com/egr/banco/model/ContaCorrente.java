package br.com.egr.banco.model;
public class ContaCorrente extends Conta {
	
	public ContaCorrente() {
		
	}

	public ContaCorrente(int numero) {
		super(numero);
		
	}


	@Override
	public boolean sacar(double valor) {
//		calculo de 1% do valor sacado
		double taxa = valor * (1.0 / 100);
		
//		chamada ao método sacar() da super classe
		return super.sacar(valor + taxa);
	}

	@Override
	public double valorImposto() {
		return this.getSaldo() * 0.05;
	}

	/*@Override
	public String getTipo() {
		return "corrente";
	}*/
}
