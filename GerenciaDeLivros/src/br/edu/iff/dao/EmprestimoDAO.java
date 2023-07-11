package br.edu.iff.dao;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import br.edu.iff.model.Emprestimo;
import br.edu.iff.model.Livro;
import br.edu.iff.model.Usuario;

public class EmprestimoDAO {
	Connection connection;
	
	public EmprestimoDAO(){
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/biblioteca?user=root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*private*/private void setDisponibilidadeSQL(boolean value, String isbn) {
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement("UPDATE livro SET disponibilidade = ? WHERE isbn = ?");
			ps.setBoolean(1, value);
			ps.setString(2, isbn);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	public List<Emprestimo> consultarEmprestimosAtivosSQL() {
		List<Emprestimo> listaEmprestimos = new ArrayList<>();
		
		PreparedStatement ps;
		String isbn = null;
		String titulo = null;
		String editora = null;
		String categoria = null;
		Boolean disponibilidade = null;
		
		String nome = null;
		String cpf = null;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM emprestimo WHERE status = true");//AND data_entrega >= CURRENT_DATE()
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				java.sql.Date emprestimo = rs.getDate("data_emprestimo");
				java.sql.Date entrega = rs.getDate("data_entrega");
				LocalDate dataEmprestimo = emprestimo.toLocalDate();
				LocalDate dataEntrega = entrega.toLocalDate();
				//==================LIVRO====================
				int idLivro = rs.getInt("livro_id");
				PreparedStatement ps2;
				ps2 = connection.prepareStatement("SELECT * FROM livro WHERE id_livro = ?");
				ps2.setInt(1, idLivro);
				ResultSet rs2 = ps2.executeQuery();
				if(rs2.next()) {
					isbn = rs2.getString("isbn");
					titulo = rs2.getString("titulo");
					editora = rs2.getString("editora");
					categoria = rs2.getString("categoria");
					disponibilidade = rs2.getBoolean("disponibilidade");
					
				}
				Livro livro = new Livro(isbn, titulo, editora, categoria, disponibilidade);
				//=================USUARIO===================
				int idUsuario = rs.getInt("usuario_id");
				PreparedStatement ps3;
				ps3 = connection.prepareStatement("SELECT * FROM usuario WHERE id_usuario = ?");
				ps3.setInt(1, idUsuario);
				ResultSet rs3 = ps3.executeQuery();
				if(rs3.next()) {
					nome = rs3.getString("nome");
					cpf = rs3.getString("cpf");	
				}
				Usuario usuario = new Usuario(nome,cpf);
				//===============EMPRESTIMO==================
				Emprestimo emprestimos = new Emprestimo(usuario, livro, dataEmprestimo, dataEntrega);
				listaEmprestimos.add(emprestimos);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaEmprestimos;	
}

	public List<Emprestimo> consultarEmprestimosAtrasadosSQL() {
		List<Emprestimo> listaEmprestimos = new ArrayList<>();
		
		PreparedStatement ps;
		String isbn = null;
		String titulo = null;
		String editora = null;
		String categoria = null;
		Boolean disponibilidade = null;
		
		String nome = null;
		String cpf = null;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM emprestimo WHERE status = true AND data_entrega <= CURRENT_DATE()");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				java.sql.Date emprestimo = rs.getDate("data_emprestimo");
				java.sql.Date entrega = rs.getDate("data_entrega");
				LocalDate dataEmprestimo = emprestimo.toLocalDate();
				LocalDate dataEntrega = entrega.toLocalDate();
				//==================LIVRO====================
				int idLivro = rs.getInt("livro_id");
				PreparedStatement ps2;
				ps2 = connection.prepareStatement("SELECT * FROM livro WHERE id_livro = ?");
				ps2.setInt(1, idLivro);
				ResultSet rs2 = ps2.executeQuery();
				if(rs2.next()) {
					isbn = rs2.getString("isbn");
					titulo = rs2.getString("titulo");
					editora = rs2.getString("editora");
					categoria = rs2.getString("categoria");
					disponibilidade = rs2.getBoolean("disponibilidade");
					
				}
				Livro livro = new Livro(isbn, titulo, editora, categoria, disponibilidade);
				//=================USUARIO===================
				int idUsuario = rs.getInt("usuario_id");
				PreparedStatement ps3;
				ps3 = connection.prepareStatement("SELECT * FROM usuario WHERE id_usuario = ?");
				ps3.setInt(1, idUsuario);
				ResultSet rs3 = ps3.executeQuery();
				if(rs3.next()) {
					nome = rs3.getString("nome");
					cpf = rs3.getString("cpf");	
				}
				Usuario usuario = new Usuario(nome,cpf);
				//===============EMPRESTIMO==================
				Emprestimo emprestimos = new Emprestimo(usuario, livro, dataEmprestimo, dataEntrega);
				listaEmprestimos.add(emprestimos);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaEmprestimos;	
}
	
	public List<Emprestimo> consultarEmprestimosConcluidosSQL() {
		List<Emprestimo> listaEmprestimos = new ArrayList<>();
		
		PreparedStatement ps;
		String isbn = null;
		String titulo = null;
		String editora = null;
		String categoria = null;
		Boolean disponibilidade = null;
		
		String nome = null;
		String cpf = null;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM emprestimo WHERE status = false");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				java.sql.Date emprestimo = rs.getDate("data_emprestimo");
				java.sql.Date entrega = rs.getDate("data_entrega");
				LocalDate dataEmprestimo = emprestimo.toLocalDate();
				LocalDate dataEntrega = entrega.toLocalDate();
				//==================LIVRO====================
				int idLivro = rs.getInt("livro_id");
				PreparedStatement ps2;
				ps2 = connection.prepareStatement("SELECT * FROM livro WHERE id_livro = ?");
				ps2.setInt(1, idLivro);
				ResultSet rs2 = ps2.executeQuery();
				if(rs2.next()) {
					isbn = rs2.getString("isbn");
					titulo = rs2.getString("titulo");
					editora = rs2.getString("editora");
					categoria = rs2.getString("categoria");
					disponibilidade = rs2.getBoolean("disponibilidade");
					
				}
				Livro livro = new Livro(isbn, titulo, editora, categoria, disponibilidade);
				//=================USUARIO===================
				int idUsuario = rs.getInt("usuario_id");
				PreparedStatement ps3;
				ps3 = connection.prepareStatement("SELECT * FROM usuario WHERE id_usuario = ?");
				ps3.setInt(1, idUsuario);
				ResultSet rs3 = ps3.executeQuery();
				if(rs3.next()) {
					nome = rs3.getString("nome");
					cpf = rs3.getString("cpf");	
				}
				Usuario usuario = new Usuario(nome,cpf);
				//===============EMPRESTIMO==================
				Emprestimo emprestimos = new Emprestimo(usuario, livro, dataEmprestimo, dataEntrega);
				listaEmprestimos.add(emprestimos);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaEmprestimos;	
}
	
	public boolean realizarEmprestimo(String cpf, String isbn) {
		if(usuarioPossuiEmprestimoEmAndamentoSQL(cpf)) {//adicionar à validação que o status do emprestimo também deve valer 1!!!!
			return false;
		}
		
		if(estaAtrasadoCPFSQL(cpf)) {
			
			return false; //O usuário possui emprestimos atrasados. Emprestimo cancelado
		}

		if(getDisponibilidadeLivroSQL(isbn) == false) {
			return false;
		}
		
		int livroId = getLivroByISBN(isbn);
		if(livroId == -1) {
			System.out.println("O ISBN inserido é inválido");
			return false;
		}
		
		int usuarioId = getUsuarioByCPF(cpf);
		if(usuarioId == -1) {
			System.out.println("O CPF inserido é inválido");
			return false;
		}
		LocalDate dataEmp = LocalDate.now();
		LocalDate dataEnt= dataEmp.plusDays(7);
		
		java.sql.Date dataEmprestimo = java.sql.Date.valueOf(dataEmp);
		java.sql.Date dataEntrega = java.sql.Date.valueOf(dataEnt);
		
		PreparedStatement ps;
		
		try{
			ps = connection.prepareStatement("INSERT into emprestimo(usuario_id, livro_id, data_emprestimo, data_entrega, status, renovacao) VALUES (?, ?, ?, ?, true, false)");
//			status = true -> emprestimo está ativo
//			status = false -> emprestimo está concluido
			ps.setInt(1, usuarioId);
			ps.setInt(2, livroId);
			ps.setDate(3, dataEmprestimo);
			ps.setDate(4, dataEntrega);
			ps.execute();
			setDisponibilidadeSQL(false, isbn);
			System.out.println("Emprestimo realizado com sucesso");
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	private boolean estaAtrasadoCPFSQL(String cpf) {
		int usuarioId = getUsuarioByCPF(cpf);
		LocalDate dataAtual = LocalDate.now();
//		java.sql.Date dataAtual = java.sql.Date.valueOf(dataAt);
		
		
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT data_emprestimo, data_entrega FROM emprestimo WHERE usuario_id = ? and status = true");
			ps.setInt(1, usuarioId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				java.sql.Date emprestimo = rs.getDate("data_emprestimo");
				java.sql.Date entrega = rs.getDate("data_entrega");
				
				LocalDate dataEmprestimo = emprestimo.toLocalDate();
				LocalDate dataEntrega = entrega.toLocalDate();
				System.out.println(dataEmprestimo+" "+dataAtual+" "+dataEntrega); //PROBLEMA DE CONVERSÃO
				
				if((dataAtual.isAfter(dataEmprestimo) || dataAtual.isEqual(dataEmprestimo) ) && (dataAtual.isBefore(dataEntrega)||dataAtual.isEqual(dataEntrega))) {
					return false;//não está atrasado
				}else {
					System.out.println("Emprestimo está atrasado.");
					return true;//está atrasado
				}
				
			}
			if(rs.next()==false) {
				//significa que não há emprestimos na tabela
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;//não está atrasado pois o cpf não está registrado na tabela
	}
	
	private boolean estaConcluidoISBNSQL(String isbn) {
		int usuarioId = getLivroByISBN(isbn);
		LocalDate dataAtual = LocalDate.now();
//		java.sql.Date dataAtual = java.sql.Date.valueOf(dataAt);
		
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT status FROM emprestimo WHERE livro_id = ?");
			ps.setInt(1, usuarioId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				boolean status = rs.getBoolean("status");
				
				if(status) {
					return false;//está em andamento
				}else {
					System.out.println("Emprestimo está concluído. Estensão de prazo cancelada.");
					return true;//está atrasado
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;//não está atrasado pois o cpf não está registrado na tabela
	}
	
	private boolean estaAtrasadoISBNSQL(String isbn) {
		int usuarioId = getLivroByISBN(isbn);
		LocalDate dataAtual = LocalDate.now();
//		java.sql.Date dataAtual = java.sql.Date.valueOf(dataAt);
		
		
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT data_emprestimo, data_entrega FROM emprestimo WHERE livro_id = ?");
			ps.setInt(1, usuarioId);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				java.sql.Date emprestimo = rs.getDate("data_emprestimo");
				java.sql.Date entrega = rs.getDate("data_entrega");
				
				LocalDate dataEmprestimo = emprestimo.toLocalDate();
				LocalDate dataEntrega = entrega.toLocalDate();
				if((dataAtual.isAfter(dataEmprestimo) || dataAtual.isEqual(dataEmprestimo) ) && (dataAtual.isBefore(dataEntrega)||dataAtual.isEqual(dataEntrega))) {
					return false;//não está atrasado
				}else {
					System.out.println("Emprestimo está atrasado. Estensão de prazo cancelada.");
					return true;//está atrasado
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;//não está atrasado pois o cpf não está registrado na tabela
	}
	
	private boolean usuarioPossuiEmprestimoEmAndamentoSQL(String cpf) {
		int usuarioId = getUsuarioByCPF(cpf);
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement("SELECT COUNT(*) AS count FROM emprestimo WHERE usuario_id = ? and status = true");
			ps.setInt(1, usuarioId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int count = rs.getInt("count");
				if(count>=1) {
					System.out.println("O usuário possui empréstimo em andamento. Operação cancelada.");
					return true;//tem emprestimo em andamento se for maior que 1
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false; // não tem emprestimo em andamento
	}
	
	private boolean getDisponibilidadeLivroSQL(String isbn) {
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT disponibilidade FROM livro WHERE isbn = ? ");
			ps.setString(1, isbn);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				boolean disponibilidade = rs.getBoolean("disponibilidade"); 
				if(disponibilidade) {
					return true;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	private int getLivroByISBN(String isbn) {
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement("SELECT id_livro FROM livro WHERE isbn = ?");
			ps.setString(1, isbn);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id_livro");
				return id;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	private int getUsuarioByCPF(String cpf) {
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement("SELECT id_usuario FROM usuario WHERE cpf = ?");
			ps.setString(1, cpf);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id = rs.getInt("id_usuario");
				return id;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return -1;
	}
	
	public void realizarDevolucaoSQL(String cpf) {
		int usuarioId = getUsuarioByCPF(cpf);
		PreparedStatement ps;
		int idEmprestimo;
		int livroId;
		String isbn;
		
		try {
			ps = connection.prepareStatement("SELECT id_emprestimo, livro_id FROM emprestimo WHERE usuario_id = ? and status = 1");
			ps.setInt(1, usuarioId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				idEmprestimo = rs.getInt("id_emprestimo");
				livroId = rs.getInt("livro_id");
				System.out.println(idEmprestimo+","+livroId);
				
				PreparedStatement ps2;
				ps2 = connection.prepareStatement("UPDATE emprestimo SET status = false WHERE id_emprestimo = ?");
				ps2.setInt(1, idEmprestimo);
				ps2.executeUpdate();
				
				PreparedStatement ps3;
				ps3 = connection.prepareStatement("SELECT isbn FROM livro WHERE id_livro = ?");
				ps3.setInt(1, livroId);
				ResultSet rs2 = ps3.executeQuery();
				if(rs2.next()) {
					isbn = rs2.getString("isbn");
					setDisponibilidadeSQL(true, isbn);
					System.out.println("Devolução concluida");
				}else {
					System.out.println("Esta devolução já foi realizada");
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void estenderEntrega(String isbn) {
		PreparedStatement ps;
		int livroId = getLivroByISBN(isbn);
		try {
			ps = connection.prepareStatement("SELECT data_entrega FROM emprestimo WHERE livro_id = ? and status = true and renovacao = false");
			ps.setInt(1, livroId);
			ResultSet rs;
			rs = ps.executeQuery();
			if(rs.next()) {
				if(estaConcluidoISBNSQL(isbn)==false&&estaAtrasadoISBNSQL(isbn) == false) {
					java.sql.Date entrega = rs.getDate("data_entrega");
					LocalDate dataEnt = entrega.toLocalDate();
					dataEnt = dataEnt.plusDays(7);
					PreparedStatement ps2;
					ps2 = connection.prepareStatement("UPDATE emprestimo SET data_entrega = ?, renovacao = true WHERE livro_id = ?");
					entrega = java.sql.Date.valueOf(dataEnt);
					ps2.setDate(1, entrega);
					ps2.setInt(2, livroId);
					ps2.executeUpdate();
					System.out.println("Estensão de prazo concluída");
					
				}
			}
			if(rs.next()==false) {
				System.out.println("A renovação já foi realizada antes ou já está concluída.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
