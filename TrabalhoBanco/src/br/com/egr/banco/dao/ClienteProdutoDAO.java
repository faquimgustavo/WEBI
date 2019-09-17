package br.com.egr.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.egr.banco.conexao.Conexao;
import br.com.egr.banco.model.Conta;

public class ClienteProdutoDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public ClienteProdutoDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void inserirConta(int idcliente, Conta conta) {
		String sql = "insert into cliente_conta(idcliente, numero) values (?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idcliente);
			stmt.setInt(2, conta.getNumero());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void inserirSeguro(int idcliente, int numero) {
		String sql = "insert into cliente_seguro(idcliente,numero) values (?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, idcliente);
			stmt.setInt(2, numero);
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
