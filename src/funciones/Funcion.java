package funciones;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;


public class Funcion {
	private ArrayList<String> funcion;
	private ArrayList<Arbol> operandos;
	
	public Funcion(String nombre){
		funcion = new ArrayList<String>();
		operandos = new ArrayList<Arbol>();
		LeerArchivo archivoIn = new LeerArchivo(nombre);
		String [] linea;
		try{
			linea=archivoIn.readLine().split(" ");
			for(int i=0; i<linea.length; i++){
				funcion.add(linea[i]);
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		
		for(int i=0; i<funcion.size(); i++){
			if(Expresion.esOperador(funcion.get(i))){
				if(Expresion.esOperadorBinario(funcion.get(i))){
					Arbol arbol = new Arbol();
					arbol.unir(funcion.get(i), operandos.get(operandos.size()-2), operandos.get(operandos.size()-1));
					operandos.remove(operandos.size()-1);
					operandos.remove(operandos.size()-1);
					operandos.add(arbol);
				}
				if(Expresion.esOperadorUnario(funcion.get(i))){
					Arbol arbol = new Arbol();
					arbol.unir(funcion.get(i), operandos.get(operandos.size()-1), null);
					operandos.remove(operandos.size()-1);
					operandos.add(arbol);
				}
			}
			if(Expresion.esOperando(funcion.get(i))){
				operandos.add(new Arbol(funcion.get(i)));
			}
		
		}
		
		System.out.println(operandos.size());
		
	}
	

	
	public static void main(String[] args) {
		Funcion f = new Funcion("funcion.in");
		
	}
}
