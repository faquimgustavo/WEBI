package br.com.egr.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.egr.banco.conexao.Conexao;
import br.com.egr.banco.model.Conta;


public class ContaDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public ContaDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void inserir(Conta conta) {
		String sql = "insert into conta (numero,saldo,situacao,tipo) values (?,?,?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1,conta.getNumero());
			stmt.setDouble(2, conta.getNumero());
			stmt.setBoolean(3, conta.getSituacao());
			stmt.setString(4,conta.getTipo());
			stmt.execute();
			stmt.close();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
