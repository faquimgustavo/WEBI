package br.com.egr.banco.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.egr.banco.conexao.Conexao;
import br.com.egr.banco.model.Cliente;
import br.com.egr.banco.model.Conta;
import br.com.egr.banco.model.ContaCorrente;
import br.com.egr.banco.model.PessoaJuridica;
import br.com.egr.banco.model.Produto;


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
	

	
	public List<Conta> pesquisarConta(int idcliente) {
		String sql = "select * from conta where cliente_idcliente = ?;";
		try {
			stmt = conexao.prepareStatement(sql);	
			stmt.setInt(1, idcliente);
			ResultSet rs = stmt.executeQuery();
			List<Conta> lista = new ArrayList<Conta>();
			
			
			while(rs.next()) {
				String classeNome = "br.com.egr.banco.model." + rs.getString("tipo");
				Class<?> conta = Class.forName(classeNome);
				Conta cont = (Conta) conta.getDeclaredConstructor().newInstance();
				
				cont.setNumero(rs.getInt("numero"));
				cont.depositar(rs.getDouble("saldo"));
				cont.ativar();
				lista.add(cont);
			}
			stmt.close();
			return lista;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public  Conta pesquisarNumero(int numConta) {
		String sql = "select * from conta where numero = ?;";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setInt(1, numConta);
			ResultSet rs = stmt.executeQuery();
			Conta ct = null;
			
			
			if(rs.next()) {	
				String classeNome = "br.com.egr.banco.model." + rs.getString("tipo");
				Class<?> conta = Class.forName(classeNome);
				Conta cont = (Conta) conta.getDeclaredConstructor().newInstance();
				
				cont.setNumero(rs.getInt("numero"));
				cont.depositar(rs.getDouble("saldo"));
				cont.ativar();
				ct = cont;		
				
			}
			return ct;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualizar(Conta conta) {
		String sql = "UPDATE conta SET saldo = ? WHERE numero = ?";
		try {
			stmt = conexao.prepareStatement(sql);
			stmt.setDouble(1,conta.getSaldo());
			stmt.setInt(2,conta.getNumero());
			stmt.execute();
			stmt.close();
		}catch (Exception e) {
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
