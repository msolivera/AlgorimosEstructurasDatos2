
package TrieHashMap;

public class UT3_TA6 {

    public static void main(String[] args) {
        TTrieHashMap trie = new TTrieHashMap();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src/triehashmap/palabras1.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
        }
        trie.imprimir();    
    }
    
}
