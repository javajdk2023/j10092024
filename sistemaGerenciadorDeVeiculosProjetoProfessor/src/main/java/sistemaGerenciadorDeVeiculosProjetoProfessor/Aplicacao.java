package sistemaGerenciadorDeVeiculosProjetoProfessor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String usuario = "postgres";
		String senha = "123";
		
		try {
			Connection myConnection = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conectado com sucesso!");
			
			String cpf = "14785296363";
			int idade = 99;
			
			Scanner entradaDeDados = new Scanner(System.in);
			
			System.out.println("Digite seu CPF: ");
			cpf = entradaDeDados.nextLine();
			
			System.out.println("Digite sua idade: ");
			idade = entradaDeDados.nextInt();
			
			//insert into usuario (cpf, idade) values (?, ?);
			String comandoSQL = "insert into usuario (cpf, idade) values (?, ?)";
			
			PreparedStatement pstm = myConnection.prepareStatement(comandoSQL);
			
			pstm.setString(1, cpf);
			pstm.setInt(2, idade);
			
			pstm.execute();
		
			
			
			///
			
			
			
			
			myConnection.close();
			entradaDeDados.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
