package funciones;

public class Arbol implements InterfazArbol {
	private Nodo raiz;
	
	public Arbol(){
		raiz=null;
	}
	
	public Arbol(String expresion){
		raiz = new Nodo(expresion, null, null);
	}
	
	public Nodo getRaiz(){
		return raiz;
	}
	
	public void unir(String expresion, Arbol izq, Arbol der){
		this.raiz = new Nodo(expresion, izq.raiz, der.raiz);
	}
}
