package br.com.egr.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

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
	
	
	public ArrayList<PessoaFisica> listarPF() {
		String sql = "select * from cliente inner join pessoaFisica on \n" + 
				"cliente.idcliente = pessoaFisica.idclient";
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<PessoaFisica> listapf = new ArrayList<PessoaFisica>();
			while(rs.next()) {
				PessoaFisica pf = new PessoaFisica(rs.getInt("idcliente"), rs.getString("nome"), rs.getString("endereco"), rs.getString("telfone"), rs.getString("cpf"), rs.getString("nomePai"), rs.getString("nomeMae"));
				listapf.add(pf);
			}
			stmt.close();
			return listapf;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public ArrayList<PessoaJuridica> listarPJ(){
		String sql = "select * from cliente inner join pessoaJuridica on \n" + 
				"cliente.idcliente = pessoaJuridica.idcliente;";
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<PessoaJuridica> listapj = new ArrayList<PessoaJuridica>();
			while(rs.next()) {
				PessoaJuridica pj = new PessoaJuridica(rs.getInt("idcliente"), rs.getString("nome"), rs.getString("endereco"), rs.getString("telfone"),rs.getString("cnpj"), rs.getString("nomeFantasia"));
				listapj.add(pj);
			}
			stmt.close();
			return listapj;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
