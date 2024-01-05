package pos_java_jdbc1.pos_java_jdbc1;

import org.junit.Test;

import conexao.jdbc.SingleConnection;
import junit.framework.TestCase;

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {
		SingleConnection.getConnection();
	}

}
