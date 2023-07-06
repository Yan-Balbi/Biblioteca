import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LivroDAO {
	//static public List<Livro> listaLivros = new ArrayList<>();
	Connection connection;
	
	LivroDAO(){
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/biblioteca?user=root");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	List<Livro> listarLivros() {
		List<Livro> listaLivros = new ArrayList<>();
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM livro ");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String livroISBN = rs.getString("isbn");
				String livroTitulo = rs.getString("titulo");
				String livroEditora = rs.getString("editora");
				String livroCategoria = rs.getString("categoria");
				boolean livroDisponibilidade = rs.getBoolean("disponibilidade");
				
				//System.out.println(livroISBN+ "|" +livroTitulo+ "|" +livroEditora+ "|" +livroCategoria+ "|" +livroDisponibilidade);
				
				Livro livro = new Livro(livroISBN, livroTitulo, livroEditora, livroCategoria, livroDisponibilidade);
				listaLivros.add(livro);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listaLivros;
	}
	
	List<Livro> consultarLivroPorNomeSQL(String titulo){
		List<Livro> listaLivros = new ArrayList<>();
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM livro WHERE titulo LIKE ? ");
			ps.setString(1, "%"+titulo+"%");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String livroISBN = rs.getString("isbn");
				String livroTitulo = rs.getString("titulo");
				String livroEditora = rs.getString("editora");
				String livroCategoria = rs.getString("categoria");
				boolean livroDisponibilidade = rs.getBoolean("disponibilidade");
				
				Livro livro = new Livro(livroISBN, livroTitulo, livroEditora, livroCategoria, livroDisponibilidade);
				listaLivros.add(livro);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaLivros;
	}
	
//	static List<Livro> consultarLivroPorNome(String titulo) {
//		List<Livro> livrosPorNome = new ArrayList<>();
//		for(Livro livro: listaLivros) {
//			if(livro.getTitulo().equals(titulo)) {
//				livrosPorNome.add(livro);
//				System.out.println("ISBN - "+livro.getISBN()+"\n"+"Editora - "+livro.getEditora()+"\n"+"Categoria - "+livro.getCategoria()+"\n"+"Titulo - "+livro.getTitulo()+"\n----------------");
//			}
//		}
//		return livrosPorNome;
//	}
	
	List<Livro> consultarLivroPorEditoraSQL(String editora){
		List<Livro> listaLivros = new ArrayList<>();
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM livro WHERE editora = ? ");
			ps.setString(1, editora);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String livroISBN = rs.getString("isbn");
				String livroTitulo = rs.getString("titulo");
				String livroEditora = rs.getString("editora");
				String livroCategoria = rs.getString("categoria");
				boolean livroDisponibilidade = rs.getBoolean("disponibilidade");
				
				Livro livro = new Livro(livroISBN, livroTitulo, livroEditora, livroCategoria, livroDisponibilidade);
				listaLivros.add(livro);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaLivros;
	}
	
//	static List<Livro> consultarLivroPorEditora(String editora) {
//		List<Livro> livrosPorEditora = new ArrayList<>();
//		for(Livro livro: listaLivros) {
//			if(livro.getEditora().equals(editora)) {
//				livrosPorEditora.add(livro);
//				System.out.println("ISBN - "+livro.getISBN()+"\n"+"Editora - "+livro.getEditora()+"\n"+"Categoria - "+livro.getCategoria()+"\n"+"Titulo - "+livro.getTitulo()+"\n----------------");
//			}
//		}
//		return livrosPorEditora;
//	}
	
	List<Livro> consultarLivroPorCategoriaSQL(String categoria){
		List<Livro> listaLivros = new ArrayList<>();
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM livro WHERE categoria = ? ");
			ps.setString(1, categoria);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String livroISBN = rs.getString("isbn");
				String livroTitulo = rs.getString("titulo");
				String livroEditora = rs.getString("editora");
				String livroCategoria = rs.getString("categoria");
				boolean livroDisponibilidade = rs.getBoolean("disponibilidade");
				
				Livro livro = new Livro(livroISBN, livroTitulo, livroEditora, livroCategoria, livroDisponibilidade);
				listaLivros.add(livro);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaLivros;
	}
	
//	static List<Livro> consultarLivroPorCategoria(String categoria) {
//		List<Livro> livrosPorCategoria = new ArrayList<>();
//		for(Livro livro: listaLivros) {
//			if(livro.getCategoria().equals(categoria)) {
//				livrosPorCategoria.add(livro);
//				System.out.println("ISBN - "+livro.getISBN()+"\n"+"Editora - "+livro.getEditora()+"\n"+"Categoria - "+livro.getCategoria()+"\n"+"Titulo - "+livro.getTitulo()+"\n----------------");
//			}
//		}
//		return livrosPorCategoria;
//	}
	
	List<Livro> consultarLivroPorIsbnSQL(String isbn){
		List<Livro> listaLivros = new ArrayList<>();
		PreparedStatement ps;
		
		try {
			ps = connection.prepareStatement("SELECT * FROM livro WHERE isbn = ? ");
			ps.setString(1, isbn);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				String livroISBN = rs.getString("isbn");
				String livroTitulo = rs.getString("titulo");
				String livroEditora = rs.getString("editora");
				String livroCategoria = rs.getString("categoria");
				boolean livroDisponibilidade = rs.getBoolean("disponibilidade");
				
				Livro livro = new Livro(livroISBN, livroTitulo, livroEditora, livroCategoria, livroDisponibilidade);
				listaLivros.add(livro);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaLivros;
	}
	
//	static List<Livro> consultarLivroPorIsbn(String isbn) {
//		List<Livro> livrosPorIsbn = new ArrayList<>();
//		for(Livro livro: listaLivros) {
//			if(livro.getISBN().equals(isbn)) {
//				livrosPorIsbn.add(livro);
//				System.out.println("ISBN - "+livro.getISBN()+"\n"+"Editora - "+livro.getEditora()+"\n"+"Categoria - "+livro.getCategoria()+"\n"+"Titulo - "+livro.getTitulo()+"\n----------------");
//			}
//		}
//		return livrosPorIsbn;
//	}
	
	void registroLivroSQL( String isbn, String nome, String  editora, String categoria) {//use o retorno true or false no Principal para falar se for cadastrado ou não!!!!!
		
		PreparedStatement ps;
		if(Livro.validacaoISBN(isbn)) {
			if(verificacaoRegistroLivroSQL(isbn) == true) {
//				System.out.println("Livro já registrado!");
				
			}else {
				try {
					
					ps = connection.prepareStatement("INSERT INTO livro(isbn, titulo, editora, categoria,disponibilidade) VALUES (?,?,?,?,true)");
					ps.setString(1, isbn);
					ps.setString(2, nome);
					ps.setString(3, editora);
					ps.setString(4, categoria);
					ps.execute();
							
					System.out.println("Registro concluido");
				} catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}else {
			System.out.println("ISBN inválido!");
		}	
	}

	boolean verificacaoRegistroLivroSQL(String isbn) {
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("SELECT COUNT(*) AS count FROM livro WHERE isbn = ?");//TODO:VER ISSO DEPOIS!!!!!!!!!!!!!!!!!!!!(FALNTADO O WHERE)
			ps.setString(1, isbn);
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				int count = rs.getInt("count");
				
				if(count >= 1) {
					System.out.println("Isbn de livro já cadastrado!");
					return true;
				} else {
					return false;
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Cadastro concluído!");
		return false;
	}
	
//	boolean verificacaoRegistroLivro(String isbn) {
//		for( Livro livro : listaLivros) {
//			if(livro.getISBN().equals(isbn)) {
//				return true;
//			}
//		}
//		return false;
//	}
	
//	static Livro getObjetoLivro(String isbn) {
//		//CRUDLivros livros = new CRUDLivros();
//		for(Livro livro: LivroDAO.listarLivros()) {
//			if(livro.getISBN().equals(isbn)) {
//				return livro;
//			}
//		}
//		return null;
//	}
	
	void removerLivroSQL( String isbn) {//use o retorno true or false no Principal para falar se for cadastrado ou não!!!!!
		//Livro livro = new Livro(isbn,nome, editora, categoria);
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement("DELETE FROM livro WHERE isbn = ?");
			ps.setString(1, isbn);
			ps.executeUpdate();
			System.out.println("Remoção concluida");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	void atualizarLivroSQL(String codigo){
		PreparedStatement ps;
		Scanner scanner = new Scanner(System.in);
		
        System.out.print("Insira o novo ISBN: ");
        String isbn = scanner.nextLine();
		
        System.out.print("Insira o novo nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("Insira o novo nome da editora: ");
        String editora = scanner.nextLine();
        
        System.out.print("Insira a nova categoria: ");
        String categoria = scanner.nextLine();
		
        try {    
	        if(Livro.validacaoISBN(isbn)) {
	        	System.out.println(isbn+": ok!");
				ps = connection.prepareStatement("UPDATE livro SET isbn = ?, titulo = ?,editora = ?, categoria = ? WHERE isbn = ? ");
				ps.setString(1, isbn);
				ps.setString(2, nome);
				ps.setString(3, editora);
				ps.setString(4, categoria);
				ps.setString(5, codigo);
				System.out.println("Atualização concluida");
				ps.executeUpdate();	        	
	        }else {
	        	System.out.println("ISBN inválido!");
	        }		
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
