package br.com.gustavofaquim.alunojsp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import br.com.gustavofaquim.alunojsp.conexao.Conexao;
import br.com.gustavofaquim.alunojsp.model.Aluno;

public class AlunoDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public AlunoDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void inserir(Aluno aluno) {
		String sql = "insert into aluno (nome,idade,idcidade) values (?,?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setInt(2, aluno.getIdade());
			stmt.setInt(3, aluno.getCidade().getId());			
			stmt.execute();
			stmt.close();
			
		}catch(Exception e) {
			 throw new RuntimeException(e);
			}
	}
}
