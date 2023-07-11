package br.edu.iff.dao;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import br.edu.iff.model.Usuario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
	private Connection connection;
	
	
	public UsuarioDAO(){
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/biblioteca?user=root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Usuario> listarUsuariosSQL() {
		List<Usuario> listaUsuarios = new LinkedList<>();
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM usuario");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String nomeUsuario = rs.getString("nome");
				String cpfUsuario = rs.getString("cpf");
				Usuario user = new Usuario(nomeUsuario, cpfUsuario);
				
				listaUsuarios.add(user);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return listaUsuarios;
	}
	
	public List<Usuario> consultarUsuarioPorCPFSQL(String cpf){
		List<Usuario> listaUsuarios = new LinkedList<>();
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM usuario WHERE cpf = ?");
			ps.setString(1, cpf);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String nomeUsuario = rs.getString("nome");
				String cpfUsuario = rs.getString("cpf");
				Usuario user = new Usuario(nomeUsuario, cpfUsuario);
				
				listaUsuarios.add(user);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return listaUsuarios;
	}
	
	public List<Usuario> consultarUsuarioPorNomeSQL(String nome) {
		List<Usuario> listaUsuarios = new LinkedList<>();
		//Usuario usuario = new Usuario(nome, null);
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT * FROM usuario WHERE nome LIKE ?");
			ps.setString(1, "%"+nome+"%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String nomeUsuario = rs.getString("nome");
				String cpfUsuario = rs.getString("cpf");
				Usuario user = new Usuario(nomeUsuario, cpfUsuario);
				
				listaUsuarios.add(user);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaUsuarios;
	}
	
	public void registroUsuarioSQL(String nome, String cpf) {
		try {
			//Usuario usuario = new Usuario(nome, cpf);
			PreparedStatement ps = null;
			
			ps = connection.prepareStatement("SELECT COUNT(*) AS count FROM usuario WHERE cpf = ?"); 
			ps.setString(1, cpf);
			
			//executando a consulta
			ResultSet rs = ps.executeQuery();
			
			//obtendo o valor de count
			if(rs.next()) {
				int count = rs.getInt("count");
				
				if(count >= 1) {
					System.out.println("CPF já registrado");
				} else {
					ps = connection.prepareStatement("INSERT INTO usuario(nome,cpf) VALUES (?,?)");
					ps.setString(1,  nome);
					ps.setString(2,  cpf);
					ps.execute();
					System.out.println("Registro concluido");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void removerUsuarioSQL( String cpf) {//use o retorno true or false no Principal para falar se for cadastrado ou não!!!!!
		//Livro livro = new Livro(isbn,nome, editora, categoria);
		PreparedStatement ps;
		try {
			//O usuário só pode ser removido caso ele não tenha emprestimos em andamento e nem emprestimos atrasados
			EmprestimoDAO emp = new EmprestimoDAO();
			if(emp.usuarioPossuiEmprestimoEmAndamentoSQL(cpf)==false &&emp.estaAtrasadoCPFSQL(cpf)==false) {
				ps = connection.prepareStatement("DELETE FROM usuario WHERE cpf = ?");
				ps.setString(1, cpf);
				ps.executeUpdate();
				System.out.println("Remoção concluida");
			}
			System.out.println("A remoção de usuário não pode ser concluída.");
			//"UPDATE SET status = TRUE FROM emprestimo WHERE usuario_id = ? and status = false"

		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void atualizarUsuarioSQL(String codigo, String cpf, String nome){
		PreparedStatement ps;
		
        try {
			ps = connection.prepareStatement("UPDATE usuario SET cpf = ?, nome = ? WHERE cpf = ? ");
			ps.setString(1, cpf);
			ps.setString(2, nome);
			ps.setString(3, codigo);
			System.out.println("Atualização concluida");
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}