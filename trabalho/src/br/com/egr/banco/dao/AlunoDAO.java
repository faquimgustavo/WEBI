package br.com.lucasfaria.projetoExemplo1.dao;

import java.sql.PreparedStatement;

import java.sql.Connection;

import br.com.lucasfaria.projetoExemplo1.conexao.Conexao;
import br.com.lucasfaria.projetoExemplo1.model.Aluno;

public class AlunoDAO {
	private Connection conexao;
	private PreparedStatement stmt;

	
	public AlunoDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void inserir(Aluno aluno) {
		String sql = "INSERT INTO ALUNO(nome,idade) values (?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setInt(2,aluno.getIdade());
			stmt.execute();
			stmt.close();
			
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
