package Trie;

import java.io.Serializable;
import java.util.LinkedList;

public class TNodoTrie implements Serializable{

    private static final int CANT_CHR_ABECEDARIO = 26;
    private TNodoTrie[] hijos;
    private boolean esPalabra;

    public TNodoTrie() {
        hijos = new TNodoTrie[CANT_CHR_ABECEDARIO];
        esPalabra = false;
    }

    public void insertar(String unaPalabra) {
        TNodoTrie nodo = this;
        for (int c = 0; c < unaPalabra.length(); c++) {
            int indice = unaPalabra.charAt(c) - 'a';
            if (nodo.hijos[indice] == null) {
                nodo.hijos[indice] = new TNodoTrie();
            }
            nodo = nodo.hijos[indice];
        }
        nodo.esPalabra = true;
    }
    public TNodoTrie buscar(char letra){
        int indice = letra - 'a';
        if (hijos[indice] != null) {
            return hijos[indice];
        }
        return null;
    }
    private void imprimir(String s, TNodoTrie nodo) {
        if (nodo != null) {
            if (nodo.esPalabra) {
                System.out.println(s);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    imprimir(s + (char) (c + 'a'), nodo.hijos[c]);
                }
            }
        }
    }

    public TNodoTrie[] getHijos() {
        return hijos;
    }

    public void setHijos(TNodoTrie[] hijos) {
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
    public int buscar(String s) {
        TNodoTrie nodo = this;
        int temp = 0;
        for (int c = 0; c < s.length(); c++) {
            int indice = s.charAt(c) - 'a';
            temp++;
            if (nodo.hijos[indice] == null) {
                return -temp;
            }
            nodo = nodo.hijos[indice];
        }
        if (nodo.esPalabra) {
            return temp;
        }
        return -temp;
    }
     public void predecir(String s, String prefijo, LinkedList<String> palabras, TNodoTrie nodo) {
         if (nodo != null) {
            if (nodo.esPalabra) {
                palabras.add(s);
            }
            for (int c = 0; c < CANT_CHR_ABECEDARIO; c++) {
                if (nodo.hijos[c] != null) {
                    predecir(s + (char) (c + 'a'),prefijo,palabras, nodo.hijos[c]);
                }
            }
        }
        
       
    }
}
