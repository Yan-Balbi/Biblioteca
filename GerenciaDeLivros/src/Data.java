
public class Data {
	private int _ano;
	private int _mes;
	private int _dia;
	
	Data(int dia, int mes, int ano){
		this._ano = SetAno(ano);
		this._mes = setMes(mes);
		this._dia = setDia(dia,mes);
	}
	
	private int setDia(int dia, int mes) {
		if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12){
			if (dia >= 1 && dia <=31) {
				return dia;
			}else{
				System.out.println("Valor de dia inválido. Valor definido como dia 1. Tente inserindo valores de 1 a 31.");
				return 1;
			}
			
		}else if(mes == 4 || mes == 6 || mes == 9 || mes == 11){
			if (dia >= 1 && dia <=30) {
				return dia;
			}else{
				System.out.println("Valor de dia inválido. Valor definido como dia 1. Tente inserindo valores de 1 a 30.");
				return 1;
			}
			
		}else if(mes == 2){
			if((_ano%4 == 0 && _ano%100 != 0) || _ano%400 == 0){
				if(dia >= 1 && dia <= 29) {
					return dia;
				} else {
					System.out.println("Valor de dia inválido. Valor definido como dia 1. O ano é bissexto e aceita até 29 dias");
					return 1;
				}
			}else if((_ano%4 != 0 && _ano%100 == 0) || _ano%400 != 0) {
				if(dia >= 1 && dia <=28) {
					return dia;
				}else {
					System.out.println("Valor de dia inválido. Valor definido como dia 1. O ano é bissexto e aceita até 28 dias");
					return 1;
				}
			}
		}
	
		System.out.println("Valor de dia inválido. Valor definido como dia 1.");
		return 1;
		
	}
	
	private int setMes(int mes) {
		if(mes >= 1 && mes <=12) {
			return mes;
		}else {
			System.out.println("Valor de mês inválido. Valor definido como mês 1. Tente inserindo valores de 1 a 12.");
			return 1;
		}
	}
	
	private int SetAno(int ano) {
		if(ano > 0) {
			return ano;
		}else {
			return 1;
		}
	}	
	
	void printData() {
		System.out.printf("%d / %d / %d",this._dia, this._mes, this._ano);
		System.out.println();
	}
	
}
