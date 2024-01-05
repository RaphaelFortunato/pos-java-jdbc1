package conexao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class SingleConnection {
	
	private static String url = "jdbc:postgresql://localhost:5434/posjava";//padrão jdbc
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection connection = null;//estanciado o objeto connection do pacote sql
	
	static {//de qualquer lugar que chamar o SingleConnection ele irá chamar o conectar()
		conectar();
	}
	
	public SingleConnection() {
		conectar();
	}
	
	private static void conectar() {
		try {// colocar um tratamento de exceção
			
			if(connection == null) {
				Class.forName("org.postgresql.Driver");//carregamento do driver que será usado, varia de banco para banco oracle, postgre
				connection = DriverManager.getConnection(url, user, password);
				connection.setAutoCommit(false);//usado se necessário, para não salvar a conexão, para decidir quando fizer um crud se a conexao será usada, isso é decidido na aplicação
							//altera o modo auto-commit da conexão (true para ativar e false para desativar). Caso o auto-commit seja desativado, é necessária a chamada explícita ao método commit(), caso contrário as alterações não terão efeito.
				System.out.println("Conectou com sucesso");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {//retorna a conexão
		return connection;
	}

}
