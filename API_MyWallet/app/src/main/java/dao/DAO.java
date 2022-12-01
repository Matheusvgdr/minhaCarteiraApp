package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
	public static Connection criarConexao() {
		
		//VARIAVEIS
		String url, dataBase, servidor, usuario, senha;
		
		String driverName = "com.mysql.cj.jdbc.Driver";
		
		//CONEXAO
		Connection conex = null;
		
		try {
			
			Class.forName(driverName);
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			
		}
		
		//INFORMAÇÕES DA CONEXÃO
		servidor = "localhost:3306";
		dataBase = "db_myWalletUpdt";
		usuario = "root";
		senha = "";
		url = "jdbc:mysql://" + servidor + "/" + dataBase;
		
		try {
			
			//FAZENDO A CONEXÃO
			conex = DriverManager.getConnection(url, usuario, senha);
			
		} catch (SQLException e) {
			
			System.out.println("Não foi possível conectar ao banco de dados");
			e.printStackTrace();

			return null;
		}
		
		return conex;
	}
}
