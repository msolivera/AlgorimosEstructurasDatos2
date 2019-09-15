package Trie_Predictor;


import java.util.LinkedList;


public class Main {

    /**
     * PRECONDICIONES:
     * - todas las palabras ingresadas deben estarn en minúsculas-
     * - el diccionario utilizado es en inglés SOLO
     * @param args
     */
    public static void main(String[] args){
        TArbolTrie trie = new TArbolTrie();

        String[] palabrasclave = ManejadorArchivosGenerico.leerArchivo("./src/palabras1.txt");
        for (String p : palabrasclave) {
                trie.insertar(p);
        }
        trie.imprimir();       
    }
}