package br.com.egr.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.egr.banco.conexao.Conexao;
import br.com.egr.banco.model.PessoaJuridica;

public class PessoaJuridicaDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public PessoaJuridicaDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void inserir(PessoaJuridica pj) {
		String sql = "insert pessoaJuridica (cnpj,idcliente,nomeFantasia) values (?,?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1,pj.getCnpj());
			stmt.setInt(2, pj.getIdcliente());
			stmt.setString(3, pj.getNomeFantasia());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
