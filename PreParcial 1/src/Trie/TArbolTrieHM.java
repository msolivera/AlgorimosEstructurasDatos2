package Trie;



import java.io.Serializable;
import java.util.LinkedList;


public class TArbolTrieHM implements Serializable {

    private TNodoTrieHM raiz;
    public int cantidadComparaciones;
    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrieHM();
        }
        raiz.insertar(palabra);
    }
    public TNodoTrieHM buscar(String palabra){
        cantidadComparaciones = 0;
        int indice = 0;
        palabra = palabra.toLowerCase();
        TNodoTrieHM aux = raiz;
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
    public TNodoTrieHM buscarPrefijo(String prefijo){
        cantidadComparaciones = 0;
        int indice = 0;
        prefijo = prefijo.toLowerCase();
        TNodoTrieHM aux = raiz;
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

        TNodoTrieHM nodo = this.buscarPrefijo(prefijo);
        LinkedList<String> palabras = new LinkedList<String>();
        if(nodo!=null){            
            nodo.predecir(prefijo, palabras,nodo);           
            
        }
        return palabras;
    }
}
