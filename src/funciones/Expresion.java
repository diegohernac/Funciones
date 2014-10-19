package funciones;

import java.util.ArrayList;

public class Expresion {
	private ArrayList<String> operadoresBinarios = new ArrayList<String>();
	private ArrayList<String> operadoresUnario = new ArrayList<String>();
	private static Expresion expresion = new Expresion(); 
	
	protected Expresion(){
		operadoresBinarios.add("+");
		operadoresBinarios.add("-");
		operadoresBinarios.add("/");
		operadoresBinarios.add("*");
		operadoresBinarios.add("^");
		operadoresUnario.add("ln");
		operadoresUnario.add("cos");
		operadoresUnario.add("sen");
	}
	
	public static Boolean esOperador(String caracter){
		if(esOperadorBinario(caracter) || esOperadorUnario(caracter))
			return true;
		return false;
	}
	
	public static Boolean esOperadorBinario (String caracter) {
		for(String a: expresion.operadoresBinarios){
			if(a.equals(caracter))
				return true;
		}
		return false;
	}
	
	public static Boolean esOperadorUnario (String caracter) {
		for(String a: expresion.operadoresUnario){
			if(a.equals(caracter))
				return true;
		}
		return false;
	}

	public static Boolean esVariable(String caracter){
		if(caracter.length()==1 && (((char)caracter.charAt(0)>='A' && (char)caracter.charAt(0)<='Z') || ((char)caracter.charAt(0)>='a' && (char)caracter.charAt(0)<='z')))
			return true;
		return false;
	}
	
	public static Boolean esNumero(String caracter){
		if(esVariable(caracter)==false && esOperadorBinario(caracter)==false  && esOperadorUnario(caracter)==false){
			return true;
		}
		return false;
	}
	
	public static Boolean esOperando(String caracter){
		if(esVariable(caracter) || esNumero(caracter))
			return true;
		return false;
	}
	
}
