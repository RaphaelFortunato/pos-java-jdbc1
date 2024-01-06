package pos_java_jdbc1.pos_java_jdbc1;

import java.util.List;

import org.junit.Test;


import conexao.jdbc.SingleConnection;
import dao.UserPosDAO;
import junit.framework.TestCase;
import model.BeanUserFone;
import model.Telefone;
import model.Userposjava;


public class TesteBancoJdbc {
	
	@Test
	public void initBanco() {
		
		UserPosDAO userPosDAO = new UserPosDAO();
		Userposjava userposjava = new Userposjava();
		
		//userposjava.setId(6L);// no começo setavamos manualmente, mas agora depois de criado o SEQUENCE no banco o id é gerado automaticamente
		userposjava.setNome("Fernanda");
		userposjava.setEmail("fernanda@gmail.com");
		
		userPosDAO.salvar(userposjava);
	}
	
	@Test
	public void initListar() {
		try {
			UserPosDAO dao = new UserPosDAO();
			List<Userposjava> list = dao.listar();
			
			for (Userposjava userposjava : list) {
				System.out.println(userposjava);
				System.out.println("----------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void initBuscar() {
		UserPosDAO dao = new UserPosDAO();
		try {
			Userposjava userposjava = dao.buscar(6L);
			
			System.out.println(userposjava);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void initAtualizar() {
		
		try {
			UserPosDAO dao = new UserPosDAO();
			
			Userposjava objetoBanco = dao.buscar(5L);
			
			objetoBanco.setNome("Nome mudado com metodo atualizar");
			
			dao.atualizar(objetoBanco);
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
			
		
	}
	
	@Test
	public void initDeletar() {
		try {
			
			UserPosDAO dao = new UserPosDAO();
			dao.deletar(9L);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testeInsertTelefone() {
		
		Telefone telefone = new Telefone();
		telefone.setNumero("(11) 9 49928-3993");
		telefone.setTipo("casa");
		telefone.setUsuario(3L);
		
		UserPosDAO dao = new UserPosDAO();
		dao.salvarTelefone(telefone);
	}
	
	
	@Test
	public void testeCarregaFonesUser() {
		
		UserPosDAO dao = new UserPosDAO();
		
		List<BeanUserFone> beanUserFones = dao.listaUserFone(2L);
		
		for (BeanUserFone beanUserFone : beanUserFones) {
			System.out.println(beanUserFone);
			System.out.println("-------------------------");
		}
		
	}

	@Test
	public void testeDeleteUserFone() {
		
		UserPosDAO dao = new UserPosDAO();
		dao.deleteFonesPorUser(2L);
		
	}
	
}
