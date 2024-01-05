package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import conexao.jdbc.SingleConnection;
import model.Userposjava;

public class UserPosDAO {
	
	private Connection connection;
	
	public UserPosDAO() {
		connection = SingleConnection.getConnection();
	}
	
	public void salvar(Userposjava userposjava) {
		try {
			
			String sql = "INSERT INTO public.userposjava(id, nome, email) VALUES (?, ?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setLong(1, 3);
			insert.setString(2, "Augusto");
			insert.setString(3, "augusto@hotmail.com");
			insert.execute();
			connection.commit();//salva no banco
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
