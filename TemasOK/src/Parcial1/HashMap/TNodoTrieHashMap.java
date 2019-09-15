package Parcial1.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class TNodoTrieHashMap implements INodoTrie {
    public static final int CANT_CHR_ABCEDARIO = 11;
    public HashMap<Comparable,TNodoTrieHashMap> hijos;
    private TDispositivo dato;    
    
    public TNodoTrieHashMap(){
        hijos = new HashMap<Comparable,TNodoTrieHashMap>(CANT_CHR_ABCEDARIO);
        dato = null;
        
    }     

    @Override
    public void insertar(TDispositivo dispositivo) {
        TNodoTrieHashMap nodo = this;
        int indice;
        for (int c = 0; c < dispositivo.getDirIP().length(); c++) {
            if (Character.toString(dispositivo.getDirIP().charAt(c)).equals(".")){
                indice = 10;
                
            }
            else{
                indice = Integer.parseInt(Character.toString(dispositivo.getDirIP().charAt(c)));
            }             
            if (nodo.hijos.containsKey(indice) == false) {
                TNodoTrieHashMap nuevo = new TNodoTrieHashMap();
                nodo.hijos.put(indice, nuevo);
            }
            nodo = nodo.hijos.get(indice);
        }
        nodo.dato = dispositivo;
    }

    

    
    
    private TNodoTrieHashMap buscarNodoTrie(String s) {
        TNodoTrieHashMap nodo = this;
        int indice;
        for (int c = 0; c < s.length(); c++) {            
            if (Character.toString(s.charAt(c)).equals(".")){
                indice = 10;                
            }
            else{
                indice = Integer.parseInt(Character.toString(s.charAt(c)));
            } 
            if (nodo.hijos.containsKey(indice)== false) {
                return null;
            }
            nodo = nodo.hijos.get(indice);
        }
        return nodo;
    }


    
    public void buscarDispositivos(String patron, LinkedList<TDispositivo> dispositivos) {
        TNodoTrieHashMap nodo = buscarNodoTrie(patron);
        if (nodo != null){
            buscarDispositivosAux(nodo, dispositivos);
        }
    }
    
    public void buscarDispositivosAux(TNodoTrieHashMap nodo, LinkedList<TDispositivo> lista){
        if (nodo != null) {
            if (nodo.dato != null) {
                lista.add(nodo.dato);
            }
            
            for (int c = 0; c < CANT_CHR_ABCEDARIO; c++) {
                if (nodo.hijos.containsKey(c) == true) {
                    buscarDispositivosAux(nodo.hijos.get(c), lista);
                }
            }
        }
    
    }
    
    
    
   
}
