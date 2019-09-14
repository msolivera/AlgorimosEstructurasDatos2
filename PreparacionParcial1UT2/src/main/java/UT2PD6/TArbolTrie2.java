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
public class TArbolTrie2<T> {
      private TNodoTrie2<T> raiz = new TNodoTrie2();
    
    public boolean agregarSufijos(String cadena){
        int nChar = cadena.length()-1;
        String prefijo = "";
        boolean respuesta = true;
        
        for (int i=nChar; i>=0; i--){
            prefijo = cadena.charAt(i) + prefijo;
            if(!agregarSufijo(prefijo, i)){
                respuesta = false;
            }
        }
        return respuesta;
    }
    
    public boolean agregarSufijo(String cadena, int posicion){
        return raiz.agregarSufijo(cadena, posicion);
    }
    
    public LinkedList buscarPatron(String patron){
        LinkedList posiciones = new LinkedList();
        
        raiz.buscarPatron(patron, posiciones);
        
        return posiciones;
    }  
}
