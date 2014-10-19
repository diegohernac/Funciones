package funciones;

public class Nodo implements Comparable<Nodo> {
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
	
	public int compareTo(Nodo nodo){
		if(Expresion.esOperador(this.dato)){
			if(Expresion.esOperando(nodo.dato))
				return 1; //der
			if(Expresion.esOperadorBinario(nodo.dato))
				return -1; //iz
		}
		if(Expresion.esOperando(this.dato)){
			return 1;
		}
		return 0; //nodo
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
	
	
	
}
