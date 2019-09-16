

import java.util.ArrayList;
import java.util.LinkedList;

public class TNodoTrie implements INodoTrie {

    public static final int CANT_CHR_ABCEDARIO = 26;
    public TNodoTrie[] hijos;
    public boolean esPalabra;
    public ArrayList paginas;
    
    public TNodoTrie(){
        hijos = new TNodoTrie[CANT_CHR_ABCEDARIO];
        esPalabra = false;
        paginas = new ArrayList();
    }
    
    public void insertar(String unaPalabra){
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++){
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null){
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }
    
    public void insertar(String unaPalabra, int pagina){
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++){
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null){
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
        paginas.add(pagina);
    }
    
    private void imprimir(String s, TNodoTrie nodo){
        if (nodo != null){
            if (nodo.esPalabra){
                System.out.println(s);
            }
            for (int c = 0; c < CANT_CHR_ABCEDARIO; c++){
                if (nodo.hijos[c] != null){
                    imprimir(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }        
    }
    
    public void imprimir(){
        this.imprimir("", this);
    }
    
    public boolean buscar (String palabra){
        TNodoTrie nodo = this;
        for (int c = 0; c < palabra.length(); c++){
            int indice = palabra.charAt(c) - 'a';
            TNodoTrie aux = nodo.hijos[indice];
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
        TNodoTrie nodo = this;
        for (int c = 0; c < palabra.length(); c++){
            int indice = palabra.charAt(c) - 'a';
            TNodoTrie aux = nodo.hijos[indice];
            if(aux == null) {
                return null;
            }
            nodo = aux;
        }
        return nodo.paginas;
    }
    
    public void predecir(String prefijo, LinkedList<String> palabras) {
        TNodoTrie nodo = this;
        for (int c = 0; c < prefijo.length(); c++){
            int indice = prefijo.charAt(c) - 'a';
            TNodoTrie aux = nodo.hijos[indice];
            if (aux != null) {
                nodo = aux;
            } 
            else{
                return ;
            }
        }
        traerTodos(prefijo, palabras, nodo);
    }
    
    private void traerTodos(String prefijo, LinkedList<String> palabras, TNodoTrie nodo) {
        if (nodo.esPalabra){
            palabras.add(prefijo);
        }
        for (int c = 0; c < 26; c++){
            if (nodo.hijos[c] != null){
                char letra = (char) (c + 'a');
                traerTodos(prefijo + letra, palabras, nodo.hijos[c]);
            }
        }  
    } 
  
}
