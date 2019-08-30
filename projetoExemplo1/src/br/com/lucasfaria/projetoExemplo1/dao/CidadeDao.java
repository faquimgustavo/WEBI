package br.com.lucasfaria.projetoExemplo1.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.lucasfaria.projetoExemplo1.conexao.Conexao;
import br.com.lucasfaria.projetoExemplo1.model.Cidade;

public class CidadeDao {
	private Connection conexao;
	private PreparedStatement stmt;

	public CidadeDao() {
		this.conexao = new Conexao().getConexao();
	}

	public void inserir(Cidade cidade) {
		String sql = "INSERT INTO cidade (nome, estado) VALUES (?, ?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, cidade.getNome());
			stmt.setString(2, cidade.getEstado());
			stmt.execute();
			stmt.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
