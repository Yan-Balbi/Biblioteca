import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {
	private Connection connection;
	
	
	UsuarioDAO(){
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/biblioteca?user=root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	List<Usuario> listarUsuariosSQL() {
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
	
	List<Usuario> consultarUsuarioPorCPFSQL(String cpf){
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
	
//	static boolean consultarUsuarioPorCPF(Usuario user) {//TODO: TROCAR POR CPF
//		for(Usuario usuario: listaUsuarios) {
//			if(usuario.getCPF().equals(user.getCPF())) {
//				return true; //caso ache o usuario, retorna true porque achou
//			}
//		}
//		return false; // caso não encontre, retorna false porque não achou
//	}
	
	List<Usuario> consultarUsuarioPorNomeSQL(String nome) {
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
	
//	static boolean consultarUsuarioPorNome(Usuario user) {//TODO: TOCAR POR NOME
//		for(Usuario usuario: listaUsuarios) {
//			if(usuario.getNome().equals(user.getNome())) {
//				return true; //caso ache o CPF, retorna true porque achou
//			}
//		}
//		return false; // caso não encontre o CPF, retorna false porque não achou
//	}
	
	void registroUsuarioSQL(String nome, String cpf) {
		try {
			//Usuario usuario = new Usuario(nome, cpf);
			PreparedStatement ps = null;
			if(Usuario.validacaoCPF(cpf)==true) {
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
				}else {
					System.out.println("CPF inválido!");	
				}
			}	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	//TODO: CLASSE DE REGISTRO DE USUÁRIO
//	void registroUsuario( String nome, String cpf) {//use o retorno true or false no Principal para falar se for cadastrado ou não!!!!!
//		Usuario usuario = new Usuario(nome,cpf);
//		if(Usuario.validacaoCPF(cpf)==true) {
//			if(verificacaoRegistroUsuario(usuario.getCPF()) == true) {
//				System.out.println("Usuário já registrado");
//				//return false; //retorna false a cancela o registro do usuário
//			}else {
//				listaUsuarios.add(usuario);
//				System.out.println("Registro concluido");
//				//return true;
//			}
//		}else {
//			System.out.println("CPF inválido!");	
//		}
//		//return false;
//	}
	
	//TODO: CLASSE DE VERIFICAÇÃO DE EXISTENCIA DE USUARIO
//	boolean verificacaoRegistroUsuario(String cpf) {
//		for( Usuario user : listaUsuarios) {
//			if(user.getCPF().equals(cpf)) {
//				return true;
//			}
//		}
//		return false;
//	}
	
	void removerUsuarioSQL( String cpf) {//use o retorno true or false no Principal para falar se for cadastrado ou não!!!!!
		//Livro livro = new Livro(isbn,nome, editora, categoria);
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("DELETE FROM usuario WHERE cpf = ?");
			ps.setString(1, cpf);
			ps.executeUpdate();
			System.out.println("Remoção concluida");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	void atualizarUsuarioSQL(String codigo){
		PreparedStatement ps;
		Scanner scanner = new Scanner(System.in);
		
        System.out.print("Insira o novo CPF: ");
        String cpf = scanner.nextLine();
		
        System.out.print("Insira o novo nome: ");
        String nome = scanner.nextLine();
        
		
        try {    
			//TODO: fazer a validação do ISBN antes da atualização dos dados
	        if(Usuario.validacaoCPF(cpf)) {
				ps = connection.prepareStatement("UPDATE usuario SET cpf = ?, nome = ? WHERE cpf = ? ");
				ps.setString(1, cpf);
				ps.setString(2, nome);
				ps.setString(3, codigo);
				System.out.println("Atualização concluida");
				ps.executeUpdate();	        	
	        }else {
	        	System.out.println("CPF inválido!");
	        }		
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/*public static void main(String[] args) {
		
		CRUDUsuarios usuarios = new CRUDUsuarios();
		usuarios.registroUsuario("yan", "12141726794");
		usuarios.registroUsuario("yan", "12141726794");
	}*/
/////////////////////////////////////////////////////////////////////////////////////////////////////////////	
//	static Usuario getObjetoUsuarioPorCPF(String cpf) {
//		UsuarioDAO usuarios = new UsuarioDAO();
//		for(Usuario usuario: usuarios.listarUsuarios()) {
//			if(usuario.getCPF().equals(cpf)) {
//				return usuario;
//			}
//		}
//		return null;
//	}
//	
//	static Usuario getObjetoUsuarioPorNome(String nome) {
//		UsuarioDAO usuarios = new UsuarioDAO();
//		for(Usuario usuario: usuarios.listarUsuarios()) {
//			if(usuario.getNome().equals(nome)) {
//				return usuario;
//			}
//		}
//		return null;
//	}
}