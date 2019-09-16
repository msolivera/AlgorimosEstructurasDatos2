/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HashTrie;

/**
 *
 * @author jsilva
 */
public class UT3_TA6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TTrieHashMap trie = new TTrieHashMap();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src/ut3_ta6/palabras1.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
        }
        trie.imprimir();    
    }
    
}
