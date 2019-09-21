package br.com.egr.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.egr.banco.conexao.Conexao;
import br.com.egr.banco.model.Cliente;
import br.com.egr.banco.model.Conta;
import br.com.egr.banco.model.PessoaJuridica;


public class ContaDAO {
	private Connection conexao;
	private PreparedStatement stmt;
	
	public ContaDAO() {
		this.conexao = new Conexao().getConexao();
	}
	
	public void inserir(Conta conta, String tipo, Cliente cliente) {
		String sql = "insert into conta (numero, saldo,situacao,tipo, cliente_idcliente) values (?,?,?,?,?)";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1,conta.getNumero() );
			stmt.setDouble(2, conta.getSaldo());
			stmt.setBoolean(3, conta.getSituacao());
			stmt.setString(4,tipo);
			stmt.setInt(5, cliente.getIdcliente());
			stmt.execute();
			stmt.close();
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Conta> listarTudo() {
		String sql = "select * from cliente n inner join cliente_conta c on  n.idcliente = c.idcliente where n.idcliente = 1;";
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			List<Conta> lista = new ArrayList<Conta>();
			stmt.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/*public ArrayList<Conta> listarTudo(){
		String sql = "select * from conta";
		try {
			stmt = conexao.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			ArrayList<Conta> lista = new ArrayList<Conta>();
			while(rs.next()) {
				Conta c conta = new Conta(rs.getInt("numero"), rs.getDouble("saldo"), rs.getString("situacao"), rs.getString("tipo"));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	} */ // Não posso criar um metodo para listar todos as contas pq Conta é classe abstrata e não pode ser instanciada.
}
