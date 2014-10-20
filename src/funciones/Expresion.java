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
	
	public static Double calcular(String operacion, Double operando1, Double operando2){
		Double resultado = 0.0;
		if(operacion.equals("+")){
			resultado = operando1 + operando2;
		}
		if(operacion.equals("*")){
			resultado = operando1 * operando2;
		}
		if(operacion.equals("-")){
			resultado = operando1 - operando2;
		}
		if(operacion.equals("/")){
			try{
				resultado = operando1 / operando2;
			}catch(Exception e){
				System.out.println("No se puede dividir por cero");
			}
		}
		if(operacion.equals("^")){
			resultado = Math.pow(operando1 ,operando2);
		}
		
		return resultado;
	}
	
	public static Double getVariable(String variable, Punto punto){
		if(variable.equals("X"))
			return punto.getX();
		if(variable.equals("Y"))
			return punto.getY();
		return punto.getZ();
	}
	
	public static Double calcular(String operacion, Double operando1){
		Double resultado = 0.0;
		if(operacion.equals("ln")){
			System.out.println("ln");
			resultado = Math.log(operando1);
		}
		if(operacion.equals("cos")){
			System.out.println("cos");
			resultado = radianesToGrados(Math.cos(operando1));
		}
		if(operacion.equals("sen")){
			System.out.println("sen");
			resultado = radianesToGrados(Math.sin(operando1));
		}
		return resultado;
	}
	
	public static Double radianesToGrados(Double radianes){
		return (radianes*Math.PI)/180;
	}
	
}
