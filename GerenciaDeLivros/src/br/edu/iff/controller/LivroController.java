package br.edu.iff.controller;
import java.util.ArrayList;
import java.util.List;

import br.edu.iff.dao.LivroDAO;
import br.edu.iff.model.Livro;

public class LivroController {
	LivroDAO livro = new LivroDAO();
	
	public void insertLivro(String isbn, String titulo, String editora, String categoria) {
		if(validacaoISBN(isbn)) {
			livro.registroLivroSQL(isbn, titulo, editora, categoria);
		}else {
			System.out.println("ISBN inválido");
		}
	}
	
	public void updateLivro(String isbnAtual, String novoIsbn, String nome, String editora, String categoria){
		if(validacaoISBN(novoIsbn)) {
			livro.atualizarLivroSQL(isbnAtual, novoIsbn, nome, editora, categoria);
		}else {
			System.out.println("ISBN inválido");
		}
		
	}
	
	public void deleteLivro(String isbn) {
		livro.removerLivroSQL(isbn);
	}
	
	public List<Livro> listarLivros() {
		List<Livro> listaLivros = new ArrayList<>();
		listaLivros = livro.listarLivros();
		return listaLivros;
	}
	
	public List<Livro> getLivroPorIsbn(String isbn) {
		List<Livro> listaLivros = new ArrayList<>();
		listaLivros = livro.consultarLivroPorIsbnSQL(isbn);
		return listaLivros;
	}
	
	public List<Livro> getLivroPorTitulo(String titulo) {
		List<Livro> listaLivros = new ArrayList<>();
		listaLivros = livro.consultarLivroPorNomeSQL(titulo);
		return listaLivros;
	}
	
	public List<Livro> getLivroPorEditora(String editora) {
		List<Livro> listaLivros = new ArrayList<>();
		listaLivros = livro.consultarLivroPorEditoraSQL(editora);
		return listaLivros;
	}
	
	public List<Livro> getLivroPorCategoria(String categoria) {
		List<Livro> listaLivros = new ArrayList<>();
		listaLivros = livro.consultarLivroPorCategoriaSQL(categoria);
		return listaLivros;
	}
	
	
	public static boolean validacaoISBN(String isbn) {
		int soma = 0, resto, restoValidacao;
		isbn = isbn.replace(".", "").replace("-", "").trim();
		
		if(isbn.length() != 13) {
			return false;
		}
		
		
		for(int i =0; i<isbn.length()-1; i++) {
			int peso;
			int elementoISBN = Character.getNumericValue(isbn.charAt(i)); 
			if(i%2 == 0) {
				peso = 1;
			} else {
				peso = 3;
			}
			soma += peso*elementoISBN;
		}
		//System.out.println(soma);
		resto = soma%10;
		if(resto ==0) {
			restoValidacao = 0;
			if(Character.getNumericValue(isbn.charAt(12)) == 0 ) {
				return true;
			}
			return false;
		}
		
		restoValidacao = 10-resto;
		if(Character.getNumericValue(isbn.charAt(12)) == restoValidacao) {
			return true;
		}
		return false;
	}
	
}
