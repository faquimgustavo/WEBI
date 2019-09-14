package br.com.egr.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.egr.banco.conexao.Conexao;
import br.com.egr.banco.model.PessoaFisica;


public class PessoaFisicaDAO {
	private Connection conexao;
	private PreparedStatement stmt;

	public PessoaFisicaDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void inserir(PessoaFisica pf) {
		
		int id = new ClienteDAO().inserir(pf);
		pf.setIdcliente(id);
		
		String sql = "insert into pessoaFisica (cpf, idcliente, nomeMae, nomePai) values (?,?,?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, pf.getCpf());
			stmt.setInt(2, pf.getIdcliente());
			stmt.setString(3,pf.getNomeMae());
			stmt.setString(4, pf.getNomePai());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
