package br.com.egr.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.egr.banco.conexao.Conexao;
import br.com.egr.banco.model.Cliente;
import br.com.egr.banco.model.Produto;
import br.com.egr.banco.model.Seguro;

public class ClienteSeguroDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public ClienteSeguroDAO(){
		this.conexao = new Conexao().getConexao();
	}
	
	
	public void inserir(Cliente cliente, Seguro seguro) {
		String sql = "insert into cliente_seguro (idcliente, numero) values (?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cliente.getIdcliente());
			stmt.setLong(2, seguro.getNumero());
			stmt.execute();
			stmt.close();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public void pesquisarID(Cliente cliente, Seguro seguro) {
		String sql = "select * from cliente_seguro where idcliente = ? where numero = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, cliente.getIdcliente());
			stmt.setLong(2, seguro.getNumero());
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				Cliente c = new Cliente();
				/////////
				
			}
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}	
}
