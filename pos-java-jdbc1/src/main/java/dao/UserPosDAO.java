package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conexao.jdbc.SingleConnection;
import model.Userposjava;

public class UserPosDAO {
	
	private Connection connection;
	
	public UserPosDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(Userposjava userposjava) {
		try {
			
			//String sql = "INSERT INTO public.userposjava(id, nome, email) VALUES (?, ?, ?)";
			String sql = "INSERT INTO public.userposjava(nome, email) VALUES (?, ?)";//aqui o id é gerado automaticamente pelo banco, por isso timramos todas as referencias de id
			PreparedStatement insert = connection.prepareStatement(sql);
			//insert.setLong(1, userposjava.getId());
			insert.setString(1, userposjava.getNome());
			insert.setString(2, userposjava.getEmail());
			insert.execute();
			connection.commit();//salva no banco -> verificar comentário SingleConnection
			
		} catch (Exception e) {
			try {
				connection.rollback();//se der algum erro da compilação o rollback() ajuda a não interferir no banco
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
	
	public List<Userposjava> listar() throws Exception{
		List<Userposjava> list = new ArrayList<Userposjava>();
		
		String sql = "SELECT * FROM userposjava";
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		while(resultado.next()) {
			Userposjava userposjava = new Userposjava();
			userposjava.setId(resultado.getLong("id"));
			userposjava.setNome(resultado.getString("nome"));
			userposjava.setEmail(resultado.getString("email"));
			
			list.add(userposjava);
			
		}
		
		return list;
	}
	
	public Userposjava buscar(Long id) throws Exception{
		Userposjava retorno = new Userposjava();
		
		String sql = "SELECT * FROM userposjava where id = " + id;
		
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet resultado = statement.executeQuery();
		
		while(resultado.next()) {//aqui irá retornar 1 ou nenhum
			retorno.setId(resultado.getLong("id"));
			retorno.setNome(resultado.getString("nome"));
			retorno.setEmail(resultado.getString("email"));
			
						
		}
		
		return retorno;
	}
	
	
	public void atualizar(Userposjava userposjava) {
		
		try {
			
			String sql = "update userposjava set nome = ? where id = " + userposjava.getId();
			
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, userposjava.getNome());
			
			statement.execute();
			connection.commit();
			
		}catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}
	
	public void deletar(Long id) {
		
		try {
			
			String sql = "delete from userposjava where id = " + id;
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.execute();
			connection.commit();
			
		} catch (Exception e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		}
		
	}

}
