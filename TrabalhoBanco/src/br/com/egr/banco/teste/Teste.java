package br.com.egr.banco.teste;
import br.com.egr.banco.dao.PessoaFisicaDAO;
import br.com.egr.banco.model.PessoaFisica;

public class Teste {
	public static void main(String[] args){
		
		PessoaFisica pf = new PessoaFisica();
		PessoaFisicaDAO pfDAO = new PessoaFisicaDAO();
		
		pfDAO.listarPF();
		
		
	}
}
