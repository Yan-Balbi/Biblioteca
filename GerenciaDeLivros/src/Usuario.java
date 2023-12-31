
public class Usuario {
	
	//private static List<String> listaCPF = new ArrayList<>();
	//private static List<String> listaUsuarios = new ArrayList<>();
	private String nome;
	private String cpf;
	
	
	
	Usuario(String nome, String cpf){		
		setNome(nome);
		setCPF(cpf);	
	}
	

	
	public void setCPF(String cpf) {
		this.cpf = cpf;
			//FUNÇÃO QUE VERIFICA SE O CPF ESTÁ REGISTRADO E O INSERE NA LISTA CASO NÃO
		/*if(encontrouCPF(cpf) == false ) {
			listaCPF.add(cpf);
		}*/
	}
	
	public void setNome(String nome) {
		this.nome = nome;
		//TODO: padrão DAO
		/*if(encontrouNome(nome) == false ) {
			listaUsuarios.add(nome);
		}*/
	}
	
	public String getCPF() {
		return this.cpf;
	}
	
	public String getNome() {
		return this.nome;
	}

	/*private boolean encontrouCPF(String cpf) {
		boolean encontrou = false;
		if(validacaoCPF(cpf) == true) {
			this.cpf = cpf; 
			for(String str : listaCPF) {
				if(str.equals(cpf)) {
					encontrou = true;
					break;
				} 
			}
			if(encontrou == false) {
				return false;
			} else  {
				return true;
			}
		} else {
			cpf = null;
		}
		return false;
	}
	
	private boolean encontrouNome(String nome) {
		boolean encontrou = false;
		for(String str : listaUsuarios) {
			if(str.equals(nome)) {
				encontrou = true;
				break;
			}
		}
		if(encontrou == false) {
			//listaUsuarios.add(nome);
			return false;
		} else  {
			return true;
		}
	}*/
	
	public static boolean validacaoCPF(String cpf) {
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
		//TODO: REFATORAR AS FUNÇÕES JOGANDO NUMA FUNÇÃO PRIVADA
	}
}
