
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
	
	Livro(String isbn, String titulo, String editora, String categoria, boolean disponibilidade){
		if(validacaoISBN(isbn)) {
			setIsbn(isbn);
			setTitulo(titulo);
			setEditora(editora);
			setCategoria(categoria);
			setDisponibilidade(disponibilidade);
		}
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
