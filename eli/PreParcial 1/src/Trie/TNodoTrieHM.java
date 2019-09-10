package Trie;



import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;

public class TNodoTrieHM implements Serializable{

    private static final int CANT_CHR_ABECEDARIO = 26;
    private HashMap<Character,TNodoTrieHM> hijos;
    private boolean esPalabra;

    public TNodoTrieHM() {
        hijos = new HashMap <Character,TNodoTrieHM>();
        esPalabra = false;
    }

    public void insertar(String unaPalabra) {
        TNodoTrieHM nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            if (!nodo.hijos.containsKey(unaPalabra.charAt(c))) {
                nodo.hijos.put(unaPalabra.charAt(c),new TNodoTrieHM());
            }
            nodo = nodo.hijos.get(unaPalabra.charAt(c));
        }
        nodo.esPalabra = true;
    }
    public TNodoTrieHM buscar(char letra){
        
        if (hijos.containsKey(letra)) {
            return hijos.get(letra);
        }
        return null;
    }
    private void imprimir(String s, TNodoTrieHM nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
            }
            for (Character caracter : nodo.hijos.keySet()) {
                imprimir(s + caracter, nodo.hijos.get(caracter));
            }            
        }
    }

    public HashMap<Character, TNodoTrieHM> getHijos() {
        return hijos;
    }

    public void setHijos(HashMap<Character, TNodoTrieHM> hijos) {
        this.hijos = hijos;
    }

    
    public boolean getEsPalabra() {
        return esPalabra;
    }

    public void setEsPalabra(boolean esPalabra) {
        this.esPalabra = esPalabra;
    }

    public void imprimir() {
        imprimir("", this);
    }
    
     public void predecir(String s, LinkedList<String> palabras, TNodoTrieHM nodo) {
         if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(s);
            }
             for (Character caracter : nodo.hijos.keySet()) {
                 if(nodo.hijos.containsKey(caracter)){
                     predecir(s+caracter,palabras,nodo.hijos.get(caracter));
                 }
                 
             }
        }
        
       
    }
}
