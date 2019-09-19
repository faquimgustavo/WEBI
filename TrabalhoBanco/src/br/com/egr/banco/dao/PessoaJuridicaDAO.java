package br.com.egr.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import br.com.egr.banco.conexao.Conexao;
import br.com.egr.banco.model.PessoaJuridica;

public class PessoaJuridicaDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public PessoaJuridicaDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void inserir(PessoaJuridica pj) {
		String sql = "insert pessoaJuridica (cnpj,idcliente,nomeFantasia) values (?,?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1,pj.getCnpj());
			stmt.setInt(2, pj.getIdcliente());
			stmt.setString(3, pj.getNomeFantasia());
			stmt.execute();
			stmt.close();
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
				PessoaJuridica pj = new PessoaJuridica(rs.getInt("idcliente"), rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone"),rs.getString("cnpj"), rs.getString("nomeFantasia"));
				listapj.add(pj);
			}
			stmt.close();
			return listapj;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public PessoaJuridica pesquisarId(int id) {
		String sql = "select c.idcliente, c.nome, pj.cnpj, c.endereco, c.telefone, pj.nomeFantasia from pessoaJuridica pj inner join cliente c on pj.idcliente = c.idcliente where c.idcliente = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			PessoaJuridica pj = new PessoaJuridica();
			
			if(rs.next()) {			
				pj = new PessoaJuridica(rs.getInt("idcliente"), rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone"),rs.getString("cnpj"), rs.getString("nomeFantasia"));
			}
			return pj;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public boolean verifica(int id) {
		String sql = "select * from pessoaJuridica where idcliente = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			boolean verifica = false;
			if(rs.next()) {
				if(rs.getInt("idcliente") != 0) {
					verifica = true;
				}
				else {
					verifica = false;
				}
			}
			return verifica;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
