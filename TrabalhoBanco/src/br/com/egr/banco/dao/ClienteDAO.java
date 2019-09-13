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
	
	public Cliente pesquisarID(Cliente cliente) {
		String sql="select * from cliente where nome = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			ResultSet rs = stmt.executeQuery();
			Cliente c = new Cliente();
			
			if(rs.next()) {
				/*c = new Cliente(rs.getInt("idcliente"), rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone")); */
				c.setIdcliente(rs.getInt("idcliente"));
				c.setNome(rs.getString("nome"));
				c.setEndereco(rs.getString("endereco"));
				c.setTelefone(rs.getString("telefone"));
				
				for() {}
				
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
}
