package pos_java_jdbc1.pos_java_jdbc1;

import org.junit.Test;

import conexaojdbc.SingleConnection;

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {
		SingleConnection.getConnection();
	}

}
