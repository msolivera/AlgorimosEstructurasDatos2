/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2PD6;

import java.util.LinkedList;

/**
 *
 * @author Micaela
 */
public class TArbolTrie {

    private TNodoTrie raiz;

    public TArbolTrie(String palabra) {

        for (int i = 0; i < palabra.length(); i++) {
            this.insertar(palabra.substring(i), i);
        }

    }

    public void insertar(String palabra, int inicio) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra, inicio);
    }

    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }

    public int buscar(String palabra) {
        return raiz.busqueda(palabra, 0, 0);
    }

    public LinkedList<Integer> ubicaciónPrefijo(String prefijo) {
        LinkedList<Integer> inicios = new LinkedList<>();
        raiz.prefijoUbicación(prefijo, inicios);
        return inicios;
    }
}
