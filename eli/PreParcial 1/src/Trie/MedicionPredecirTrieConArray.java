/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Trie;

/**
 *
 * @author Usuario
 */
public class MedicionPredecirTrieConArray extends Medible{
    
    private TArbolTrie tarbolTrie;

    public MedicionPredecirTrieConArray(TArbolTrie tarbolTrie) {
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
