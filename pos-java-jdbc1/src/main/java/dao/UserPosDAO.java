package dao;

import java.sql.Connection;

import conexao.jdbc.SingleConnection;

public class UserPosDAO {
	
	private Connection coneConnection;
	
	public UserPosDAO() {
		coneConnection = SingleConnection.getConnection();
	}

}
