package TrieHashMap;
public class Main {

    /**
     * PRECONDICIONES:
     * - todas las palabras ingresadas deben estarn en minúsculas-
     * - el diccionario utilizado es en inglés SOLO
     * @param args
     */
    public static void main(String[] args){
        TTrieHashMap trie = new TTrieHashMap();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("src/TrieHashMap/palabras1.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
        }        
        trie.imprimir();
        System.out.println("\n");
        System.out.println(trie.buscar("solar"));
        System.out.println(trie.buscar("solju"));
    }
}