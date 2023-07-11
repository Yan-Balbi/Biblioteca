package br.edu.iff.controller;

import java.util.LinkedList;
import java.util.List;

import br.edu.iff.dao.UsuarioDAO;
import br.edu.iff.model.Usuario;

public class UsuarioController {
	UsuarioDAO usuario = new UsuarioDAO();
	
	public void insertUsuario(String nome, String cpf) {
		if(validacaoCPF(cpf)) {
			usuario.registroUsuarioSQL(nome, cpf);
		}else {
			System.out.println("CPF inválido!");
		}
	}
	
	public void updateUsuario(String cpfAtual, String cpfNovo, String nome) {
		if(validacaoCPF(cpfAtual)) {
			usuario.atualizarUsuarioSQL(cpfAtual, cpfNovo, nome);
		}else {
			System.out.println("CPF inválido!");
		}
	}
	
	public void  deleteUsuario(String cpf) {
		usuario.removerUsuarioSQL(cpf);
	}
	
	public List<Usuario> getUsuarioPorNome(String nome) {
		List<Usuario> listaUsuarios = new LinkedList<>();
		listaUsuarios = usuario.consultarUsuarioPorNomeSQL(nome);
		return listaUsuarios;
	}
	
	public List<Usuario> getUsuarioPorCpf(String cpf) {
		List<Usuario> listaUsuarios = new LinkedList<>();
		listaUsuarios = usuario.consultarUsuarioPorCPFSQL(cpf);
		return listaUsuarios;
	}
	
	public List<Usuario> listarUsuarios() {
		List<Usuario> listaUsuarios = new LinkedList<>();
		listaUsuarios = usuario.listarUsuariosSQL();
		return listaUsuarios;
	}
	
	private static boolean validacaoCPF(String cpf) {
		int cont = 10, cont2 = 11;
		int  resto1, soma1 = 0;
		int resto2, soma2 = 0;
		
		if(cpf == null)
		{
			return true;
		}
		for(int i = 0; i<14; i++) {
			cpf = cpf.replace(".", "").replace("-", "").trim();
			//cpf = cpf.replace(".", "");
		}
		
		for(int i = 0; i<9; i++) {
			soma1 += cont*Character.getNumericValue(cpf.charAt(i));
			cont--; //ao inves de usar cont, poderia usar (10-i)
		}
		
		resto1 = soma1%11;
		if(resto1 < 2) {
			if(Character.getNumericValue(cpf.charAt(9)) != 0) {
				return false;
			}
		}else {
			if(Character.getNumericValue(cpf.charAt(9)) != (11- resto1)) {
				return false;
			}
		}
		
		for(int i = 0; i<10; i++) {
			soma2 += cont2*Character.getNumericValue(cpf.charAt(i)); //TODO: O CONT2 ERA CONT APENAS
			cont2--;  // ao inves de usar cont, poderia usar (11-i)
		}
		
		resto2 = soma2%11;
		if(resto2 < 2) {
			if(Character.getNumericValue(cpf.charAt(10)) != 0) {
				return false;
			}
		}else {
			if(Character.getNumericValue(cpf.charAt(10)) != (11- resto2)) {
				return false;
			}
		}
		
		return true;
	}
}
