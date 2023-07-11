package br.edu.iff.controller;
import java.util.ArrayList;
import java.util.List;

import br.edu.iff.dao.EmprestimoDAO;
import br.edu.iff.model.Emprestimo;

public class EmprestimoController {
	EmprestimoDAO emprestimo = new EmprestimoDAO();
	
	public void registerEmprestimo(String cpf, String isbn) {
		emprestimo.realizarEmprestimo(cpf, isbn);
	}
	
	public void accomplishEmprestimo(String cpf) {
		emprestimo.realizarDevolucaoSQL(cpf);
	}
	
	public void estenderEntrega(String isbn) {
		emprestimo.estenderEntrega(isbn);
	}
	
	public List<Emprestimo> getEmprestimosAtivos() {
		List<Emprestimo> listaEmprestimos = new ArrayList<>();
		listaEmprestimos = emprestimo.consultarEmprestimosAtivosSQL();
		return listaEmprestimos;
	}
	
	public List<Emprestimo> getEmprestimosAtrasados() {
		List<Emprestimo> listaEmprestimos = new ArrayList<>();
		listaEmprestimos = emprestimo.consultarEmprestimosAtrasadosSQL();
		return listaEmprestimos;
	}
	
	public List<Emprestimo> getEmprestimosConcluidos() {
		List<Emprestimo> listaEmprestimos = new ArrayList<>();
		
		listaEmprestimos = emprestimo.consultarEmprestimosConcluidosSQL();
		return listaEmprestimos;
	}
	
}
