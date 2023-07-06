
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args) {
		//MENU
		
		UsuarioDAO usuarios = new UsuarioDAO();
		LivroDAO livros = new LivroDAO();
		EmprestimoDAO emprestimos = new EmprestimoDAO();
		
		
		while(true) {
			System.out.println("\n 1 - Cadastro de Usuário \n 2 - Cadastro de Livro \n 3 - Novo empréstimo \n 4 - Devolução \n 5 - Consulta de usuarios"
					+ " \n 6 - Consulta de Livros \n 7 - Consulta de emprestimos ativos \n 8 - Consulta de empréstimos atrasados \n 9 - consulta de empréstimos concluídos "
					+ "\n 10 - Atualizar Usuario \n 11 - Atualizar livro \n 12 - Estender entrega");
		    Scanner scan = new Scanner(System.in);
	        int opcao1 = scan.nextInt();
	        
	        switch(opcao1) {
	        	case 1:
	        		System.out.println("Insira o nome do usuario");
	        		String nomeUsuario = scan.next();
	        		System.out.println("Insira o cpf");
	        		String cpf = scan.next();
	        		usuarios.registroUsuarioSQL(nomeUsuario, cpf);
	        	break;
	        	
	        	case 2:
	        		System.out.println("Insira o nome do livro");
	        		String titulo = scan.next();
	        		System.out.println("Insira o ISBN do livro");
	        		String isbn = scan.next();
	        		System.out.println("Insira a editora do livro");
	        		String editora = scan.next();
	        		System.out.println("Insira a categoria do livro");
	        		String categoria = scan.next();
	        		livros.registroLivroSQL(isbn, titulo, editora, categoria);
	        		break;
	        	
	        	case 3:
	        		System.out.println("Insira o cpf do usuario");
	        		String cpf1 = scan.next();
	        		System.out.println("Insira o isbn do livro");
	        		String isbn1 = scan.next();
	        		EmprestimoDAO emprestimos1 = new EmprestimoDAO();
	        		emprestimos1.realizarEmprestimo(cpf1, isbn1);
	        		
	        		break;
	        	
	        	case 4:
	        		System.out.println("Insira o cpf do usuario");
	        		String cpf2 = scan.next();
	        		System.out.println("Insira o isbn do livro");
	        		String isbn2 = scan.next();
	        		EmprestimoDAO emprestimos2 = new EmprestimoDAO();
	        		emprestimos2.realizarDevolucaoSQL(cpf2);
	        		
	        		break;
	        	
	        	case 5:
	        		System.out.println("Consulta de usuario\n 'cpf' para consultar por cpf\n 'nome' para consultar por nome");
	        		String var1 = scan.next();
	        		List<Usuario> listaUsuarios = new LinkedList<>();
	        		if(var1.equals("cpf")) {
	        			System.out.println("Insira o cpf do usuario");
		        		String usuarioCPF = scan.next();
		        		
		        		listaUsuarios = usuarios.consultarUsuarioPorCPFSQL("58843744020");
		        		for(Usuario i : listaUsuarios) {
		        			System.out.println(i.getCPF()+"|"+i.getNome());
		        		}
	        		} else if (var1.equals("nome")) {
	        			System.out.println("Insira o nome do usuario");
		        		String usuarioNome = scan.next();
		        		
		        		listaUsuarios = usuarios.consultarUsuarioPorNomeSQL("Jose ");
		        		for(Usuario i : listaUsuarios) {
		        			System.out.println(i.getCPF()+"|"+i.getNome());
		        		}
	        		}else {
	        			System.out.println("Falha: método inserido não existe.");
	        		}
	        		break;
	        	
	        	case 6:
	        		System.out.println("Consulta de livro\n 'titulo' para consultar livro por cpf\n 'editora' para consultar livro por editora"
	        				+ "\n'categoria' para registrar livro por categoria \n'isbn' para registrar livro por isbn");
	        		String var2 = scan.next();
	        		System.out.println(var2);
	        		List<Livro> listaLivros2 = new ArrayList<>();
	        		if(var2.equals("titulo")) {
	        			System.out.println("Insira o título do livro");
	        			String tittle = scan.next();
	        			
	        			listaLivros2 = livros.consultarLivroPorNomeSQL(tittle);
	        			for(Livro i : listaLivros2) {
	        				System.out.println(i.getISBN()+"|"+i.getTitulo()+"|"+i.getEditora()+"|"+i.getCategoria());
	        			}
	        		}else if(var2.equals("editora")) {
	        			System.out.println("Insira o nome da editora");
	        			String edit = scan.next();
	        			
	        			listaLivros2 = livros.consultarLivroPorEditoraSQL("WMF Martins Pontes");
	        			for(Livro i : listaLivros2) {
	        				System.out.println(i.getISBN()+"|"+i.getTitulo()+"|"+i.getEditora()+"|"+i.getCategoria());
	        			}
	        		}else if(var2.equals("categoria")) {
	        			System.out.println("Insira a cadegoria do livro");
	        			String category = scan.next();
//	        			
	        			listaLivros2 = livros.consultarLivroPorCategoriaSQL("fantasia");
	        			for(Livro i : listaLivros2) {
	        				System.out.println(i.getISBN()+"|"+i.getTitulo()+"|"+i.getEditora()+"|"+i.getCategoria());
	        			}
	        		}else if(var2.equals("isbn")) {
	        			System.out.println("Insira o ISBN do livro");
	        			String idBook = scan.next();
	        			
	        			listaLivros2 = livros.consultarLivroPorIsbnSQL(idBook);
	        			for(Livro i : listaLivros2) {
	        				System.out.println(i.getISBN()+"|"+i.getTitulo()+"|"+i.getEditora()+"|"+i.getCategoria());
	        			}
	        		}
	        		else {
	        			System.out.println("Falha");
	        		}
	        		break;
	        	
	        	case 7:
	        		System.out.println("Consulta de empréstimos ativos");
	        		List<EmprestimoLivros> listaEmprestimos= new LinkedList<>();
	        		
	        		emprestimos.consultarEmprestimosAtivosSQL();
	        		
	        		for(EmprestimoLivros i : listaEmprestimos) {
	    				System.out.println(i.getUsuario().getCPF()+"|"+i.getUsuario().getNome()+"|"+i.getLivro().getISBN()+"|"+i.getLivro().getTitulo()+"|"
	    				+i.getLivro().getEditora()+"|"+i.getLivro().getCategoria()+"|"+i.getDataEmprestimo()+"|"+i.getDataDevolucao());
	    			}
	        		break;
	        	
	        	case 8:
	        		System.out.println("Consulta de empréstimos atrasados");
	        		List<EmprestimoLivros> listaEmprestimos2= new LinkedList<>();
	        		
	        		emprestimos.consultarEmprestimosAtrasadosSQL();
	        		
	        		for(EmprestimoLivros i : listaEmprestimos2) {
	    				System.out.println(i.getUsuario().getCPF()+"|"+i.getUsuario().getNome()+"|"+i.getLivro().getISBN()+"|"+i.getLivro().getTitulo()+"|"
	    				+i.getLivro().getEditora()+"|"+i.getLivro().getCategoria()+"|"+i.getDataEmprestimo()+"|"+i.getDataDevolucao());
	    			}
	        		break;
	        	
	        	case 9:
	        		System.out.println("Consulta de empréstimos concluídos");
	        		List<EmprestimoLivros> listaEmprestimos3= new LinkedList<>();
	        		
	        		emprestimos.consultarEmprestimosConcluidosSQL();
	        		
	        		for(EmprestimoLivros i : listaEmprestimos3) {
	    				System.out.println(i.getUsuario().getCPF()+"|"+i.getUsuario().getNome()+"|"+i.getLivro().getISBN()+"|"+i.getLivro().getTitulo()+"|"
	    				+i.getLivro().getEditora()+"|"+i.getLivro().getCategoria()+"|"+i.getDataEmprestimo()+"|"+i.getDataDevolucao());
	    			}
	        		break;
	        	case 10:
	        		break;
	        	case 11:
	        		break;
	        	case 12:
	        		break;
	        }
	        
		}
		//===========================================LIVRO====================================================
//		livros.registroLivroSQL("9788533622104", "As Crônicas de Nárnia Volume Único", "WMF Martins Pontes", "fantasia");
//		livros.registroLivroSQL("9789510445877", "A torre da andorinha", "WMF Martins Pontes", "fantasia");
//		livros.registroLivroSQL("9780307969941", "Neuromancer", "Aleph", "ficcao cientifica");
//		livros.registroLivroSQL("9788576573203", "Encarcerados", "John Scalzi", "ficao cientifica");
//		livros.registroLivroSQL("9788556520487", "Relatos de um gato viajante", "Alfaguara", "ficcao contemporani");
//		livros.registroLivroSQL("9788576572046", "Snow Crash", "Aleph", "ficao cientifica");
		
		//livros.registroLivroSQL("9780316160179", "Crepusculo", "Editora", "romance");
		//List<Livro> listaLivros2 = new ArrayList<>();

//		listaLivros2 = livros.consultarLivroPorIsbnSQL("9789510445877");
//		for(Livro i : listaLivros2) {
//			System.out.println(i.getISBN()+"|"+i.getTitulo()+"|"+i.getEditora()+"|"+i.getCategoria());
//		}
		
//		listaLivros2 = livros.consultarLivroPorNomeSQL("A torre da andorinha");
//		for(Livro i : listaLivros2) {
//			System.out.println(i.getISBN()+"|"+i.getTitulo()+"|"+i.getEditora()+"|"+i.getCategoria());
//		}
		
//		listaLivros2 = livros.consultarLivroPorEditoraSQL("WMF Martins Pontes");
//		for(Livro i : listaLivros2) {
//			System.out.println(i.getISBN()+"|"+i.getTitulo()+"|"+i.getEditora()+"|"+i.getCategoria());
//		}
		
//		listaLivros2 = livros.consultarLivroPorCategoriaSQL("fantasia");
//		for(Livro i : listaLivros2) {
//			System.out.println(i.getISBN()+"|"+i.getTitulo()+"|"+i.getEditora()+"|"+i.getCategoria());
//		}
		
//		listaLivros2 = livros.listarLivros();
//		for(Livro i : listaLivros2) {
//			System.out.println(i.getISBN()+"|"+i.getTitulo()+"|"+i.getEditora()+"|"+i.getCategoria());
//		}
//		System.out.println(Livro.validacaoISBN("9788533622104"));
		
//		livros.atualizarLivroSQL("9788576573203");
		
//		livros.removerLivroSQL("9780316160179");
		
//		livros.atualizarLivroSQL("1234567");
		
		//==========================================USUARIO===================================================

		//List<Usuario> listaUsuarios = new LinkedList<>();
		
//		usuarios.registroUsuarioSQL("Yan Nascimento", "12141726794");
		
		//usuarios.registroUsuarioSQL("Jose das couves", "58843744020");
//		usuarios.registroUsuarioSQL("Maria dos Alfaces", "67951635049");
//		usuarios.registroUsuarioSQL("Zé Banana", "36957729052");
//		usuarios.registroUsuarioSQL("Jose da Pera", "97129963018");
//		usuarios.registroUsuarioSQL("Zé da Manga", "94416527098");
		

//		usuarios.removerUsuarioSQL("94416527098");
		
//		listaUsuarios = usuarios.consultarUsuarioPorCPFSQL("58843744020");
//		for(Usuario i : listaUsuarios) {
//			System.out.println(i.getCPF()+"|"+i.getNome());
//		}
		
//		listaUsuarios = usuarios.consultarUsuarioPorNomeSQL("Jose ");
//		for(Usuario i : listaUsuarios) {
//			System.out.println(i.getCPF()+"|"+i.getNome());
//		}
		
//		listaUsuarios = usuarios.listarUsuariosSQL();
//		for(Usuario i : listaUsuarios) {
//			System.out.println(i.getCPF()+"|"+i.getNome());
//		}
		
//		usuarios.atualizarUsuarioSQL("12141726794");
//		usuarios.removerUsuarioSQL("94416527098");
		
		
		//========================================EMPRESTIMO==================================================
//		List<EmprestimoLivros> listaEmprestimos= new LinkedList<>();
		//System.out.println(emprestimos.getDisponibilidadeLivro("9788533622104"));
//		emprestimos.setDisponibilidade(true, "9788533622104");
//		System.out.println(emprestimos.getLivroByISBN("9788533622104"));
//		System.out.println(emprestimos.getUsuarioByCPF("58843744020"));
		//System.out.println(emprestimos.usuarioPossuiEmprestimoEmAndamentoSQL("58843744020"));
//		emprestimos.realizarEmprestimo("12141726794", "9780307969941");
//		emprestimos.realizarDevolucaoSQL("12141726794");
		//System.out.println(emprestimos.estaAtrasadoSQL("12141726794"));
		
//		listaEmprestimos = emprestimos.consultarEmprestimosAtivosSQL();
//		for(EmprestimoLivros i : listaEmprestimos) {
//			System.out.println(i.getUsuario().getCPF()+"|"+i.getUsuario().getNome()+"|"+i.getLivro().getISBN()+"|"+i.getLivro().getTitulo()+"|"
//			+i.getLivro().getEditora()+"|"+i.getLivro().getCategoria()+"|"+i.getDataEmprestimo()+"|"+i.getDataDevolucao());
//		}
		
//		listaEmprestimos = emprestimos.consultarEmprestimosAtrasadosSQL();
//		for(EmprestimoLivros i : listaEmprestimos) {
//			System.out.println(i.getUsuario().getCPF()+"|"+i.getUsuario().getNome()+"|"+i.getLivro().getISBN()+"|"+i.getLivro().getTitulo()+"|"
//			+i.getLivro().getEditora()+"|"+i.getLivro().getCategoria()+"|"+i.getDataEmprestimo()+"|"+i.getDataDevolucao());
//		}
		
//		listaEmprestimos = emprestimos.consultarEmprestimosConcluidosSQL();
//		for(EmprestimoLivros i : listaEmprestimos) {
//			System.out.println(i.getUsuario().getCPF()+"|"+i.getUsuario().getNome()+"|"+i.getLivro().getISBN()+"|"+i.getLivro().getTitulo()+"|"
//			+i.getLivro().getEditora()+"|"+i.getLivro().getCategoria()+"|"+i.getDataEmprestimo()+"|"+i.getDataDevolucao());
//		}
//		emprestimos.realizarEmprestimo("94416527098", "9788576572046");
		//emprestimos.estenderEntrega("9780307969941");
		
		
	}
}
