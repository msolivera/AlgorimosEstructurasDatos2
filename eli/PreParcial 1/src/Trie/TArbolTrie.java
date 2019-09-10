package Trie;

import java.io.Serializable;
import java.util.LinkedList;


public class TArbolTrie implements Serializable{

    private TNodoTrie raiz;
    public int cantidadComparaciones;
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra);
    }
    public TNodoTrie buscar(String palabra){
        cantidadComparaciones = 0;
        int indice = 0;
        palabra = palabra.toLowerCase();
        TNodoTrie aux = raiz;
        while (indice < palabra.length() && aux != null)
        {
            cantidadComparaciones++;
            aux = aux.buscar(palabra.charAt(indice));
            indice ++;
        }
        if(aux!=null && aux.getEsPalabra()){
            return aux;
        }
        return null;
    }
    public TNodoTrie buscarPrefijo(String prefijo){
        cantidadComparaciones = 0;
        int indice = 0;
        prefijo = prefijo.toLowerCase();
        TNodoTrie aux = raiz;
        while (indice < prefijo.length() && aux != null)
        {
            cantidadComparaciones++;
            aux = aux.buscar(prefijo.charAt(indice));
            indice ++;
        }
        return aux;
    }
    
    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }
    
    public LinkedList<String> predecir(String prefijo) {

        TNodoTrie nodo = this.buscarPrefijo(prefijo);
        LinkedList<String> palabras = new LinkedList<String>();
        if(nodo!=null){            
            nodo.predecir(prefijo, prefijo, palabras,nodo);           
            
        }
        return palabras;
    }
}
