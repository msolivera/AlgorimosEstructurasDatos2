package Tries_Sufijos;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class TTrieSufijosHashMap {

    private TNodoTrieHashMap raiz;

    public void insertar(String palabra) {
        if (raiz == null) {
            raiz = new TNodoTrieHashMap();
        }
        raiz.insertar(palabra);
    }
    
    public void insertar(String palabra, int indice) {
        if (raiz == null) {
            raiz = new TNodoTrieHashMap();
        }
        raiz.insertar(palabra, indice);
    }

    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    public LinkedList<String> predecir(String prefijo) {
        if (raiz != null) {
            LinkedList<String> palabras = new LinkedList<String>();
            raiz.predecir(prefijo,palabras);
            return palabras;
        }
        return null;
    }
     public ArrayList<Integer> ocurrenciasPosicionesPatron(String patron) {
        ArrayList<Integer> posiciones = new ArrayList<>();
        ArrayList<Integer> otro = new ArrayList<>();
        if (raiz != null) {
            
            raiz.getPosicionesPatron(patron,posiciones);            
            otro.add(0, posiciones.size());
            for (int i = 0; i < posiciones.size(); i++) {
                otro.add(i+1, posiciones.get(i));
            }
            return otro;
        }
        return otro;
    }
}
