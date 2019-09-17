package br.com.egr.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;


import br.com.egr.banco.conexao.Conexao;
import br.com.egr.banco.model.Seguro;

public class SeguroDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	
	public SeguroDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void inserir(Seguro seguro) {
		System.out.println("Entrou aqui!!!!! \n \n \n \n");
		System.out.println("\n \n " + seguro.getNumero() + "\n \n ");
		System.out.println("\n \n " + seguro.getValor() + "\n \n ");
		String sql = "insert into seguro(numero,valor,situacao) values (?,?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, seguro.getNumero());
			stmt.setDouble(2, seguro.getValor());
			stmt.setBoolean(3, seguro.getSituacao());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
