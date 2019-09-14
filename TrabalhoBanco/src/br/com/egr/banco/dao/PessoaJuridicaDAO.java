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
		
		String sql = "inser insert pessoaJuridica (cnpj,idcliente,nomeFantasia) values ()";
		
	}
}
