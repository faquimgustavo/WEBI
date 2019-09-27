package br.com.egr.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.egr.banco.conexao.Conexao;
import br.com.egr.banco.model.Cliente;

import br.com.egr.banco.model.Seguro;

public class SeguroDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	
	public SeguroDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void inserir(Seguro seguro, Cliente cliente) {
		String sql = "insert into seguro(numero,valor,situacao, cliente_idcliente) values (?,?,?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, seguro.getNumero());
			stmt.setDouble(2, seguro.getValor());
			stmt.setBoolean(3, true);
			stmt.setInt(4, cliente.getIdcliente());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Seguro> pesquisarSeguro(int idcliente) {
		String sql = "select * from seguro where cliente_idcliente = ?;";
		try {
			stmt = conexao.prepareStatement(sql);	
			stmt.setInt(1, idcliente);
			ResultSet rs = stmt.executeQuery();
			List<Seguro> lista = new ArrayList<Seguro>();
			
			
			while(rs.next()) {
				Seguro seguro = new Seguro(rs.getInt("numero"), rs.getInt("valor"));
				lista.add(seguro);
			}
			stmt.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
