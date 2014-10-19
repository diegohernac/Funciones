package funciones;

import java.util.ArrayList;


public class Funcion {
	
	private Arbol arbol;
	
	public Funcion(String nombre){
		ArrayList<String> expresion;
		ArrayList<Arbol> operandos;
		expresion = new ArrayList<String>();
		operandos = new ArrayList<Arbol>();
		LeerArchivo archivoIn = new LeerArchivo(nombre);
		String [] linea;
		try{
			linea=archivoIn.readLine().split(" ");
			for(int i=0; i<linea.length; i++){
				expresion.add(linea[i]);
			}
		}
		catch(Exception e){
			e.printStackTrace();
			
		}
		
		
		for(int i=0; i<expresion.size(); i++){
			if(Expresion.esOperador(expresion.get(i))){
				if(Expresion.esOperadorBinario(expresion.get(i))){
					Arbol arbolParcial = new Arbol();
					arbolParcial.unir(expresion.get(i), operandos.get(operandos.size()-2), operandos.get(operandos.size()-1));
					operandos.remove(operandos.size()-1);
					operandos.remove(operandos.size()-1);
					operandos.add(arbolParcial);
				}
				if(Expresion.esOperadorUnario(expresion.get(i))){
					Arbol arbolParcial = new Arbol();
					arbolParcial.unir(expresion.get(i), operandos.get(operandos.size()-1), null);
					operandos.remove(operandos.size()-1);
					operandos.add(arbolParcial);
				}
			}
			if(Expresion.esOperando(expresion.get(i))){
				operandos.add(new Arbol(expresion.get(i)));
			}
		
		}
		
		arbol = operandos.get(operandos.size()-1);
		
		
	}
	
	public void mostar(){
		arbol.mostrarInOrden();
	}

	
	public static void main(String[] args) {
		Funcion f = new Funcion("funcion.in");
		f.mostar();
	}
}
