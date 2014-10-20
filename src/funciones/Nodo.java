package funciones;

public class Nodo{
	private String dato;
	private Nodo izq, der;
	
	public Nodo(){
		this(null, null, null);
	}
	
	public Nodo(String dato, Nodo izq, Nodo der){
		this.dato=dato;
		this.der=der;
		this.izq=izq;
	}
	
	public Nodo(String dato, Nodo izq){
		this.dato=dato;
		this.der=null;
		this.izq=izq;
	}
	
	public void InOrden(){
		if(izq!=null){
			izq.InOrden();
		}
		System.out.print(dato + " ");
		if(der!=null){
			der.InOrden();
		}
	}
	
	public String getDato(){
		return dato;
	}
	
	public String toString(){
		return dato;
	}

	public Nodo getIzq() {
		return izq;
	}

	public Nodo getDer() {
		return der;
	}
	
	public Double evaluar(Punto punto){
		if(Expresion.esOperador(dato)){
			if(Expresion.esOperadorBinario(dato)){
				if(izq!=null && der!=null){
					return Expresion.calcular(dato,izq.evaluar(punto) ,der.evaluar(punto));
				}
			}
			if(Expresion.esOperadorUnario(dato)){
				if(izq!=null){
					return Expresion.calcular(dato,izq.evaluar(punto));
				}
			}
		}
		if(Expresion.esVariable(dato)){
			
		}
		return Double.parseDouble(dato);
	}
	
}
