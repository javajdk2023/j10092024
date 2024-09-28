package aula3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import aula3.dao.UsuarioDAO;
import aula3.model.Usuario;
import aula3.utils.FabricaDeConexao;

public class Aplicacao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			
			//a conexão está na Fábrica
			FabricaDeConexao fabrica = new FabricaDeConexao();
			
			Connection myConnection = fabrica.getConnection();
			
			//myConnection.close();
			
			
			//E/S - entrada/saida de dados
			Scanner entradaDeDados = new Scanner(System.in);

			System.out.println("Escolha a opção: \n1-Inserir\n2-Consultar");
			System.out.println("Digite: ");

			int opcao = entradaDeDados.nextInt();

			
			//lógica
			if (opcao == 1) {
				String cpf = "14785296363";
				int idade = 99;

				System.out.println("Digite seu CPF: ");
				cpf = entradaDeDados.nextLine();

				System.out.println("Digite sua idade: ");
				idade = entradaDeDados.nextInt();

				UsuarioDAO usuarioDAO = new UsuarioDAO();
				
				
				Usuario usuario = new Usuario();
				usuario.setCpf(cpf);
				usuario.setIdade(idade);
				
				usuarioDAO.create(myConnection, usuario);

			} else if (opcao == 2) {

				System.out.println("Digite o CPF que deseja pesquisar:");

				entradaDeDados.nextLine();

				String cpfPesquisa = entradaDeDados.nextLine();

				UsuarioDAO usuarioDAO = new UsuarioDAO();
				
				 List<Usuario> resultadoConsulta = usuarioDAO.findAll(myConnection);
				 
				 for (Usuario usuario : resultadoConsulta) {
					System.out.println(usuario.getCpf());
				}

			}

			///

			myConnection.close();
			entradaDeDados.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
