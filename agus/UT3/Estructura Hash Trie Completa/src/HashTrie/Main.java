package HashTrie;
import java.util.LinkedList;


public class Main {

    /**
     * PRECONDICIONES:
     * - todas las palabras ingresadas deben estarn en minúsculas-
     * - el diccionario utilizado es en inglés SOLO
     * @param args
     */
    public static void main(String[] args){
        TTrieHashMap trie = new TTrieHashMap();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src/HashTrie/palabras1.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
        }        
        trie.imprimir();   
        //System.out.println(trie.buscar("solar"));
        //System.out.println(trie.buscar("solju"));
    }
}