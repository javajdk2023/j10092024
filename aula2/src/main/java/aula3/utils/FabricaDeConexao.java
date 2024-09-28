package aula3.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class FabricaDeConexao {

	
	//desafio: 1 método e vários bancos diferentes
	//desafio 2: singleton - conexao unica
	public Connection getConnection() {
		
		//Classe utilitária que carrega os dados de um arquivo
		Properties props = ReadProperties.loadProperties();
		
		// conexao
		String url = props.getProperty("url");
		String usuario = props.getProperty("usuario");
		String senha = props.getProperty("senha");

		try {
			Connection myConnection = DriverManager.getConnection(url,usuario, senha);
			System.out.println("Conectado com sucesso!");
			return myConnection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	public Connection getConnectionMysql() {

		// conexao
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String usuario = "postgres";
		String senha = "123";

		try {
			Connection myConnection = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectado com sucesso!");
			return myConnection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

}
