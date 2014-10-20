package funciones;

public class Nodo{
	private String expresion;
	private Nodo izq, der;
	
	public Nodo(){
		this(null, null, null);
	}
	
	public Nodo(String expresion, Nodo izq, Nodo der){
		this.expresion=expresion;
		this.der=der;
		this.izq=izq;
	}
	
	public Nodo(String expresion, Nodo izq){
		this.expresion=expresion;
		this.der=null;
		this.izq=izq;
	}
	
	public void InOrden(){
		if(izq!=null){
			izq.InOrden();
		}
		System.out.print(expresion + " ");
		if(der!=null){
			der.InOrden();
		}
	}
	
	public String getDato(){
		return expresion;
	}
	
	public String toString(){
		return expresion;
	}

	public Nodo getIzq() {
		return izq;
	}

	public Nodo getDer() {
		return der;
	}
	
	public Double evaluar(Punto punto){
		if(Expresion.esOperador(expresion)){
			if(Expresion.esOperadorBinario(expresion)){
				if(izq!=null && der!=null){
					return Expresion.calcular(expresion,izq.evaluar(punto) ,der.evaluar(punto));
				}
			}
			if(Expresion.esOperadorUnario(expresion)){
				if(izq!=null){
					return Expresion.calcular(expresion,izq.evaluar(punto));
				}
			}
		}
		if(Expresion.esVariable(expresion)){
			return Expresion.getVariable(expresion, punto);
		}
		return Double.parseDouble(expresion);
	}
	
}
