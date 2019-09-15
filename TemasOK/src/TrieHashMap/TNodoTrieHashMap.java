
package TrieHashMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class TNodoTrieHashMap {
    public static final int CANT_CHR_ABCEDARIO = 26;
    public HashMap<Comparable,TNodoTrieHashMap> hijos;
    public boolean esPalabra;
    public ArrayList paginas;
    
    public TNodoTrieHashMap(){
        hijos = new HashMap<Comparable,TNodoTrieHashMap>(CANT_CHR_ABCEDARIO);
        esPalabra = false;
        paginas = new ArrayList();
    }
    
    public void insertar(String unaPalabra){
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++){
            char letra = unaPalabra.charAt(c);
            if (nodo.hijos.containsKey(letra) == false){
                TNodoTrieHashMap nuevo = new TNodoTrieHashMap();
                nodo.hijos.put(letra, nuevo);
            }
            nodo = nodo.hijos.get(letra);
        }
        nodo.esPalabra = true;
    }
    
    public void insertar(String unaPalabra, int pagina){
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++){
            char letra = unaPalabra.charAt(c);
            if (nodo.hijos.containsKey(letra) == false){
                TNodoTrieHashMap nuevo = new TNodoTrieHashMap();
                nodo.hijos.put(letra, nuevo);
            }
            nodo = nodo.hijos.get(letra);
        }
        nodo.esPalabra = true;
        paginas.add(pagina);
    }
    
    private void imprimir(String s, TNodoTrieHashMap nodo){
        if (nodo != null){
            if (nodo.esPalabra){
                System.out.println(s);
            }
            for (int c = 0; c < CANT_CHR_ABCEDARIO; c++){    
                //En lugar de buscar el valor en número de la posición de la letra, busco la letra en si ya que mis 
                //claves son letras y no números.
                if (nodo.hijos.get((char) ('a' + c ))!=null){
                    imprimir(s + (char) (c + 'a'), nodo.hijos.get((char) ('a' + c)));
                }
            }
        }        
    }
    
    public void imprimir(){
        this.imprimir("", this);
    }
    
    public boolean buscar (String palabra){
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < palabra.length(); c++){
            char letra = palabra.charAt(c);
            TNodoTrieHashMap aux = nodo.hijos.get(letra);
            if(aux == null) {
                return false;
            }
            nodo = aux;
        }
        return nodo.esPalabra;
    }
    
    /**
     *
     * @param palabra
     * @return
     */
    public ArrayList buscarPaginas(String palabra){
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < palabra.length(); c++){
            char letra = palabra.charAt(c);
            TNodoTrieHashMap aux = nodo.hijos.get(letra);
            if(aux == null) {
                return null;
            }
            nodo = aux;
        }
        return nodo.paginas;
    }
    
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrieHashMap nodo = this;
        for (int c = 0; c < prefijo.length(); c++){
            char letra = prefijo.charAt(c);
            TNodoTrieHashMap aux = nodo.hijos.get(letra);
            if (aux != null) {
                nodo = aux;
            } 
            else{
                return ;
            }
        }
        traerTodos(prefijo, palabras, nodo);
    }
    
    private void traerTodos(String prefijo, LinkedList<String> palabras, TNodoTrieHashMap nodo) {
        if (nodo.esPalabra){
            palabras.add(prefijo);
        }
        for (int c = 0; c < CANT_CHR_ABCEDARIO; c++){
            //HAY QUE CORREGIR ESTE BUCLE PARA QUE TRAIGA TODOS LOS HIJOS
            if (nodo.hijos.get((char) ('a' + c ))!=null){
                char letra = (char) ('a'+ c);
                traerTodos(prefijo + letra, palabras, nodo.hijos.get(letra));
            }
           
        }  
    }   
}
