package br.com.egr.banco.model;

public class Relatorio {
	
	public double calcularImposto(Cliente c) {
		double impostos = 0;
		for (Produto p : c.getProdutos()) {
			impostos += p.valorImposto(); 
			System.out.println("OIOIOIOIOIO");
			System.out.println("\n  Chegou aqui, valor do imposto: " + impostos);
		}
		return impostos;
	}
	
	public double calcularImposto(Produto p) {
//		System.out.println("Valor do imposto: ");
		return p.valorImposto();
	}
}
