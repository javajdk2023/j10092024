package aula3.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aula3.model.Usuario;

//DAO = Data access object
public class UsuarioDAO {
//inserir (insert), excluir (delete), alterar (update) e consultar (select)
//inserir (create), e consultar (recovery), alterar (update), excluir (delete)
	
	public void create(Connection myConnection, Usuario usuario) throws SQLException {
		// insert into usuario (cpf, idade) values (?, ?);
		String comandoSQL = "insert into usuario (cpf, idade, altura) values (?, ?, ?)";

		
		PreparedStatement pstm = myConnection.prepareStatement(comandoSQL);

		pstm.setString(1, usuario.getCpf());
		pstm.setInt(2, usuario.getIdade());
		pstm.setDouble(3, usuario.getAltura());

		pstm.execute();
		
	}

	
	public List<Usuario> findAll(Connection myConnection) throws SQLException{
		
		
		String comandoSQLConsulta = "select codigo, cpf, idade from usuario";

		PreparedStatement pstmConsulta = myConnection.prepareStatement(comandoSQLConsulta);


		ResultSet resultaoConsulta = pstmConsulta.executeQuery();
		
		ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

		while (resultaoConsulta.next()) {

			// extrair os dados do resultSet
			//int codigo = resultaoConsulta.getInt("codigo");
			String cpf = resultaoConsulta.getString("cpf");
			int idade = resultaoConsulta.getInt("idade");
			
			Usuario u = new Usuario();
			u.setCpf(cpf);
			u.setIdade(idade);

			
			usuarios.add(u);
		}
		
		return usuarios; //
	}
	
}
