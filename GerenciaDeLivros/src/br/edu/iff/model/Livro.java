package br.edu.iff.model;

public class Livro {
	//int quantidade;
	private String isbn;
	private String titulo;
	private String editora;
	private String categoria;
	//private boolean disponivelParaEmprestimo = true;
	private boolean disponivelParaEmprestimo;
	
	Livro(){
		
	}
	
	public Livro(String isbn, String titulo, String editora, String categoria, boolean disponibilidade){
		setIsbn(isbn);
		setTitulo(titulo);
		setEditora(editora);
		setCategoria(categoria);
		setDisponibilidade(disponibilidade);
		
	}
	
	public String getISBN() {
		return this.isbn;
	}
	
	public String getTitulo() {
		return this.titulo;
	}
	
	public String getEditora() {
		return this.editora;
	}
	
	public String getCategoria() {
		return this.categoria;
	}
	
//	public boolean getDisponibilidade() {
//		return this.disponivelParaEmprestimo;
//	}
	
	public boolean getDisponibilidade() {
		return this.disponivelParaEmprestimo;
	}
	
	private void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	private void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	private void setEditora(String editora) {
		this.editora = editora;
	}
	
	private void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
//	public void setDisponibilidade(boolean value) {
//		this.disponivelParaEmprestimo = value;
//	}
	
	public void setDisponibilidade(boolean value) {
		//if(value == 0 || value == 1) {
			this.disponivelParaEmprestimo = value;
		//}
	}
	
}
