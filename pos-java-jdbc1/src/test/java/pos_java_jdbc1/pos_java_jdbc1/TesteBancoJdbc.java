package pos_java_jdbc1.pos_java_jdbc1;

import org.junit.Test;

<<<<<<< HEAD
import conexao.jdbc.SingleConnection;
import dao.UserPosDAO;
import junit.framework.TestCase;
import model.Userposjava;
=======
import conexaojdbc.SingleConnection;
>>>>>>> refs/heads/master

public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {
		
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();
		
		userposjava.setId(6L);
		userposjava.setNome("Bores");
		userposjava.setEmail("bores@gmail.com");
		
		userPosDAO.salvar(userposjava);
	}

}
