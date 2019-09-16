
package Trie;
import java.util.*;

public class Main {

    private static final int REPETICIONES = 200;

    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();      
        TArbolTrieHM trieHM = new TArbolTrieHM();
        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src/Trie/listado-general_desordenado.txt");
        String[] palabrasBuscar = ManejadorArchivosGenerico.leerArchivo("src/Trie/listado-general_palabrasBuscar.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
                trieHM.insertar(p);
        }
        
        Medible[] medibles = {new MedicionPredecirTrieConArray(trie),new MedicionPredecirTrieConHashMap(trieHM)  };
          
        Object[] params = {REPETICIONES, palabrasBuscar};
        for (Medible m: medibles){
            m.medir(params).print();
        }
    }
}