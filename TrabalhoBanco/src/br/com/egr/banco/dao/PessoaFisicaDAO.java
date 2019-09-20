package br.com.egr.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.egr.banco.conexao.Conexao;
import br.com.egr.banco.model.PessoaFisica;
import br.com.egr.banco.model.PessoaJuridica;


public class PessoaFisicaDAO {
	private Connection conexao;
	private PreparedStatement stmt;

	public PessoaFisicaDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void inserir(PessoaFisica pf) {
		
		String sql = "insert into pessoaFisica (cpf, idcliente, nomeMae, nomePai) values (?,?,?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, pf.getCpf());
			stmt.setInt(2, pf.getIdcliente());
			stmt.setString(3,pf.getNomeMae());
			stmt.setString(4, pf.getNomePai());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<PessoaFisica> listarPF() {
		String sql = "select c.nome, c.endereco, c.telefone, pf.cpf, pf.idcliente,pf.nomeMae, pf.nomePai from cliente c inner join pessoaFisica pf on c.idcliente = pf.idcliente";
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<PessoaFisica> listapf = new ArrayList<PessoaFisica>();
			while(rs.next()) {
				PessoaFisica pf = new PessoaFisica(rs.getInt("idcliente"), rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone"), rs.getString("cpf"), rs.getString("nomePai"), rs.getString("nomeMae"));
				listapf.add(pf);
			}
			stmt.close();
			return listapf;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public PessoaFisica pesquisarId(int id) {
		String sql = "select c.idcliente, c.nome, pf.cpf, c.endereco, c.telefone, pf.nomeMae, pf.nomePai from pessoaFisica pf inner join cliente c\n" + 
				"on pf.idcliente = c.idcliente where c.idcliente = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			PessoaFisica pf = null;
			
			if(rs.next()) {
				pf = new PessoaFisica(rs.getInt("idcliente"), rs.getString("nome"), rs.getString("endereco"), rs.getString("telefone"), rs.getString("cpf"), rs.getString("nomePai"), rs.getString("nomeMae"));
			}
			return pf;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public boolean verifica(int id) {
		String sql = "select * from pessoaFisica where idcliente = ?";
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
