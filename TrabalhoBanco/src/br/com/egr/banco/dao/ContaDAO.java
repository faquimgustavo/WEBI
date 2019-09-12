package br.com.egr.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.egr.banco.conexao.Conexao;
import br.com.egr.banco.model.Cliente;
import br.com.egr.banco.model.Conta;
import br.com.egr.banco.model.Produto;

public class ContaDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public ContaDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void inserir(Conta conta) {
		String sql = "insert into conta (numero,saldo,situacao) values (?,?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1,conta.getNumero());
			stmt.setDouble(2, conta.getNumero());
			stmt.setBoolean(3, conta.getSituacao());
			stmt.execute();
			stmt.close();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Conta pesquisarID(Conta conta) {
		String sql = "select * from conta where numero = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, conta.getNumero());
			ResultSet rs = stmt.executeQuery();
			Cliente cliente = new Cliente();
			if(rs.next()) {
				cliente = new Cliente(rs.getInt("numero"), rs.getDouble("saldo"), rs.getBoolean("situacao"));
			}
			//Pareiiiiii aqui!!!!!!!!
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
