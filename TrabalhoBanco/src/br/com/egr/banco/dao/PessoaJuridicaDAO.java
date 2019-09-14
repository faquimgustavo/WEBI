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
		
		int id = new ClienteDAO().inserir(pj);
		pj.setIdcliente(id);
		
		String sql = "insert pessoaJuridica (cnpj,idcliente,nomeFantasia) values (?,?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1,pj.getCnpj());
			stmt.setInt(2, pj.getIdcliente());
			stmt.setString(3, pj.getNomeFantasia());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
