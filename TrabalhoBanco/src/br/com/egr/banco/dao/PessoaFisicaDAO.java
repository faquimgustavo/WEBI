package br.com.egr.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.egr.banco.conexao.Conexao;
import br.com.egr.banco.model.Cliente;
import br.com.egr.banco.model.PessoaFisica;



public class PessoaFisicaDAO {
	private Connection conexao;
	private PreparedStatement stmt;

	public PessoaFisicaDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void inserir(Cliente cliente) {
		String sql = "insert into cliente (nome,endereco, telefone) values (?,?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEndereco());
			stmt.setString(3, cliente.getTelefone());
			stmt.execute();
			stmt.close();
			
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public Cliente pesquisarID(Cliente cliente) {
		String sql = "select * from cliente where nome = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			ResultSet rs = stmt.executeQuery();
			PessoaFisica pf = new PessoaFisica();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
