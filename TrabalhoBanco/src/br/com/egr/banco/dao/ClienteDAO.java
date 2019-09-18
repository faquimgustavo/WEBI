package br.com.egr.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.egr.banco.conexao.Conexao;
import br.com.egr.banco.model.Cliente;
import br.com.egr.banco.model.PessoaFisica;
import br.com.egr.banco.model.PessoaJuridica;


public class ClienteDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public ClienteDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public int inserir(Cliente cliente) {
		String sql = "insert into cliente(nome,endereco,telefone) values (?,?,?)";
		try {
			stmt = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getTelefone());
			stmt.setString(3, cliente.getEndereco());
			
			stmt.execute();
			
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			stmt.close();
			return id;
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Cliente> listarTudo() {
		String sql = "select * from cliente";
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<Cliente> lista = new ArrayList<Cliente>();
			stmt.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
