package br.com.egr.banco.conexao;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
	private static final String DSN = "jdbc:mysql://localhost/banco_egr";
	private static final String USUARIO = "root";
	private static final String SENHA = "";
	//private static final String SENHA = "123456789";

	public Connection getConexao() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(DSN, USUARIO, SENHA);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
