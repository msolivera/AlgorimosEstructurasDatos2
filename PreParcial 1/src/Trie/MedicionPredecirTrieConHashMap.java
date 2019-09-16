package Trie;

import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Bruno Maratinez
 */
public class MedicionPredecirTrieConHashMap extends Medible{
     private TArbolTrieHM tarbolTrie;

    public MedicionPredecirTrieConHashMap(TArbolTrieHM tarbolTrie) {
        this.tarbolTrie = tarbolTrie;
    }
    
    
    @Override
    public void ejecutar(Object... params) {
        int repeticion = (int) params[0];
        String[] palabras = (String[]) params[1];
        for(int i = 0; i < repeticion; i++){
            for(String palabra : palabras){
                tarbolTrie.predecir(palabra);
            }
        }
    }

    
    @Override
    public Object getObjetoAMedirMemoria() {
        return this.tarbolTrie;
    }
}
