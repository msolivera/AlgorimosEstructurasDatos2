/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UT2PD2;

/**
 *
 * @author Micaela
 */
public class TArbolTrie {
    
        private TNodoTrie raiz;

    public void insertar(String palabra, int pagina) {
        if (raiz == null) {
            raiz = new TNodoTrie();
        }
        raiz.insertar(palabra, pagina);
    }

    public void imprimir() {
        if (raiz != null) {
            raiz.imprimir();
        }
    }
    public TNodoTrie getRaiz(){return raiz;}

    public void paginasDePalabra(String palabra) {
        if (raiz != null) {
            System.out.println(raiz.paginasDePalabra(palabra));
        }        
    }
}
