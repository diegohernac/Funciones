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
