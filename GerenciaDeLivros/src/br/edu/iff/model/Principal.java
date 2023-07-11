package br.edu.iff.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import br.edu.iff.controller.EmprestimoController;
import br.edu.iff.controller.LivroController;
import br.edu.iff.controller.UsuarioController;
import br.edu.iff.dao.*;

public class Principal {
	public static void main(String[] args) {	
		UsuarioController usuarios = new UsuarioController();
		LivroController livros = new LivroController();
		EmprestimoController emprestimos = new EmprestimoController();
		
		
/*		while(true) {
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
	        		//usuarios.registroUsuarioSQL(nomeUsuario, cpf);
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
	        		//livros.registroLivroSQL(isbn, titulo, editora, categoria);
	        		break;
	        	
	        	case 3:
	        		System.out.println("Insira o cpf do usuario");
	        		String cpf1 = scan.next();
	        		System.out.println("Insira o isbn do livro");
	        		String isbn1 = scan.next();
	        		EmprestimoDAO emprestimos1 = new EmprestimoDAO();
	        		//emprestimos1.realizarEmprestimo(cpf1, isbn1);
	        		
	        		break;
	        	
	        	case 4:
	        		System.out.println("Insira o cpf do usuario");
	        		String cpf2 = scan.next();
	        		System.out.println("Insira o isbn do livro");
	        		String isbn2 = scan.next();
	        		EmprestimoDAO emprestimos2 = new EmprestimoDAO();
	        		//emprestimos2.realizarDevolucaoSQL(cpf2);
	        		
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
	        		List<Emprestimo> listaEmprestimos= new LinkedList<>();
	        		
	        		emprestimos.consultarEmprestimosAtivosSQL();
	        		
	        		for(Emprestimo i : listaEmprestimos) {
	    				System.out.println(i.getUsuario().getCPF()+"|"+i.getUsuario().getNome()+"|"+i.getLivro().getISBN()+"|"+i.getLivro().getTitulo()+"|"
	    				+i.getLivro().getEditora()+"|"+i.getLivro().getCategoria()+"|"+i.getDataEmprestimo()+"|"+i.getDataDevolucao());
	    			}
	        		break;
	        	
	        	case 8:
	        		System.out.println("Consulta de empréstimos atrasados");
	        		List<Emprestimo> listaEmprestimos2= new LinkedList<>();
	        		
	        		emprestimos.consultarEmprestimosAtrasadosSQL();
	        		
	        		for(Emprestimo i : listaEmprestimos2) {
	    				System.out.println(i.getUsuario().getCPF()+"|"+i.getUsuario().getNome()+"|"+i.getLivro().getISBN()+"|"+i.getLivro().getTitulo()+"|"
	    				+i.getLivro().getEditora()+"|"+i.getLivro().getCategoria()+"|"+i.getDataEmprestimo()+"|"+i.getDataDevolucao());
	    			}
	        		break;
	        	
	        	case 9:
	        		System.out.println("Consulta de empréstimos concluídos");
	        		List<Emprestimo> listaEmprestimos3= new LinkedList<>();
	        		
	        		emprestimos.consultarEmprestimosConcluidosSQL();
	        		
	        		for(Emprestimo i : listaEmprestimos3) {
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
	        
		}*/
		
		//===========================================LIVRO====================================================
//		livros.insertLivro("9788533622104", "As Crônicas de Nárnia Volume Único", "WMF Martins Pontes", "fantasia");
//		livros.insertLivro("9789510445877", "A torre da andorinha", "WMF Martins Pontes", "fantasia");
//		livros.insertLivro("9780307969941", "Neuromancer", "Aleph", "ficcao cientifica");
//		livros.insertLivro("9788576573203", "Encarcerados", "John Scalzi", "ficao cientifica");
//		livros.insertLivro("9788556520487", "Relatos de um gato viajante", "Alfaguara", "ficcao contemporani");
//		livros.insertLivro("9788576572046", "Snow Crash", "Aleph", "ficao cientifica");
		
		
		List<Livro> listaLivros2 = new ArrayList<>();

//		listaLivros2 = livros.getLivroPorIsbn("9789510445877");
//		for(Livro i : listaLivros2) {
//			System.out.println(i.getISBN()+"|"+i.getTitulo()+"|"+i.getEditora()+"|"+i.getCategoria());
//		}
		
//		listaLivros2 = livros.getLivroPorTitulo("A torre da andorinha");
//		for(Livro i : listaLivros2) {
//			System.out.println(i.getISBN()+"|"+i.getTitulo()+"|"+i.getEditora()+"|"+i.getCategoria());
//		}
		
//		listaLivros2 = livros.getLivroPorEditora("WMF Martins Pontes");
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
				
//		livros.updateLivro("9788556520487","9788556520487","Relatos de um gato viajante","Alfaguara","ficção contemporânea");
		
//		livros.removerLivroSQL("9780316160179");
		
		//==========================================USUARIO===================================================

		List<Usuario> listaUsuarios = new LinkedList<>();
		
//		usuarios.insertUsuario("Yan Nascimento", "12141726794");
		
//		usuarios.insertUsuario("Jose das couves", "58843744020");
//		usuarios.insertUsuario("Maria dos Alfaces", "67951635049");
//		usuarios.insertUsuario("Zé Banana", "36957729052");
//		usuarios.insertUsuario("Jose da Pera", "97129963018");
//		usuarios.insertUsuario("Zé da Manga", "94416527098");
//		usuarios.insertUsuario("Manoel Gomes", "29706609032");
		

//		usuarios.deleteUsuario("29706609032");
		
//		listaUsuarios = usuarios.getUsuarioPorCpf("58843744020");
//		for(Usuario i : listaUsuarios) {
//			System.out.println(i.getCPF()+"|"+i.getNome());
//		}
		
//		listaUsuarios = usuarios.getUsuarioPorNome("José ");
//		for(Usuario i : listaUsuarios) {
//			System.out.println(i.getCPF()+"|"+i.getNome());
//		}
		
//		listaUsuarios = usuarios.listarUsuarios();
//		for(Usuario i : listaUsuarios) {
//			System.out.println(i.getCPF()+"|"+i.getNome());
//		}
		
//		usuarios.updateUsuario("29706609032","29706609032","Manoel Gomes Blue Pen");
		
		//========================================EMPRESTIMO==================================================
		List<Emprestimo> listaEmprestimos= new LinkedList<>();
//		emprestimos.registerEmprestimo("12141726794", "9789510445877");
//		emprestimos.accomplishEmprestimo("12141726794");
		
//		listaEmprestimos = emprestimos.getEmprestimosAtivos();
//		for(Emprestimo i : listaEmprestimos) {
//			System.out.println(i.getUsuario().getCPF()+"|"+i.getUsuario().getNome()+"|"+i.getLivro().getISBN()+"|"+i.getLivro().getTitulo()+"|"
//			+i.getLivro().getEditora()+"|"+i.getLivro().getCategoria()+"|"+i.getDataEmprestimo()+"|"+i.getDataDevolucao());
//		}
		
		//OBSERVAÇÃO: CONSIDEREI QUE MESMO ATRASADO, UM EMPRESTIMO PERMANECE ATIVO SE NÃO FOR ENTREGUE, MAS POSSO ALTERAR ISSO ADICIONANDO "AND data_entrega >= CURRENT_DATE()" 
		//NA CLÁUSULA SQL
		
//		listaEmprestimos = emprestimos.getEmprestimosAtrasados();
//		for(Emprestimo i : listaEmprestimos) {
//			System.out.println(i.getUsuario().getCPF()+"|"+i.getUsuario().getNome()+"|"+i.getLivro().getISBN()+"|"+i.getLivro().getTitulo()+"|"
//			+i.getLivro().getEditora()+"|"+i.getLivro().getCategoria()+"|"+i.getDataEmprestimo()+"|"+i.getDataDevolucao());
//		}
		
//		listaEmprestimos = emprestimos.getEmprestimosConcluidos();
//		for(Emprestimo i : listaEmprestimos) {
//			System.out.println(i.getUsuario().getCPF()+"|"+i.getUsuario().getNome()+"|"+i.getLivro().getISBN()+"|"+i.getLivro().getTitulo()+"|"
//			+i.getLivro().getEditora()+"|"+i.getLivro().getCategoria()+"|"+i.getDataEmprestimo()+"|"+i.getDataDevolucao());
//		}
		
//		emprestimos.realizarEmprestimo("94416527098", "9788576572046");
//		emprestimos.estenderEntrega("9789510445877");
		
		
	}
}
