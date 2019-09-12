package br.com.egr.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.egr.banco.conexao.Conexao;
import br.com.egr.banco.model.Cliente;

public class ClienteDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public ClienteDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void inserir(Cliente cliente) {
		String sql = "insert into cliente(nome,endereco,telefone) values (?,?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setString(3, cliente.getTelefone());
			stmt.execute();
			stmt.close();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
