package br.edu.iff.model;
import java.time.LocalDate;

public class Emprestimo {
	
	private LocalDate dataEmprestimo;
	private LocalDate dataDevolucao;
	private Usuario usuario;
	private Livro livro;
	
	public Emprestimo(Usuario usuario, Livro livro, LocalDate dataEmprestimo, LocalDate dataDevolucao){ // EMp = emprestimo; Dev = devolução
		setUsuario(usuario);
		setLivro(livro);
		setDataEmprestimo(dataEmprestimo);
		setDataDevolucao(dataDevolucao);
	}
	
	private void setDataEmprestimo(LocalDate dataEmprestimo){
		this.dataEmprestimo = dataEmprestimo;
	}
	
	private void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	private void setLivro(Livro livro) {
		this.livro = livro;
	}
	
	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}	
	
	public Usuario getUsuario() {
		return this.usuario;
	}
	
	public Livro getLivro() {
		return this.livro;
	}
	
	public LocalDate getDataEmprestimo() {
		return this.dataEmprestimo;
	}
	
	public LocalDate getDataDevolucao() {
		return this.dataDevolucao;
	}
	
}
